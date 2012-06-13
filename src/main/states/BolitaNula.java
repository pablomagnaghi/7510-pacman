package main.states;

import main.model.Bolita;

public class BolitaNula extends Bolita {

	@Override
	public void comer() {
		
	}

	@Override
	public String imprimir() {
		return " ";
	}
	
	@Override
	public Boolean fueComida(){
		return Boolean.TRUE;
	}

}
