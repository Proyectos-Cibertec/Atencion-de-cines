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

import arreglos.ArregloEmpleados;
import clases.Empleado;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
public class DlgMantenimientoEmpleado extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMensaje;
	private JLabel lblCdigo;
	private JLabel lblNombres;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JLabel lblTipo;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidoPaterno;
	private JTextField txtApellidoMaterno;
	private JComboBox<String> cboTipo;
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
					DlgMantenimientoEmpleado dialog = new DlgMantenimientoEmpleado();
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
	public DlgMantenimientoEmpleado() {
		setModal(true);
		setResizable(false);
		setTitle("Mantenimiento | Empleado");
		setBounds(100, 100, 832, 624);
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
		lblNombres.setBounds(27, 83, 46, 14);
		getContentPane().add(lblNombres);
		
		lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setBounds(27, 108, 78, 14);
		getContentPane().add(lblApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setBounds(27, 133, 80, 14);
		getContentPane().add(lblApellidoMaterno);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(27, 158, 46, 14);
		getContentPane().add(lblTipo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(129, 55, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.addActionListener(this);
		
		txtNombres = new JTextField();
		txtNombres.addActionListener(this);
		txtNombres.setEditable(false);
		txtNombres.setBounds(129, 80, 184, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidoPaterno = new JTextField();
		txtApellidoPaterno.addActionListener(this);
		txtApellidoPaterno.setEditable(false);
		txtApellidoPaterno.setBounds(129, 105, 242, 20);
		getContentPane().add(txtApellidoPaterno);
		txtApellidoPaterno.setColumns(10);
		
		txtApellidoMaterno = new JTextField();
		txtApellidoMaterno.addActionListener(this);
		txtApellidoMaterno.setEditable(false);
		txtApellidoMaterno.setBounds(129, 130, 242, 20);
		getContentPane().add(txtApellidoMaterno);
		txtApellidoMaterno.setColumns(10);
		
		cboTipo = new JComboBox<String>();
		cboTipo.addActionListener(this);
		cboTipo.setEnabled(false);
		cboTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrador", "Supervisor", "Cajero"}));
		cboTipo.setBounds(129, 155, 184, 20);
		getContentPane().add(cboTipo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(225, 54, 89, 23);
		getContentPane().add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 257, 770, 280);
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
		btnAceptar.setBounds(677, 180, 120, 23);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setEnabled(false);
		btnVolver.addActionListener(this);
		btnVolver.setBounds(677, 205, 120, 23);
		getContentPane().add(btnVolver);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("C�digo");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellido Paterno");
		modelo.addColumn("Apellido Materno");
		modelo.addColumn("Tipo");
		modelo.addColumn("Usuario");
		modelo.addColumn("Contrase�a");
		tblTabla.setModel(modelo);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(27, 183, 46, 14);
		getContentPane().add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(27, 208, 56, 14);
		getContentPane().add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.addActionListener(this);
		txtUsuario.setEditable(false);
		txtUsuario.setBounds(129, 180, 184, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrase�a = new JPasswordField();
		txtContrase�a.addActionListener(this);
		txtContrase�a.setEditable(false);
		txtContrase�a.setBounds(129, 205, 184, 20);
		getContentPane().add(txtContrase�a);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(708, 548, 89, 23);
		getContentPane().add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(609, 548, 89, 23);
		getContentPane().add(btnGrabar);
		
		listar();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == txtContrase�a) {
			actionPerformedTxtContrase�a(e);
		}
		if (e.getSource() == txtUsuario) {
			actionPerformedTxtUsuario(e);
		}
		if (e.getSource() == cboTipo) {
			actionPerformedCboTipo(e);
		}
		if (e.getSource() == txtApellidoMaterno) {
			actionPerformedTxtApellidoMaterno(e);
		}
		if (e.getSource() == txtApellidoPaterno) {
			actionPerformedTxtApellidoPaterno(e);
		}
		if (e.getSource() == txtNombres) {
			actionPerformedTxtNombres(e);
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
	ArregloEmpleados arregloEmpleados = new ArregloEmpleados("empleados.txt");
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JPasswordField txtContrase�a;
	private JButton btnCerrar;
	private JButton btnGrabar;
	
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		tipoOperacion = INGRESAR;
		lblMensaje.setText("Ingresando Empleado");
		txtCodigo.setText(arregloEmpleados.codigoCorrelativo() + ""); // Se genera el c�digo del siguiente empleado
		limpiarEntradas();
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombres.requestFocus();
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarEmpleado();
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Empleado");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Empleado");
		txtCodigo.setEditable(true);
		habilitarEntradas(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Empleado");
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
				ingresarEmpleado();
				break;
				
			case CONSULTAR:
				consultarEmpleado();
				break;
				
			case MODIFICAR:
				modificarEmpleado();
				break;
				
			case ELIMINAR:
				eliminarEmpleado();
				break;
		}
	}
	
	// Lista los empleados en la tabla
	void listar() {
		modelo.setRowCount(0);
		Empleado empleado = null;
		for (int i = 0; i < arregloEmpleados.tama�o(); i++) {
			empleado = arregloEmpleados.obtener(i);
			Object[] fila = {
					empleado.getCodigo(),
					empleado.getNombres(),
					empleado.getApellidoPaterno(),
					empleado.getApellidoMaterno(),
					empleado.nombreTipoEmpleado(),
					empleado.getUsuario(),
					empleado.getContrase�a()};
			modelo.addRow(fila);
		}
	}
	
	void ingresarEmpleado() {
		int codigo = leerCodigo();
		String nombres = leerNombres();
		if (nombres.length() > 0) {
			String apellidoPaterno = leerApellidoPaterno();
			if (apellidoPaterno.length() > 0) {
				String apellidoMaterno = leerApellidoMaterno();
				if (apellidoMaterno.length() > 0) {
					int tipo = leerTipo();
					String usuario = leerUsuario();
					if (usuario.length() > 0) {
						String contrase�a = leerContrase�a();
						if (contrase�a.length() > 0) {
							// Datos correctos
							Empleado empleado = new Empleado(codigo, nombres, apellidoPaterno, apellidoMaterno, tipo, usuario, contrase�a);
							arregloEmpleados.adicionar(empleado);
							listar();
							txtCodigo.setText("" + arregloEmpleados.codigoCorrelativo());
							limpiarEntradas();
							txtNombres.requestFocus();
							mensaje("Registro exitoso");
							
						} else {
							mensaje("Ingrese Contrase�a correcta");
							txtContrase�a.setText("");
							txtContrase�a.requestFocus();
						}
					} else {
						mensaje("Ingrese Usuario correcto");
						txtUsuario.setText("");
						txtUsuario.requestFocus();
					}
				} else {
					mensaje("Ingrese Apelido Materno correcto");
					txtApellidoMaterno.setText("");
					txtApellidoMaterno.requestFocus();
				}
			} else {
				mensaje("Ingrese Apellido Paterno correcto");
				txtApellidoPaterno.setText("");
				txtApellidoPaterno.requestFocus();
			}
		} else {
			mensaje("Ingrese Nombres correctos");
			txtNombres.setText("");
			txtNombres.requestFocus();
		}
	}
	
	void consultarEmpleado() {
		try {
			Empleado empleado = arregloEmpleados.buscar(leerCodigo());
			if (empleado != null) {
				txtNombres.setText(empleado.getNombres());
				txtApellidoPaterno.setText(empleado.getApellidoPaterno());
				txtApellidoMaterno.setText(empleado.getApellidoMaterno());
				cboTipo.setSelectedIndex(empleado.getTipo());
				txtUsuario.setText(empleado.getUsuario());
				txtContrase�a.setText(empleado.getContrase�a());
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
	
	void modificarEmpleado() {
		try {
			Empleado empleado = arregloEmpleados.buscar(leerCodigo());
			String nombres = leerNombres();
			if (nombres.length() > 0) {
				String apellidoPaterno = leerApellidoPaterno();
				if (apellidoPaterno.length() > 0) {
					String apellidoMaterno = leerApellidoMaterno();
					if (apellidoMaterno.length() > 0) {
						int tipo = leerTipo();
						String usuario = leerUsuario();
						if (usuario.length() > 0) {
							String contrase�a = leerContrase�a();
							if (contrase�a.length() > 0) {
								// Datos correctos
								int respuesta = JOptionPane.showConfirmDialog(this, "�Seguro que desea modificar los datos del empleado seleccionado?",
										"Seleccionar una opci�n", JOptionPane.YES_NO_OPTION);
										
								if (respuesta == JOptionPane.YES_OPTION) {
									empleado.setNombres(nombres);
									empleado.setApellidoPaterno(apellidoPaterno);
									empleado.setApellidoMaterno(apellidoMaterno);
									empleado.setTipo(tipo);
									empleado.setUsuario(usuario);
									empleado.setContrase�a(contrase�a);
									listar();
									txtCodigo.requestFocus();								
									mensaje("Modificaci�n exitosa");
								}
							} else {
								mensaje("Ingrese Contrase�a correcta");
								txtContrase�a.setText("");
								txtContrase�a.requestFocus();
							}
						} else {
							mensaje("Ingrese Usuario correcto");
							txtUsuario.setText("");
							txtUsuario.requestFocus();
						}
					} else {
						mensaje("Ingrese Apelido Materno correcto");
						txtApellidoMaterno.setText("");
						txtApellidoMaterno.requestFocus();
					}
				} else {
					mensaje("Ingrese Apellido Paterno correcto");
					txtApellidoPaterno.setText("");
					txtApellidoPaterno.requestFocus();
				}
			} else {
				mensaje("Ingrese NOMBRES correctos");
				txtNombres.setText("");
				txtNombres.requestFocus();
			}
		} catch (Exception e) {
			mensaje("Ingrese C�DIGO correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	
	void eliminarEmpleado() {
		try {
			Empleado empleado = arregloEmpleados.buscar(leerCodigo());
			if (empleado != null) {
				int respuesta = JOptionPane.showConfirmDialog(this, "�Seguro que desea eliminar al empleado seleccionado?",
						"Seleccionar una opci�n", JOptionPane.YES_NO_OPTION);
						
				if (respuesta == JOptionPane.YES_OPTION) {
					arregloEmpleados.eliminar(empleado);
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
		txtNombres.setText("");
		txtApellidoPaterno.setText("");
		txtApellidoMaterno.setText("");
		cboTipo.setSelectedIndex(0);
		txtUsuario.setText("");
		txtContrase�a.setText("");
	}
	
	// Habilita los cuadros de texto y combobox para ingresar/seleccionar datos
	void habilitarEntradas(boolean valor) {		
		txtNombres.setEditable(valor);
		txtApellidoPaterno.setEditable(valor);
		txtApellidoMaterno.setEditable(valor);
		cboTipo.setEnabled(valor);
		txtUsuario.setEditable(valor);
		txtContrase�a.setEditable(valor);
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
	
	String leerNombres() {
		return txtNombres.getText().trim();
	}
	
	String leerApellidoPaterno() {
		return txtApellidoPaterno.getText().trim();
	}
	
	String leerApellidoMaterno() {
		return txtApellidoMaterno.getText().trim();
	}
	
	int leerTipo() {
		return cboTipo.getSelectedIndex();
	}
	
	String leerUsuario() {
		return txtUsuario.getText().trim();
	}
	
	String leerContrase�a() {
		return new String(txtContrase�a.getPassword());
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedTxtNombres(ActionEvent e) {
		txtApellidoPaterno.requestFocus();
	}
	
	protected void actionPerformedTxtApellidoPaterno(ActionEvent e) {
		txtApellidoMaterno.requestFocus();
	}
	
	protected void actionPerformedTxtApellidoMaterno(ActionEvent e) {
		cboTipo.requestFocus();
	}
	
	protected void actionPerformedCboTipo(ActionEvent e) {
		txtUsuario.requestFocus();
	}
	
	protected void actionPerformedTxtUsuario(ActionEvent e) {
		txtContrase�a.requestFocus();
	}
	
	protected void actionPerformedTxtContrase�a(ActionEvent e) {
		btnAceptar.requestFocus();
	}
	
	// Actualiza el archivo
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		if (arregloEmpleados.existeArchivo()) {
			int respuesta = confirmar("�Seguro que desea actualizar \"" + arregloEmpleados.getArchivo() + "\"?");
			if (respuesta == JOptionPane.YES_OPTION) {
				arregloEmpleados.grabarEmpleados();
				mensaje("\"" + arregloEmpleados.getArchivo() + "\" ha sido actualizado");
			} else {
				mensaje("No se actualiz� \"" + arregloEmpleados.getArchivo() + "\"");
			}
		} else {
			// Si no existe el archivo es creado
			arregloEmpleados.grabarEmpleados();
			mensaje("\"" + arregloEmpleados.getArchivo() + "\" ha sido creado");
		}
	}
}
