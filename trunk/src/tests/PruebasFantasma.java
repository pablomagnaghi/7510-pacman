package tests;

import static org.junit.Assert.*;

import main.config.Constantes;
import main.model.Fantasma;
import main.states.EstadoMuerto;
import main.states.EstadoPresa;
import main.states.EstadoCazador;

import org.junit.Test;

public class PruebasFantasma {
	
	@Test
	public void crearFantasma() {
		Fantasma f = new Fantasma();
		assertTrue(f.getEstado().equals(EstadoCazador.getInstance()));
		assertTrue(f.getIra().equals(Constantes.IRA_MINIMA));
	}
	
	@Test
	public void convCazadorPresa() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		assertTrue(f.getEstado().equals(EstadoPresa.getInstance()));
	}
	
	@Test
	public void convCazadorCazador() {
		Fantasma f = new Fantasma();
		f.convertirEnCazador();
		assertTrue(f.getEstado().equals(EstadoCazador.getInstance()));
	}
	
	@Test
	public void pruebaEliminarFantasmaCazador() {
		Fantasma f = new Fantasma();
		f.eliminar();
		assertFalse(f.getEstado().equals(EstadoMuerto.getInstance()));
		assertTrue(f.getEstado().equals(EstadoCazador.getInstance()));
	}
	
	@Test
	public void pruebaRevivirFantasmaCazador() {
		Fantasma f = new Fantasma();
		f.revivir();
		assertTrue(f.getEstado().equals(EstadoCazador.getInstance()));
	}
	
	@Test
	public void convPresaCazador() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		f.convertirEnCazador();
		assertTrue(f.getEstado().equals(EstadoCazador.getInstance()));
	}
	
	@Test
	public void convPresaPresa() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		f.convertirEnPresa();
		assertTrue(f.getEstado().equals(EstadoPresa.getInstance()));
	}
	
	@Test
	public void pruebaEliminarFantasmaPresa() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		f.eliminar();
		assertTrue(f.getEstado().equals(EstadoMuerto.getInstance()));
	}
	
	@Test 
	public void pruebaRevivirFantasmaPresa() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		f.revivir();
		assertTrue(f.getEstado().equals(EstadoPresa.getInstance()));
	}
	
	@Test
	public void convMuertoCazador() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		f.eliminar();
		assertTrue(f.getEstado().equals(EstadoMuerto.getInstance()));
		f.revivir();
		assertTrue(f.getEstado().equals(EstadoCazador.getInstance()));
	}
	
	@Test
	public void convMuertoPresa() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		f.eliminar();
		assertTrue(f.getEstado().equals(EstadoMuerto.getInstance()));
		f.convertirEnPresa();
		assertFalse(f.getEstado().equals(EstadoPresa.getInstance()));
		assertTrue(f.getEstado().equals(EstadoMuerto.getInstance()));
	}
	
	@Test
	public void pruebaEliminarFantasmaMuerto() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		f.eliminar();
		assertTrue(f.getEstado().equals(EstadoMuerto.getInstance()));
		f.eliminar();
		assertTrue(f.getEstado().equals(EstadoMuerto.getInstance()));
	}
	
	@Test
	public void pruebaRevivirFantasmaMuerto() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		f.eliminar();
		assertTrue(f.getEstado().equals(EstadoMuerto.getInstance()));
		f.revivir();
		assertTrue(f.getEstado().equals(EstadoCazador.getInstance()));
	}
	
	@Test
	public void pruebaMoverCazador() {
		Fantasma f = new Fantasma();
		assertEquals(Constantes.MOVER_CAZADOR + f.getIra(), f.mover());
	}
	
	@Test
	public void pruebaMoverPresa() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		assertEquals(Constantes.MOVER_PRESA, f.mover());
	}
	
	@Test
	public void pruebaMoverMuerto() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		f.eliminar();
		assertEquals(Constantes.MOVER_MUERTO, f.mover());
	}	
}
