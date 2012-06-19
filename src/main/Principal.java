package main;

import main.gameController.ManejadorJuego;


public class Principal {

	public static void main(String[] args) {
		if (args.length == 0){
			System.out.println("Ingrese un archivo de configuracion valido");
		} else {
			final String fileName = args[0];
			ManejadorJuego manejadorJuego = new ManejadorJuego(fileName);
			manejadorJuego.correrJuego();
		}
	}

}
