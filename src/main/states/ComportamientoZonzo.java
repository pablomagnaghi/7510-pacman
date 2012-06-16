package main.states;

import main.config.Constantes;
import main.model.Comportamiento;
import main.model.Fantasma;

public class ComportamientoZonzo implements Comportamiento{
	
	private static ComportamientoZonzo instance = null;

	@Override
	public void realizarMovimiento(Fantasma fantasma) {
		
	}

	public static ComportamientoZonzo getInstance() {
		if (instance == null){
			instance = new ComportamientoZonzo();
		}
		return instance;
	}

	@Override
	public String getNombre(Fantasma fantasma) {
		return Constantes.ZONZO;
	}

}
