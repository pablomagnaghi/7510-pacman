package controller;

import main.config.ConfiguracionPrincipal;
import main.config.Constantes;
import main.gameController.ControladorFantasma;
import view.VistaConsola;

public class ControladorConsola {

	private ControladorFantasma controlador;
	
	public ControladorConsola(String configFileName){
		ConfiguracionPrincipal.getInstance().leerParametros(configFileName);
	}
	
	public void mostrarVista() {
		if (VistaConsola.getInstance().getControlador() == null){
			VistaConsola.getInstance().setControlador(this);
			VistaConsola.redirect();
		}
		VistaConsola.getInstance().mostrar();
	}
	
	public void manejarBtnComer(){
		if (controlador == null){
			System.out.println(Constantes.ERROR_FANTASMA_NO_INICIADO);
		} else {
			this.controlador.eliminarFantasma();
		}
	}
	
	public void manejarBtnConvertirPresa(){
		if (controlador == null){
			System.out.println(Constantes.ERROR_FANTASMA_NO_INICIADO);
		} else {
			this.controlador.convertirFantasmaEnPresa();
		}
	}

	public void manejarBtnMover(){
		if (controlador == null){
			System.out.println(Constantes.ERROR_FANTASMA_NO_INICIADO);
		} else {
			System.out.println(this.controlador.moverFantasma());
		}
	}

	public void manejarBtnMostrar(){
		if (controlador == null){
			System.out.println(Constantes.ERROR_FANTASMA_NO_INICIADO);
		} else {
			this.controlador.mostrarFantasma();
		}
	}

	public void manejarBtnIncrementarIra(){
		if (controlador == null){
			System.out.println(Constantes.ERROR_FANTASMA_NO_INICIADO);
		} else {
			System.out.println(this.controlador.incrementarIraFantasma());
		}
	}
	
	public void manejarBtnIniciar(){
		if (this.controlador == null){
			this.controlador = new ControladorFantasma();
		} else {
			System.out.println(Constantes.FANTASMA_YA_INICIADO);
		}
	}

}
