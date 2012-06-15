package main.states;

import main.model.Bolita;

public class BolitaNormal extends Bolita{

	@Override
	public void comer() {
		// TODO Auto-generated method stub
	}

	@Override
	public String imprimir() {
		return ".";
	}

	@Override
	public Boolean fueComida() {
		return Boolean.FALSE;
	}

	@Override
	public String getContent() {
		return "bolita";
	}

}
