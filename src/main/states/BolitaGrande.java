package main.states;

import main.model.Bolita;

public class BolitaGrande extends Bolita{

	@Override
	public void comer() {
		setChanged();
		notifyObservers();
	}

}
