package grafos_and_algoritmos;

public class Arista {
	
	private int vertice_S;
	private int vertice_T;
	private int peso;
	
	
	/**
	 * Constructor de aristas entre 2 vertices
	 * @param vertice inicial
	 * @param vertice destino
	 * @param peso o distancia entre vertices
	 */
	public Arista(int vertice_S, int vertice_T, int peso) {
		this.vertice_S = vertice_S;
		this.vertice_T = vertice_T;
		this.peso = peso;
	}

	
	//Getters y set de peso
	public int getVertice_S() {
		return vertice_S;
	}

	public int getVertice_T() {
		return vertice_T;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	
	//Hashcode y equals entre vertices
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vertice_S;
		result = prime * result + vertice_T;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		if (vertice_S != other.vertice_S)
			return false;
		if (vertice_T != other.vertice_T)
			return false;
		return true;
	}
}
