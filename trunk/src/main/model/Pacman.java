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
		Celda nextCell = null;
		System.out.print("Pacman: ");
		if (Constantes.PACMAN_ABAJO.equals(direccion)){
			nextCell = this.celdaActual.getCeldaAbajo();
		} 
		else if (Constantes.PACMAN_ARRIBA.equals(direccion)){
			nextCell = this.celdaActual.getCeldaArriba();
		} 
		else if (Constantes.PACMAN_DERECHA.equals(direccion)){
			nextCell = this.celdaActual.getCeldaDerecha();
		} 
		else if (Constantes.PACMAN_IZQUIERDA.equals(direccion)){
			nextCell = this.celdaActual.getCeldaIzquierda();
		}
		if (nextCell != null && nextCell.esTransitable()){
			this.celdaActual = nextCell;
			System.out.println(this.celdaActual);
			System.out.println(this.celdaActual.getPosicion());
			this.celdaActual.visitarPorPacman();
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
