package main.gameController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.config.ConfiguracionPrincipal;
import main.config.Constantes;
import main.model.Celda;
import main.model.Fantasma;
import main.model.Laberinto;
import main.model.Pacman;
import main.states.EstadoPresa;

public class ManejadorTurnos {

	private static ManejadorTurnos instance = null;

	private String sentido;
	private Laberinto laberinto;
	private Integer tick = 1;
	private Integer turnoPacman = 1;
	private Boolean hayMas = Boolean.TRUE;

	public String leerTurnoPacman(String archivoPacman){
		String direccion = null;
		try {
			FileReader fr = new FileReader(new File(archivoPacman + turnoPacman + ".txt"));
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

	public void ejecutarTurnoPacman(){
		if (this.getTickNumber() % Constantes.PACMAN_VELOCIDAD == 0){
			System.out.println("Moviendo pacman");
			moverPacman();
		}
	}
	
	public void ejecutarTurnoFantasma(){
		Iterator<Fantasma> it = this.laberinto.getFantasmas().iterator();
		while (it.hasNext()){
			Fantasma fantasma = it.next();
			if (((this.getTickNumber() % Constantes.FANTASMA_VELOCIDAD_FURIOSO == 0) && fantasma.getIra().equals(Constantes.IRA_ESTADO_FURIOSO))
					||
					((this.getTickNumber() % Constantes.FANTASMA_VELOCIDAD_MOLESTO == 0) && fantasma.getIra().equals(Constantes.IRA_ESTADO_MOLESTO))
					||
					((this.getTickNumber() % Constantes.FANTASMA_VELOCIDAD_NORMAL == 0) && fantasma.getIra().equals(Constantes.IRA_ESTADO_NORMAL))){
				System.out.println("Moviendo fantasma");
				fantasma.mover();
				Celda celda = this.laberinto.getCelda(fantasma.getSiguienteCelda());
				fantasma.setCeldaActual(celda);
			}

			if (this.getTickNumber() % Constantes.FANTASMA_TICKS_ENOJO == 0 && !(fantasma.getEstado().equals(EstadoPresa.getInstance()))){
				System.out.println("AumentandoIra");
				fantasma.incrementarIra();
			}
		}
		this.tick = this.getTickNumber() + 1;
	}

	private void moverPacman() {
		String direccionPacman = leerTurnoPacman(ConfiguracionPrincipal.getInstance().getDirectorioOrdenes() + "Ordenes");
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

	public Boolean hayMasMovimientos() {
		return !hayMas;
	}

	public Integer getTickNumber() {
		return tick;
	}

}
