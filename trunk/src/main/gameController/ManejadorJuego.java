package main.gameController;

import main.config.Constantes;
import main.model.Laberinto;

public class ManejadorJuego {
	
	private Laberinto laberinto;
	
	public ManejadorJuego(){
		this.laberinto = new Laberinto(Constantes.ARCHIVO_LABERINTO);
	}

	public Laberinto getLaberinto() {
		return laberinto;
	}
	
	public void correrJuego(){
		Boolean finished = false;
		ManejadorTurnos.getInstance().setFantasmas(laberinto.getFantasmas());
		ManejadorReglas.getInstance().setFantasmas(laberinto.getFantasmas());
		laberinto.imprimir();
//		while (!finished){
//			ManejadorTurnos.getInstance().ejecutarTurno();
//			ManejadorReglas.getInstance().chequearSituacion();
//			finished = ManejadorTurnos.getInstance().esFinDeJuego();
//			if (!finished){
//				ManejadorReglas.getInstance().esFinJuego();
//			}
//			this.laberinto.imprimir();
//		}
	}
	
}
