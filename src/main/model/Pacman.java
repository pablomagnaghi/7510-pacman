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

	public Celda getCeldaActual() {
		return celdaActual;
	}

	public void setCeldaActual(Celda celdaActual) {
		this.celdaActual = celdaActual;
	}

	public void eliminar() {
		System.out.println("Eliminando pacman");
	}

	public Boolean mover(Integer direccion) {
		siguienteCeldaId = "";
		if (Constantes.PACMAN_ABAJO.equals(direccion)){
			siguienteCeldaId = this.celdaActual.getCeldaAbajo();
		} 
		else if (Constantes.PACMAN_ARRIBA.equals(direccion)){
			siguienteCeldaId = this.celdaActual.getCeldaArriba();
		} 
		else if (Constantes.PACMAN_DERECHA.equals(direccion)){
			siguienteCeldaId = this.celdaActual.getCeldaDerecha();
		} 
		else if (Constantes.PACMAN_IZQUIERDA.equals(direccion)){
			siguienteCeldaId = this.celdaActual.getCeldaIzquierda();
		}
		if (siguienteCeldaId != ""){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public String getSiguienteCelda(){
		return this.siguienteCeldaId;
	}

}
