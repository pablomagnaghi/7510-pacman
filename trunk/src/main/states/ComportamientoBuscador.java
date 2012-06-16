package main.states;

import main.config.Constantes;
import main.model.Comportamiento;
import main.model.Fantasma;

public class ComportamientoBuscador extends Comportamiento{

	private static ComportamientoBuscador instance = null;

	public static ComportamientoBuscador getInstance() {
		if (instance == null){
			instance = new ComportamientoBuscador();
		}
		return instance;
	}
	
	@Override
	public void realizarMovimientoCazador(Fantasma fantasma) {
		super.realizarMovimiento(fantasma, Constantes.DISTANCIA_BUSCADOR + fantasma.getIra() - 1, Constantes.ACCION_ACERCAR);
	}

	@Override
	public String getNombre(Fantasma fantasma) {
		if (fantasma.getIra() == Constantes.IRA_ESTADO_FURIOSO){
			return Constantes.BUSCADOR;
		} else {
			return Constantes.BUSCADOR_T;
		}
	}

	@Override
	public void realizarMovimientoPresa(Fantasma fantasma) {
		super.realizarMovimiento(fantasma, Constantes.DISTANCIA_BUSCADOR, Constantes.ACCION_ESCAPAR);
	}

}
