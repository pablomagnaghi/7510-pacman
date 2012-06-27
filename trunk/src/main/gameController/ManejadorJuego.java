package main.gameController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.config.ConfiguracionPrincipal;
import main.model.Laberinto;

public class ManejadorJuego {

	private Laberinto laberinto;

	private static final Pattern ancho = Pattern.compile("\\sancho=\"(\\d+)\"", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static final Pattern alto = Pattern.compile("\\salto=\"(\\d+)\"", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static final Pattern nodoAncho = Pattern.compile("\\snodoAncho=\"(\\d+)\"", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static final Pattern nodoAlto = Pattern.compile("\\snodoAlto=\"(\\d+)\"", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static final Pattern inicioPacman = Pattern.compile("\\sinicioPacman=\"(\\d+)\"", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	private static final Pattern inicioFantasmas = Pattern.compile("\\sinicioFantasmas=\"(\\d+)\"", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);


	public ManejadorJuego(String configuracion){
		ConfiguracionPrincipal.getInstance().leerParametros(configuracion);
		String input = ConfiguracionPrincipal.getInstance().getArchivoLaberinto();
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(new File(input));
			br = new BufferedReader(fr);
			String firstLine = br.readLine();
			configurarParametrosLaberinto(firstLine);
			String line;
			while ((line = br.readLine()) != null){
				this.laberinto.parsearNodo(line);
			}
			Integer cantZonzos = ConfiguracionPrincipal.getInstance().getCantFantasmaZonzo();
			Integer cantBuscadores = ConfiguracionPrincipal.getInstance().getCantFantasmaBuscador();
			Integer cantPerezosos = ConfiguracionPrincipal.getInstance().getCantFantasmaPerezoso();

			this.laberinto.inicializarActores(cantZonzos, cantBuscadores, cantPerezosos);
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void configurarParametrosLaberinto(String line) {
		Integer cantColumnas = null;
		Integer cantFilas = null;
		Matcher matcher = ancho.matcher(line);
		if (matcher.find()){
			cantColumnas = new Integer(matcher.group(1));
		}
		matcher = alto.matcher(line);
		if (matcher.find()){
			cantFilas = new Integer(matcher.group(1));
		}
		this.laberinto = new Laberinto(cantFilas, cantColumnas);
		matcher = nodoAncho.matcher(line);
		if (matcher.find()){
			this.laberinto.setNodoAncho(new Integer(matcher.group(1)));
		}
		matcher = nodoAlto.matcher(line);
		if (matcher.find()){
			this.laberinto.setNodoAlto(new Integer(matcher.group(1)));
		}
		matcher = inicioPacman.matcher(line);
		if (matcher.find()){
			this.laberinto.setInicioPacman(matcher.group(1));
		}

		matcher = inicioFantasmas.matcher(line);
		if (matcher.find()){
			this.laberinto.setInicioFantasma(matcher.group(1));
		}

	}

	public Laberinto getLaberinto() {
		return laberinto;
	}

	public void correrJuego(){
		Boolean finished = false;
		ManejadorTurnos.getInstance().setLaberinto(laberinto);
		ManejadorReglas.getInstance().setLaberinto(laberinto);
		String salidaActores = ConfiguracionPrincipal.getInstance().getDirectorioSalida() + "PersonajesTick";
		String salidaLaberinto = ConfiguracionPrincipal.getInstance().getDirectorioSalida() + "LaberintoTick";
		Integer tickNumber = 1;
		Integer outputNumber = 1;
		while (!finished){
			Boolean isPacmanMoving = ManejadorTurnos.getInstance().ejecutarTurnoPacman(tickNumber);
			ManejadorReglas.getInstance().chequearActoresMuertos();
			finished = ManejadorReglas.getInstance().estaElPacmanEliminado();
			if (finished){
				System.out.println("Fin, pacman eliminado");
			} else {
				ManejadorTurnos.getInstance().ejecutarTurnoFantasma();
				ManejadorReglas.getInstance().chequearActoresMuertos();
				ManejadorReglas.getInstance().chequearTiempos();
				finished = ManejadorReglas.getInstance().estaElPacmanEliminado();
				if (finished){
					System.out.println("Fin, pacman eliminado");
				} else {
					finished = !(this.laberinto.hayMasBolitas());
					if (finished){
						System.out.println("Fin, todas las pelotas comidas");
					}
				}
			}
			if (isPacmanMoving || tickNumber == 1 || finished){
				this.laberinto.imprimirActoresAXml(salidaActores, outputNumber, finished);
				this.laberinto.imprimirLaberintoAXml(salidaLaberinto, outputNumber);
				if (isPacmanMoving){
					outputNumber++;
				}
			}
			tickNumber++;
		}
	}

}
