package main.states;

import main.config.Constantes;
import main.model.Estado;
import main.model.Fantasma;

public class EstadoMuerto implements Estado{

	@Override
	public void mover(Fantasma fantasma) {
		System.out.println(Constantes.MOVER_MUERTO);		
	}

	@Override
	public void incrementarIra(Fantasma fantasma) {
		System.out.println(Constantes.INCREMENTAR_IRA_MUERTO);		
	}

	@Override
	public Estado eliminar() {
		System.out.println(Constantes.ELIMINAR_MUERTO);
		return null;
	}

	@Override
	public String getNombre() {
		return Constantes.MUERTO;
	}

	@Override
	public Estado convertirEnCazador(Fantasma fantasma) {
		System.out.println(Constantes.CONVERTIR_MUERTO_A_CAZADOR);
		fantasma.setIra(Constantes.IRA_MINIMA);
		return new EstadoCazador();
	}

	@Override
	public Estado convertirEnPresa() {
		System.out.println(Constantes.CONVERTIR_MUERTO_A_PRESA);
		return null;
	}

}
