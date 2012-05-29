package main.states;

import main.config.Constantes;
import main.model.Estado;
import main.model.Fantasma;

public class EstadoPresa implements Estado{

	@Override
	public void mover(Fantasma fantasma) {
		System.out.println(Constantes.MOVER_PRESA);
	}

	@Override
	public void incrementarIra(Fantasma fantasma) {
		System.out.println(Constantes.INCREMENTAR_IRA_PRESA);
	}

	@Override
	public Estado eliminar() {
		System.out.println(Constantes.ELIMINAR_PRESA);
		return new EstadoMuerto();
	}

	@Override
	public String getNombre() {
		return Constantes.PRESA;
	}

	@Override
	public Estado convertirEnCazador(Fantasma fantasma) {
		System.out.println(Constantes.CONVERTIR_PRESA_A_CAZADOR);
		return new EstadoCazador();
	}

	@Override
	public Estado convertirEnPresa() {
		System.out.println(Constantes.CONVERTIR_PRESA_A_PRESA);
		return null;
	}

}
