package tests;

import static org.junit.Assert.*;

import main.config.Constantes;
import main.model.Bolita;
import main.model.Celda;
import main.states.BolitaGrande;
import main.states.BolitaNormal;
import main.states.BolitaNula;

import org.junit.Test;

public class PruebasCelda {
	
	@Test
	public void crearCelda() {
		Celda c = new Celda(Constantes.BOLITA,"0001");
		assertTrue(c.getId().equals("0001"));
		assertTrue(c.getBolita().getClass().equals(BolitaNormal.class));
	}
	
	@Test
	public void CeldaSiguiente() {
		Celda c = new Celda(Constantes.BOLITA,"0001");
		c.setCeldaDerecha("0003");
		assertTrue(c.getSiguienteCelda(Constantes.DERECHA).equals("0003"));
	}
	
	@Test
	public void CeldaComer() {
		Celda c = new Celda(Constantes.BOLITA,"0001");
		c.visitarPorPacman();
		assertTrue(c.getBolita().getClass().equals(BolitaNula.class));
	}
	
	@Test
	public void CeldaBifurcacion() {
		Celda c = new Celda(Constantes.BOLITA,"0001");
		c.setCeldaAbajo("0002");
		c.setCeldaDerecha("0003");
		c.setCeldaIzquierda("0004");
		assertTrue(c.esBifurcacion().equals(true));
	}
	
	@Test
	public void Celdagetfila() {
		Celda c = new Celda(Constantes.BOLITA,"0001");
		assertTrue(c.getFila().equals("00"));
	}
	
	@Test
	public void Celdagetcolumna() {
		Celda c = new Celda(Constantes.BOLITA,"0001");
		assertTrue(c.getColumna().equals("01"));
	}
	
	@Test
	public void CeldagetDistancia() {
		Integer i=Celda.getDistanciaEntreCeldas("0001", "0102");
		assertTrue(i.equals(2));
	}
}
