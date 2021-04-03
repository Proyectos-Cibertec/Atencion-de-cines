package clases;

public class Cliente extends Usuario {
	// Atributos privados
	private String fechaAfiliacion;

	// Constructor
	public Cliente(int codigo, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion,
			String distrito, String fechaNacimiento, int estadoCivil, String telefono, String dni, String usuario,
			String contraseña, String fechaAfiliacion) {
		super(codigo, nombres, apellidoPaterno, apellidoMaterno, direccion, distrito, fechaNacimiento, estadoCivil,
				telefono, dni, usuario, contraseña);
		this.fechaAfiliacion = fechaAfiliacion;
	}

	// Métodos de acceso público get y set
	public String getFechaAfiliacion() {
		return fechaAfiliacion;
	}

	public void setFechaAfiliacion(String fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}

	
}

/*package clases;

public class Cliente {
	// Atributos privados
	private int codigo;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String direccion;
	private String fechaNacimiento;
	private String fechaAfiliacion;
	private int estadoCivil;
	private String telefono;
	private String dni;
	private String usuario;
	private String contraseña;

	// Constructor con 12 argumentos
	public Cliente(int codigo, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion,
			String fechaNacimiento, String fechaAfiliacion, int estadoCivil, String telefono, String dni,
			String usuario, String contraseña) {
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAfiliacion = fechaAfiliacion;
		this.estadoCivil = estadoCivil;
		this.telefono = telefono;
		this.dni = dni;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaAfiliacion() {
		return fechaAfiliacion;
	}

	public void setFechaAfiliacion(String fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}

	public int getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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
	
	public String descripcionEstadoCivil() {
		String estadoCivil;
		
		switch (getEstadoCivil()) {
			case 0:
				estadoCivil = "Soltero";
				break;
				
			case 1:
				estadoCivil = "Casado";
				break;
				
			case 2:
				estadoCivil = "Viudo";
				break;
				
			default:
				estadoCivil = "Divorciado";
		}
		
		return estadoCivil;
	}
}
*/