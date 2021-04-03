package arreglos;

import java.util.ArrayList;

import clases.DetalleReserva;

public class ArregloDetalleReservas {
	// Atributo privado
	private ArrayList<DetalleReserva> detalleReservas;
	
	// Constructor
	public ArregloDetalleReservas() {
		detalleReservas = new ArrayList<DetalleReserva>();
	}
	
	// Operaciones p�blicas b�sicas
	public int tama�o() {
		return detalleReservas.size();
	}
	
	public DetalleReserva obtener(int indice) {
		return detalleReservas.get(indice);
	}
	
	public void adicionar(DetalleReserva detalleReserva) {
		detalleReservas.add(detalleReserva);
	}
	
	public void eliminarAlFinal() {
		detalleReservas.remove(tama�o() - 1);
	}
	
	public void eliminarTodo() {
		detalleReservas.clear();
	}
	
	public void eliminar(DetalleReserva detalleReserva) {
		detalleReservas.remove(detalleReserva);
	}
}
