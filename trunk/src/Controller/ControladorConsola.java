package Controller;

import main.config.Constantes;
import main.model.Fantasma;
import view.VistaConsola;

public class ControladorConsola {

	private Fantasma fantasma;
	
	public void mostrarVista() {
		if (VistaConsola.getInstance().getControlador() == null){
			VistaConsola.getInstance().setControlador(this);
			VistaConsola.redirect();
		}
		VistaConsola.getInstance().mostrar();
	}
	
	public void manejarBtnComer(){
		if (fantasma == null){
			System.out.println(Constantes.ERROR_FANTASMA_NO_INICIADO);
		} else {
			this.fantasma.eliminar();
		}
	}
	
	public void manejarBtnConvertirPresa(){
		if (fantasma == null){
			System.out.println(Constantes.ERROR_FANTASMA_NO_INICIADO);
		} else {
			this.fantasma.convertirEnPresa();
		}
	}

	public void manejarBtnMover(){
		if (fantasma == null){
			System.out.println(Constantes.ERROR_FANTASMA_NO_INICIADO);
		} else {
			System.out.println(this.fantasma.mover());
		}
	}

	public void manejarBtnMostrar(){
		if (fantasma == null){
			System.out.println(Constantes.ERROR_FANTASMA_NO_INICIADO);
		} else {
			this.fantasma.mostrarFantasma();
		}
	}

	public void manejarBtnIncrementarIra(){
		if (fantasma == null){
			System.out.println(Constantes.ERROR_FANTASMA_NO_INICIADO);
		} else {
			System.out.println(this.fantasma.incrementarIra());
		}
	}
	
	public void manejarBtnIniciar(){
		if (this.fantasma == null){
			this.fantasma = new Fantasma();
		} else {
			System.out.println(Constantes.FANTASMA_YA_INICIADO);
		}
	}

}
