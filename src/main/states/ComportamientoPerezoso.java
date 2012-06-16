package main.states;

import main.config.Constantes;
import main.model.Comportamiento;
import main.model.Fantasma;

public class ComportamientoPerezoso extends Comportamiento{

	private static ComportamientoPerezoso instance = null;

	public static ComportamientoPerezoso getInstance() {
		if (instance == null){
			instance = new ComportamientoPerezoso();
		}
		return instance;
	}
	
	@Override
	public void realizarMovimientoCazador(Fantasma fantasma) {
		super.realizarMovimiento(fantasma, Constantes.DISTANCIA_PEREZOSO, Constantes.ACCION_ACERCAR);
	}

	@Override
	public String getNombre(Fantasma fantasma) {
		return Constantes.PEREZOSO;
	}

	@Override
	public void realizarMovimientoPresa(Fantasma fantasma) {
		super.realizarMovimiento(fantasma, Constantes.DISTANCIA_PEREZOSO, Constantes.ACCION_ESCAPAR);
	}

}
