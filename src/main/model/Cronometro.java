package main.model;

import java.util.Observable;

public class Cronometro extends Observable{

	private Reloj reloj;
	
	public Cronometro(ControladorFantasma controlador) {
		this.addObserver(controlador);
	}

	private void terminarCuenta() {
		setChanged();
		notifyObservers();
	}
	
	public void contar(Integer tiempo) {
		if (this.reloj == null || !this.reloj.isAlive()){
			reloj = new Reloj(this, tiempo);
			reloj.start();
		}
	}
	
	public void terminar(){
		if (this.reloj != null && this.reloj.isAlive()){
			this.reloj.parar();
		}
	}
	
	private class Reloj extends Thread {
		
		private Cronometro cron;
		private Integer tiempo;
		private Boolean stop;
		
		private Reloj(Cronometro cron, Integer tiempo){
			this.cron = cron;
			this.tiempo = tiempo;
			this.stop = false;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(this.tiempo*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!this.stop){
				this.cron.terminarCuenta();
			}
		}

		private void parar() {
			this.stop = Boolean.TRUE;
		}
		
	}
	
}
