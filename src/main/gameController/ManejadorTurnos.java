package main.gameController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.config.Constantes;
import main.model.Celda;
import main.model.Fantasma;
import main.model.Laberinto;
import main.model.Pacman;

public class ManejadorTurnos {

	private static ManejadorTurnos instance = null;

	private String sentido;
	private Laberinto laberinto;
	private Integer tick = 1;
	private Integer turnoPacman = 1;
	private Boolean hayMas = Boolean.TRUE;

	public String leerTurnoPacman(){
		String direccion = null;
		try {
			FileReader fr = new FileReader(new File(Constantes.ARCHIVO_PACMAN + turnoPacman + ".txt"));
			this.turnoPacman++;
			String line;
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null && direccion == null){
				direccion = parsearOrden(line);
			}

			fr.close();
		} catch (IOException e) {
			this.hayMas = Boolean.FALSE;
		}
		return direccion;
	}



	private String parsearOrden(String line) {
		Pattern ordenPat = Pattern.compile("<pacman\\s*direccion=\"([^\"]*)\"/>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher m = ordenPat.matcher(line);
		if (m.find()){
			return m.group(1);
		}
		return null;
	}

	public void ejecutarTurno(){
		if (this.tick % Constantes.PACMAN_VELOCIDAD == 0){
			moverPacman();
		}

		Iterator<Fantasma> it = this.laberinto.getFantasmas().iterator();
		while (it.hasNext()){
			Fantasma fantasma = it.next();
			if (((this.tick % Constantes.FANTASMA_VELOCIDAD_FURIOSO == 0) && fantasma.getIra().equals(Constantes.IRA_ESTADO_FURIOSO))
					||
					((this.tick % Constantes.FANTASMA_VELOCIDAD_MOLESTO == 0) && fantasma.getIra().equals(Constantes.IRA_ESTADO_MOLESTO))
					||
					((this.tick % Constantes.FANTASMA_VELOCIDAD_NORMAL == 0) && fantasma.getIra().equals(Constantes.IRA_ESTADO_NORMAL))){
				fantasma.mover();
			}

			if (this.tick % Constantes.FANTASMA_TICKS_ENOJO == 0){
				fantasma.incrementarIra();
			}
		}

		this.tick++;
	}

	private void moverPacman() {
		String direccionPacman = leerTurnoPacman();
		Boolean resultadoDeMovimiento;
		resultadoDeMovimiento = Pacman.getInstance().mover(direccionPacman); 
		if (resultadoDeMovimiento){
			this.sentido = direccionPacman;
		} else {
			resultadoDeMovimiento = Pacman.getInstance().mover(this.sentido);
		}
		if (resultadoDeMovimiento){
			Celda celda = this.laberinto.getCelda(Pacman.getInstance().getSiguienteCelda());
			Pacman.getInstance().setCeldaActual(celda);
			Pacman.getInstance().setSentido(this.sentido);
			celda.visitarPorPacman();
		}
	}

	public static ManejadorTurnos getInstance() {
		if (instance == null){
			instance = new ManejadorTurnos();
		}
		return instance;
	}

	public void setLaberinto(Laberinto laberinto) {
		this.laberinto = laberinto;
	}

	public Boolean esFinDeJuego() {
		return !hayMas;
	}

}
