package main;

import java.awt.EventQueue;

import Controller.ControladorConsola;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControladorConsola controlador = new ControladorConsola();
					controlador.mostrarVista();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
}
