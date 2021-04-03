package clases;

public class DetalleReserva {
	// Atributos privados
	private int codigo;
	private int codigoButaca;
	private int codigoReserva;
	private int tipoEntrada; // 0 = General | 1 = Menores de 11 a�os | 2 = Mayores de 60 a�os
	private double precioEntrada;
	
	// Constructor con 6 argumentos
	public DetalleReserva(int codigo, int codigoButaca, int codigoReserva, int tipoEntrada, double precioEntrada) {
		this.codigo = codigo;
		this.codigoButaca = codigoButaca;
		this.codigoReserva = codigoReserva;
		this.tipoEntrada = tipoEntrada;
		this.precioEntrada = precioEntrada;
	}

	// M�todos de acceso p�blico get y set
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

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

	public double getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;
	}
}
