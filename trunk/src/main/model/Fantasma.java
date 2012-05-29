package main.model;

import main.config.Constantes;
import main.states.EstadoCazador;

public class Fantasma {
	
	private Estado estado;
	private Integer ira;
	
	public Fantasma(){
		this.estado = new EstadoCazador();
		this.ira = Constantes.IRA_MINIMA;
	}
	
	public void mover(){
		this.estado.mover(this);
	}
	
	public void incrementarIra(){
		this.estado.incrementarIra(this);
	}
	
	public void eliminar(){
		cambiarEstado(this.estado.eliminar());
	}
	
	public void convertirEnPresa(){
		cambiarEstado(this.estado.convertirEnPresa());
	}
	
	public void convertirEnCazador(){
		cambiarEstado(this.estado.convertirEnCazador(this));
	}
	
	public void cambiarEstado(Estado nuevoEstado){
		if (nuevoEstado != null){
			this.estado = nuevoEstado;
		}
	}

	public Integer getIra() {
		return ira;
	}

	public void setIra(Integer ira) {
		this.ira = ira;
	}
	
	public void mostrarFantasma(){
		System.out.println("Fantasma " + this.estado.getNombre() 
				+ "con agresividad " + getIra());
	}
	
}
