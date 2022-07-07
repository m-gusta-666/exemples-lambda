package lambda.test;

public class Samarreta {

	private String color;
	private String talla;
	private int preu;
	
	public Samarreta(String color, String talla, int preu) {
		super();
		this.color = color;
		this.talla = talla;
		this.preu = preu;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public int getPreu() {
		return preu;
	}

	public boolean setPreu(int preu) {
		this.preu = preu;
		return true;
	}
	
	
	public void emprovar() {
		System.out.println("Aquesta samarreta de color " + color + " et queda genial!");
	}

	
	@Override
	public String toString() {
		return "Samarreta [color=" + color + ", talla=" + talla + ", preu=" + preu + "]";
	}
	
	
	
}
