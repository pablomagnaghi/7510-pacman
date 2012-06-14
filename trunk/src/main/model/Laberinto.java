package main.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.config.Constantes;
import main.states.ComportamientoZonzo;

public class Laberinto {

	private Map<Posicion, Celda> mapa;
	private Posicion posiciones[][] = new Posicion[Constantes.LABERINTO_HEIGHT][Constantes.LABERINTO_WIDTH];
	private Posicion primerPortal;
	private Posicion segundoPortal;
	private List<Fantasma> fantasmas;

	public Laberinto(String input){
		crearPosiciones();
		this.mapa = new HashMap<Posicion, Celda>();
		construirCeldas(input);
		this.fantasmas = new ArrayList<Fantasma>();
		Celda celda = this.mapa.get(getPosicionInicioFantasma());
		this.getFantasmas().add(new Fantasma(Constantes.COLOR_AMARILLO, celda, ComportamientoZonzo.getInstance()));
		Pacman.getInstance().setCeldaActual(this.mapa.get(getPosicionInicioPacman()));
	}

	private void crearPosiciones() {
		Integer height;
		for (height = 0 ; height < Constantes.LABERINTO_HEIGHT; height++){
			Integer width;
			for (width = 0 ; width < Constantes.LABERINTO_WIDTH; width++ ){
				this.posiciones[height][width] = new Posicion(height, width);
			}
		}
	}

	public Posicion getPosicionInicioPacman() {
		return this.posiciones[1][1];
	}

	public Map<Posicion, Celda> getMapa() {
		return mapa;
	}

	public void setMapa(Map<Posicion, Celda> mapa) {
		this.mapa = mapa;
	}

	public void construirCeldas(String archivoEntrada){
		FileReader fr;
		try {
			fr = new FileReader(new File(archivoEntrada));
			BufferedReader br = new BufferedReader(fr);
			Integer lineIndex = 0;
			String line;
			while ((line = br.readLine()) != null){
				Integer charIndex = 0;
				Integer positionIndex = 0;
				while (charIndex < 55){
					char val = line.charAt(charIndex);
					if (charIndex % 2 == 0){
						Posicion posicion = this.posiciones[lineIndex][positionIndex];
						Celda celda = new Celda(val, posicion);
						this.mapa.put(posicion, celda);
						relacionarCeldas(posicion, celda);
						if (val == 'p'){
							if (this.primerPortal == null){
								this.primerPortal = posicion;
							} else {
								this.segundoPortal = posicion;
							}
						}
						positionIndex++;
					}
					charIndex++;
				}
				lineIndex++;
			}
			asociarPortales();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void asociarPortales() {
		Celda celdaUno = this.mapa.get(primerPortal);
		Celda celdaDos = this.mapa.get(segundoPortal);
		if (celdaUno != null && celdaDos!= null){
			if (celdaUno.getCeldaAbajo()==null){
				celdaUno.setCeldaAbajo(celdaDos);
				celdaDos.setCeldaArriba(celdaUno);
			} else if (celdaUno.getCeldaArriba()==null){
				celdaUno.setCeldaArriba(celdaDos);
				celdaDos.setCeldaAbajo(celdaUno);
			} else if (celdaUno.getCeldaDerecha()==null){
				celdaUno.setCeldaDerecha(celdaDos);
				celdaDos.setCeldaIzquierda(celdaUno);
			}
			if (celdaUno.getCeldaIzquierda()==null){
				celdaUno.setCeldaIzquierda(celdaDos);
				celdaDos.setCeldaDerecha(celdaUno);
			}
		}
	}

	private void relacionarCeldas(Posicion posicion, Celda celda) {
		Integer width = posicion.getWidth();
		Integer height = posicion.getHeight();
		if ((width-1) >= 0){
			Posicion sigPosicionIzquierda = this.posiciones[height][width-1];
			Celda celdaIzquierda = this.mapa.get(sigPosicionIzquierda);
			asignarRelacionIzquieda(celda, celdaIzquierda);
		}
		if ((height-1)>=0){
			Posicion sigPosicionArriba = this.posiciones[height-1][width];
			Celda celdaArriba = this.mapa.get(sigPosicionArriba);
			asignarRelacionArriba(celda, celdaArriba);
		}
	}

	private void asignarRelacionArriba(Celda celda, Celda celdaArriba) {
		if (celdaArriba != null){
			celda.setCeldaArriba(celdaArriba);
			celdaArriba.setCeldaAbajo(celda);
		}
	}

	private void asignarRelacionIzquieda(Celda celda, Celda celdaIzquierda) {
		if (celdaIzquierda != null){
			celda.setCeldaIzquierda(celdaIzquierda);
			celdaIzquierda.setCeldaDerecha(celda);
		}
	}

	public Posicion getPosicionInicioFantasma() {
		return this.posiciones[1][16];
	}


	public Posicion getPosicionInicioLaberinto() {
		return this.posiciones[0][0];
	}

	public void imprimir(){
		System.out.println("----Imprimiendo laberinto -----");
		Boolean hayAbajo = Boolean.TRUE;
		Celda celda = mapa.get(getPosicionInicioLaberinto());
		while (hayAbajo){
			Boolean hayDerecha = Boolean.TRUE;
			Celda celdaActual = celda;
			while (hayDerecha){
				imprimirCelda(celdaActual);
				celdaActual = celdaActual.getCeldaDerecha();
				if (celdaActual == null || celdaActual.esPortal()){
					hayDerecha = Boolean.FALSE;
					if (celdaActual!= null && celdaActual.esPortal()){
						System.out.print(celdaActual);
					}
				}
			}
			System.out.println();
			celda = celda.getCeldaAbajo();
			if (celda == null){
				hayAbajo = Boolean.FALSE;
			}
		}
	}

	private void imprimirCelda(Celda celdaActual) {
		if (celdaActual.equals(Pacman.getInstance().getCeldaActual())){
			System.out.print("P");
		} else {
			Boolean hayFantasma = Boolean.FALSE;
			for (Fantasma fantasma : this.fantasmas) {
				if (fantasma.getCeldaActual().equals(celdaActual)){
					System.out.print("F");
					hayFantasma = Boolean.TRUE;
				}
			}
			if (!hayFantasma){
				System.out.print(celdaActual);
			}
		}
	}

	public Boolean hayMasBolitas(){
		Collection<Celda> values = this.mapa.values();
		for (Celda celda : values) {
			if (!celda.getBolita().fueComida()){
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	public List<Fantasma> getFantasmas() {
		return fantasmas;
	}

}
