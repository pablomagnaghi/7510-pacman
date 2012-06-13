package main;

import main.gameController.ManejadorJuego;


public class Principal {

//	public static void main(String[] args) {
//		if (args.length == 0){
//			System.out.println(Constantes.ERROR_PARAMETROS);
//		} else {
//			final String fileName = args[0];
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						ControladorConsola controlador = new ControladorConsola(fileName);
//						controlador.mostrarVista();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}
//	}
//	

	public static void main(String[] args) {
		ManejadorJuego manejadorJuego = new ManejadorJuego();
		manejadorJuego.correrJuego();
	}

}
