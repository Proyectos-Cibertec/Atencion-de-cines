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
	
	// Operaciones p�blicas b�sicas
	public int tama�o() {
		return reservas.size();
	}
	
	public Reserva obtener(int indice) {
		return reservas.get(indice);
	}
	
	public void adicionar(Reserva reserva) {
		reservas.add(reserva);
	}
	
	public void eliminarAlFinal() {
		reservas.remove(tama�o() - 1);
	}
	
	public void eliminarTodo() {
		reservas.clear();
	}
	
	// Operaciones p�blicas complementarias
	public Reserva buscar(int codigo) {
		for (int i = 0; i < tama�o(); i++) {
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
		if (tama�o() == 0) {
			return 10001;
		} else {
			return obtener(tama�o() - 1).getCodigo() + 1;
		}
	}
}
