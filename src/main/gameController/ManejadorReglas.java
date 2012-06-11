package main.gameController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import main.config.ConfiguracionPrincipal;
import main.model.Fantasma;
import main.model.Pacman;

public class ManejadorReglas implements Observer{

	private static ManejadorReglas instance = null;

	private Boolean cronometroPresaContando = Boolean.FALSE;
	private Integer tiempoMuerto;
	private Integer tiempoPresa;
	private Map<Fantasma, Integer> tiemposMuertos;
	private List<Fantasma> fantasmas;
	private Integer cantTicks = 0;

	private ManejadorReglas(){
		this.tiemposMuertos = new HashMap<Fantasma, Integer>();
		this.tiempoMuerto = ConfiguracionPrincipal.getInstance().getTiempoMuerto();
		this.tiempoPresa = ConfiguracionPrincipal.getInstance().getTiempoPresa();
	}

	@Override
	public void update(Observable o, Object arg) {
		this.cronometroPresaContando = Boolean.TRUE;
	}

	public void chequearEstadoActores(){
		Iterator<Fantasma> it = getFantasmas().iterator();
		while (it.hasNext()){
			Fantasma fantasma = it.next();
			if (fantasma.getCeldaActual().equals(Pacman.getInstance().getCeldaActual())){
				if (cronometroPresaContando){
					fantasma.eliminar();
					this.tiemposMuertos.put(fantasma, this.tiempoMuerto);
				} else {
					Pacman.getInstance().eliminar();
				}
			}
		}
	}
	
	public void chequearTiempos(){
		if (this.cronometroPresaContando){
			if (tiempoPresa < cantTicks){
				cantTicks++;
			} else {
				this.cronometroPresaContando = Boolean.FALSE;
				cantTicks = 0;
				Iterator<Fantasma> it = getFantasmas().iterator();
				while (it.hasNext()){
					Fantasma fantasma = it.next();
					if (fantasma.estaMuerto()){
						fantasma.revivir();
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

	public List<Fantasma> getFantasmas() {
		return fantasmas;
	}

	public void setFantasmas(List<Fantasma> fantasmas) {
		this.fantasmas = fantasmas;
	}

}
