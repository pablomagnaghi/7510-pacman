package main.states;

import main.config.Constantes;
import main.config.Evento;
import main.model.Estado;
import main.model.Fantasma;

public class EstadoCazador implements Estado{

	private static EstadoCazador instance = null;
	
	private EstadoCazador(){
		
	}
	
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
	public String getNombre() {
		return Constantes.CAZADOR;
	}

	@Override
	public Estado getNextState(Integer evento) {
		if (Evento.CONVERTIR_PRESA.equals(evento)){
			System.out.println(Constantes.CONVERTIR_CAZADOR_A_PRESA);
			return EstadoPresa.getInstance();
		}
		if (Evento.CONVERTIR_CAZADOR.equals(evento)){
			System.out.println(Constantes.CONVERTIR_CAZADOR_A_CAZADOR);
		}
		if (Evento.ELIMINAR.equals(evento)){
			System.out.println(Constantes.ELIMINAR_CAZADOR);
		}
		if (Evento.REVIVIR.equals(evento)){
			System.out.println(Constantes.REVIVIR_CAZADOR);
		}
		return instance;
	}

	public static EstadoCazador getInstance() {
		if (instance == null){
			instance = new EstadoCazador();
		}
		return instance;
	}

}
