package gui;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import arreglos.ArregloButacas;
import arreglos.ArregloDetalleReservas;
import arreglos.ArregloFunciones;
import arreglos.ArregloReservas;
import arreglos.ArregloSalas;
import clases.Butaca;
import clases.Funcion;
import clases.Sala;
import libreria.Asiento;
import libreria.ModeloTablaCeldaNoEditable;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class DlgSeleccionButacas extends JDialog implements MouseListener, ActionListener, KeyListener, InputMethodListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private JPanel panelSeleccionarButacas;
	private JLabel lblPantalla;
	private JPanel panelButacas;
	private JLabel lblDescripcion;
	private JLabel lblNDeButacas;
	public static JLabel lblButacasSeleccionadas;
	public static JLabel lblButacasOcupadas;
	private JLabel lblEntradas;
	private JPanel panelRegistro;
	private JButton btnAceptar;
	private JPanel panel;
	private JLabel lblTotals;
	private static JComboBox<String> cboTipoEntrada2;
	private JTable tblTablaEntradas;
	public ModeloTablaCeldaNoEditable modelo = new ModeloTablaCeldaNoEditable();;

	public DlgSeleccionButacas(int codigoFuncion) {
		setTitle("Selecci\u00F3n de butacas");
		setBounds(100, 100, 1293, 708);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		panelSeleccionarButacas = new JPanel();
		panelSeleccionarButacas.setToolTipText("");
		tabbedPane.addTab("Seleccionar butacas", null, panelSeleccionarButacas, null);
		panelSeleccionarButacas.setLayout(null);
		
		lblPantalla = new JLabel("");
		lblPantalla.setIcon(new ImageIcon(DlgSeleccionButacas.class.getResource("/img/pantallaCine.png")));
		lblPantalla.setBounds(663, 11, 528, 149);
		panelSeleccionarButacas.add(lblPantalla);
		
		
		cboTipoEntrada2 = new JComboBox<String>();
		cboTipoEntrada2.setModel(new DefaultComboBoxModel<String>(new String[] {"General", "Menores de 11 a\u00F1os", "Mayores de 60 a\u00F1os"}));
		if (cboTipoEntrada2 == null) {
			mensaje("CBO es nulo");
		}
		
		panel = new JPanel();
		panel.setBounds(243, 655, 206, 52);
		panelSeleccionarButacas.add(panel);
		panel.add(cboTipoEntrada2);
		panel.setVisible(true);
		
		if (panel == null) {
			mensaje("panel es nulo");
		}
		
		
		panelButacas = new JPanel();
		panelButacas.addInputMethodListener(this);
		panelButacas.setLayout(null);
		panelButacas.setBorder(new TitledBorder(null, "Seleccione butacas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelButacas.setBounds(584, 160, 678, 461);
		panelSeleccionarButacas.add(panelButacas);
		
		lblEntradas = new JLabel("LISTA DE ENTRADAS");
		lblEntradas.setBounds(10, 119, 564, 27);
		panelSeleccionarButacas.add(lblEntradas);
		lblEntradas.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		panelRegistro = new JPanel();
		panelRegistro.setBounds(10, 160, 564, 427);
		panelSeleccionarButacas.add(panelRegistro);
		panelRegistro.setLayout(null);
		panelRegistro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registro de Entradas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 23, 544, 393);
		panelRegistro.add(scrollPane_1);
		
		
		tblTablaEntradas = new JTable();
		tblTablaEntradas.addKeyListener(this);
		tblTablaEntradas.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblTablaEntradas);
		
		modelo.addColumn("Código de butaca");
		modelo.addColumn("Tipo de entrada");
		modelo.addColumn("Precio");
		modelo.addColumn("Fila");
		modelo.addColumn("Columna");
		tblTablaEntradas.setModel(modelo);
		
		
		// Insertar combobox a la columna 1 de la tabla
		TableColumn tc = tblTablaEntradas.getColumnModel().getColumn(1); // Se obtiene la columna
		TableCellEditor tce = new DefaultCellEditor(cboTipoEntrada2);
		tc.setCellEditor(tce);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(DlgSeleccionButacas.class.getResource("/img/btnAceptar.png")));
		btnAceptar.setBounds(20, 598, 128, 32);
		panelSeleccionarButacas.add(btnAceptar);
		
		lblTotals = new JLabel("Total (S/.) :");
		lblTotals.setBounds(267, 598, 97, 20);
		panelSeleccionarButacas.add(lblTotals);
		lblTotals.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblCostoTotal = new JLabel("00.0");
		lblCostoTotal.setBounds(374, 598, 89, 20);
		panelSeleccionarButacas.add(lblCostoTotal);
		lblCostoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostoTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnActualizar = new JButton("");
		btnActualizar.setIcon(new ImageIcon(DlgSeleccionButacas.class.getResource("/img/btnActualizar.png")));
		btnActualizar.setBounds(485, 598, 89, 32);
		panelSeleccionarButacas.add(btnActualizar);
		
		
		
		lblDescripcion = new JLabel("N\u00BA de butacas seleccionadas");
		lblDescripcion.setBounds(1038, 11, 146, 14);
		panelSeleccionarButacas.add(lblDescripcion);
		
		lblButacasSeleccionadas = new JLabel("0");
		lblButacasSeleccionadas.setBounds(1216, 11, 46, 14);
		panelSeleccionarButacas.add(lblButacasSeleccionadas);
		lblButacasSeleccionadas.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblNDeButacas = new JLabel("N\u00BA de butacas Ocupadas");
		lblNDeButacas.setBounds(1038, 47, 146, 14);
		panelSeleccionarButacas.add(lblNDeButacas);
		
		lblButacasOcupadas = new JLabel("0");
		lblButacasOcupadas.setBounds(1216, 45, 46, 14);
		panelSeleccionarButacas.add(lblButacasOcupadas);
		lblButacasOcupadas.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnActualizar.addActionListener(this);
		btnAceptar.addActionListener(this);
		
		
		// Se obtiene la función
		funcionActual = arregloFunciones.buscar(codigoFuncion);
		
		if (funcionActual != null) {
			// Se obtiene la sala en la que se realizará la función
			salaActual = arregloSalas.buscar(funcionActual.getCodigoSala());
			
			// Carga los asientos en sus respectivos lugares
			if (salaActual != null) {
				filas = salaActual.getFilas();	// Obtiene el # de filas
				columnas = salaActual.getButacas(); // Obtiene el # de columnas
				
				asientos = new Asiento[filas][columnas]; // Crea el arreglo de asientos
				cargarAsientos();						 // Carga los asientos en la ventana
				
				listarAsientosTemporales(); // Carga la tabla con las entradas seleccionadas anteriormente en esta misma reserva
				
			} else {
				mensaje("ERROR. La sala seleccionada no existe en el archivo");
			}
		} else {
			mensaje("ERROR. La función seleccionada no existe en el archivo");
		}
	}
	
	// Declaración Global
	ArregloFunciones arregloFunciones = new ArregloFunciones("funciones.txt");
	ArregloSalas arregloSalas = new ArregloSalas("salas.txt");
	ArregloButacas arregloButacas = new ArregloButacas("butacas.txt");
	ArregloReservas arregloReservas = new ArregloReservas("reservas.txt");
	ArregloDetalleReservas adr = new ArregloDetalleReservas("detalle_reservas.txt");
	
	Funcion funcionActual = null;	// Es la función seleccionada actualmente
	Sala salaActual = null;			// Es la sala de la cual se elijen sus butacas
	int filas, columnas;			// Número de butacas por filas y columnas
	int butacasReservadas = 0;			// Contabiliza la cantidad de butacas reservadas por otros clientes
	public static int butacasSeleccionadas;	// Contabiliza la cantidad de butacas seleccionadas en este momento (Se inicializa con el arreglo de entradas temporales)
	public static int codigoReservaActual;
	int numeroButacasOcupadas;
	
	// Declaración del array de butacas
	Asiento[][] asientos;
	
	// Declaración del vector de txtDetalleReserva
	ArrayList<JTextField>txtCodigoDetalleReservas = new ArrayList<JTextField>();
	
	
	
	int totalRegistros; // # total de entradas registradas
	private JScrollPane scrollPane_1;
	
	// Método que muestra un mensaje
	void mensaje(String cadena) {
		JOptionPane.showMessageDialog(this, cadena);
	}
	
	// Método sobrecargado que pide una confirmación
	int confirmar(String mensaje, String tituloMensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje,
				tituloMensaje, JOptionPane.YES_NO_OPTION);
	}
	
	// Método sobrecargado que pide una confirmación
	int confirmar(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje,
				"Seleccionar una opción", JOptionPane.YES_NO_OPTION);
	}

	
	// Carga los asientos que representan a cada butaca de la sala
	void cargarAsientos() {
		int numeroAsientos = 0;
		numeroButacasOcupadas = 0;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				numeroAsientos++;
				
				// Obtiene una butaca en una determinada sala, en la fila y columna especificada
				Butaca butaca = arregloButacas.obtenerButaca(funcionActual.getCodigoSala(), i + 1, j + 1); // Obtiene la butaca en la fila y columna especificada (a partir de 1)
				
				// Se obtiene información sobre su disponibilidad
				int estadoButaca = butaca.getEstado(); // 0: Reservado | 1: Disponible // Solo las butacas disponibles serán elegibles
				if (estadoButaca == 0) {
					numeroButacasOcupadas++;
				}
				asientos[i][j] = new Asiento(butaca.getCodigo(), codigoReservaActual, numeroAsientos, estadoButaca); // Se crea cada asiento con código igual al código de butaca
				
				/* En este bloque consiste en pintar como ocupadas aquellos asientos que han sido seleccionados hace un momento y 
				 * mientras todavía no se haya cerrado la ventana de DlgReservaEntradas*/
				ocuparSiEstanEnTablaDeAsientosTemporales(asientos[i][j]);
				/* * */
				
				
				if (i == 0) {
					// La primera fila debe estar un poco más alejada de la pantalla
					asientos[i][j].setBounds(5 + j * 64, 20 + i * 64, 64, 64);
				} else {
					asientos[i][j].setBounds(5 + j * 64, 20 + i * 64, 64, 64);
				}
				
				asientos[i][j].addMouseListener(this);
				panelButacas.add(asientos[i][j]);
			}
		}
		lblButacasOcupadas.setText("" + numeroButacasOcupadas);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	// ArrayList temporal de asientos
	public static ArrayList<Asiento> asientosTMP = new ArrayList<>(); // Permite saber cuántos asientos están seleccionados actualmente
	public static JLabel lblCostoTotal;
	public static double costoTotal;
	private JButton btnActualizar;
	
	void listarAsientosTemporales() {
		modelo.setRowCount(0);
		costoTotal = 0;
		for (Asiento asiento : asientosTMP) {
			Object[] fila = {
					asiento.getCodigo(), // Código del asiento == código de la butaca
					asiento.getTipoEntrada(), // Tipo de entrada
					asiento.getPrecio(), // Precio
					arregloButacas.buscar(asiento.getCodigo()).getNumeroFila(),	// Fila
					arregloButacas.buscar(asiento.getCodigo()).getNumeroColumna()	// Columna
			};
			modelo.addRow(fila);
			costoTotal += Double.parseDouble(fila[2].toString()); // Se acumula el costo total
		}
		
		butacasSeleccionadas = asientosTMP.size();
		lblButacasSeleccionadas.setText("" + butacasSeleccionadas);
		lblCostoTotal.setText("" + costoTotal);
		DlgReservaEntradas.txtEntradas.setText("" + butacasSeleccionadas);
		DlgReservaEntradas.txtCostoTotal.setText("" + costoTotal);
	}
	
	void ocuparSiEstanEnTablaDeAsientosTemporales(Asiento a) {
		for (Asiento asiento : asientosTMP) {
			if (asiento.getCodigo() == a.getCodigo()) {
				a.ocupar();
			}
		}
	}
	
	void eliminarAsientoPorCodigo(int codigoAsiento) {
		Iterator<Asiento> itrAsientos = asientosTMP.iterator();
		while (itrAsientos.hasNext()) {
			Asiento asiento = itrAsientos.next();
			if (asiento.getCodigo() == codigoAsiento && asiento.getCodigoReserva() == codigoReservaActual) {
				itrAsientos.remove();
			}
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		if (panelButacas.isEnabled()) {
			for (int i = 0; i < filas; i++) {
	    		for (int j = 0; j < columnas; j++) {
	    			if (e.getSource() == asientos[i][j]) {
	    				
	    				if (asientos[i][j].getEstado() != 0) { // Se descarta cualquier evento de clic en asientos que no estén disponibles para la reserva actual
	    					
		    				asientos[i][j].ocupar(); // Ocupa o desocupa la butaca en donde se hizo clic
		    				
		    				// Si la butaca está ocupado, se añade al arraylist de asientosTMP
		    				if (asientos[i][j].estaOcupado()) {
		    					
		    					// Se llena el arrayList asientosTMP para saber los asientos temporales que se han seleccionado actualmente
		    					asientosTMP.add(asientos[i][j]);
		    					listarAsientosTemporales();
		    					
		    				// Si la butaca se ha desocupado, se debe quitar del arrayList de asientos temporales
		    				} else {
		    					
		    					// Se quita el asiento seleccionado del arraylist de asientos temporales		    							    					
		    					eliminarAsientoPorCodigo(asientos[i][j].getCodigo());
		    					listarAsientosTemporales();
		    				}
		    				
		    				lblButacasSeleccionadas.setText("" + butacasSeleccionadas);
		    				DlgReservaEntradas.txtEntradas.setText("" + butacasSeleccionadas);
		    				lblCostoTotal.setText("" + costoTotal);
	    				}
	    			}
	    		}
			}
		}		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		//int respuesta = confirmar("¿Seguro que desea continuar?");
		//if (respuesta == JOptionPane.YES_OPTION) {
			DlgReservaEntradas.txtEntradas.setText("" + butacasSeleccionadas);
			dispose();
		//}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblTablaEntradas) {
			keyReleasedTblTablaEntradas(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	
	protected void keyReleasedTblTablaEntradas(KeyEvent e) {
		actualizarValoresDeTablaDeEntradas();
	}
	
	public void caretPositionChanged(InputMethodEvent event) {
	}
	public void inputMethodTextChanged(InputMethodEvent event) {
		if (event.getSource() == panelButacas) {
			inputMethodTextChangedPanelButacas(event);
		}
	}
	
	protected void inputMethodTextChangedPanelButacas(InputMethodEvent event) {
		
	}
	
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarValoresDeTablaDeEntradas();
	}
	
	void actualizarValoresDeTablaDeEntradas() {
		for (int i = 0; i < tblTablaEntradas.getRowCount(); i++) {
			try {
				int codigoButaca = Integer.parseInt(tblTablaEntradas.getValueAt(i, 0).toString());
				String tipoEntrada = tblTablaEntradas.getValueAt(i, 1).toString();
				double precioTotal = Double.parseDouble(tblTablaEntradas.getValueAt(i, 2).toString());
				
				// Se modifican los valores de dicho asientos en el arraylist de asientos temporales
				for (Asiento asiento : asientosTMP) {
					if (asiento.getCodigo() == codigoButaca && asiento.getCodigoReserva() == codigoReservaActual) {
						asiento.setTipoEntrada(tipoEntrada);
						asiento.setPrecio(precioTotal);
					}
				}
				
			} catch (Exception e2) {
				mensaje("Ha ingresado datos no válidos en la tabla");
				break;
			}
		}
		listarAsientosTemporales();
	}
}
