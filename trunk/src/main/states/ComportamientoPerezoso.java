package main.states;

import main.config.Constantes;
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

	@Override
	public String getNombre(Fantasma fantasma) {
		return Constantes.PEREZOSO;
	}

}
