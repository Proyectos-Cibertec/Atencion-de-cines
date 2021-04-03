package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
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

import arreglos.ArregloCines;
import clases.Cine;

import javax.swing.DefaultComboBoxModel;
public class DlgMantenimientoCine extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMensaje;
	private JLabel lblCdigo;
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
		setModal(true);
		setResizable(false);
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
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(27, 58, 46, 14);
		getContentPane().add(lblCdigo);
		
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
		modelo.addColumn("C�digo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Departamento");
		modelo.addColumn("Provincia");
		modelo.addColumn("Distrito");
		modelo.addColumn("Fecha de inicio");
		modelo.addColumn("Tipo de cine");
		tblTabla.setModel(modelo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(708, 556, 89, 23);
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
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.addActionListener(this);
		txtFechaInicio.setEditable(false);
		txtFechaInicio.setBounds(158, 185, 133, 20);
		getContentPane().add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		listar();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtFechaInicio) {
			actionPerformedTxtFechaInicio(e);
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
	
	// Declaraci�n Global
	ArregloCines arregloCines = new ArregloCines();
	private JButton btnCerrar;
	private JLabel lblDistrito;
	private JTextField txtDistrito;
	private JLabel lblFechaInicio;
	private JTextField txtFechaInicio;
	
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		tipoOperacion = INGRESAR;
		lblMensaje.setText("Ingresando Cine");
		txtCodigo.setText(arregloCines.codigoCorrelativo() + ""); // Se genera el c�digo del siguiente Cine
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
		lblMensaje.setText("Seleccione una acci�n");
	}
	
	// Procesa la pulsaci�n del bot�n Aceptar
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
		for (int i = 0; i < arregloCines.tama�o(); i++) {
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
							
						} else {
							mensaje("Ingrese Fecha de Inicio correcta");
							txtFechaInicio.setText("");
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
				txtFechaInicio.setText(cine.getFechaInicio());
				cboTipoCine.setSelectedIndex(cine.getTipo());
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
	
	void modificarCine() {
		try {
			Cine cine = arregloCines.buscar(leerCodigo());
			String nombre = leerNombre();
			
			if (nombre.length() > 0) {
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
								int respuesta = JOptionPane.showConfirmDialog(this, "�Seguro que desea modificar los datos del cine seleccionado?",
										"Seleccionar una opci�n", JOptionPane.YES_NO_OPTION);
										
								if (respuesta == JOptionPane.YES_OPTION) {
									cine.setNombre(nombre);
									cine.setDepartamento(departamento);
									cine.setProvincia(provincia);
									cine.setDistrito(distrito);
									cine.setFechaInicio(fechaInicio);
									cine.setTipo(tipoCine);
									listar();
									txtCodigo.requestFocus();								
									mensaje("Modificaci�n exitosa");
								}								
							} else {
								mensaje("Ingrese Fecha de Inicio correcta");
								txtFechaInicio.setText("");
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
				mensaje("Ingrese Nombre correctos");
				txtNombre.setText("");
				txtNombre.requestFocus();
			}
		} catch (Exception e) {
			mensaje("Ingrese C�DIGO correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	
	void eliminarCine() {
		try {
			Cine cine = arregloCines.buscar(leerCodigo());
			if (cine != null) {
				int respuesta = JOptionPane.showConfirmDialog(this, "�Seguro que desea eliminar al cine seleccionado?",
						"Seleccionar una opci�n", JOptionPane.YES_NO_OPTION);
						
				if (respuesta == JOptionPane.YES_OPTION) {
					arregloCines.eliminar(cine);
					listar();
					txtCodigo.setText("");
					limpiarEntradas();
					txtCodigo.requestFocus();
					mensaje("Eliminaci�n exitosa");
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
		txtNombre.setText("");
		txtDepartamento.setText("");
		txtProvincia.setText("");
		txtDistrito.setText("");
		txtFechaInicio.setText("");
		cboTipoCine.setSelectedIndex(0);
	}
	
	// Habilita los cuadros de texto y combobox para ingresar/seleccionar datos
	void habilitarEntradas(boolean valor) {		
		txtNombre.setEditable(valor);
		txtDepartamento.setEditable(valor);
		txtProvincia.setEditable(valor);
		txtDistrito.setEditable(valor);
		txtFechaInicio.setEditable(valor);
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
	
	// M�todo que muestra un mensaje
	void mensaje(String cadena) {
		JOptionPane.showMessageDialog(this, cadena);
	}
	
	// M�todos que retornan valor sin par�metros
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
		return txtFechaInicio.getText().trim();
	}
	
	int leerTipoCine() {
		return cboTipoCine.getSelectedIndex();
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
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
	
	protected void actionPerformedTxtFechaInicio(ActionEvent e) {
		cboTipoCine.requestFocus();
	}
	
	protected void actionPerformedCboTipoCine(ActionEvent e) {
		btnAceptar.requestFocus();
	}
}
