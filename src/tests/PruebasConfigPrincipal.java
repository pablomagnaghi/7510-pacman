package tests;

import static org.junit.Assert.*;

import main.config.*;
import main.model.*;
import main.gameController.*;
import main.states.*;

import org.junit.Test;

public class PruebasConfigPrincipal {
	
	@Test
	public void crearConfigPrincipal() {
		ConfiguracionPrincipal c = ConfiguracionPrincipal.getInstance();
		ConfiguracionPrincipal c2 = ConfiguracionPrincipal.getInstance();
		assertTrue(c.equals(c2));
	}
	
	@Test
	public void leerConfigPrincipal() {
		ConfiguracionPrincipal c = ConfiguracionPrincipal.getInstance();
		String ruta = "C:\\Users\\Metal\\workspace\\TpTecnicas\\src\\tests\\ArchivoEntradaPrueba.txt";
		c.leerParametros(ruta);
		assertTrue(c.getArchivoLaberinto().equals("C:\\Users\\Metal\\workspace\\TpTecnicas\\res\\escenariosxml\\escenario2.xml"));
		assertTrue(c.getCantFantasmaBuscador().equals(1));
		assertTrue(c.getCantFantasmaPerezoso().equals(1));
		assertTrue(c.getCantFantasmaZonzo().equals(1));
		assertTrue(c.getDirectorioOrdenes().equals("C:\\Users\\Metal\\workspace\\TpTecnicas\\res\\ordenes\\"));
		
	}
}
