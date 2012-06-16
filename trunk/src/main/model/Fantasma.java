package main.model;

import java.util.ArrayList;

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
	private String siguienteCelda;

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

	public String getSiguienteCelda() {
		return siguienteCelda;
	}

	public void setSiguienteCelda(String siguienteCelda) {
		this.siguienteCelda = siguienteCelda;
	}

	public String getDireccionMasCercanaAPacman() {
		Integer distancia = Constantes.DISTANCIA_MAX;
		Celda celdaPacman = Pacman.getInstance().getCeldaActual();
		String direccion = "";
		if (!getCeldaActual().getSiguienteCelda(Constantes.ARRIBA).isEmpty()){
			distancia = Celda.getDistanciaEntreCeldas(celdaPacman.getId(), getCeldaActual().getSiguienteCelda(Constantes.ARRIBA));
			direccion = Constantes.ARRIBA;
		} 
		if (!getCeldaActual().getSiguienteCelda(Constantes.ABAJO).isEmpty()){
			Integer distanciaArriba = Celda.getDistanciaEntreCeldas(celdaPacman.getId(), getCeldaActual().getSiguienteCelda(Constantes.ABAJO));
			if (distanciaArriba < distancia){
				distancia = distanciaArriba;
				direccion = Constantes.ABAJO;
			}
		} 
		if (!getCeldaActual().getSiguienteCelda(Constantes.DERECHA).isEmpty()){
			Integer distanciaDerecha = Celda.getDistanciaEntreCeldas(celdaPacman.getId(), getCeldaActual().getSiguienteCelda(Constantes.DERECHA));
			if (distanciaDerecha < distancia){
				distancia = distanciaDerecha;
				direccion = Constantes.DERECHA;
			}
		}
		if (!getCeldaActual().getSiguienteCelda(Constantes.IZQUIERDA).isEmpty()){
			Integer distanciaIzquierda = Celda.getDistanciaEntreCeldas(celdaPacman.getId(), getCeldaActual().getSiguienteCelda(Constantes.IZQUIERDA));
			if (distanciaIzquierda < distancia){
				distancia = distanciaIzquierda;
				direccion = Constantes.IZQUIERDA;
			}
		}
		return direccion;
	}

	public String getDireccionMasLejanAPacman() {
		Integer distancia = 0;
		Celda celdaPacman = Pacman.getInstance().getCeldaActual();
		String direccion = "";
		if (!getCeldaActual().getSiguienteCelda(Constantes.ARRIBA).isEmpty()){
			distancia = Celda.getDistanciaEntreCeldas(celdaPacman.getId(), getCeldaActual().getSiguienteCelda(Constantes.ARRIBA));
			direccion = Constantes.ARRIBA;
		} 
		if (!getCeldaActual().getSiguienteCelda(Constantes.ABAJO).isEmpty()){
			Integer distanciaArriba = Celda.getDistanciaEntreCeldas(celdaPacman.getId(), getCeldaActual().getSiguienteCelda(Constantes.ABAJO));
			if (distancia < distanciaArriba){
				distancia = distanciaArriba;
				direccion = Constantes.ABAJO;
			}
		} 
		if (!getCeldaActual().getSiguienteCelda(Constantes.DERECHA).isEmpty()){
			Integer distanciaDerecha = Celda.getDistanciaEntreCeldas(celdaPacman.getId(), getCeldaActual().getSiguienteCelda(Constantes.DERECHA));
			if (distancia < distanciaDerecha){
				distancia = distanciaDerecha;
				direccion = Constantes.DERECHA;
			}
		}
		if (!getCeldaActual().getSiguienteCelda(Constantes.IZQUIERDA).isEmpty()){
			Integer distanciaIzquierda = Celda.getDistanciaEntreCeldas(celdaPacman.getId(), getCeldaActual().getSiguienteCelda(Constantes.IZQUIERDA));
			if (distancia < distanciaIzquierda){
				distancia = distanciaIzquierda;
				direccion = Constantes.IZQUIERDA;
			}
		}
		return direccion;
	}
	
	public Boolean estaCercaDePacman(Integer distancia) {
		Celda celdaPacman = Pacman.getInstance().getCeldaActual();
		Integer distanciaEntreCeldas = Celda.getDistanciaEntreCeldas(celdaPacman, this.celdaActual);
		return (distanciaEntreCeldas <= distancia);
	}

	public String getDireccionAleatoria() {
		ArrayList<String> direccionesPosibles = listaDeDireccionesPosibles();
		Integer length = direccionesPosibles.size();
		Double randomNumber = Math.random();
		Integer subIndex = randomNumber.intValue() % length;
		return direccionesPosibles.get(subIndex);
	}

	private ArrayList<String> listaDeDireccionesPosibles() {
		ArrayList<String> lista = new ArrayList<String>();
		String celdaArriba = this.celdaActual.getSiguienteCelda(Constantes.ARRIBA);
		if (!(celdaArriba == null || celdaArriba.isEmpty())){
			lista.add(celdaArriba);
		}
		String celdaAbajo = this.celdaActual.getSiguienteCelda(Constantes.ABAJO);
		if (!(celdaAbajo == null || celdaAbajo.isEmpty())){
			lista.add(celdaAbajo);
		}
		String celdaDerecha = this.celdaActual.getSiguienteCelda(Constantes.DERECHA);
		if (!(celdaDerecha == null || celdaDerecha.isEmpty())){
			lista.add(celdaDerecha);
		}
		String celdaIzquierda = this.celdaActual.getSiguienteCelda(Constantes.IZQUIERDA);
		if (!(celdaIzquierda == null || celdaIzquierda.isEmpty())){
			lista.add(celdaIzquierda);
		}
		return lista;
	}

}
