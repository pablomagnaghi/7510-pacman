package main.model;

import main.config.Constantes;

public class Pacman {

	private static Pacman instance = null;

	private Pacman(){

	}

	public static Pacman getInstance() {
		if (instance == null){
			instance = new Pacman();
		}
		return instance;
	}

	private Celda celdaActual;
	private String siguienteCeldaId;
	private String sentido;

	public Celda getCeldaActual() {
		return celdaActual;
	}

	public void setCeldaActual(Celda celdaActual) {
		this.celdaActual = celdaActual;
	}

	public void eliminar() {
		System.out.println("Eliminando pacman");
	}

	public Boolean mover(String direccion) {
		siguienteCeldaId = "";
		if (Constantes.ABAJO.equals(direccion)){
			siguienteCeldaId = this.celdaActual.getCeldaAbajo();
		} 
		else if (Constantes.ARRIBA.equals(direccion)){
			siguienteCeldaId = this.celdaActual.getCeldaArriba();
		} 
		else if (Constantes.DERECHA.equals(direccion)){
			siguienteCeldaId = this.celdaActual.getCeldaDerecha();
		} 
		else if (Constantes.IZQUIERDA.equals(direccion)){
			siguienteCeldaId = this.celdaActual.getCeldaIzquierda();
		}
		if (siguienteCeldaId != ""){
			return Boolean.TRUE;
		}
		this.siguienteCeldaId = this.celdaActual.getId();
		return Boolean.FALSE;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public String getSiguienteCelda(){
		return this.siguienteCeldaId;
	}

	public String getSentido() {
		return this.sentido;
	}

	public void setSentido(String sentido) {
		this.sentido = sentido;
	}

}
