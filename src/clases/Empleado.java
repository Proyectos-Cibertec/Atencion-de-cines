package clases;

public class Empleado {
	
	// Atributos privados
	private int codigo;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private int tipo;
	private String usuario;
	private String contraseña;
	
	// Constructor con 7 parámetros	
	public Empleado(int codigo, String nombres, String apellidoPaterno, String apellidoMaterno, int tipo,
			String usuario, String contraseña) {
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.tipo = tipo;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	// Métodos de acceso público get y set
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String nombreTipoEmpleado() {
		String tipoEmpleado;
		switch (getTipo()) {
			case 0:
				tipoEmpleado = "Administrador";
				break;
			
			case 1:
				tipoEmpleado = "Supervisor";
				break;
				
			default:
				tipoEmpleado = "Cajero";
		}
		return tipoEmpleado;
	}
}