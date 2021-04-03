package arreglos;

import java.util.ArrayList;

import clases.Pelicula;

public class ArregloPeliculas {
	// Atributo privado
	private ArrayList<Pelicula> peliculas;
	
	// Constructor
	public ArregloPeliculas() {
		peliculas = new ArrayList<Pelicula>();
	}
	
	// Operaciones públicas básicas
	public int tamaño() {
		return peliculas.size();
	}
	
	public Pelicula obtener(int indice) {
		return peliculas.get(indice);
	}
	
	public void adicionar(Pelicula pelicula) {
		peliculas.add(pelicula);
	}
	
	public void eliminarAlFinal() {
		peliculas.remove(tamaño() - 1);
	}
	
	public void eliminarTodo() {
		peliculas.clear();
	}
	
	// Operaciones públicas complementarias
	public Pelicula buscar(int codigo) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	public void eliminar(Pelicula pelicula) {
		peliculas.remove(pelicula);
	}
	
	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 10001;
		} else {
			return obtener(tamaño() - 1).getCodigo() + 1;
		}
	}
}
