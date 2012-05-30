package tests;

import static org.junit.Assert.*;

import main.config.Constantes;
import main.model.Fantasma;
import main.states.EstadoMuerto;
import main.states.EstadoPresa;

import org.junit.Test;

public class PruebasFantasma {

	@Test
	public void beginTest() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		assertTrue(f.getEstado().equals(EstadoPresa.getInstance()));
	}
	
	
	@Test
	public void pruebaEliminarFantasmaCazador() {
		Fantasma f = new Fantasma();
		f.eliminar();
		assertFalse(f.getEstado().equals(EstadoMuerto.getInstance()));
	}
	
	@Test
	public void pruebaEliminarFantasmaPresa() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		f.eliminar();
		assertTrue(f.getEstado().equals(EstadoMuerto.getInstance()));
	}
	
	@Test
	public void pruebaConvertirMuertoEnPresa() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		f.eliminar();
		f.convertirEnPresa();
		assertFalse(f.getEstado().equals(EstadoPresa.getInstance()));
	}
	
	@Test
	public void pruebaMoverMuerto() {
		Fantasma f = new Fantasma();
		f.convertirEnPresa();
		f.eliminar();
		assertEquals(Constantes.MOVER_MUERTO, f.mover());
	}

}
