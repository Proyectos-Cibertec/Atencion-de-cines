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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import arreglos.ArregloCines;
import arreglos.ArregloFunciones;
import arreglos.ArregloPeliculas;
import arreglos.ArregloSalas;
import clases.Cine;
import clases.Funcion;
import clases.Sala;
import libreria.LibreriaFechas;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import com.toedter.calendar.JDateChooser;
public class DlgMantenimientoFuncion extends JInternalFrame implements ActionListener, ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMensaje;
	private JLabel lbloCdigo;
	private JLabel lblCodigoCine;
	private JLabel lblCodigoSala;
	private JLabel lblCodigoPelicula;
	private JTextField txtCodigo;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnConsultar;
	private JButton btnAceptar;
	private JButton btnVolver;

	//  Tipo de operaci�n a procesar:
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
					DlgMantenimientoFuncion dialog = new DlgMantenimientoFuncion();
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
	public DlgMantenimientoFuncion() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		setTitle("Mantenimiento | Funci\u00F3n");
		setBounds(100, 100, 832, 618);
		getContentPane().setLayout(null);
		
		lblMensaje = new JLabel("Seleccione una acci\u00F3n");
		lblMensaje.setOpaque(true);
		lblMensaje.setBackground(Color.LIGHT_GRAY);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensaje.setForeground(Color.BLACK);
		lblMensaje.setBounds(27, 11, 770, 36);
		getContentPane().add(lblMensaje);
		
		lbloCdigo = new JLabel("C\u00F3digo");
		lbloCdigo.setBounds(27, 58, 46, 14);
		getContentPane().add(lbloCdigo);
		
		lblCodigoCine = new JLabel("Cine");
		lblCodigoCine.setBounds(27, 87, 46, 14);
		getContentPane().add(lblCodigoCine);
		
		lblCodigoSala = new JLabel("Sala");
		lblCodigoSala.setBounds(27, 112, 78, 14);
		getContentPane().add(lblCodigoSala);
		
		lblCodigoPelicula = new JLabel("Pel\u00EDcula");
		lblCodigoPelicula.setBounds(27, 137, 80, 14);
		getContentPane().add(lblCodigoPelicula);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(158, 55, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.addActionListener(this);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(299, 54, 89, 23);
		getContentPane().add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 259, 770, 280);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(521, 58, 133, 43);
		getContentPane().add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(521, 108, 133, 43);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(664, 108, 120, 43);
		getContentPane().add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(664, 58, 120, 43);
		getContentPane().add(btnConsultar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(521, 184, 133, 43);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setEnabled(false);
		btnVolver.addActionListener(this);
		btnVolver.setBounds(664, 184, 120, 43);
		getContentPane().add(btnVolver);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("C�digo");
		modelo.addColumn("Cine");
		modelo.addColumn("Sala");
		modelo.addColumn("Pel�cula");
		modelo.addColumn("Fecha de la funci�n");
		modelo.addColumn("Hora de la funci�n");		
		tblTabla.setModel(modelo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(678, 546, 106, 43);
		getContentPane().add(btnCerrar);
		
		lblFechaFuncion = new JLabel("Fecha de la funci\u00F3n:");
		lblFechaFuncion.setBounds(27, 162, 97, 14);
		getContentPane().add(lblFechaFuncion);
		
		lblHoraFuncion = new JLabel("Hora de la funci\u00F3n");
		lblHoraFuncion.setBounds(27, 188, 98, 14);
		getContentPane().add(lblHoraFuncion);
		
		txtHoraFuncion = new JTextField();
		txtHoraFuncion.addActionListener(this);
		txtHoraFuncion.setEditable(false);
		txtHoraFuncion.setBounds(158, 185, 133, 20);
		getContentPane().add(txtHoraFuncion);
		txtHoraFuncion.setColumns(10);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(548, 546, 120, 43);
		getContentPane().add(btnGrabar);
		
		cboCine = new JComboBox<String>();
		cboCine.setEnabled(false);
		cboCine.addActionListener(this);
		cboCine.addItemListener(this);
		cboCine.setBounds(158, 84, 230, 20);
		getContentPane().add(cboCine);
		
		cboSala = new JComboBox<String>();
		cboSala.setEnabled(false);
		cboSala.addActionListener(this);
		cboSala.addItemListener(this);
		cboSala.setBounds(158, 109, 230, 20);
		getContentPane().add(cboSala);
		
		cboPelicula = new JComboBox<String>();
		cboPelicula.setEnabled(false);
		cboPelicula.addActionListener(this);
		cboPelicula.addItemListener(this);
		cboPelicula.setBounds(158, 134, 230, 20);
		getContentPane().add(cboPelicula);
		
		txtFechaFuncion = new JDateChooser();
		txtFechaFuncion.setEnabled(false);
		txtFechaFuncion.setDateFormatString("dd/MM/yyyy");
		txtFechaFuncion.setBounds(158, 159, 133, 20);
		getContentPane().add(txtFechaFuncion);
		
		btnIngresar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnIngresar.png")));
		btnModificar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnModificar.png")));

		btnEliminar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnEliminar.png")));
		btnConsultar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/itemConsultarPapel.png")));
		btnAceptar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnAceptar.png")));
		btnVolver.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnVolver.png")));
		btnCerrar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnCancelar.png")));

		btnGrabar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnGrabar.png")));
		
		// Se valida que haya cines existentes que contengan al menos una sala
		if (arregloCines.tama�o() > 0) {
			if (arregloSalas.tama�o() > 0) {
				if (arregloPeliculas.tama�o() > 0) {
					cargarCinesExistentes(); // Carga din�micamente los cines existentes que contengan al menos una sala
					cargarPeliculasExistentes(); // Carga din�micamente la lista de pel�culas
					listar();
				} else {
					mensaje("Error. No existen pel�culas registradas. No se podr� elegir ninguna " + ""
							+ "funci�n a menos que alguna pel�cula haya sido registrada.");
					
					// Se deshabilitan todos los botones excepto el de Cerrar
					habilitarBotones(false);
					btnAceptar.setEnabled(false);
					btnVolver.setEnabled(false);
					btnGrabar.setEnabled(false);
				}
			} else {
				mensaje("Error. No existe ninguna Sala en ning�n cine. No se podr� elegir ninguna " + ""
						+ "funci�n a menos que alg�n cine tenga una sala como m�nimo");
				
				// Se deshabilitan todos los botones excepto el de Cerrar
				habilitarBotones(false);
				btnAceptar.setEnabled(false);
				btnVolver.setEnabled(false);
				btnGrabar.setEnabled(false);
			}
		} else {
			mensaje("Error. No existe ning�n Cine en el archivo. No se podr� elegir ninguna funci�n.");
			
			// Se deshabilitan todos los botones excepto el de Cerrar
			habilitarBotones(false);
			btnAceptar.setEnabled(false);
			btnVolver.setEnabled(false);
			btnGrabar.setEnabled(false);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboPelicula) {
			actionPerformedCboPelicula(e);
		}
		if (e.getSource() == cboSala) {
			actionPerformedCboSala(e);
		}
		if (e.getSource() == cboCine) {
			actionPerformedCboCine(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == txtHoraFuncion) {
			actionPerformedTxtFechaInicio(e);
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
	
	// Declaraci�n Global
	ArregloFunciones arregloFunciones = new ArregloFunciones("funciones.txt");
	ArregloCines arregloCines = new ArregloCines("cines.txt");
	ArregloSalas arregloSalas = new ArregloSalas("salas.txt");
	ArregloPeliculas arregloPeliculas = new ArregloPeliculas("peliculas.txt");
	boolean cambios = false; // Permite saber si se hicieron cambios que necesitan guardarse
	
	private JButton btnCerrar;
	private JLabel lblFechaFuncion;
	private JLabel lblHoraFuncion;
	private JTextField txtHoraFuncion;
	private JButton btnGrabar;
	private JComboBox<String> cboCine;
	private JComboBox<String> cboSala;
	private JComboBox<String> cboPelicula;
	private JDateChooser txtFechaFuncion;
	
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		tipoOperacion = INGRESAR;
		lblMensaje.setText("Ingresando Funcion");
		txtCodigo.setText(arregloFunciones.codigoCorrelativo() + ""); // Se genera el c�digo de la siguiente Funci�n
		limpiarEntradas();
		habilitarEntradas(true);
		habilitarBotones(false);
		cboCine.requestFocus();
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarFuncion();
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Funcion");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Funcion");
		txtCodigo.setEditable(true);
		habilitarEntradas(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Funcion");
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
		lblMensaje.setText("Seleccione una acci�n");
	}
	
	// Procesa la pulsaci�n del bot�n Aceptar
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		switch (tipoOperacion) {
			case INGRESAR:
				ingresarFuncion();
				break;
				
			case CONSULTAR:
				consultarFuncion();
				break;
				
			case MODIFICAR:
				modificarFuncion();
				break;
				
			case ELIMINAR:
				eliminarFuncion();
				break;
		}
	}
	
	// Lista las funciones en la tabla
	void listar() {
		modelo.setRowCount(0);
		Funcion funcion = null;
		for (int i = 0; i < arregloFunciones.tama�o(); i++) {
			funcion = arregloFunciones.obtener(i);
			String nombreCine = arregloCines.buscar(funcion.getCodigoCine()).getNombre();
			int numeroSala = arregloSalas.buscar(funcion.getCodigoSala()).getNumeroSala();
			String nombrePelicula = arregloPeliculas.buscar(funcion.getCodigoPelicula()).getTituloDistribucion();
			Object[] fila = {
					funcion.getCodigo(),
					nombreCine,
					numeroSala,
					nombrePelicula,
					funcion.getFechaFuncion(),
					funcion.getHoraFuncion()
					};
			modelo.addRow(fila);
		}
	}
	
	void ingresarFuncion() {
		int codigo = leerCodigo();
		int codigoCine = leerCodigoCine();
		try {
			int codigoSala = leerCodigoSala();
			int codigoPelicula = leerCodigoPelicula();
			String fechaFuncion = leerFechaFuncion();
			if (fechaFuncion.length() > 0) {
				String horaFuncion = leerHoraFuncion();
				if (horaFuncion.length() > 0) {
					// Datos correctos
					Funcion funcion = new Funcion(codigo, codigoCine, codigoSala, codigoPelicula, fechaFuncion, horaFuncion);
					arregloFunciones.adicionar(funcion);
					listar();
					txtCodigo.setText("" + arregloFunciones.codigoCorrelativo());
					limpiarEntradas();
					cboCine.requestFocus();
					mensaje("Registro exitoso");
					cambios = true; // Variable que permite saber si se realizaron cambios en el ArrayList
					
				} else {
					mensaje("Ingrese Hora de la funci�n correcta");
					txtHoraFuncion.setText("");
					txtHoraFuncion.requestFocus();
				}
			} else {
				mensaje("Ingrese Fecha de la funci�n correcta");
				txtFechaFuncion.setDate(null);
				txtFechaFuncion.requestFocus();
			}
		} catch (Exception e) {
			mensaje("A�n no se han creado salas en el cine: " + cboCine.getSelectedItem().toString() + ". Elija otro cine");
			cboCine.setSelectedIndex(0);
			cboCine.requestFocus();
		}
	}
	
	void consultarFuncion() {
		try {
			Funcion funcion = arregloFunciones.buscar(leerCodigo());
			if (funcion != null) {
				cboCine.setSelectedItem(arregloCines.buscar(funcion.getCodigoCine()).getNombre());
				cboSala.setSelectedItem(arregloSalas.buscar(funcion.getCodigoSala()).getNumeroSala());
				cboPelicula.setSelectedItem(arregloPeliculas.buscar(funcion.getCodigoPelicula()).getTituloDistribucion());
				txtFechaFuncion.setDate(LibreriaFechas.stringToDate(funcion.getFechaFuncion()));
				txtHoraFuncion.setText(funcion.getHoraFuncion());
				
			} else {
				mensaje("El c�digo " + leerCodigo() + " no existe");
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		} catch (Exception e) {
			mensaje("Ingrese C�DIGO correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	
	void modificarFuncion() {
		try {
			Funcion funcion = arregloFunciones.buscar(leerCodigo());
			int codigoCine = leerCodigoCine();
			int codigoSala = leerCodigoSala();
			int codigoPelicula = leerCodigoPelicula();
			String fechaFuncion = leerFechaFuncion();
			if (fechaFuncion.length() > 0) {
				String horaFuncion = leerHoraFuncion();
				if (horaFuncion.length() > 0) {
					// Datos correctos
					int respuesta = confirmar("�Seguro que desea modificar los datos del funcion seleccionado?",
							"Seleccionar una opci�n");
							
					if (respuesta == JOptionPane.YES_OPTION) {
						funcion.setCodigoCine(codigoCine);
						funcion.setCodigoSala(codigoSala);
						funcion.setCodigoPelicula(codigoPelicula);
						funcion.setFechaFuncion(fechaFuncion);
						funcion.setHoraFuncion(horaFuncion);
						listar();
						txtCodigo.requestFocus();								
						mensaje("Modificaci�n exitosa");
						cambios = true; // Variable que permite saber si se realizaron cambios en el ArrayList
						
					}
				} else {
					mensaje("Ingrese Hora correcta de la funci�n ");
					txtHoraFuncion.setText("");
					txtHoraFuncion.requestFocus();
				}
			} else {
				mensaje("Ingrese Fecha correcta para la Funci�n");
				txtFechaFuncion.setDate(null);
				txtFechaFuncion.requestFocus();
			}
		} catch (Exception e) {
			mensaje("Ingrese C�DIGO correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	
	void eliminarFuncion() {
		try {
			Funcion funcion = arregloFunciones.buscar(leerCodigo());
			if (funcion != null) {
				int respuesta = confirmar("�Seguro que desea eliminar al funcion seleccionado?",
						"Seleccionar una opci�n");
						
				if (respuesta == JOptionPane.YES_OPTION) {
					arregloFunciones.eliminar(funcion);
					listar();
					txtCodigo.setText("");
					limpiarEntradas();
					txtCodigo.requestFocus();
					mensaje("Eliminaci�n exitosa");
					cambios = true; // Variable que permite saber si se realizaron cambios en el ArrayList
					
				}
			} else {
				mensaje("El c�digo " + leerCodigo() + " no existe");
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		} catch (Exception e) {
			mensaje("ingrese C�digo correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	
	// Limpia los cuadros de texto
	void limpiarEntradas() {
		
		/* NOTA: De la lista de cines del combobox, puede darse el caso de que algunos cines no tengan salas.
		 * Cada vez que se realice la limpieza de los inputs y adem�s el reseteo de los JCombobox,
		 * por defecto, no se debe seleccionar el Cine de �ndice 0 (c�mo se har�a normalmente en otros casos) ya que
		 * si el primer Cine del Jcombobox no tiene Salas, ocurrir�a un error con la siguiente l�nea de c�digo:
		 * 			cboSala.setSelectedIndex(0);
		 * debido a que se estar�a suponiendo que el primer cine del JCombobox tiene al menos una sala.
		 * Para evitar dicho error, hay que determinar mediante un algoritmo cu�l es el �ndice del primer cine del Jcombobox
		 * que cumpla con la condici�n de que debe tener al menos una sala.
		 */
		
		//int indice = determinarPrimerCineConAlMenosUnaSala();
		cboCine.setSelectedIndex(0); // Se selecciona el primer Cine de la lista que tiene al menos una sala
		cboSala.setSelectedIndex(0); // Se selecciona por defecto la primera sala de la lista de salas
		cboPelicula.setSelectedIndex(0);
		txtFechaFuncion.setDate(LibreriaFechas.fechaActual()); // Por defecto es la fecha actual
		txtHoraFuncion.setText("");
	}
	
	// Habilita los cuadros de texto y combobox para ingresar/seleccionar datos
	void habilitarEntradas(boolean valor) {		
		cboCine.setEnabled(valor);
		cboSala.setEnabled(valor);
		cboPelicula.setEnabled(valor);
		txtFechaFuncion.setEnabled(valor);
		txtHoraFuncion.setEditable(valor);
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
	
	// M�todo que muestra un mensaje
	void mensaje(String cadena) {
		JOptionPane.showMessageDialog(this, cadena);
	}
	
	// M�todo sobrecargado que pide una confirmaci�n
	int confirmar(String mensaje, String tituloMensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje,
				tituloMensaje, JOptionPane.YES_NO_OPTION);
	}
	
	// M�todo sobrecargado que pide una confirmaci�n
	int confirmar(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje,
				"Seleccionar una opci�n", JOptionPane.YES_NO_OPTION);
	}
	
	// M�todos que retornan valor sin par�metros
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	int leerCodigoCine() {
		return arregloCines.obtenerCodigoCine(cboCine.getSelectedItem().toString());
	}
	
	// Retorna el c�digo de la sala cuyo n�mero de sala y c�digo de cine al que pertenece se le pasan como par�metros
	int leerCodigoSala() {
		return arregloSalas.obtenerCodigoSala(Integer.parseInt(cboSala.getSelectedItem().toString()), leerCodigoCine());
	}
	
	// Retorna el c�digo de la pel�cula cuyo nombre se le pasa como par�metro
	int leerCodigoPelicula() {
		return arregloPeliculas.obtenerCodigoPelicula(cboPelicula.getSelectedItem().toString());
	}
	
	String leerFechaFuncion() {
		String fechaFuncion = LibreriaFechas.dateToString(txtFechaFuncion.getDate());
		return (fechaFuncion == null) ? "" : fechaFuncion;
	}
	
	String leerHoraFuncion() {
		return txtHoraFuncion.getText().trim();
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		if (cambios) {
			int respuesta = confirmar("�Desea guardar los cambios realizados en el archivo \"" + arregloPeliculas.getArchivo() + "\"?");
			if (respuesta == JOptionPane.YES_OPTION) {
				arregloFunciones.grabarFunciones();
				mensaje("\"" + arregloFunciones.getArchivo() + "\" ha sido actualizado");
				cambios = false; // Permite saber que ya se guardaron los cambios en el arraylist
			}
		}
		dispose();
	}
	
	protected void actionPerformedTxtFechaInicio(ActionEvent e) {
		
	}
	
	// Actualiza el archivo
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		if (arregloFunciones.existeArchivo()) {
			int respuesta = confirmar("�Seguro que desea actualizar \"" + arregloFunciones.getArchivo() + "\"?");
			if (respuesta == JOptionPane.YES_OPTION) {
				// Se guardan los cambios en los archivos correspondientes
				arregloFunciones.grabarFunciones();	
				mensaje("\"" + arregloFunciones.getArchivo() + "\" ha sido actualizado");
				cambios = false; // Permite saber que ya se guardaron los cambios en el arraylist
				
			} else {
				mensaje("No se actualiz� \"" + arregloFunciones.getArchivo() + "\"");
			}
		} else {
			// Si no existe el archivo es creado
			arregloFunciones.grabarFunciones();
			mensaje("\"" + arregloFunciones.getArchivo() + "\" ha sido creado");
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboPelicula) {
			itemStateChangedCboPelicula(e);
		}
		if (e.getSource() == cboSala) {
			itemStateChangedCboSala(e);
		}
		if (e.getSource() == cboCine) {
			itemStateChangedCboCine(e);
		}
	}
	
	// Al seleccionar
	protected void itemStateChangedCboCine(ItemEvent e) {
		cargarSalasExistentes(leerCodigoCine());
	}
	
	protected void itemStateChangedCboSala(ItemEvent e) {
	}
	
	protected void itemStateChangedCboPelicula(ItemEvent e) {
	}
	protected void actionPerformedCboCine(ActionEvent e) {
	}
	protected void actionPerformedCboSala(ActionEvent e) {
	}
	protected void actionPerformedCboPelicula(ActionEvent e) {
	}
	
	// Llena el combobox con los Cines que tienen al menos una sala
	public void cargarCinesExistentes() {
		for (int i = 0; i < arregloCines.tama�o(); i++) {
			Cine cine = arregloCines.obtener(i);
			for (int j = 0; j < arregloSalas.tama�o(); j++) {
				Sala sala = arregloSalas.obtener(j);
				if (sala.getCodigoCine() == cine.getCodigo()) {
					// Significa que el cine actual al menos contiene una sala
					cboCine.addItem(arregloCines.obtener(i).getNombre());
					break;
				}
			}
		}
	}
	
	// Llena el combobox con las salas que pertenecen al cine cuyo c�digo se le pasa como argumento
	public void cargarSalasExistentes(int codigoCine) {
		cboSala.removeAllItems();
		for (int i = 0; i < arregloSalas.tama�o(); i++) {
			Sala sala = arregloSalas.obtener(i);
			if (sala.getCodigoCine() == codigoCine) {
				cboSala.addItem(sala.getNumeroSala() + "");
			}
		}
	}
	
	// Llena el combobox con las Pel�culas existentes
	public void cargarPeliculasExistentes() {
		for (int i = 0; i < arregloPeliculas.tama�o(); i++) {
			cboPelicula.addItem(arregloPeliculas.obtener(i).getTituloDistribucion());
		}
	}
}
