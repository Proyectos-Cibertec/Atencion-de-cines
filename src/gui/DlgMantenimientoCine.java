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
import clases.Cine;
import clases.Sala;
import libreria.LibreriaFechas;

import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
public class DlgMantenimientoCine extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMensaje;
	private JLabel lbloCdigo;
	private JLabel lblNombres;
	private JLabel lblDepartamento;
	private JLabel lblProvincia;
	private JLabel lblTipoCine;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDepartamento;
	private JTextField txtProvincia;
	private JComboBox<String> cboTipoCine;
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
					DlgMantenimientoCine dialog = new DlgMantenimientoCine();
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
	public DlgMantenimientoCine() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		setTitle("Mantenimiento | Cine");
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
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(27, 87, 46, 14);
		getContentPane().add(lblNombres);
		
		lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(27, 112, 78, 14);
		getContentPane().add(lblDepartamento);
		
		lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(27, 137, 80, 14);
		getContentPane().add(lblProvincia);
		
		lblTipoCine = new JLabel("Tipo de cine");
		lblTipoCine.setBounds(27, 213, 57, 14);
		getContentPane().add(lblTipoCine);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(158, 55, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.addActionListener(this);
		
		txtNombre = new JTextField();
		txtNombre.addActionListener(this);
		txtNombre.setEditable(false);
		txtNombre.setBounds(158, 84, 230, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDepartamento = new JTextField();
		txtDepartamento.addActionListener(this);
		txtDepartamento.setEditable(false);
		txtDepartamento.setBounds(158, 109, 290, 20);
		getContentPane().add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		txtProvincia = new JTextField();
		txtProvincia.addActionListener(this);
		txtProvincia.setEditable(false);
		txtProvincia.setBounds(158, 134, 290, 20);
		getContentPane().add(txtProvincia);
		txtProvincia.setColumns(10);
		
		cboTipoCine = new JComboBox<String>();
		cboTipoCine.addActionListener(this);
		cboTipoCine.setEnabled(false);
		cboTipoCine.setModel(new DefaultComboBoxModel<String>(new String[] {"Est\u00E1ndar", "Prime"}));
		cboTipoCine.setBounds(158, 210, 133, 20);
		getContentPane().add(cboTipoCine);
		
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
		btnIngresar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnIngresar.png")));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(533, 54, 120, 36);
		getContentPane().add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnModificar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(533, 101, 120, 36);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnEliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(663, 101, 120, 36);
		getContentPane().add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/itemConsultarPapel.png")));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(663, 55, 120, 35);
		getContentPane().add(btnConsultar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnAceptar.png")));
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(533, 151, 120, 36);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnVolver.png")));
		btnVolver.setEnabled(false);
		btnVolver.addActionListener(this);
		btnVolver.setBounds(663, 151, 120, 36);
		getContentPane().add(btnVolver);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Departamento");
		modelo.addColumn("Provincia");
		modelo.addColumn("Distrito");
		modelo.addColumn("Fecha de inicio");
		modelo.addColumn("Tipo de cine");
		tblTabla.setModel(modelo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnCancelar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(663, 210, 120, 38);
		getContentPane().add(btnCerrar);
		
		lblDistrito = new JLabel("Distrito");
		lblDistrito.setBounds(27, 162, 43, 14);
		getContentPane().add(lblDistrito);
		
		txtDistrito = new JTextField();
		txtDistrito.addActionListener(this);
		txtDistrito.setEditable(false);
		txtDistrito.setBounds(158, 159, 290, 20);
		getContentPane().add(txtDistrito);
		txtDistrito.setColumns(10);
		
		lblFechaInicio = new JLabel("Fecha de inicio");
		lblFechaInicio.setBounds(27, 188, 98, 14);
		getContentPane().add(lblFechaInicio);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(DlgMantenimientoCine.class.getResource("/img/btnGrabar.png")));
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(533, 210, 120, 38);
		getContentPane().add(btnGrabar);
		
		txtFechaInicio = new JDateChooser();
		txtFechaInicio.setDateFormatString("dd/MM/yyyy");
		txtFechaInicio.setEnabled(false);
		txtFechaInicio.setBounds(158, 184, 133, 20);
		getContentPane().add(txtFechaInicio);
		
		listar();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == txtDistrito) {
			actionPerformedTxtDistrito(e);
		}
		if (e.getSource() == cboTipoCine) {
			actionPerformedCboTipoCine(e);
		}
		if (e.getSource() == txtProvincia) {
			actionPerformedTxtProvincia(e);
		}
		if (e.getSource() == txtDepartamento) {
			actionPerformedTxtDepartamento(e);
		}
		if (e.getSource() == txtNombre) {
			actionPerformedTxtNombre(e);
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
	ArregloCines arregloCines = new ArregloCines("cines.txt");
	ArregloSalas arregloSalas = new ArregloSalas("salas.txt");
	ArregloButacas arregloButacas = new ArregloButacas("butacas.txt");
	ArregloFunciones arregloFunciones = new ArregloFunciones("funciones.txt");
	
	boolean cambios = false; // Permite saber si se hicieron cambios que necesitan guardarse
	
	private JButton btnCerrar;
	private JLabel lblDistrito;
	private JTextField txtDistrito;
	private JLabel lblFechaInicio;
	private JButton btnGrabar;
	private JDateChooser txtFechaInicio;
	
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		tipoOperacion = INGRESAR;
		lblMensaje.setText("Ingresando Cine");
		txtCodigo.setText(arregloCines.codigoCorrelativo() + ""); // Se genera el código del siguiente Cine
		limpiarEntradas();
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombre.requestFocus();
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarCine();
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Cine");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Cine");
		txtCodigo.setEditable(true);
		habilitarEntradas(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Cine");
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
				ingresarCine();
				break;
				
			case CONSULTAR:
				consultarCine();
				break;
				
			case MODIFICAR:
				modificarCine();
				break;
				
			case ELIMINAR:
				eliminarCine();
				break;
		}
	}
	
	// Lista los cines en la tabla
	void listar() {
		modelo.setRowCount(0);
		Cine cine = null;
		for (int i = 0; i < arregloCines.tamaño(); i++) {
			cine = arregloCines.obtener(i);
			Object[] fila = {
					cine.getCodigo(),
					cine.getNombre(),
					cine.getDepartamento(),
					cine.getProvincia(),
					cine.getDistrito(),
					cine.getFechaInicio(),
					cine.descripcionTipoCine()
					};
			modelo.addRow(fila);
		}
	}
	
	void ingresarCine() {
		int codigo = leerCodigo();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			if (!nombreCineEsRepetido(nombre)) {
				String departamento = leerDepartamento();
				if (departamento.length() > 0) {
					String provincia = leerProvincia();
					if (provincia.length() > 0) {
						String distrito = leerDistrito();
						if (distrito.length() > 0) {
							String fechaInicio = leerFechaInicio();
							if (fechaInicio.length() > 0) {
								int tipoCine = leerTipoCine();
								// Datos correctos
								
								Cine cine = new Cine(codigo, nombre, departamento, provincia, distrito, fechaInicio, tipoCine);
								arregloCines.adicionar(cine);
								listar();
								txtCodigo.setText("" + arregloCines.codigoCorrelativo());
								limpiarEntradas();
								txtNombre.requestFocus();
								mensaje("Registro exitoso");
								cambios = true; // Variable que permite saber si se realizaron cambios en el ArrayList
								
							} else {
								mensaje("Ingrese Fecha de Inicio correcta");
								txtFechaInicio.setDate(null);
								txtFechaInicio.requestFocus();
							}
						} else {
							mensaje("Ingrese Distrito correcto");
							txtDistrito.setText("");
							txtDistrito.requestFocus();
						}
					} else {
						mensaje("Ingrese Orovincia correcta");
						txtProvincia.setText("");
						txtProvincia.requestFocus();
					}
				} else {
					mensaje("Ingrese Departamento correcto");
					txtDepartamento.setText("");
					txtDepartamento.requestFocus();
				}
			} else {
				mensaje("Ya existe un cine con el nombre: " + nombre + ". Ingrese un nombre diferente");
				txtNombre.setText("");
				txtNombre.requestFocus();
			}
		} else {
			mensaje("Ingrese Nombre correctos");
			txtNombre.setText("");
			txtNombre.requestFocus();
		}
	}
	
	void consultarCine() {
		try {
			Cine cine = arregloCines.buscar(leerCodigo());
			if (cine != null) {
				txtNombre.setText(cine.getNombre());
				txtDepartamento.setText(cine.getDepartamento());
				txtProvincia.setText(cine.getProvincia());
				txtDistrito.setText(cine.getDistrito());
				txtFechaInicio.setDate(LibreriaFechas.stringToDate(cine.getFechaInicio()));
				cboTipoCine.setSelectedIndex(cine.getTipo());
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
	
	void modificarCine() {
		try {
			Cine cine = arregloCines.buscar(leerCodigo());
			String nombre = leerNombre();
			
			if (nombre.length() > 0) {
				if (!nombreCineEsRepetido(nombre)) {
					String departamento = leerDepartamento();
					if (departamento.length() > 0) {
						String provincia = leerProvincia();
						if (provincia.length() > 0) {
							String distrito = leerDistrito();
							if (distrito.length() > 0) {
								String fechaInicio = leerFechaInicio();
								if (fechaInicio.length() > 0) {
									int tipoCine = leerTipoCine();
									// Datos correctos
									int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar los datos del cine seleccionado?",
											"Seleccionar una opción", JOptionPane.YES_NO_OPTION);
											
									if (respuesta == JOptionPane.YES_OPTION) {
										cine.setNombre(nombre);
										cine.setDepartamento(departamento);
										cine.setProvincia(provincia);
										cine.setDistrito(distrito);
										cine.setFechaInicio(fechaInicio);
										cine.setTipo(tipoCine);
										listar();
										txtCodigo.requestFocus();								
										mensaje("Modificación exitosa");
										cambios = true; // Variable que permite saber si se realizaron cambios en el Arraylist 
									}								
								} else {
									mensaje("Ingrese Fecha de Inicio correcta");
									txtFechaInicio.setDate(null);
									txtFechaInicio.requestFocus();
								}
							} else {
								mensaje("Ingrese Distrito correcto");
								txtDistrito.setText("");
								txtDistrito.requestFocus();
							}
						} else {
							mensaje("Ingrese Provincia correcta");
							txtProvincia.setText("");
							txtProvincia.requestFocus();
						}
					} else {
						mensaje("Ingrese Departamento correcto");
						txtDepartamento.setText("");
						txtDepartamento.requestFocus();
					}
				} else {
					mensaje("Ya existe un cine con el nombre: " + nombre + ". Ingrese un nombre diferente");
					txtNombre.setText("");
					txtNombre.requestFocus();
				}
			} else {
				mensaje("Ingrese Nombre correctos");
				txtNombre.setText("");
				txtNombre.requestFocus();
			}
		} catch (Exception e) {
			mensaje("Ingrese CÓDIGO correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	
	void eliminarCine() {
		try {
			Cine cine = arregloCines.buscar(leerCodigo());
			if (cine != null) {
				int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar al cine seleccionado?",
						"Seleccionar una opción", JOptionPane.YES_NO_OPTION);
						
				if (respuesta == JOptionPane.YES_OPTION) {
					arregloFunciones.eliminarFuncionesDeCine(cine.getCodigo());
					eliminarSalas(cine.getCodigo()); // Se eliminan las salas pertenecientes al cine que se va a eliminar
					arregloCines.eliminar(cine);
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
			mensaje("ingrese Código correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	
	// Limpia los cuadros de texto
	void limpiarEntradas() {
		txtNombre.setText("");
		txtDepartamento.setText("");
		txtProvincia.setText("");
		txtDistrito.setText("");
		txtFechaInicio.setDate(LibreriaFechas.fechaActual()); // Por defecto es la fecha actual
		cboTipoCine.setSelectedIndex(0);
	}
	
	// Habilita los cuadros de texto y combobox para ingresar/seleccionar datos
	void habilitarEntradas(boolean valor) {		
		txtNombre.setEditable(valor);
		txtDepartamento.setEditable(valor);
		txtProvincia.setEditable(valor);
		txtDistrito.setEditable(valor);
		txtFechaInicio.setEnabled(valor);
		cboTipoCine.setEnabled(valor);
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
	
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	
	String leerDepartamento() {
		return txtDepartamento.getText().trim();
	}
	
	String leerProvincia() {
		return txtProvincia.getText().trim();
	}
	
	String leerDistrito() {
		return txtDistrito.getText().trim();
	}
	
	String leerFechaInicio() {
		String fechaInicio = LibreriaFechas.dateToString(txtFechaInicio.getDate());
		return (fechaInicio == null) ? "" : fechaInicio;
	}
	
	int leerTipoCine() {
		return cboTipoCine.getSelectedIndex();
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		if (cambios) {
			int respuesta = confirmar("¿Desea guardar los cambios realizados en el archivo \"" + arregloCines.getArchivo() + "\"?");
			if (respuesta == JOptionPane.YES_OPTION) {
				arregloCines.grabarCines();
				arregloSalas.grabarSalas();
				arregloButacas.grabarButacas();
				arregloFunciones.grabarFunciones();
				mensaje("\"" + arregloCines.getArchivo() + "\" ha sido actualizado");
				cambios = false; // Permite saber que ya se guardaron los cambios en el arraylist
			}
		}
		dispose();
	}
	
	protected void actionPerformedTxtNombre(ActionEvent e) {
		txtDepartamento.requestFocus();
	}
	
	protected void actionPerformedTxtDepartamento(ActionEvent e) {
		txtProvincia.requestFocus();
	}
	
	protected void actionPerformedTxtProvincia(ActionEvent e) {
		txtDistrito.requestFocus();
	}
	
	protected void actionPerformedTxtDistrito(ActionEvent e) {
		txtFechaInicio.requestFocus();
	}
	
	protected void actionPerformedCboTipoCine(ActionEvent e) {
		btnAceptar.requestFocus();
	}
	
	// Actualiza el archivo
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		if (arregloCines.existeArchivo()) {
			int respuesta = confirmar("¿Seguro que desea actualizar \"" + arregloCines.getArchivo() + "\"?");
			if (respuesta == JOptionPane.YES_OPTION) {
				// Se guardan los cambios en los archivos correspondientes
				arregloCines.grabarCines();
				arregloSalas.grabarSalas();
				arregloButacas.grabarButacas();
				arregloFunciones.grabarFunciones();
				mensaje("\"" + arregloCines.getArchivo() + "\" ha sido actualizado");
				cambios = false; // Permite saber que ya se guardaron los cambios en el arraylist
			} else {
				mensaje("No se actualizó \"" + arregloCines.getArchivo() + "\"");
			}
		} else {
			// Si no existe el archivo es creado y se guardan los cambios correspondientes
			arregloCines.grabarCines();
			arregloSalas.grabarSalas();
			arregloButacas.grabarButacas();
			arregloFunciones.grabarFunciones();
			mensaje("\"" + arregloCines.getArchivo() + "\" ha sido creado");
		}
	}
	
	// Elimina las salas para el cine cuyo código se le pasa como argumento
	public void eliminarSalas(int codigoCine) {
		
		// Primero se eliminan las butacas de las salas
		for (int i = 0; i < arregloSalas.tamaño(); i++) {
			Sala sala = arregloSalas.obtener(i);
			if (sala.getCodigoCine() == codigoCine) {
				
				// Se manda a eliminar sus butacas
				arregloButacas.eliminarButacasDeSala(sala.getCodigo());
			}
		}
		
		// Segundo, se proceden a eliminar las salas
		arregloSalas.eliminarSalasDeCine(codigoCine);
	}
	
	// Retorna true cuando el nombreCine ya existe en el arraylist de cines
	public boolean nombreCineEsRepetido(String nombreCine) {
		for (int i = 0; i < arregloCines.tamaño(); i++) {
			Cine cine = arregloCines.obtener(i);
			if (cine.getNombre().equalsIgnoreCase(nombreCine)) {
				return true;
			}
		}
		return false;
	}
}
