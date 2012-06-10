package main.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Laberinto {

	private Map<Posicion, Celda> mapa;
	private final Posicion posicionInicioPacman = new Posicion(17,14);
	private final Posicion posicionInicioLaberinto = new Posicion(0,0);
	private final Posicion posicionFinalLaberinto = new Posicion(27,27);
	private final Posicion posicionInicioFantasma = new Posicion(11,14);
	private Map<Integer, String> mapaString;

	public Laberinto(String input){
		this.mapa = new HashMap<Posicion, Celda>();
		this.mapaString = new HashMap<Integer, String>();
		construirCeldas(input);
	}

	public Posicion getPosicionInicioPacman() {
		return posicionInicioPacman;
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
						Posicion posicion = new Posicion(positionIndex, lineIndex);
						Celda celda = new Celda(val);
						System.out.print(celda.toString());
						this.mapa.put(posicion, celda);
						relacionarCeldas(posicion, celda);
						positionIndex++;
					}
					charIndex++;
				}
				System.out.println();
				lineIndex++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void relacionarCeldas(Posicion posicion, Celda celda) {
		Posicion sigPosicionIzquierda = posicion.getSigPosicionIzquierda();
		Celda celdaIzquierda = this.mapa.get(sigPosicionIzquierda);
		asignarRelacionIzquieda(celda, celdaIzquierda);
		Posicion sigPosicionArriba = posicion.getSigPosicionArriba();
		Celda celdaArriba = this.mapa.get(sigPosicionArriba);
		asignarRelacionArriba(celda, celdaArriba);
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
		return posicionInicioFantasma;
	}

	public void imprimirLaberintoDerecho(){
		Boolean hayAbajo = Boolean.TRUE;
		Celda celda = mapa.get(this.posicionInicioLaberinto);
		while (hayAbajo){
			Boolean hayDerecha = Boolean.TRUE;
			Celda celdaActual = celda;
			while (hayDerecha){
				System.out.println(celdaActual);
				celdaActual = celdaActual.getCeldaDerecha();
				if (celdaActual == null){
					hayDerecha = Boolean.FALSE;
				}
			}
			celda = celda.getCeldaAbajo();
			if (celda == null){
				hayAbajo = Boolean.FALSE;
			}
		}
	}
	
}
