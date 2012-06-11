package main.model;

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

	public void mover(Integer integer) {
		
	}

}
