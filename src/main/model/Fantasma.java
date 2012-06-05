package main.model;

import main.config.Constantes;
import main.config.Evento;
import main.states.EstadoCazador;

public class Fantasma{
	
	private Estado estado;
	private Integer ira;
	
	public Fantasma(){
		System.out.println("Iniciando fantasma");
		this.setEstado(EstadoCazador.getInstance());
		this.ira = Constantes.IRA_MINIMA;
	}
	
	public String mover(){
		return (this.getEstado().mover(this));
	}
	
	public String incrementarIra(){
		return (this.getEstado().incrementarIra(this));
	}
	
	public void eliminar(){
		cambiarEstado(this.getEstado().getNextState(Evento.ELIMINAR));
	}
	
	public void revivir() {
		cambiarEstado(this.getEstado().getNextState(Evento.REVIVIR));
	}
	
	public void convertirEnPresa(){
		cambiarEstado(this.getEstado().getNextState(Evento.CONVERTIR_PRESA));
	}
	
	public void convertirEnCazador(){
		cambiarEstado(this.getEstado().getNextState(Evento.CONVERTIR_CAZADOR));
	}
	
	public void cambiarEstado(Estado nuevoEstado){
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
	
	public void mostrar(){
		System.out.println("Fantasma " + this.getEstado().getNombre() 
				+ " con agresividad " + getIra());
	}

	public Estado getEstado() {
		return estado;
	}

	private void setEstado(Estado estado) {
		this.estado = estado;
	}

}
