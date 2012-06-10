package main.model;

public class Posicion {

	private Integer x;
	private Integer y;

	public Posicion(Integer x, Integer y){
		this.setX(x);
		this.setY(y);
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Posicion getSigPosicionIzquierda(){
		return new Posicion(x-1, y);
	}

	public Posicion getSigPosicionDerecha(){
		return new Posicion (x+1, y);
	}

	public Posicion getSigPosicionArriba(){
		return new Posicion (x, y-1);
	}

	public Posicion getSigPosicionAbajo(){
		return new Posicion (x, y+1);
	}
	
}
