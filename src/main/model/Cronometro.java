package main.model;

import java.util.Observable;

public class Cronometro extends Observable{

	private Integer time;
	
	public Cronometro(Fantasma fantasma, Integer maxTime) {
		this.time = maxTime;
		this.addObserver(fantasma);
	}

	private void finishCount() {
		setChanged();
		notifyObservers();
	}
	
	public void beginCount() {
		try {
			Thread.sleep(this.time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.finishCount();
	}
	
}
