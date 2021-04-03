package arreglos;

import java.util.ArrayList;

import clases.Cine;

public class ArregloCines {
	// Atributo privado
	private ArrayList<Cine> cines;
	
	// Constructor
	public ArregloCines() {
		cines = new ArrayList<Cine>();
		
		// Cines de ejemplo
		cines.add(new Cine(10001, "Cine Star", "Lima", "Lima", "SJL", "20/10/2003", 0));
		cines.add(new Cine(10002, "Cineplanet", "Lima", "Lima", "Miraflores", "10/02/2014", 1));
		cines.add(new Cine(10003, "Cinemark", "Lima", "Lima", "San Isidro", "01/01/2016", 0));
		cines.add(new Cine(10004, "UVK", "Lima", "Lima", "Jes�s Mar�a", "01/03/2015", 1));
		cines.add(new Cine(10005, "Cin�polis", "Lima", "Lima", "Bre�a", "15/08/2009", 0));
		cines.add(new Cine(10006, "Cines Plaza", "Lima", "Lima", "Santa Anita", "13/01/207", 1));
		cines.add(new Cine(10007, "Movietime", "Lima", "Lima", "La Molina", "01/01/2016", 0));
	}
	
	// Operaciones p�blicas b�sicas
	public int tama�o() {
		return cines.size();
	}
	
	public Cine obtener(int indice) {
		return cines.get(indice);
	}
	
	public void adicionar(Cine cine) {
		cines.add(cine);
	}
	
	public void eliminarAlFinal() {
		cines.remove(tama�o() - 1);
	}
	
	public void eliminarTodo() {
		cines.clear();
	}
	
	// Operaciones p�blicas complementarias
	public Cine buscar(int codigo) {
		for (int i = 0; i < tama�o(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	public void eliminar(Cine cine) {
		cines.remove(cine);
	}
	
	public int codigoCorrelativo() {
		if (tama�o() == 0) {
			return 10001;
		} else {
			return obtener(tama�o() - 1).getCodigo() + 1;
		}
	}
}
