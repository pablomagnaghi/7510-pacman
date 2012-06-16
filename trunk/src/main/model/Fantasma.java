package main.model;

import main.config.Constantes;
import main.config.Evento;
import main.states.EstadoCazador;
import main.states.EstadoMuerto;

public class Fantasma{
	
	private Estado estado;
	private Comportamiento comportamiento;
	private Integer ira;
	private String color;
	private Celda celdaActual;
	private String id;
	private String sentido;
	
	public Fantasma(String color, Celda inicial, Comportamiento comportamiento, String id){
		this.comportamiento = comportamiento;
		this.setEstado(EstadoCazador.getInstance());
		this.ira = Constantes.IRA_ESTADO_NORMAL;
		this.setColor(color);
		this.celdaActual = inicial;
		this.id =(id);
	}
	
	public Fantasma(){
		System.out.println("Iniciando fantasma");
		this.setEstado(EstadoCazador.getInstance());
		this.ira = Constantes.IRA_ESTADO_NORMAL;
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

	public Comportamiento getComportamiento() {
		return comportamiento;
	}

	public void setComportamiento(Comportamiento comportamiento) {
		this.comportamiento = comportamiento;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Celda getCeldaActual() {
		return celdaActual;
	}

	public void setCeldaActual(Celda celdaActual) {
		this.celdaActual = celdaActual;
	}
	
	public Boolean estaMuerto(){
		return this.estado.equals(EstadoMuerto.getInstance());
	}

	public String getId() {
		return id;
	}

	public String getSentido() {
		return this.sentido;
	}

	public void setSentido(String sentido) {
		this.sentido = sentido;
	}

	public String getPersonalidad() {
		return this.comportamiento.getNombre(this);
	}

}
