package main;

import main.config.Constantes;
import main.gameController.ManejadorJuego;


public class Principal {

	public static void main(String[] args) {
		ManejadorJuego manejadorJuego;
		if (args.length == 0){
			manejadorJuego = new ManejadorJuego(Constantes.ARCHIVO_CONFIGURACION);
		} else {
			final String fileName = args[0];
			manejadorJuego = new ManejadorJuego(fileName);
		}
		manejadorJuego.correrJuego();
	}

}
