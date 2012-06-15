package main;

import main.gameController.ManejadorJuego;


public class Principal {

	public static void main(String[] args) {
		ManejadorJuego manejadorJuego = new ManejadorJuego();
//		manejadorJuego.correrJuego();
		manejadorJuego.getLaberinto().imprimirAXML();
	}

}
