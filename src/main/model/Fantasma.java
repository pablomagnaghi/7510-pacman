package main.model;

import java.util.Observable;
import java.util.Observer;

import main.config.ConfiguracionPrincipal;
import main.config.Constantes;
import main.config.Evento;
import main.states.EstadoCazador;
import main.states.EstadoMuerto;
import main.states.EstadoPresa;

public class Fantasma implements Observer{
	
	private Estado estado;
	private Integer ira;
	private Cronometro cronometro;
	private Integer tiempoMuerto;
	private Integer tiempoPresa;
	
	public Fantasma(){
		System.out.println("Iniciando fantasma");
		this.setEstado(EstadoCazador.getInstance());
		this.ira = Constantes.IRA_MINIMA;
		this.cronometro = new Cronometro(this);
		this.tiempoMuerto = ConfiguracionPrincipal.getInstance().getTiempoMuerto();
		this.tiempoPresa = ConfiguracionPrincipal.getInstance().getTiempoPresa();
		System.out.println("Iniciando con tiempo Muerto : " + this.tiempoMuerto);
		System.out.println("Iniciando con tiempo Presa : " + this.tiempoPresa);
	}
	
	public String mover(){
		return (this.getEstado().mover(this));
	}
	
	public String incrementarIra(){
		return (this.getEstado().incrementarIra(this));
	}
	
	public void eliminar(){
		cambiarEstado(this.getEstado().getNextState(Evento.ELIMINAR));
		if (this.getEstado().equals(EstadoMuerto.getInstance())){
			cronometro.contarMuerto(this.tiempoMuerto);
		}
	}
	
	public void revivir() {
		cambiarEstado(this.getEstado().getNextState(Evento.REVIVIR));
	}
	
	public void convertirEnPresa(){
		cambiarEstado(this.getEstado().getNextState(Evento.CONVERTIR_PRESA));
		if (this.getEstado().equals(EstadoPresa.getInstance())){
			cronometro.contarPresa(this.tiempoPresa);
		}
	}
	
	public void convertirEnCazador(){
		cambiarEstado(this.getEstado().getNextState(Evento.CONVERTIR_CAZADOR));
	}
	
	private void cambiarEstado(Estado nuevoEstado){
		if (nuevoEstado != null){
			this.setEstado(nuevoEstado);
		}
	}

	public Integer getIra() {
		return ira;
	}

	public void setIra(Integer ira) {
		this.ira = ira;
	}
	
	public void mostrarFantasma(){
		System.out.println("Fantasma " + this.getEstado().getNombre() 
				+ " con agresividad " + getIra());
	}

	public Estado getEstado() {
		return estado;
	}

	private void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (this.getEstado() == EstadoMuerto.getInstance()){
			revivir();
		} else {
			cambiarEstado(this.getEstado().getNextState(Evento.CONVERTIR_CAZADOR));
		}
	}

}
