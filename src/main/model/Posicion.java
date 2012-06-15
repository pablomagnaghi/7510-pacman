package main.model;

public class Posicion {

	private Integer height;
	private Integer width;

	public Posicion(Integer height, Integer width){
		this.setHeight(height);
		this.setWidth(width);
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("height: " + height + " , width: " + width);
		return sb.toString();
	}

	public String getStringId() {
		return String.format("%02d%02d", this.height, this.width);
	}

	public String getStringHeight() {
		return String.format("%02d", this.height);
	}

	public String getStringWidth() {
		return String.format("%02d", this.width);
	}
	
}
