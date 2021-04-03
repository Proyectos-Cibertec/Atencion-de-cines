package libreria;

public class GeneradorClave {
	
	// Genera un nombre de usuario como la concatenación de los siguientes datos:
	/* - El valor numérico del código
	 * - El primer nombre
	 * - La primera letra del apellido paterno
	 * - La última letra del apellido materno
	 * */
	public static String generarUsuario(int codigo, String nombre, String apellidoPaterno, String apellidoMaterno) {
		// Código, nombre, primera letra del apellido paterno y última letra del apellido materno
		return codigo + nombre + apellidoPaterno.charAt(0) + apellidoMaterno.charAt(apellidoMaterno.length() - 1);  
	}
	
	/* Genera una contraseña como la concatenación de los siguientes datos:
	 * - Un número aleatorio desde 0 hasta el valor de su código
	 * - Las 4 primeras letras de su apellido paterno
	 * - Las 4 primeras letras de su apellido materno
	 */ 
	public static String generarContraseña(int codigo, String apellidoPaterno, String apellidoMaterno) {
		return "" + aleatorio(0, codigo) + apellidoPaterno.substring(0, 4) + apellidoMaterno.substring(0, 4);
	}
	
	public static int aleatorio(int minimo, int maximo) {
		return (int)((maximo - minimo + 1) * Math.random() + minimo);
	}
}
