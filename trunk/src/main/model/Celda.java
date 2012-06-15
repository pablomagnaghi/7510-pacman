package main.model;

import main.states.BolitaGrande;
import main.states.BolitaNormal;
import main.states.BolitaNula;

public class Celda {
	
	private Celda celdaIzquierda;
	private Celda celdaDerecha;
	private Celda celdaArriba;
	private Celda celdaAbajo;
	private Bolita bolita;
	private Boolean pared = Boolean.FALSE;
	private Boolean portal = Boolean.FALSE;
	private Posicion posicion;
	
	public Celda(char val, Posicion posicion){
		if (val == 'x'){
			this.pared = Boolean.TRUE;
			this.bolita = new BolitaNula();
		} else if (val == ' '){
			this.bolita = new BolitaNula();
		} else if (val == '.'){
			this.bolita = new BolitaNormal();
		} else if (val == 'p'){
			this.portal = Boolean.TRUE;
			this.bolita = new BolitaNula();
		} else {
			this.pared = Boolean.FALSE;
			this.bolita = new BolitaGrande();
		}
		this.setPosicion(posicion);
	}

	public Celda getCeldaIzquierda() {
		return celdaIzquierda;
	}

	public void setCeldaIzquierda(Celda celdaIzquierda) {
		this.celdaIzquierda = celdaIzquierda;
	}

	public Celda getCeldaDerecha() {
		return celdaDerecha;
	}

	public void setCeldaDerecha(Celda celdaDerecha) {
		this.celdaDerecha = celdaDerecha;
	}

	public Celda getCeldaArriba() {
		return celdaArriba;
	}

	public void setCeldaArriba(Celda celdaArriba) {
		this.celdaArriba = celdaArriba;
	}

	public Celda getCeldaAbajo() {
		return celdaAbajo;
	}

	public void setCeldaAbajo(Celda celdaAbajo) {
		this.celdaAbajo = celdaAbajo;
	}

	public Bolita getBolita() {
		return bolita;
	}

	public void setBolita(Bolita bolita) {
		this.bolita = bolita;
	}

	public Boolean esPared() {
		return pared;
	}

	public void setPared(Boolean pared) {
		this.pared = pared;
	}
	
	@Override
	public String toString() {
		String s = new String();
		if (this.esPared()){
			s = "x";
		} else if (this.esPortal()){
			s = "p";
		} else {
			s = this.bolita.imprimir();
		}
		return s;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Boolean esPortal() {
		return portal;
	}

	public Boolean esTransitable() {
		return !this.esPared();
	}

	public void visitarPorPacman() {
		this.bolita.comer();
		this.bolita = new BolitaNula();
	}

	public Boolean esBifurcacion(){
		Boolean celdaAbajoPosible = this.celdaAbajo != null && this.celdaAbajo.esTransitable(); 
		Boolean celdaArribaPosible = this.celdaArriba != null && this.celdaArriba.esTransitable();
		Boolean celdaDerechaPosible = this.celdaDerecha != null && this.celdaDerecha.esTransitable();
		Boolean celdaIzquierdaPosible = this.celdaIzquierda != null && this.celdaIzquierda.esTransitable();
		Boolean bifurcacionPosibleUno = celdaDerechaPosible && celdaIzquierdaPosible && (celdaAbajoPosible || celdaArribaPosible);
		Boolean bifurcacionPosibleDos = celdaAbajoPosible && celdaArribaPosible && (celdaIzquierdaPosible || celdaDerechaPosible);
		return (bifurcacionPosibleUno || bifurcacionPosibleDos);
	}

	public String getContent() {
		return this.bolita.getContent();
	}
}
