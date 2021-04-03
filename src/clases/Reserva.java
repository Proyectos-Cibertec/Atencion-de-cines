package clases;

public class Reserva {
	// Atributos privados
	private int codigo;
	private int codigoCliente;
	private int codigoEmpleado;
	private int codigoFuncion;
	private int numeroEntradas;
	private String fechaReserva;
	private String horaReserva;
	private int estado;	// 0 = Reservada 
						// 1 = Reserva usada
						// 2 = Reserva cancelada
						// 3 = Reserva caducada
	
	

	// Constructor
	public Reserva(int codigo, int codigoCliente, int codigoEmpleado, int codigoFuncion,
			int numeroEntradas, String fechaReserva, String horaReserva, int estado) {
		this.codigo = codigo;
		this.codigoCliente = codigoCliente;
		this.codigoEmpleado = codigoEmpleado;
		this.codigoFuncion = codigoFuncion;
		this.numeroEntradas = numeroEntradas;
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

	public int getNumeroEntradas() {
		return numeroEntradas;
	}

	public void setNumeroEntradas(int numeroEntradas) {
		this.numeroEntradas = numeroEntradas;
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
	
	public String getEstadoDescripcion() {
		switch (getEstado()) {
			case 0:
				return "Reservada";
				
			case 1:
				return "Reserva usada";
			
			case 2:
				return "Reserva cancelada";
				
			default:
				return "Reserva caducada";
		}
	}
}
