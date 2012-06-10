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
	private Boolean pared;
	
	public Celda(char val){
		if (val == 'x'){
			this.pared = Boolean.TRUE;
			this.bolita = new BolitaNula();
		} else if (val == ' '){
			this.pared = Boolean.FALSE;
			this.bolita = new BolitaNula();
		} else if (val == '.'){
			this.pared = Boolean.FALSE;
			this.bolita = new BolitaNormal();
		} else {
			this.pared = Boolean.FALSE;
			this.bolita = new BolitaGrande();
		}
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
		} else {
			s = this.bolita.imprimir();
		}
		return s;
	}

}
