package main.model;

import java.util.Observable;

import main.gameController.ManejadorReglas;

public abstract class Bolita extends Observable{

	public Bolita(){
		addObserver(ManejadorReglas.getInstance());
	}
	
	public abstract void comer();

	public abstract String imprimir();

	public abstract Boolean fueComida();

	public abstract String getContent();
	
}
