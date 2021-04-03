package clases;

public class Persona {
	private int codigo;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String direccion;
	private String distrito;
	private String fechaNacimiento;
	private int estadoCivil;	// 0 = Soltero | 1 = Casado | 2 = Viudo | 3 = Divorciado
	private String telefono;
	private String dni;
	
	public Persona(int codigo, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion,
			String distrito, String fechaNacimiento, int estadoCivil, String telefono, String dni) {
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.direccion = direccion;
		this.distrito = distrito;
		this.fechaNacimiento = fechaNacimiento;
		this.estadoCivil = estadoCivil;
		this.telefono = telefono;
		this.dni = dni;
	}

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
	
	public String getDistrito() {
		return distrito;
	}
	
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	
	// Métodos complementarios
	public String getEstadoCivilDescripcion() {
		String estado;
		
		switch (this.getEstadoCivil()) {
			case 0:
				estado = "Soltero";
				break;
				
			case 1:
				estado = "Casado";
				break;
				
			case 2:
				estado = "Viudo";
				break;
				
			default:
				estado = "Divorciado";
				break;
		}
		
		return estado;
	}
}
