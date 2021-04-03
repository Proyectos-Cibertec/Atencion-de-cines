package clases;

public class DetalleReserva {
	// Atributos privados
	private int codigoButaca;
	private int codigoReserva;
	private int tipoEntrada;
	private int cantidadEntradas;
	private double precioEntrada;
	
	// Constructor con 5 argumentos
	public DetalleReserva(int codigoButaca, int codigoReserva, int tipoEntrada, int cantidadEntradas,
			double precioEntrada) {
		this.codigoButaca = codigoButaca;
		this.codigoReserva = codigoReserva;
		this.tipoEntrada = tipoEntrada;
		this.cantidadEntradas = cantidadEntradas;
		this.precioEntrada = precioEntrada;
	}

	// Métodos de acceso público get y set
	public int getCodigoButaca() {
		return codigoButaca;
	}

	public void setCodigoButaca(int codigoButaca) {
		this.codigoButaca = codigoButaca;
	}

	public int getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public int getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(int tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	public int getCantidadEntradas() {
		return cantidadEntradas;
	}

	public void setCantidadEntradas(int cantidadEntradas) {
		this.cantidadEntradas = cantidadEntradas;
	}

	public double getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;
	}
}
