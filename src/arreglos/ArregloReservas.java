package arreglos;

import java.util.ArrayList;

import clases.Reserva;

public class ArregloReservas {
	// Atributo privado
	private ArrayList<Reserva> reservas;
	
	// Constructor
	public ArregloReservas() {
		reservas = new ArrayList<Reserva>();
	}
	
	// Operaciones públicas básicas
	public int tamaño() {
		return reservas.size();
	}
	
	public Reserva obtener(int indice) {
		return reservas.get(indice);
	}
	
	public void adicionar(Reserva reserva) {
		reservas.add(reserva);
	}
	
	public void eliminarAlFinal() {
		reservas.remove(tamaño() - 1);
	}
	
	public void eliminarTodo() {
		reservas.clear();
	}
	
	// Operaciones públicas complementarias
	public Reserva buscar(int codigo) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	public void eliminar(Reserva reserva) {
		reservas.remove(reserva);
	}
	
	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 10001;
		} else {
			return obtener(tamaño() - 1).getCodigo() + 1;
		}
	}
}
