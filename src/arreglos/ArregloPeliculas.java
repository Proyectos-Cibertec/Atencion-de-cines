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
	
	// Operaciones p�blicas b�sicas
	public int tama�o() {
		return peliculas.size();
	}
	
	public Pelicula obtener(int indice) {
		return peliculas.get(indice);
	}
	
	public void adicionar(Pelicula pelicula) {
		peliculas.add(pelicula);
	}
	
	public void eliminarAlFinal() {
		peliculas.remove(tama�o() - 1);
	}
	
	public void eliminarTodo() {
		peliculas.clear();
	}
	
	// Operaciones p�blicas complementarias
	public Pelicula buscar(int codigo) {
		for (int i = 0; i < tama�o(); i++) {
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
		if (tama�o() == 0) {
			return 10001;
		} else {
			return obtener(tama�o() - 1).getCodigo() + 1;
		}
	}
}
