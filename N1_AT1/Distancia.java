package N1_AT1;

public class Distancia {
    public int peso;

    public Distancia(int peso) {
		this.peso = peso;
	}

    public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

    @Override
	public String toString() {
		return "" + peso;
	}
}
