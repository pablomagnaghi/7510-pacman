package main.states;

import main.config.Constantes;
import main.model.Estado;
import main.model.Fantasma;

public class EstadoCazador implements Estado{

	@Override
	public void mover(Fantasma fantasma) {
		System.out.println(Constantes.MOVER_CAZADOR + fantasma.getIra());
	}

	@Override
	public void incrementarIra(Fantasma fantasma) {
		if (fantasma.getIra() < Constantes.IRA_MAXIMA){
			fantasma.setIra(fantasma.getIra()+1);
		}
	}

	@Override
	public Estado eliminar() {
		System.out.println(Constantes.ELIMINAR_CAZADOR);
		return null;
	}

	@Override
	public String getNombre() {
		return Constantes.CAZADOR;
	}

	@Override
	public Estado convertirEnCazador(Fantasma fantasma) {
		System.out.println(Constantes.CONVERTIR_CAZADOR_A_CAZADOR);
		return null;
	}

	@Override
	public Estado convertirEnPresa() {
		System.out.println(Constantes.CONVERTIR_CAZADOR_A_PRESA);
		return new EstadoPresa();
	}
	
}
