package clases;

public class Pelicula {
	// Atributos privados
	private int codigo;
	private String tituloDistribucion;
	private String tituloOriginal;
	private String fechaEstreno;
	private int tipoProyeccion; // 0 = Estreno | 1 = Fuera de estreno
	private String genero;
	private String paisOrigen;
	private String sinopsis;
	private int duracion; // minutos
	private int tipoCensura; // 0 = Apta para todos
							 // 1 = Mayores de 14 años
							 // 2 = Fuera de cartelera
	private int estadoProyeccion; // 0 = En cartelera | 2 = Fuera de cartelera
	private double recaudacion;

	// Constructor con 12 argumentos
	public Pelicula(int codigo, String tituloDistribucion, String tituloOriginal, String fechaEstreno,
			int tipoProyeccion, String genero, String paisOrigen, String sinopsis, int duracion, int tipoCensura,
			int estadoProyeccion, double recaudacion) {
		this.codigo = codigo;
		this.tituloDistribucion = tituloDistribucion;
		this.tituloOriginal = tituloOriginal;
		this.fechaEstreno = fechaEstreno;
		this.tipoProyeccion = tipoProyeccion;
		this.genero = genero;
		this.paisOrigen = paisOrigen;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
		this.tipoCensura = tipoCensura;
		this.estadoProyeccion = estadoProyeccion;
		this.recaudacion = recaudacion;
	}
	
	// Métodos de acceso público get y set
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTituloDistribucion() {
		return tituloDistribucion;
	}

	public void setTituloDistribucion(String tituloDistribucion) {
		this.tituloDistribucion = tituloDistribucion;
	}

	public String getTituloOriginal() {
		return tituloOriginal;
	}

	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}

	public String getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public int getTipoProyeccion() {
		return tipoProyeccion;
	}

	public void setTipoProyeccion(int tipoProyeccion) {
		this.tipoProyeccion = tipoProyeccion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getTipoCensura() {
		return tipoCensura;
	}

	public void setTipoCensura(int tipoCensura) {
		this.tipoCensura = tipoCensura;
	}

	public int getEstadoProyeccion() {
		return estadoProyeccion;
	}

	public void setEstadoProyeccion(int estadoProyeccion) {
		this.estadoProyeccion = estadoProyeccion;
	}

	public double getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(double recaudacion) {
		this.recaudacion = recaudacion;
	}
}
