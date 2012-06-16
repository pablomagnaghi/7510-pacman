package main;

import main.config.Constantes;
import main.gameController.ManejadorJuego;


public class Principal {

	public static void main(String[] args) {
		ManejadorJuego manejadorJuego = new ManejadorJuego(Constantes.ARCHIVO_LABERINTO);
//		manejadorJuego.correrJuego();
		manejadorJuego.getLaberinto().imprimirLaberintoAXml();
	}

}
