package tests;

import static org.junit.Assert.*;
import main.config.Constantes;
import main.model.Pacman;
import main.model.Celda;

import org.junit.Test;

public class PruebasPacman {
	
	@Test
	public void crearPacman() {
		Pacman f = Pacman.getInstance();
		assertTrue(f.getClass().equals(Pacman.class));
	}
	
	@Test
	public void PacmanSingle() {
		Pacman p1 = Pacman.getInstance();
		Pacman p2 = Pacman.getInstance();
		assertTrue(p1.equals(p2));
	}
	
	@Test
	public void PacmanSentido() {
		Pacman p = Pacman.getInstance();
		p.setSentido(Constantes.ABAJO);
		assertTrue(p.getSentido().equals(Constantes.ABAJO));
	}
	
	@Test
	public void PacmanMoverFalse() {
		Celda c = new Celda(Constantes.BOLITA,"0001"); 
		Pacman p1 = Pacman.getInstance();
		p1.setCeldaActual(c);
		assertTrue(p1.mover(Constantes.DERECHA).equals(false));
		assertTrue(p1.getSiguienteCelda().equals(p1.getCeldaActual().getId()));
	}
	
	@Test
	public void PacmanMoverTrue() {
		Celda c = new Celda(Constantes.BOLITA,"0001");
		c.setCeldaDerecha("0002");
		Pacman p1 = Pacman.getInstance();
		p1.setCeldaActual(c);
		assertTrue(p1.mover(Constantes.DERECHA).equals(true));
		assertTrue(p1.getSiguienteCelda().equals("0002"));
	}
	
}
