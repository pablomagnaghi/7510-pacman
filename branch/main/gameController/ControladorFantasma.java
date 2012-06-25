package main.gameController;

import java.util.Observable;
import java.util.Observer;

import main.config.ConfiguracionPrincipal;
import main.config.Constantes;
import main.model.Cronometro;
import main.model.Fantasma;

public class ControladorFantasma implements Observer{

	private Fantasma fantasma;
	private Cronometro cronometroPresa;
	private Cronometro cronometroMuerto;
	private Integer tiempoMuerto;
	private Integer tiempoPresa;
	
	public ControladorFantasma(){
		this.cronometroPresa = new Cronometro(this);
		this.cronometroMuerto = new Cronometro(this);
		this.tiempoMuerto = ConfiguracionPrincipal.getInstance().getTiempoMuerto();
		this.tiempoPresa = ConfiguracionPrincipal.getInstance().getTiempoPresa();
		System.out.println("Iniciando con tiempo Muerto : " + this.tiempoMuerto);
		System.out.println("Iniciando con tiempo Presa : " + this.tiempoPresa);
		this.fantasma = new Fantasma();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o.equals(cronometroMuerto)){
			this.fantasma.revivir();
			this.fantasma.setIra(Constantes.IRA_ESTADO_NORMAL);
		} else {
			this.fantasma.convertirEnCazador();
		}
	}

	public void eliminarFantasma() {
		this.fantasma.eliminar();
		if (this.fantasma.getEstado().getNombre().equals(Constantes.MUERTO)){
			this.cronometroPresa.parar();
			this.cronometroMuerto.activar(this.tiempoMuerto);
		}
	}

	public void convertirFantasmaEnPresa() {
		this.fantasma.convertirEnPresa();
		if (this.fantasma.getEstado().getNombre().equals(Constantes.PRESA)){
			this.cronometroPresa.activar(this.tiempoPresa);
		}
	}

	public String moverFantasma() {
		return this.fantasma.mover();
	}

	public void mostrarFantasma() {
		this.fantasma.mostrar();
	}

	public String incrementarIraFantasma() {
		return this.fantasma.incrementarIra();
	}

	
}
