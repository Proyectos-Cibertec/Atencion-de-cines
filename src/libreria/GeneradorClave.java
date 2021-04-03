package libreria;

public class GeneradorClave {
	
	// Genera un nombre de usuario como la concatenaci�n de los siguientes datos:
	/* - El valor num�rico del c�digo
	 * - El primer nombre
	 * - La primera letra del apellido paterno
	 * - La �ltima letra del apellido materno
	 * */
	public static String generarUsuario(int codigo, String nombre, String apellidoPaterno, String apellidoMaterno) {
		// C�digo, nombre, primera letra del apellido paterno y �ltima letra del apellido materno
		return codigo + nombre + apellidoPaterno.charAt(0) + apellidoMaterno.charAt(apellidoMaterno.length() - 1);  
	}
	
	/* Genera una contrase�a como la concatenaci�n de los siguientes datos:
	 * - Un n�mero aleatorio desde 0 hasta el valor de su c�digo
	 * - Las 4 primeras letras de su apellido paterno
	 * - Las 4 primeras letras de su apellido materno
	 */ 
	public static String generarContrase�a(int codigo, String apellidoPaterno, String apellidoMaterno) {
		return "" + aleatorio(0, codigo) + apellidoPaterno.substring(0, 4) + apellidoMaterno.substring(0, 4);
	}
	
	public static int aleatorio(int minimo, int maximo) {
		return (int)((maximo - minimo + 1) * Math.random() + minimo);
	}
}
