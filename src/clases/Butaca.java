package clases;

public class Butaca {
	// Atributos privados
	private int codigo;
	private int codigoSala;
	private int numeroFila;
	private int numeroColumna;
	private int estado; // 0 = Reservada | 1 = Disponible
	
	// Constructor con 5 argumentos
	public Butaca(int codigo, int codigoSala, int numeroFila, int numeroColumna, int estado) {
		this.codigo = codigo;
		this.codigoSala = codigoSala;
		this.numeroFila = numeroFila;
		this.numeroColumna = numeroColumna;
		this.estado = estado;
	}

	// Métodos de acceso público get y set
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoSala() {
		return codigoSala;
	}

	public void setCodigoSala(int codigoSala) {
		this.codigoSala = codigoSala;
	}

	public int getNumeroFila() {
		return numeroFila;
	}

	public void setNumeroFila(int numeroFila) {
		this.numeroFila = numeroFila;
	}

	public int getNumeroColumna() {
		return numeroColumna;
	}

	public void setNumeroColumna(int numeroColumna) {
		this.numeroColumna = numeroColumna;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
}
