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

import arreglos.ArregloClientes;
import clases.Cliente;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
public class DlgMantenimientoCliente extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMensaje;
	private JLabel lblCdigo;
	private JLabel lblNombres;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JLabel lblEstadoCivil;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidoPaterno;
	private JTextField txtApellidoMaterno;
	private JComboBox<String> cboEstadoCivil;
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
					DlgMantenimientoCliente dialog = new DlgMantenimientoCliente();
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
	public DlgMantenimientoCliente() {
		setModal(true);
		setResizable(false);
		setTitle("Mantenimiento | Cliente");
		setBounds(100, 100, 1033, 700);
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
		
		lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setBounds(27, 112, 78, 14);
		getContentPane().add(lblApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setBounds(27, 137, 80, 14);
		getContentPane().add(lblApellidoMaterno);
		
		lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setBounds(27, 238, 53, 14);
		getContentPane().add(lblEstadoCivil);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(158, 55, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.addActionListener(this);
		
		txtNombres = new JTextField();
		txtNombres.addActionListener(this);
		txtNombres.setEditable(false);
		txtNombres.setBounds(158, 84, 230, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidoPaterno = new JTextField();
		txtApellidoPaterno.addActionListener(this);
		txtApellidoPaterno.setEditable(false);
		txtApellidoPaterno.setBounds(158, 109, 290, 20);
		getContentPane().add(txtApellidoPaterno);
		txtApellidoPaterno.setColumns(10);
		
		txtApellidoMaterno = new JTextField();
		txtApellidoMaterno.addActionListener(this);
		txtApellidoMaterno.setEditable(false);
		txtApellidoMaterno.setBounds(158, 134, 290, 20);
		getContentPane().add(txtApellidoMaterno);
		txtApellidoMaterno.setColumns(10);
		
		cboEstadoCivil = new JComboBox<String>();
		cboEstadoCivil.addActionListener(this);
		cboEstadoCivil.setEnabled(false);
		cboEstadoCivil.setModel(new DefaultComboBoxModel<String>(new String[] {"Soltero", "Casado", "Viudo", "Divorciado"}));
		cboEstadoCivil.setBounds(158, 235, 133, 20);
		getContentPane().add(cboEstadoCivil);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(299, 54, 89, 23);
		getContentPane().add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 346, 969, 280);
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
		btnAceptar.setBounds(677, 222, 120, 23);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setEnabled(false);
		btnVolver.addActionListener(this);
		btnVolver.setBounds(677, 249, 120, 23);
		getContentPane().add(btnVolver);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellido Paterno");
		modelo.addColumn("Apellido Materno");
		modelo.addColumn("Dirección");
		modelo.addColumn("Fecha de nacimiento");
		modelo.addColumn("Fecha de afiliación");
		modelo.addColumn("Estado civil");
		modelo.addColumn("Teléfono");
		modelo.addColumn("Dni");
		modelo.addColumn("Usuario");
		modelo.addColumn("Contraseña");
		tblTabla.setModel(modelo);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(27, 288, 46, 14);
		getContentPane().add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(27, 313, 56, 14);
		getContentPane().add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.addActionListener(this);
		txtUsuario.setEditable(false);
		txtUsuario.setBounds(158, 285, 184, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.addActionListener(this);
		txtContraseña.setEditable(false);
		txtContraseña.setBounds(158, 310, 184, 20);
		getContentPane().add(txtContraseña);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(907, 637, 89, 23);
		getContentPane().add(btnCerrar);
		
		lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(27, 162, 43, 14);
		getContentPane().add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.addActionListener(this);
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(158, 159, 290, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(27, 188, 98, 14);
		getContentPane().add(lblFechaDeNacimiento);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.addActionListener(this);
		txtFechaNacimiento.setEditable(false);
		txtFechaNacimiento.setBounds(158, 185, 133, 20);
		getContentPane().add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		
		lblFechaDeAfiliacin = new JLabel("Fecha de afiliaci\u00F3n");
		lblFechaDeAfiliacin.setBounds(27, 213, 88, 14);
		getContentPane().add(lblFechaDeAfiliacin);
		
		txtFechaAfiliacion = new JTextField();
		txtFechaAfiliacion.addActionListener(this);
		txtFechaAfiliacion.setEditable(false);
		txtFechaAfiliacion.setBounds(158, 210, 133, 20);
		getContentPane().add(txtFechaAfiliacion);
		txtFechaAfiliacion.setColumns(10);
		
		lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(27, 263, 46, 14);
		getContentPane().add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.addActionListener(this);
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(158, 260, 133, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(313, 263, 18, 14);
		getContentPane().add(lblDni);
		
		txtDni = new JTextField();
		txtDni.addActionListener(this);
		txtDni.setEditable(false);
		txtDni.setBounds(341, 260, 107, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		listar();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtDni) {
			actionPerformedTxtDni(e);
		}
		if (e.getSource() == txtTelefono) {
			actionPerformedTxtTelefono(e);
		}
		if (e.getSource() == txtFechaAfiliacion) {
			actionPerformedTxtFechaAfiliacion(e);
		}
		if (e.getSource() == txtFechaNacimiento) {
			actionPerformedTxtFechaNacimiento(e);
		}
		if (e.getSource() == txtDireccion) {
			actionPerformedTxtDireccion(e);
		}
		if (e.getSource() == txtContraseña) {
			actionPerformedTxtContraseña(e);
		}
		if (e.getSource() == txtUsuario) {
			actionPerformedTxtUsuario(e);
		}
		if (e.getSource() == cboEstadoCivil) {
			actionPerformedCboEstadoCivil(e);
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
	
	// Declaración Global
	ArregloClientes arregloClientes = new ArregloClientes();
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	private JButton btnCerrar;
	private JLabel lblDireccin;
	private JTextField txtDireccion;
	private JLabel lblFechaDeNacimiento;
	private JTextField txtFechaNacimiento;
	private JLabel lblFechaDeAfiliacin;
	private JTextField txtFechaAfiliacion;
	private JLabel lblTelfono;
	private JTextField txtTelefono;
	private JLabel lblDni;
	private JTextField txtDni;
	
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		tipoOperacion = INGRESAR;
		lblMensaje.setText("Ingresando Cliente");
		txtCodigo.setText(arregloClientes.codigoCorrelativo() + ""); // Se genera el código del siguiente Cliente
		limpiarEntradas();
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombres.requestFocus();
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarCliente();
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Cliente");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Cliente");
		txtCodigo.setEditable(true);
		habilitarEntradas(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Cliente");
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
				ingresarCliente();
				break;
				
			case CONSULTAR:
				consultarCliente();
				break;
				
			case MODIFICAR:
				modificarCliente();
				break;
				
			case ELIMINAR:
				eliminarCliente();
				break;
		}
	}
	
	// Lista los clientes en la tabla
	void listar() {
		modelo.setRowCount(0);
		Cliente cliente = null;
		for (int i = 0; i < arregloClientes.tamaño(); i++) {
			cliente = arregloClientes.obtener(i);
			Object[] fila = {
					cliente.getCodigo(),
					cliente.getNombres(),
					cliente.getApellidoPaterno(),
					cliente.getApellidoMaterno(),
					cliente.getDireccion(),
					cliente.getFechaNacimiento(),
					cliente.getFechaAfiliacion(),
					cliente.descripcionEstadoCivil(),
					cliente.getTelefono(),
					cliente.getDni(),
					cliente.getUsuario(),
					cliente.getContraseña()};
			modelo.addRow(fila);
		}
	}
	
	void ingresarCliente() {
		int codigo = leerCodigo();
		String nombres = leerNombres();
		if (nombres.length() > 0) {
			String apellidoPaterno = leerApellidoPaterno();
			if (apellidoPaterno.length() > 0) {
				String apellidoMaterno = leerApellidoMaterno();
				if (apellidoMaterno.length() > 0) {
					String direccion = leerDireccion();
					if (direccion.length() > 0) {
						String fechaNacimiento = leerFechaNacimiento();
						if (fechaNacimiento.length() > 0) {
							String fechaAfiliacion = leerFechaAfiliacion();
							if (fechaAfiliacion.length() > 0) {
								int estadoCivil = leerEstadoCivil();
								String telefono = leerTelefono();
								if (telefono.length() > 0) {
									String dni = leerDni();
									if (dni.length() > 0) {
										String usuario = leerUsuario();
										if (usuario.length() > 0) {
											String contraseña = leerContraseña();
											if (contraseña.length() > 0) {
												// Datos correctos
												Cliente cliente = new Cliente(codigo, nombres, apellidoPaterno, apellidoMaterno, direccion, fechaNacimiento, fechaAfiliacion, estadoCivil,  telefono, dni, usuario, contraseña);
												arregloClientes.adicionar(cliente);
												listar();
												txtCodigo.setText("" + arregloClientes.codigoCorrelativo());
												limpiarEntradas();
												txtNombres.requestFocus();
												mensaje("Registro exitoso");
												
											} else {
												mensaje("Ingrese Contraseña correcta");
												txtContraseña.setText("");
												txtContraseña.requestFocus();
											}
										} else {
											mensaje("Ingrese Usuario correcto");
											txtUsuario.setText("");
											txtUsuario.requestFocus();
										}
									} else {
										mensaje("Ingrese DNI correcto");
										txtDni.setText("");
										txtDni.requestFocus();
									}
								} else {
									mensaje("Ingrese Teléfono correcto");
									txtTelefono.setText("");
									txtTelefono.requestFocus();
								}
							} else {
								mensaje("Ingrese Fecha de afiliación correcta");
								txtFechaAfiliacion.setText("");
								txtFechaAfiliacion.requestFocus();
							}
						} else {
							mensaje("Ingrese Fecha de nacimiento correcta");
							txtFechaNacimiento.setText("");
							txtFechaNacimiento.requestFocus();
						}
					} else {
						mensaje("Ingrese Dirección correcta");
						txtDireccion.setText("");
						txtDireccion.requestFocus();
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
	
	void consultarCliente() {
		try {
			Cliente cliente = arregloClientes.buscar(leerCodigo());
			if (cliente != null) {
				txtNombres.setText(cliente.getNombres());
				txtApellidoPaterno.setText(cliente.getApellidoPaterno());
				txtApellidoMaterno.setText(cliente.getApellidoMaterno());
				txtDireccion.setText(cliente.getDireccion());
				txtFechaNacimiento.setText(cliente.getFechaNacimiento());
				txtFechaAfiliacion.setText(cliente.getFechaAfiliacion());
				cboEstadoCivil.setSelectedIndex(cliente.getEstadoCivil());
				txtTelefono.setText(cliente.getTelefono());
				txtDni.setText(cliente.getDni());
				txtUsuario.setText(cliente.getUsuario());
				txtContraseña.setText(cliente.getContraseña());
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
	
	void modificarCliente() {
		try {
			Cliente cliente = arregloClientes.buscar(leerCodigo());
			String nombres = leerNombres();
			if (nombres.length() > 0) {
				String apellidoPaterno = leerApellidoPaterno();
				if (apellidoPaterno.length() > 0) {
					String apellidoMaterno = leerApellidoMaterno();
					if (apellidoMaterno.length() > 0) {
						String direccion = leerDireccion();
						if (direccion.length() > 0) {
							String fechaNacimiento = leerFechaNacimiento();
							if (fechaNacimiento.length() > 0) {
								String fechaAfiliacion = leerFechaAfiliacion();
								if (fechaAfiliacion.length() > 0) {
									int estadoCivil = leerEstadoCivil();
									String telefono = leerTelefono();
									if (telefono.length() > 0) {
										String dni = leerDni();
										if (dni.length() > 0) {
											String usuario = leerUsuario();
											if (usuario.length() > 0) {
												String contraseña = leerContraseña();
												if (contraseña.length() > 0) {
													// Datos correctos
													int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar los datos del cliente seleccionado?",
															"Seleccionar una opción", JOptionPane.YES_NO_OPTION);
															
													if (respuesta == JOptionPane.YES_OPTION) {
														cliente.setNombres(nombres);
														cliente.setApellidoPaterno(apellidoPaterno);
														cliente.setApellidoMaterno(apellidoMaterno);
														cliente.setDireccion(direccion);
														cliente.setFechaNacimiento(fechaNacimiento);
														cliente.setFechaAfiliacion(fechaAfiliacion);
														cliente.setEstadoCivil(estadoCivil);
														cliente.setTelefono(telefono);
														cliente.setDni(dni);
														cliente.setUsuario(usuario);
														cliente.setContraseña(contraseña);
														listar();
														txtCodigo.requestFocus();								
														mensaje("Modificación exitosa");
													}
													
												} else {
													mensaje("Ingrese Contraseña correcta");
													txtContraseña.setText("");
													txtContraseña.requestFocus();
												}
											} else {
												mensaje("Ingrese Usuario correcto");
												txtUsuario.setText("");
												txtUsuario.requestFocus();
											}
										} else {
											mensaje("Ingrese DNI correcto");
											txtDni.setText("");
											txtDni.requestFocus();
										}
									} else {
										mensaje("Ingrese Teléfono correcto");
										txtTelefono.setText("");
										txtTelefono.requestFocus();
									}
								} else {
									mensaje("Ingrese Fecha de afiliación correcta");
									txtFechaAfiliacion.setText("");
									txtFechaAfiliacion.requestFocus();
								}
							} else {
								mensaje("Ingrese Fecha de nacimiento correcta");
								txtFechaNacimiento.setText("");
								txtFechaNacimiento.requestFocus();
							}
						} else {
							mensaje("Ingrese Dirección correcta");
							txtDireccion.setText("");
							txtDireccion.requestFocus();
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
			mensaje("Ingrese CÓDIGO correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	
	void eliminarCliente() {
		try {
			Cliente cliente = arregloClientes.buscar(leerCodigo());
			if (cliente != null) {
				int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar al cliente seleccionado?",
						"Seleccionar una opción", JOptionPane.YES_NO_OPTION);
						
				if (respuesta == JOptionPane.YES_OPTION) {
					arregloClientes.eliminar(cliente);
					listar();
					txtCodigo.setText("");
					limpiarEntradas();
					txtCodigo.requestFocus();
					mensaje("Eliminación exitosa");
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
		txtNombres.setText("");
		txtApellidoPaterno.setText("");
		txtApellidoMaterno.setText("");
		txtDireccion.setText("");
		txtFechaNacimiento.setText("");
		txtFechaAfiliacion.setText("");
		cboEstadoCivil.setSelectedIndex(0);
		txtTelefono.setText("");
		txtDni.setText("");
		txtUsuario.setText("");
		txtContraseña.setText("");
	}
	
	// Habilita los cuadros de texto y combobox para ingresar/seleccionar datos
	void habilitarEntradas(boolean valor) {		
		txtNombres.setEditable(valor);
		txtApellidoPaterno.setEditable(valor);
		txtApellidoMaterno.setEditable(valor);
		txtDireccion.setEditable(valor);
		txtFechaNacimiento.setEditable(valor);
		txtFechaAfiliacion.setEditable(valor);
		cboEstadoCivil.setEnabled(valor);
		txtTelefono.setEditable(valor);
		txtDni.setEditable(valor);
		txtUsuario.setEditable(valor);
		txtContraseña.setEditable(valor);
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
	
	// Métodos que retornan valor sin parámetros
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
	
	String leerDireccion() {
		return txtDireccion.getText().trim();
	}
	
	String leerFechaNacimiento() {
		return txtFechaNacimiento.getText().trim();
	}
	
	String leerFechaAfiliacion() {
		return txtFechaAfiliacion.getText().trim();
	}
	
	int leerEstadoCivil() {
		return cboEstadoCivil.getSelectedIndex();
	}
	
	String leerTelefono() {
		return txtTelefono.getText().trim();
	}
	
	String leerDni() {
		return txtDni.getText().trim();
	}
	
	String leerUsuario() {
		return txtUsuario.getText().trim();
	}
	
	String leerContraseña() {
		return new String(txtContraseña.getPassword());
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
		txtDireccion.requestFocus();
	}
	
	protected void actionPerformedCboEstadoCivil(ActionEvent e) {
		txtTelefono.requestFocus();
	}
	
	protected void actionPerformedTxtUsuario(ActionEvent e) {
		txtContraseña.requestFocus();
	}
	
	protected void actionPerformedTxtContraseña(ActionEvent e) {
		btnAceptar.requestFocus();
	}
	
	protected void actionPerformedTxtDireccion(ActionEvent e) {
		txtFechaNacimiento.requestFocus();
	}
	
	protected void actionPerformedTxtFechaNacimiento(ActionEvent e) {
		txtFechaAfiliacion.requestFocus();
	}
	
	protected void actionPerformedTxtFechaAfiliacion(ActionEvent e) {
		cboEstadoCivil.requestFocus();
	}
	
	protected void actionPerformedTxtTelefono(ActionEvent e) {
		txtDni.requestFocus();
	}
	
	protected void actionPerformedTxtDni(ActionEvent e) {
		txtUsuario.requestFocus();
	}
}
