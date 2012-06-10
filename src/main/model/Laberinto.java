package main.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Laberinto {

	private Map<Posicion, Celda> mapa;
	private final Posicion posicionInicioPacman = new Posicion(17,14);
	private final Posicion posicionInicioFantasma = new Posicion(11,14);

	public Laberinto(String input){
		this.mapa = new HashMap<Posicion, Celda>();
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
						this.mapa.put(posicion, celda);
						relacionarCeldas(posicion, celda);
						positionIndex++;
					}
					charIndex++;
				}
				lineIndex++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void relacionarCeldas(Posicion posicion, Celda celda) {
		Posicion sigPosicionDerecha = posicion.getSigPosicionDerecha();
		Celda celdaDerecha = this.mapa.get(sigPosicionDerecha);
		Posicion sigPosicionIzquierda = posicion.getSigPosicionIzquierda();
		Celda celdaIzquierda = this.mapa.get(sigPosicionIzquierda);
		Posicion sigPosicionArriba = posicion.getSigPosicionArriba();
		Celda celdaArriba = this.mapa.get(sigPosicionArriba);
		Posicion sigPosicionAbajo = posicion.getSigPosicionAbajo();
		Celda celdaAbajo = this.mapa.get(sigPosicionAbajo);
	}

	public Posicion getPosicionInicioFantasma() {
		return posicionInicioFantasma;
	}

}
