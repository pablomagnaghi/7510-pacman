package main.states;

import main.config.ConfiguracionPrincipal;
import main.config.Constantes;
import main.model.Comportamiento;
import main.model.Fantasma;

public class ComportamientoZonzo extends Comportamiento{
	
	private static ComportamientoZonzo instance = null;

	@Override
	public void realizarMovimientoCazador(Fantasma fantasma) {
		super.realizarMovimiento(fantasma, ConfiguracionPrincipal.getInstance().getDistanciaZonzo(), Constantes.ACCION_ACERCAR);
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

	@Override
	public void realizarMovimientoPresa(Fantasma fantasma) {
		super.realizarMovimiento(fantasma, ConfiguracionPrincipal.getInstance().getDistanciaZonzo(), Constantes.ACCION_ESCAPAR);
	}

}
