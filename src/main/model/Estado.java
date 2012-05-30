package main.model;

public interface Estado {

	public String incrementarIra(Fantasma fantasma);

	public String mover(Fantasma fantasma);
	
	public Estado getNextState(Integer evento);

	public String getNombre();
}
