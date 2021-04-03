package libreria;

import javax.swing.table.DefaultTableModel;

public class ModeloTablaCeldaNoEditable extends DefaultTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Se sobrescribe el método isCellEditable
	// Se quiere que sean editables la columna 1 (Tipo de entrada) y columna 2 (Precio)
	public boolean isCellEditable(int fila, int columna) {
		if (columna == 1 || columna == 2) {
			return true;
		} else
			return false;
	}
}
