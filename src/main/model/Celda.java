package main.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.config.Constantes;
import main.states.BolitaGrande;
import main.states.BolitaNormal;
import main.states.BolitaNula;

public class Celda {
	
	private String idCeldaIzquierda;
	private String idCeldaDerecha;
	private String idCeldaArriba;
	private String idCeldaAbajo;
	private Bolita bolita;
	private String id;
	
	public Celda(String val, String id){
		if (Constantes.BOLITA.equals(val)){
			this.bolita = new BolitaNormal();
		} else if (Constantes.BOLON.equals(val)){
			this.bolita = new BolitaGrande();
		} else if ("".equals(val)){
			this.bolita = new BolitaNula();
		} 
		this.setId(id);
	}

	public String getCeldaIzquierda() {
		if (this.idCeldaIzquierda == null){
			return "";
		}
		return idCeldaIzquierda;
	}

	public void setCeldaIzquierda(String celdaIzquierda) {
		this.idCeldaIzquierda = celdaIzquierda;
	}

	public String getCeldaDerecha() {
		if (this.idCeldaDerecha == null){
			return "";
		}
		return idCeldaDerecha;
	}

	public void setCeldaDerecha(String celdaDerecha) {
		this.idCeldaDerecha = celdaDerecha;
	}

	public String getCeldaArriba() {
		if (this.idCeldaArriba == null){
			return "";
		}
		return idCeldaArriba;
	}

	public void setCeldaArriba(String celdaArriba) {
		this.idCeldaArriba = celdaArriba;
	}

	public String getCeldaAbajo() {
		if (this.idCeldaAbajo == null){
			return "";
		}
		return idCeldaAbajo;
	}

	public void setCeldaAbajo(String celdaAbajo) {
		this.idCeldaAbajo = celdaAbajo;
	}

	public Bolita getBolita() {
		return bolita;
	}

	public void setBolita(Bolita bolita) {
		this.bolita = bolita;
	}

	public String toString() {
		String s = new String();
		s = this.bolita.imprimir();
		return s;
	}

	public void visitarPorPacman() {
		this.bolita.comer();
		this.bolita = new BolitaNula();
	}

	public Boolean esBifurcacion(){
		Boolean celdaAbajoPosible = this.idCeldaAbajo != null; 
		Boolean celdaArribaPosible = this.idCeldaArriba != null;
		Boolean celdaDerechaPosible = this.idCeldaDerecha != null;
		Boolean celdaIzquierdaPosible = this.idCeldaIzquierda != null;
		Boolean bifurcacionPosibleUno = celdaDerechaPosible && celdaIzquierdaPosible && (celdaAbajoPosible || celdaArribaPosible);
		Boolean bifurcacionPosibleDos = celdaAbajoPosible && celdaArribaPosible && (celdaIzquierdaPosible || celdaDerechaPosible);
		return (bifurcacionPosibleUno || bifurcacionPosibleDos);
	}

	public String getContent() {
		return this.bolita.getContent();
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}
	
	public String getFila(){
		Pattern p = Pattern.compile("(\\d{2})\\d{2}");
		Matcher m = p.matcher(id);
		if (m.find()){
			return m.group(1);
		}
		return null;
	}
	
	public String getColumna(){
		Pattern p = Pattern.compile("\\d{2}(\\d{2})");
		Matcher m = p.matcher(id);
		if (m.find()){
			return m.group(1);
		}
		return null;
	}
}
