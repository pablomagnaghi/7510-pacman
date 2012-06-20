package tests;

import static org.junit.Assert.*;

import java.util.Collection;

import main.config.*;
import main.model.*;
import main.gameController.*;
import main.states.*;

import org.junit.Test;

public class PruebasLaberinto {
	
	@Test
	public void laberintohayBolitas() {
		//Por medio del manejador de juego
		ManejadorJuego m = new ManejadorJuego("src\\tests\\ArchivoEntradaPrueba2.txt");
		Laberinto l = m.getLaberinto();		
		assertTrue(l.hayMasBolitas().equals(true));
	}
	
	@Test
	public void crearLaberinto() {
		//Por medio del manejador de juego
		ManejadorJuego m = new ManejadorJuego("src\\tests\\ArchivoEntradaPrueba.txt");
		Laberinto l = m.getLaberinto();
		assertTrue(l.getCantCol().equals(12));
		assertTrue(l.getCantFil().equals(1));
		assertTrue(l.getNodoAlto().equals(30));
		assertTrue(l.getNodoAncho().equals(30));
		assertTrue(l.getPosicionInicioFantasma().equals("0009"));
		assertTrue(l.getPosicionInicioPacman().equals("0001"));
	}
	
}
