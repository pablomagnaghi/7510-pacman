package main.model;

import main.config.Constantes;


public abstract class Comportamiento {

	public abstract void realizarMovimientoCazador(Fantasma fantasma);
	
	public abstract void realizarMovimientoPresa(Fantasma fantasma);

	public abstract String getNombre(Fantasma fantasma);
	
	public void realizarMovimiento(Fantasma fantasma, Integer distancia, Integer accion){
		String direccion = "";
		if (fantasma.estaCercaDePacman(distancia)){
			if (Constantes.ACCION_ESCAPAR.equals(accion)){
				direccion = fantasma.getDireccionMasLejanAPacman();
			} else {
				direccion = fantasma.getDireccionMasCercanaAPacman();
			}
		} else {
			if (fantasma.getCeldaActual().esBifurcacion()){
				direccion = fantasma.getDireccionAleatoria();
			} else {
				direccion = fantasma.getSentido();
			}
		}
		fantasma.setSiguienteCelda(fantasma.getCeldaActual().getSiguienteCelda(direccion));
		fantasma.setSentido(direccion);
	}
	
}
