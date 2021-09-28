package grafos_and_algoritmos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grafo {
	
	private ArrayList<Set<Integer>> vecinos;
	private ArrayList<Arista> aristas;
	
	
	/**
	 * Constructor de Grafos
	 * @param cantidad de vertices del grafo a crear
	 */
	public Grafo(int vertices) {
		
		vecinos = new ArrayList<Set<Integer>>(vertices);

		for (int i = 0; i < vertices; i++) {
			vecinos.add(new HashSet<Integer>());
		}
		aristas = new ArrayList<Arista>();
	}
	
	
	public void agregarArista (int s, int t, int peso) {
		verificarVertice(s, this);
		verificarVertice(t, this);
		verificarDistintos(s, t);
		
		vecinos.get(s).add(t);
		vecinos.get(t).add(s);
		
		aristas.add(new Arista(s, t, peso));
	}
	
	
	public void eliminarArista(int s, int t) {
		verificarVertice(s, this);
		verificarVertice(t, this);
		verificarDistintos(s, t);
		
		vecinos.get(s).remove(t);
		vecinos.get(t).remove(s);
		
		for (int i = 0; i < aristas.size(); i++) {
			if ((aristas.get(i).getVertice_S() == s || aristas.get(i).getVertice_S() == t) && (aristas.get(i).getVertice_T() == s || aristas.get(i).getVertice_T() == t)) {
				aristas.remove(i);
			}
		}
	}
	
	
	public boolean existeArista (int s, int t) {
		verificarVertice(s, this);
		verificarVertice(t, this);
		return vecinos.get(s).contains(t);
	}

	
	public Set<Integer> vecinos(int s){
		verificarVertice(s, this);
		return vecinos.get(s);
	}

	
	public int grado (int s){ 
		return vecinos.get(s).size();
	}
	
	
	// Cantidad de vertices
	public int tamanio () {
		return vecinos.size();
	}
	
	
	// Verifica que no se introduzcan loops
	public static void verificarDistintos(int s, int t) {
		if (s == t) {
			throw new IllegalArgumentException("No se permiten loops: (" + s + ", " + t + ")" );
		}
	}
		
	
	// Verifica que sea un vertice valido
	public static void verificarVertice(int s, Grafo grafo) {
		if (s < 0) {
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + s);
		}
		if (s >= grafo.tamanio()) {
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + s);
		}
	}
	
	
	// Este m�todo verifica que no se haya ingresado un grafo null.
	public static void verificarNull(Grafo grafo) {
		if (grafo == null) {
				throw new IllegalArgumentException("Grafo no inicializado");
		}
	}
}
