package main.states;

import main.model.Comportamiento;
import main.model.Fantasma;

public class ComportamientoPerezoso implements Comportamiento{

	private static ComportamientoPerezoso instance = null;

	public static ComportamientoPerezoso getInstance() {
		if (instance == null){
			instance = new ComportamientoPerezoso();
		}
		return instance;
	}
	
	@Override
	public void realizarMovimiento(Fantasma fantasma) {
		
	}

}
