package clases;

public class Reserva {
	// Atributos privados
	private int codigo;
	private int codigoCliente;
	private int codigoEmpleado;
	private int codigoFuncion;
	private String fechaReserva;
	private String horaReserva;
	private int estado;	// 0 = Reservada 
						// 1 = Reserva usada
						// 2 = Reserva cancelada
						// 3 = Reserva caducada
	
	

	// Constructor con 7 argumentos
	public Reserva(int codigo, int codigoCliente, int codigoEmpleado, int codigoFuncion,
			String fechaReserva, String horaReserva, int estado) {
		this.codigo = codigo;
		this.codigoCliente = codigoCliente;
		this.codigoEmpleado = codigoEmpleado;
		this.codigoFuncion = codigoFuncion;
		this.fechaReserva = fechaReserva;
		this.horaReserva = horaReserva;
		this.estado = estado;
	}

	// Métodos de acceso público get y set
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public int getCodigoFuncion() {
		return codigoFuncion;
	}

	public void setCodigoFuncion(int codigoFuncion) {
		this.codigoFuncion = codigoFuncion;
	}

	public String getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public String getHoraReserva() {
		return horaReserva;
	}

	public void setHoraReserva(String horaReserva) {
		this.horaReserva = horaReserva;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
}
