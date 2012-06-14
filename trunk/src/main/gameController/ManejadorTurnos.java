package main.gameController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import main.config.Constantes;
import main.model.Fantasma;
import main.model.Pacman;

public class ManejadorTurnos {

	private static ManejadorTurnos instance = null;
	
	private List<Fantasma> fantasmas;
	private BufferedReader br;
	private Integer ordenActual;
	
	private ManejadorTurnos(){
		FileReader fr;
		try {
			fr = new FileReader(new File(Constantes.ARCHIVO_PACMAN));
			this.br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Integer leerTurnoPacman(){
		String line;
		try {
			if ((line = br.readLine()) != null){
				ordenActual = parsearOrden(line);
			} else {
				ordenActual = Constantes.PACMAN_FIN;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ordenActual;
	}
	
	private Integer parsearOrden(String line) {
		if (Constantes.ABAJO.equals(line)){
			return Constantes.PACMAN_ABAJO;
		} else if (Constantes.ARRIBA.equals(line)){
			return Constantes.PACMAN_ARRIBA;
		} else if (Constantes.IZQUIERDA.equals(line)){
			return Constantes.PACMAN_IZQUIERDA;
		} else if (Constantes.DERECHA.equals(line)){
			return Constantes.PACMAN_DERECHA;
		} 
		return Constantes.PACMAN_FIN;
	}

	public void ejecutarTurno(){
		if (Pacman.getInstance().getCeldaActual().esBifurcacion()){
			Pacman.getInstance().mover(leerTurnoPacman());
		} else {
			if (!Pacman.getInstance().mover(this.ordenActual)){
				Pacman.getInstance().mover(leerTurnoPacman());
			}
		}
		Iterator<Fantasma> it = fantasmas.iterator();
		while (it.hasNext()){
			Fantasma fantasma = it.next();
			fantasma.mover();
		}
	}
	
	public Boolean esFinDeJuego(){
		return (Constantes.PACMAN_FIN.equals(this.ordenActual));
	}
	
	public void setFantasmas(List<Fantasma> fantasmas){
		this.fantasmas = fantasmas;
	}
	
	public static ManejadorTurnos getInstance() {
		if (instance == null){
			instance = new ManejadorTurnos();
		}
		return instance;
	}
	
}
