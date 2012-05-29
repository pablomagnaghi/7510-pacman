package main.model;

public interface Estado {

	public void incrementarIra(Fantasma fantasma);

	void mover(Fantasma fantasma);

	public Estado eliminar();
	
	public Estado convertirEnCazador(Fantasma fantasma);

	public Estado convertirEnPresa();
	
	public String getNombre();
}
