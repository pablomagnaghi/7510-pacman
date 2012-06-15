package main.gameController;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import main.config.ConfiguracionPrincipal;
import main.model.Fantasma;
import main.model.Laberinto;
import main.model.Pacman;

public class ManejadorReglas implements Observer{

	private static ManejadorReglas instance = null;

	private Boolean cronometroPresaContando = Boolean.FALSE;
	private Integer tiempoPresa;
	private Integer cantTicks = 0;
	private Laberinto laberinto;
	private Boolean finJuego = Boolean.FALSE;

	private ManejadorReglas(){
		this.tiempoPresa = ConfiguracionPrincipal.getInstance().getTiempoPresa();
	}

	@Override
	public void update(Observable o, Object arg) {
		this.cronometroPresaContando = Boolean.TRUE;
		Iterator<Fantasma> it = this.laberinto.getFantasmas().iterator();
		while (it.hasNext()){
			Fantasma fantasma = it.next();
			fantasma.convertirEnPresa();
		}
	}

	private void chequearEstadoActores(){
		Iterator<Fantasma> it = this.laberinto.getFantasmas().iterator();
		while (it.hasNext()){
			Fantasma fantasma = it.next();
			if (fantasma.getCeldaActual().equals(Pacman.getInstance().getCeldaActual())){
				if (cronometroPresaContando){
					fantasma.eliminar();
				} else {
					Pacman.getInstance().eliminar();
					this.setFinJuego(Boolean.TRUE);
				}
			}
		}
	}
	
	private void chequearTiempos(){
		if (this.cronometroPresaContando){
			if (cantTicks < tiempoPresa){
				System.out.println("Sumando tiempoPresa");
				cantTicks++;
			} else {
				this.cronometroPresaContando = Boolean.FALSE;
				cantTicks = 0;
				Iterator<Fantasma> it = this.laberinto.getFantasmas().iterator();
				while (it.hasNext()){
					Fantasma fantasma = it.next();
					if (fantasma.estaMuerto()){
						fantasma.revivir();
					} else {
						fantasma.convertirEnCazador();
					}
				}
			}
		}
	}


	public static ManejadorReglas getInstance() {
		if (instance == null){
			instance = new ManejadorReglas();
		}
		return instance;
	}

	public void chequearSituacion(){
		this.chequearEstadoActores();
		this.chequearTiempos();
	}

	public Boolean esFinJuego() {
		return finJuego;
	}

	private void setFinJuego(Boolean finJuego) {
		this.finJuego = finJuego;
	}

	public Laberinto getLaberinto() {
		return laberinto;
	}

	public void setLaberinto(Laberinto laberinto) {
		this.laberinto = laberinto;
	}

}
