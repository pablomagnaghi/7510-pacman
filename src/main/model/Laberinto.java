package main.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import main.config.Constantes;

public class Laberinto {

	private Map<Posicion, Celda> mapa;
	private Posicion posiciones[][] = new Posicion[Constantes.LABERINTO_HEIGHT][Constantes.LABERINTO_WIDTH];

	public Laberinto(String input){
		crearPosiciones();
		this.mapa = new HashMap<Posicion, Celda>();
		construirCeldas(input);
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
		return this.posiciones[17][14];
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
		return this.posiciones[11][14];
	}
	

	public Posicion getPosicionInicioLaberinto() {
		return this.posiciones[0][0];
	}

	public void imprimirLaberintoDerecho(){
		System.out.println("----Imprimiendo laberinto -----");
		Boolean hayAbajo = Boolean.TRUE;
		Celda celda = mapa.get(getPosicionInicioLaberinto());
		while (hayAbajo){
			Boolean hayDerecha = Boolean.TRUE;
			Celda celdaActual = celda;
			while (hayDerecha){
				System.out.print(celdaActual);
				celdaActual = celdaActual.getCeldaDerecha();
				if (celdaActual == null){
					hayDerecha = Boolean.FALSE;
				}
			}
			System.out.println();
			celda = celda.getCeldaAbajo();
			if (celda == null){
				hayAbajo = Boolean.FALSE;
			}
		}
	}
	
}
