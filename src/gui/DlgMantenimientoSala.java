package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloButacas;
import arreglos.ArregloCines;
import arreglos.ArregloFunciones;
import arreglos.ArregloSalas;
import clases.Butaca;
import clases.Sala;
public class DlgMantenimientoSala extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMensaje;
	private JLabel lblCdigo;
	private JLabel lblCodigoCine;
	private JLabel lblNumeroSala;
	private JLabel lblNumeroFilas;
	private JTextField txtCodigo;
	private JTextField txtNumeroSala;
	private JTextField txtNumeroFilas;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnConsultar;
	private JButton btnAceptar;
	private JButton btnVolver;

	//  Tipo de operación a procesar:
	//  Listar, Consultar, Modificar, Eliminar
	private int tipoOperacion;
	
	//  Constantes para los tipos de operaciones
	public final static int INGRESAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR = 3;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgMantenimientoSala dialog = new DlgMantenimientoSala();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgMantenimientoSala() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setResizable(false);
		setTitle("Mantenimiento | Sala");
		setBounds(100, 100, 831, 583);
		getContentPane().setLayout(null);
		
		lblMensaje = new JLabel("Seleccione una acci\u00F3n");
		lblMensaje.setOpaque(true);
		lblMensaje.setBackground(Color.LIGHT_GRAY);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensaje.setForeground(Color.BLACK);
		lblMensaje.setBounds(27, 11, 770, 36);
		getContentPane().add(lblMensaje);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(27, 58, 46, 14);
		getContentPane().add(lblCdigo);
		
		lblCodigoCine = new JLabel("Cine");
		lblCodigoCine.setBounds(27, 87, 78, 14);
		getContentPane().add(lblCodigoCine);
		
		lblNumeroSala = new JLabel("N\u00FAmero de sala");
		lblNumeroSala.setBounds(27, 112, 74, 14);
		getContentPane().add(lblNumeroSala);
		
		lblNumeroFilas = new JLabel("N\u00FAmero de filas");
		lblNumeroFilas.setBounds(27, 137, 74, 14);
		getContentPane().add(lblNumeroFilas);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(158, 55, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.addActionListener(this);
		
		txtNumeroSala = new JTextField();
		txtNumeroSala.addActionListener(this);
		txtNumeroSala.setEditable(false);
		txtNumeroSala.setBounds(158, 109, 86, 20);
		getContentPane().add(txtNumeroSala);
		txtNumeroSala.setColumns(10);
		
		txtNumeroFilas = new JTextField();
		txtNumeroFilas.addActionListener(this);
		txtNumeroFilas.setEditable(false);
		txtNumeroFilas.setBounds(158, 134, 290, 20);
		getContentPane().add(txtNumeroFilas);
		txtNumeroFilas.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(299, 54, 89, 23);
		getContentPane().add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 225, 770, 280);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);
		
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(677, 55, 120, 23);
		getContentPane().add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(677, 105, 120, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(677, 130, 120, 23);
		getContentPane().add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(677, 80, 120, 23);
		getContentPane().add(btnConsultar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(677, 164, 120, 23);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setEnabled(false);
		btnVolver.addActionListener(this);
		btnVolver.setBounds(677, 191, 120, 23);
		getContentPane().add(btnVolver);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código de sala");
		modelo.addColumn("Cine");
		modelo.addColumn("Número de sala");
		modelo.addColumn("Filas");
		modelo.addColumn("Butacas");
		tblTabla.setModel(modelo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(708, 516, 89, 23);
		getContentPane().add(btnCerrar);
		
		lblNumeroButacas = new JLabel("N\u00FAmero de butacas");
		lblNumeroButacas.setBounds(27, 162, 93, 14);
		getContentPane().add(lblNumeroButacas);
		
		txtNumeroButacas = new JTextField();
		txtNumeroButacas.addActionListener(this);
		txtNumeroButacas.setEditable(false);
		txtNumeroButacas.setBounds(158, 159, 290, 20);
		getContentPane().add(txtNumeroButacas);
		txtNumeroButacas.setColumns(10);
		txtNumeroButacas.addActionListener(this);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(609, 516, 89, 23);
		getContentPane().add(btnGrabar);
		
		cboCine = new JComboBox<String>();
		cboCine.setEnabled(false);
		cboCine.addActionListener(this);
		cboCine.setBounds(158, 84, 230, 20);
		
		
		getContentPane().add(cboCine);
		
		listar();
		cargarCinesExistentes();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboCine) {
			actionPerformedCboCine(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnBuscar || e.getSource() == txtCodigo) {
			actionPerformedBtnBuscar(e);
		}
	}
	
	// Declaración Global
	ArregloSalas arregloSalas = new ArregloSalas("salas.txt");
	ArregloCines arregloCines = new ArregloCines("cines.txt");
	ArregloButacas arregloButacas = new ArregloButacas("butacas.txt");
	ArregloFunciones arregloFunciones = new ArregloFunciones("funciones.txt");
	boolean cambios = false; // Permite saber si se hicieron cambios que necesitan guardarse
	
	private JButton btnCerrar;
	private JLabel lblNumeroButacas;
	private JTextField txtNumeroButacas;
	private JButton btnGrabar;
	private JComboBox<String> cboCine;
	private JTable tblTabla;
	
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		tipoOperacion = INGRESAR;
		lblMensaje.setText("Ingresando Sala");
		txtCodigo.setText(arregloSalas.codigoCorrelativo() + ""); // Se genera el código de la siguiente sala
		limpiarEntradas();
		habilitarEntradas(true);
		habilitarBotones(false);
		cboCine.requestFocus();
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarSala();
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Sala");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Sala");
		txtCodigo.setEditable(true);
		habilitarEntradas(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Sala");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}	
	
	protected void actionPerformedBtnVolver(ActionEvent e) {
		txtCodigo.setText("");
		limpiarEntradas();
		txtCodigo.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
		lblMensaje.setText("Seleccione una acción");
	}
	
	// Procesa la pulsación del botón Aceptar
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		switch (tipoOperacion) {
			case INGRESAR:
				ingresarSala();
				break;
				
			case CONSULTAR:
				consultarSala();
				break;
				
			case MODIFICAR:
				modificarSala();
				break;
				
			case ELIMINAR:
				eliminarSala();
				break;
		}
	}
	
	// Lista las salas en la tabla
	void listar() {
		modelo.setRowCount(0);
		Sala sala = null;
		for (int i = 0; i < arregloSalas.tamaño(); i++) {
			sala = arregloSalas.obtener(i);
			// Se obtiene el nombre del cine al que pertece la sala
			String nombreCine = arregloCines.buscar(sala.getCodigoCine()).getNombre();
			Object[] fila = {
					sala.getCodigo(),
					nombreCine,
					sala.getNumeroSala(),
					sala.getFilas(),
					sala.getButacas(),
					};
			
			modelo.addRow(fila);
		}
	}
	
	void ingresarSala() {
		int codigo = leerCodigo();
		int codigoCine = leerCodigoCine();
		try {
			int numeroSala = leerNumeroSala();
			if (numeroSala > 0) {
				// Se valida de que no exista un mismo número de sala en un mismo cine, no se debe repetir el número de sala
				if (arregloSalas.existeSala(codigoCine, numeroSala)) {
					mensaje("Error. Ya existe el número de sala: \"" + numeroSala + "\" para el cine: \"" + arregloCines.buscar(codigoCine).getNombre() + "\"");
					throw new Exception();
				}
				try {
					int numeroFilas = leerNumeroFilas();
					if (numeroFilas > 0) {
						try {
							int numeroButacas = leerNumeroButacas();
							if (numeroButacas > 0) {
								// Datos correctos
								Sala sala = new Sala(codigo, codigoCine, numeroSala, numeroFilas, numeroButacas);
								arregloSalas.adicionar(sala);
								listar();
								txtCodigo.setText("" + arregloSalas.codigoCorrelativo());
								limpiarEntradas();
								cboCine.requestFocus();
								
								// Una vez creada una sala se generan sus butacas
								generarButacas(codigo, numeroFilas, numeroButacas);
								
								mensaje("Registro exitoso");
								cambios = true; // Variable que permite saber si se realizaron cambios en el Arraylist 
								
							} else {
								mensaje("El número de butacas debe ser mayor que cero");
								throw new Exception();
							}
						} catch (Exception e) {
							mensaje("Ingrese Número butacas correcto");
							txtNumeroSala.setText("");
							txtNumeroSala.requestFocus();
						}
					} else {
						mensaje("El número de filas debe ser mayor que cero");
						throw new Exception();
					}
				} catch (Exception e) {
					mensaje("Ingrese Número de filas correcto");
					txtNumeroFilas.setText("");
					txtNumeroFilas.requestFocus();
				}
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			mensaje("Ingrese Número de sala correcto");
			txtNumeroSala.setText("");
			txtNumeroSala.requestFocus();
		}
	}
	
	void consultarSala() {
		try {
			Sala sala = arregloSalas.buscar(leerCodigo());
			if (sala != null) {
				cboCine.setSelectedItem(arregloCines.buscar(sala.getCodigoCine()).getNombre());
				txtNumeroSala.setText("" + sala.getNumeroSala());
				txtNumeroFilas.setText("" + sala.getFilas());
				txtNumeroButacas.setText("" + sala.getButacas());
				
			} else {
				mensaje("El código " + leerCodigo() + " no existe");
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		} catch (Exception e) {
			mensaje("Ingrese CÓDIGO correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	
	void modificarSala() {
		try {
			Sala sala = arregloSalas.buscar(leerCodigo());
			int codigoCine = leerCodigoCine();
			try {
				int numeroSala = leerNumeroSala();
				if (numeroSala > 0) {
					try {
						int numeroFilas = leerNumeroFilas();
						if (numeroFilas > 0) {
							try {
								int numeroButacas = leerNumeroButacas();
								if (numeroButacas > 0) {
									
									// Datos correctos
									int respuesta = confirmar("¿Seguro que desea modificar los datos del cine seleccionado?",
											"Seleccionar una opción");
											
									if (respuesta == JOptionPane.YES_OPTION) {
										sala.setCodigoCine(codigoCine);
										sala.setNumeroSala(numeroSala);
										
										/************************************************************************************/
										/* Al modificar el # de filas o columnas se ha optado por borrar todas las butacas de la
										 * sala y volver a generarlas. Para ello el número de filas o columnas de la sala actual
										 * debe haber cambiado
										 * */
										/************************************************************************************/
										if (sala.getFilas() != numeroFilas || sala.getButacas() != numeroButacas) {
											arregloButacas.eliminarButacasDeSala(sala.getCodigo()); // Se eliminan todas las butacas
											generarButacas(sala.getCodigo(), numeroFilas, numeroButacas);
										}
										sala.setFilas(numeroFilas);
										sala.setButacas(numeroButacas);
										
										
										listar();
										txtCodigo.requestFocus();								
										mensaje("Modificación exitosa");
										cambios = true; // Variable que permite saber si se realizaron cambios en el Arraylist
									}	
									
								} else {
									throw new Exception();
								}
							} catch (Exception e) {
								mensaje("Ingrese Número butacas correcto");
								txtNumeroSala.setText("");
								txtNumeroSala.requestFocus();
							}
						} else {
							throw new Exception();
						}
					} catch (Exception e) {
						mensaje("Ingrese Número de filas correcto");
						txtNumeroFilas.setText("");
						txtNumeroFilas.requestFocus();
					}
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				mensaje("Ingrese Número de sala correcto");
				txtNumeroSala.setText("");
				txtNumeroSala.requestFocus();
			}
		} catch (Exception e) {
			mensaje("Ingrese CÓDIGO correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	
	void eliminarSala() {
		try {
			Sala sala = arregloSalas.buscar(leerCodigo());
			if (sala  != null) {
				int respuesta = confirmar("¿Seguro que desea eliminar al cine seleccionado?",
						"Seleccionar una opción");
						
				if (respuesta == JOptionPane.YES_OPTION) {
					arregloButacas.eliminarButacasDeSala(sala.getCodigo()); // Se elimina las butacas de la sala actual
					arregloFunciones.eliminarFuncionesDeSala(sala.getCodigo()); // Se eliminan las funciones de la sala actual
					arregloSalas.eliminar(sala);
					listar();
					txtCodigo.setText("");
					limpiarEntradas();
					txtCodigo.requestFocus();
					mensaje("Eliminación exitosa");
					cambios = true; // Variable que permite saber si se realizaron cambios en el Arraylist
				}
			} else {
				mensaje("El código " + leerCodigo() + " no existe");
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		} catch (Exception e) {
			e.printStackTrace();
			mensaje("ingrese Código correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	
	// Limpia los cuadros de texto
	void limpiarEntradas() {
		cboCine.setSelectedIndex(0);
		txtNumeroSala.setText("");
		txtNumeroFilas.setText("");
		txtNumeroButacas.setText("");
	}
	
	// Habilita los cuadros de texto y combobox para ingresar/seleccionar datos
	void habilitarEntradas(boolean valor) {		
		cboCine.setEnabled(valor);
		txtNumeroSala.setEditable(valor);
		txtNumeroFilas.setEditable(valor);
		txtNumeroButacas.setEditable(valor);
	}
	
	// Habilita / Deshabilita botones
	void habilitarBotones(boolean valor) {
		if (tipoOperacion != INGRESAR) {
			btnBuscar.setEnabled(!valor);
		}
		btnIngresar.setEnabled(valor);
		btnConsultar.setEnabled(valor);
		btnModificar.setEnabled(valor);
		btnEliminar.setEnabled(valor);
		
		if (tipoOperacion == CONSULTAR) {
			btnAceptar.setEnabled(false);
		} else {
			btnAceptar.setEnabled(!valor);
		}
		btnVolver.setEnabled(!valor);
	}
	
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
	
	// Métodos que retornan valor sin parámetros
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	int leerCodigoCine() {
		return arregloCines.obtenerCodigoCine(cboCine.getSelectedItem().toString());
	}
	
	int leerNumeroSala() {
		return Integer.parseInt(txtNumeroSala.getText().trim());
	}
	
	int leerNumeroFilas() {
		return Integer.parseInt(txtNumeroFilas.getText().trim());
	}
	
	int leerNumeroButacas() {
		return Integer.parseInt(txtNumeroButacas.getText().trim());
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		if (cambios) {
			int respuesta = confirmar("¿Desea guardar los cambios realizados en el archivo \"" + arregloSalas.getArchivo() + "\"?");
			if (respuesta == JOptionPane.YES_OPTION) {
				// Se guardan los cambios en los archivos correspondientes
				arregloSalas.grabarSalas();
				arregloButacas.grabarButacas();
				arregloFunciones.grabarFunciones();
				mensaje("\"" + arregloSalas.getArchivo() + "\" ha sido actualizado");
				cambios = false; // Permite saber que ya se guardaron los cambios en el arraylist
			}
		}
		dispose();
	}
	
	// Actualiza el archivo
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		if (arregloSalas.existeArchivo()) {
			int respuesta = confirmar("¿Seguro que desea actualizar \"" + arregloSalas.getArchivo() + "\"?");
			if (respuesta == JOptionPane.YES_OPTION) {
				// Se guardan los cambios en los archivos correspondientes
				arregloSalas.grabarSalas();
				arregloButacas.grabarButacas();
				arregloFunciones.grabarFunciones();
				mensaje("\"" + arregloSalas.getArchivo() + "\" ha sido actualizado");
				cambios = false; // Permite saber que ya se guardaron los cambios en el Arraylist
			} else {
				mensaje("No se actualizó \"" + arregloSalas.getArchivo() + "\"");
			}
		} else {
			// Si no existe el archivo es creado y se guardan los cambios correspondientes
			arregloSalas.grabarSalas();
			arregloButacas.grabarButacas();
			arregloFunciones.grabarFunciones();
			mensaje("\"" + arregloSalas.getArchivo() + "\" ha sido creado");
		}
	}

	protected void actionPerformedCboCine(ActionEvent e) {
		txtNumeroSala.requestFocus();
	}
	
	// Llena el combobox con los Cines existentes
	public void cargarCinesExistentes() {
		for (int i = 0; i < arregloCines.tamaño(); i++) {
			cboCine.addItem(arregloCines.obtener(i).getNombre());
		}
	}
	
	// Genera las butacas para la sala cuyo código, filas y butacasPorFila se le pasa como argumento
	public void generarButacas(int codigoSala, int filas, int butacasPorFila) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < butacasPorFila; j++) {
				int codigoButaca = arregloButacas.codigoCorrelativo();
				// Se generan las butacas, todas disponibles
				arregloButacas.adicionar(new Butaca(codigoButaca, codigoSala, (i + 1), (j + 1), 1));
			}
		}
	}
}
