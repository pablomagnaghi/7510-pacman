package main.gameController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.config.Constantes;
import main.model.Fantasma;
import main.model.Pacman;

public class ManejadorTurnos {

	private List<Fantasma> fantasmas;
	
	public ManejadorTurnos(){
		this.fantasmas = new ArrayList<Fantasma>();
		this.fantasmas.add(new Fantasma(Constantes.COLOR_AMARILLO));
		this.fantasmas.add(new Fantasma(Constantes.COLOR_ROJO));
		this.fantasmas.add(new Fantasma(Constantes.COLOR_VERDE));
		this.fantasmas.add(new Fantasma(Constantes.COLOR_NEGRO));
		ManejadorReglas.getInstance().setFantasmas(this.fantasmas);
	}
	
	public Integer leerTurnoPacman(){
		
		return 0;
	}
	
	public void ejecutarTurno(){
		Pacman.getInstance().mover(leerTurnoPacman());
		Iterator<Fantasma> it = fantasmas.iterator();
		while (it.hasNext()){
			Fantasma fantasma = it.next();
			fantasma.mover();
		}
	}
	
}
