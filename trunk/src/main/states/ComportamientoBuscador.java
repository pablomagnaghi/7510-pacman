package main.states;

import main.config.Constantes;
import main.model.Comportamiento;
import main.model.Fantasma;

public class ComportamientoBuscador implements Comportamiento{

	private static ComportamientoBuscador instance = null;

	public static ComportamientoBuscador getInstance() {
		if (instance == null){
			instance = new ComportamientoBuscador();
		}
		return instance;
	}
	
	@Override
	public void realizarMovimiento(Fantasma fantasma) {

	}

	@Override
	public String getNombre(Fantasma fantasma) {
		if (fantasma.getIra() == Constantes.IRA_ESTADO_FURIOSO){
			return Constantes.BUSCADOR;
		} else {
			return Constantes.BUSCADOR_T;
		}
	}

}
