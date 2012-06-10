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
}
