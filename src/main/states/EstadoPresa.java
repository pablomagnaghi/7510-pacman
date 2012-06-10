package main.states;

import main.config.Constantes;
import main.config.Evento;
import main.model.Estado;
import main.model.Fantasma;

public class EstadoPresa implements Estado{

	private static EstadoPresa instance = null;
	
	private EstadoPresa(){
		
	}
	
	@Override
	public String mover(Fantasma fantasma) {
		fantasma.getComportamiento().realizarMovimiento(fantasma);
		return(Constantes.MOVER_PRESA);
	}

	@Override
	public String incrementarIra(Fantasma fantasma) {
		return Constantes.INCREMENTAR_IRA_PRESA;
	}

	@Override
	public String getNombre() {
		return Constantes.PRESA;
	}
	
	public static EstadoPresa getInstance(){
		if (instance == null){
			instance = new EstadoPresa();
		}
		return instance;
	}

	@Override
	public Estado getNextState(Integer evento) {
		if (Evento.CONVERTIR_CAZADOR.equals(evento)){
			System.out.println(Constantes.CONVERTIR_PRESA_A_CAZADOR);
			return EstadoCazador.getInstance();
		} else if (Evento.ELIMINAR.equals(evento)){
			System.out.println(Constantes.ELIMINAR_PRESA);
			return EstadoMuerto.getInstance();
		}
		if (Evento.CONVERTIR_PRESA.equals(evento)){
			System.out.println(Constantes.CONVERTIR_PRESA_A_PRESA);
		}
		if (Evento.REVIVIR.equals(evento)){
			System.out.println(Constantes.REVIVIR_PRESA);
		}
		return instance;
	}

}
