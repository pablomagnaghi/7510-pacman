package main.model;

public interface Estado {

	public void incrementarIra(Fantasma fantasma);

	public void mover(Fantasma fantasma);
	
	public Estado getNextState(Integer evento);

	public String getNombre();
}
