package main.model;

import java.util.Observable;
import java.util.Observer;

import main.config.Constantes;
import main.config.Evento;
import main.states.EstadoCazador;
import main.states.EstadoMuerto;

public class Fantasma implements Observer{
	
	private Estado estado;
	private Integer ira;
	private Cronometro deadTime;
	private Boolean isDead;
	
	public Fantasma(){
		this.setEstado(EstadoCazador.getInstance());
		this.ira = Constantes.IRA_MINIMA;
		this.deadTime = new Cronometro(this, Constantes.DEATH_TIME);
		this.isDead = Boolean.FALSE;
	}
	
	public String mover(){
		return (this.getEstado().mover(this));
	}
	
	public String incrementarIra(){
		return (this.getEstado().incrementarIra(this));
	}
	
	public void eliminar(){
		cambiarEstado(this.getEstado().getNextState(Evento.ELIMINAR));
		if (this.getEstado().equals(EstadoMuerto.getInstance())){
			deadTime.beginCount();
			this.isDead = Boolean.TRUE;
		}
	}
	
	public void revivir(){
		cambiarEstado(this.getEstado().getNextState(Evento.REVIVIR));
	}
	
	public void convertirEnPresa(){
		if (!this.isDead){
			cambiarEstado(this.getEstado().getNextState(Evento.CONVERTIR_PRESA));
		}
	}
	
	public void convertirEnCazador(){
		cambiarEstado(this.getEstado().getNextState(Evento.CONVERTIR_CAZADOR));
	}
	
	private void cambiarEstado(Estado nuevoEstado){
		if (nuevoEstado != null){
			this.setEstado(nuevoEstado);
		}
	}

	public Integer getIra() {
		return ira;
	}

	public void setIra(Integer ira) {
		this.ira = ira;
	}
	
	public void mostrarFantasma(){
		System.out.println("Fantasma " + this.getEstado().getNombre() 
				+ "con agresividad " + getIra());
	}

	public Estado getEstado() {
		return estado;
	}

	private void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.isDead = Boolean.FALSE;
	}

}
