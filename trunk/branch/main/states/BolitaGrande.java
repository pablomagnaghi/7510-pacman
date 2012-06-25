package main.states;

import main.model.Bolita;

public class BolitaGrande extends Bolita{

	@Override
	public void comer() {
		setChanged();
		notifyObservers();
	}

	@Override
	public String imprimir() {
		return "*";
	}

	@Override
	public Boolean fueComida() {
		return Boolean.FALSE;
	}

	@Override
	public String getContent() {
		return "bolon";
	}

}
