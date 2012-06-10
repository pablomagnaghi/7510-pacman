package main.states;

import main.config.Constantes;
import main.config.Evento;
import main.model.Estado;
import main.model.Fantasma;

public class EstadoMuerto implements Estado{

	private static EstadoMuerto instance = null;
	
	private EstadoMuerto(){
		
	}
	
	@Override
	public String mover(Fantasma fantasma) {
		fantasma.getComportamiento().realizarMovimiento(fantasma);
		return(Constantes.MOVER_MUERTO);		
	}

	@Override
	public String incrementarIra(Fantasma fantasma) {
		return Constantes.INCREMENTAR_IRA_MUERTO;		
	}

	@Override
	public String getNombre() {
		return Constantes.MUERTO;
	}

	@Override
	public Estado getNextState(Integer evento) {
		if (Evento.REVIVIR.equals(evento)){
			System.out.println(Constantes.REVIVIR_MUERTO);
			return EstadoCazador.getInstance();
		}
		if (Evento.CONVERTIR_CAZADOR.equals(evento)){
			System.out.println(Constantes.CONVERTIR_MUERTO_A_CAZADOR);
		}
		if (Evento.CONVERTIR_PRESA.equals(evento)){
			System.out.println(Constantes.CONVERTIR_MUERTO_A_PRESA);
		}
		if (Evento.ELIMINAR.equals(evento)){
			System.out.println(Constantes.ELIMINAR_MUERTO);
		}
		return instance;
	}
	
	public static EstadoMuerto getInstance(){
		if (instance == null){
			instance = new EstadoMuerto();
		}
		return instance;
	}

}
