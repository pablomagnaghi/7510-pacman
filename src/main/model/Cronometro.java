package main.model;

import java.util.Observable;

public class Cronometro extends Observable{

	private Reloj relojPresa;
	private Reloj relojMuerto;
	
	public Cronometro(Fantasma fantasma) {
		this.addObserver(fantasma);
	}

	private void terminarCuenta() {
		setChanged();
		notifyObservers();
	}
	
	public void contarPresa(Integer tiempo) {
		if (this.relojPresa == null || !this.relojPresa.isAlive()){
			relojPresa = new Reloj(this, tiempo);
			relojPresa.start();
		}
	}
	
	public void contarMuerto(Integer tiempo){
		if (this.relojMuerto == null || !this.relojMuerto.isAlive()){
			relojMuerto = new Reloj(this, tiempo);
			relojMuerto.start();
			relojPresa.parar();
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
