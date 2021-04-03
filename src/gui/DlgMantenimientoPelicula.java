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
import arreglos.ArregloPeliculas;
import clases.Pelicula;
import javax.swing.DefaultComboBoxModel;
public class DlgMantenimientoPelicula extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMensaje;
	private JLabel lblCdigo;
	private JLabel lblTituloDistribucion;
	private JLabel lblTituloOriginal;
	private JLabel lblFechaEstreno;
	private JLabel lblSinopsis;
	private JTextField txtCodigo;
	private JTextField txtTituloDistribucion;
	private JTextField txtTituloOriginal;
	private JTextField txtFechaEstreno;
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
					DlgMantenimientoPelicula dialog = new DlgMantenimientoPelicula();
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
	public DlgMantenimientoPelicula() {
		setModal(true);
		setResizable(false);
		setTitle("Mantenimiento | Pel\u00EDcula");
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
		
		lblTituloDistribucion = new JLabel("T\u00EDtulo de distribuci\u00F3n");
		lblTituloDistribucion.setBounds(27, 87, 98, 14);
		getContentPane().add(lblTituloDistribucion);
		
		lblTituloOriginal = new JLabel("T\u00EDtulo Original");
		lblTituloOriginal.setBounds(27, 112, 78, 14);
		getContentPane().add(lblTituloOriginal);
		
		lblFechaEstreno = new JLabel("Fecha estreno");
		lblFechaEstreno.setBounds(27, 137, 80, 14);
		getContentPane().add(lblFechaEstreno);
		
		lblSinopsis = new JLabel("Sinopsis");
		lblSinopsis.setBounds(27, 238, 53, 14);
		getContentPane().add(lblSinopsis);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(158, 55, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.addActionListener(this);
		
		txtTituloDistribucion = new JTextField();
		txtTituloDistribucion.addActionListener(this);
		txtTituloDistribucion.setEditable(false);
		txtTituloDistribucion.setBounds(158, 84, 230, 20);
		getContentPane().add(txtTituloDistribucion);
		txtTituloDistribucion.setColumns(10);
		
		txtTituloOriginal = new JTextField();
		txtTituloOriginal.addActionListener(this);
		txtTituloOriginal.setEditable(false);
		txtTituloOriginal.setBounds(158, 109, 290, 20);
		getContentPane().add(txtTituloOriginal);
		txtTituloOriginal.setColumns(10);
		
		txtFechaEstreno = new JTextField();
		txtFechaEstreno.addActionListener(this);
		txtFechaEstreno.setEditable(false);
		txtFechaEstreno.setBounds(158, 134, 290, 20);
		getContentPane().add(txtFechaEstreno);
		txtFechaEstreno.setColumns(10);
		
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
		modelo.addColumn("Título de distribución");
		modelo.addColumn("Título Original");
		modelo.addColumn("Estreno");
		modelo.addColumn("Tipo de proyección");
		modelo.addColumn("Género");
		modelo.addColumn("País origen");
		modelo.addColumn("Sinopsis");
		modelo.addColumn("Duración");
		modelo.addColumn("Censura");
		modelo.addColumn("Estado proyección");
		modelo.addColumn("Recaudación");
		tblTabla.setModel(modelo);
		
		lblEstadoProyeccion = new JLabel("Estado de proyecci\u00F3n");
		lblEstadoProyeccion.setBounds(27, 288, 103, 14);
		getContentPane().add(lblEstadoProyeccion);
		
		lblRecaudacion = new JLabel("Recaudaci\u00F3n");
		lblRecaudacion.setBounds(27, 313, 61, 14);
		getContentPane().add(lblRecaudacion);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(907, 637, 89, 23);
		getContentPane().add(btnCerrar);
		
		lblTipoProyeccion = new JLabel("Tipo de proyecci\u00F3n");
		lblTipoProyeccion.setBounds(27, 162, 90, 14);
		getContentPane().add(lblTipoProyeccion);
		
		lblGenero = new JLabel("G\u00E9nero");
		lblGenero.setBounds(27, 188, 98, 14);
		getContentPane().add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.addActionListener(this);
		txtGenero.setEditable(false);
		txtGenero.setBounds(158, 185, 133, 20);
		getContentPane().add(txtGenero);
		txtGenero.setColumns(10);
		
		lblPaisOrigen = new JLabel("Pa\u00EDs de origen");
		lblPaisOrigen.setBounds(27, 213, 88, 14);
		getContentPane().add(lblPaisOrigen);
		
		txtPaisOrigen = new JTextField();
		txtPaisOrigen.addActionListener(this);
		txtPaisOrigen.setEditable(false);
		txtPaisOrigen.setBounds(158, 210, 133, 20);
		getContentPane().add(txtPaisOrigen);
		txtPaisOrigen.setColumns(10);
		
		lblDuracion = new JLabel("Duraci\u00F3n");
		lblDuracion.setBounds(27, 263, 42, 14);
		getContentPane().add(lblDuracion);
		
		txtDuracion = new JTextField();
		txtDuracion.addActionListener(this);
		txtDuracion.setEditable(false);
		txtDuracion.setBounds(158, 260, 133, 20);
		getContentPane().add(txtDuracion);
		txtDuracion.setColumns(10);
		
		lblTipoCensura = new JLabel("Tipo de censura");
		lblTipoCensura.setBounds(313, 263, 76, 14);
		getContentPane().add(lblTipoCensura);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(808, 637, 89, 23);
		getContentPane().add(btnGrabar);
		
		cboTipoProyeccion = new JComboBox<String>();
		cboTipoProyeccion.setEnabled(false);
		cboTipoProyeccion.addActionListener(this);
		cboTipoProyeccion.setModel(new DefaultComboBoxModel<String>(new String[] {"Estreno", "Fuera de estreno"}));
		cboTipoProyeccion.setBounds(158, 159, 184, 20);
		getContentPane().add(cboTipoProyeccion);
		
		txtSinopsis = new JTextField();
		txtSinopsis.addActionListener(this);
		txtSinopsis.setEditable(false);
		txtSinopsis.setBounds(158, 235, 133, 20);
		getContentPane().add(txtSinopsis);
		txtSinopsis.setColumns(10);
		
		cboTipoCensura = new JComboBox<String>();
		cboTipoCensura.setEnabled(false);
		cboTipoCensura.addActionListener(this);
		cboTipoCensura.setModel(new DefaultComboBoxModel<String>(new String[] {"Apta para todos", "Mayores de 14 a\u00F1os", "Mayores de 18 a\u00F1os"}));
		cboTipoCensura.setBounds(399, 260, 127, 20);
		getContentPane().add(cboTipoCensura);
		
		cboEstadoProyeccion = new JComboBox<String>();
		cboEstadoProyeccion.setEnabled(false);
		cboEstadoProyeccion.addActionListener(this);
		cboEstadoProyeccion.setModel(new DefaultComboBoxModel<String>(new String[] {"En cartelera", "Fuera de cartelera"}));
		cboEstadoProyeccion.setBounds(158, 285, 133, 20);
		getContentPane().add(cboEstadoProyeccion);
		
		txtRecaudacion = new JTextField();
		txtRecaudacion.setEditable(false);
		txtRecaudacion.addActionListener(this);
		txtRecaudacion.setBounds(158, 310, 184, 20);
		getContentPane().add(txtRecaudacion);
		txtRecaudacion.setColumns(10);
		
		listar();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboTipoCensura) {
			actionPerformedCboTipoCensura(e);
		}
		if (e.getSource() == txtRecaudacion) {
			actionPerformedTxtRecaudacion(e);
		}
		if (e.getSource() == cboEstadoProyeccion) {
			actionPerformedCboEstadoProyeccion(e);
		}
		if (e.getSource() == txtSinopsis) {
			actionPerformedTxtSinopsis(e);
		}
		if (e.getSource() == cboTipoProyeccion) {
			actionPerformedCboTipoProyeccion(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == txtDuracion) {
			actionPerformedTxtDuracion(e);
		}
		if (e.getSource() == txtPaisOrigen) {
			actionPerformedTxtFechaAfiliacion(e);
		}
		if (e.getSource() == txtGenero) {
			actionPerformedTxtGenero(e);
		}
		if (e.getSource() == txtFechaEstreno) {
			actionPerformedTxtFechaEstreno(e);
		}
		if (e.getSource() == txtTituloOriginal) {
			actionPerformedTxtTituloOriginal(e);
		}
		if (e.getSource() == txtTituloDistribucion) {
			actionPerformedTxtTituloDistribucion(e);
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
	ArregloPeliculas arregloPeliculas = new ArregloPeliculas("peliculas.txt");
	private JLabel lblEstadoProyeccion;
	private JLabel lblRecaudacion;
	private JButton btnCerrar;
	private JLabel lblTipoProyeccion;
	private JLabel lblGenero;
	private JTextField txtGenero;
	private JLabel lblPaisOrigen;
	private JTextField txtPaisOrigen;
	private JLabel lblDuracion;
	private JTextField txtDuracion;
	private JLabel lblTipoCensura;
	private JButton btnGrabar;
	private JComboBox<String> cboTipoProyeccion;
	private JTextField txtSinopsis;
	private JComboBox<String> cboTipoCensura;
	private JComboBox<String> cboEstadoProyeccion;
	private JTextField txtRecaudacion;
	
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		tipoOperacion = INGRESAR;
		lblMensaje.setText("Ingresando Pelicula");
		txtCodigo.setText(arregloPeliculas.codigoCorrelativo() + ""); // Se genera el código de la siguiente Pelicula
		limpiarEntradas();
		habilitarEntradas(true);
		habilitarBotones(false);
		txtTituloDistribucion.requestFocus();
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarPelicula();
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Pelicula");
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Pelicula");
		txtCodigo.setEditable(true);
		habilitarEntradas(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Pelicula");
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
				ingresarPelicula();
				break;
				
			case CONSULTAR:
				consultarPelicula();
				break;
				
			case MODIFICAR:
				modificarPelicula();
				break;
				
			case ELIMINAR:
				eliminarPelicula();
				break;
		}
	}
	
	// Lista las películas en la tabla
	void listar() {
		modelo.setRowCount(0);
		Pelicula pelicula = null;
		for (int i = 0; i < arregloPeliculas.tamaño(); i++) {
			pelicula = arregloPeliculas.obtener(i);
			Object[] fila = {
					pelicula.getCodigo(),
					pelicula.getTituloDistribucion(),
					pelicula.getTituloOriginal(),
					pelicula.getFechaEstreno(),
					pelicula.getTipoProyeccion(),
					pelicula.getGenero(),
					pelicula.getPaisOrigen(),
					pelicula.getSinopsis(),
					pelicula.getDuracion(),
					pelicula.getTipoCensura(),
					pelicula.getEstadoProyeccion(),
					pelicula.getRecaudacion()
					};
			modelo.addRow(fila);
		}
	}
	
	void ingresarPelicula() {
		int codigo = leerCodigo();
		String tituloDistribucion = leerTituloDistribucion();
		if (tituloDistribucion.length() > 0) {
			String tituloOriginal = leerTituloOriginal();
			if (tituloOriginal.length() > 0) {
				String fechaEstreno = leerFechaEstreno();
				if (fechaEstreno.length() > 0) {
					int tipoProyeccion = leerTipoProyeccion();
					String genero = leerGenero();
					if (genero.length() > 0) {
						String paisOrigen = leerPaisOrigen();
						if (paisOrigen.length() > 0) {
							String sinopsis = leerSinopsis();
							if (sinopsis.length() > 0) {
								try {
									int duracion = leerDuracion();
									if (duracion > 0) {
										int tipoCensura = leerTipoCensura();
										int estadoProyeccion = leerEstadoProyeccion();
										try {
											double recaudacion = leerRecaudacion();
											if (recaudacion > 0) {
												// Datos correctos
												Pelicula pelicula = new Pelicula(codigo, tituloDistribucion, tituloOriginal, 
														fechaEstreno, tipoProyeccion, genero, paisOrigen, sinopsis, duracion, 
														tipoCensura, estadoProyeccion, recaudacion);
												arregloPeliculas.adicionar(pelicula);
												listar();
												txtCodigo.setText("" + arregloPeliculas.codigoCorrelativo());
												limpiarEntradas();
												txtTituloDistribucion.requestFocus();
												mensaje("Registro exitoso");
											} else {
												throw new Exception();
											}
										} catch (Exception e) {
											mensaje("Ingrese la recaudación correcta (S/.)");
											txtRecaudacion.setText("");
											txtRecaudacion.requestFocus();
										}
									} else {
										throw new Exception();
									}
								} catch (Exception e) {
									mensaje("Ingrese la Duración correcta (en minutos)");
									txtDuracion.setText("");
									txtDuracion.requestFocus();
								}
							} else {
								mensaje("Ingrese la Sinopsis correcta");
								txtSinopsis.setText("");
								txtSinopsis.requestFocus();
							}
						} else {
							mensaje("Ingrese el País de origen correcto");
							txtPaisOrigen.setText("");
							txtPaisOrigen.requestFocus();
						}
					} else {
						mensaje("Ingrese el Género correcto");
						txtGenero.setText("");
						txtGenero.requestFocus();
					}
				} else {
					mensaje("Ingrese la Fecha de Estreno correcta");
					txtFechaEstreno.setText("");
					txtFechaEstreno.requestFocus();
				}
			} else {
				mensaje("Ingrese el Título Original correcto");
				txtTituloOriginal.setText("");
				txtTituloOriginal.requestFocus();
			}
		} else {
			mensaje("Ingrese el Título de Distribución correcto");
			txtTituloDistribucion.setText("");
			txtTituloDistribucion.requestFocus();
		}
	}
	
	void consultarPelicula() {
		try {
			Pelicula pelicula = arregloPeliculas.buscar(leerCodigo());
			if (pelicula != null) {
				txtTituloDistribucion.setText(pelicula.getTituloDistribucion());
				txtTituloOriginal.setText(pelicula.getTituloOriginal());
				txtFechaEstreno.setText(pelicula.getFechaEstreno());
				cboTipoProyeccion.setSelectedIndex(pelicula.getTipoProyeccion());
				txtGenero.setText(pelicula.getGenero());
				txtPaisOrigen.setText(pelicula.getPaisOrigen());
				txtSinopsis.setText(pelicula.getSinopsis());
				txtDuracion.setText(pelicula.getDuracion() + "");
				cboTipoCensura.setSelectedIndex(pelicula.getTipoCensura());
				cboEstadoProyeccion.setSelectedIndex(pelicula.getEstadoProyeccion());
				txtRecaudacion.setText(pelicula.getRecaudacion() + "");
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
	
	void modificarPelicula() {
		try {
			Pelicula pelicula = arregloPeliculas.buscar(leerCodigo());
			String tituloDistribucion = leerTituloDistribucion();
			if (tituloDistribucion.length() > 0) {
				String tituloOriginal = leerTituloOriginal();
				if (tituloOriginal.length() > 0) {
					String fechaEstreno = leerFechaEstreno();
					if (fechaEstreno.length() > 0) {
						int tipoProyeccion = leerTipoProyeccion();
						String genero = leerGenero();
						if (genero.length() > 0) {
							String paisOrigen = leerPaisOrigen();
							if (paisOrigen.length() > 0) {
								String sinopsis = leerSinopsis();
								if (sinopsis.length() > 0) {
									try {
										int duracion = leerDuracion();
										if (duracion > 0) {
											int tipoCensura = leerTipoCensura();
											int estadoProyeccion = leerEstadoProyeccion();
											try {
												double recaudacion = leerRecaudacion();
												if (recaudacion > 0) {
													// Datos correctos
													int respuesta = confirmar("¿Seguro que desea modificar los datos de la película seleccionada?",
															"Seleccionar una opción");
															
													if (respuesta == JOptionPane.YES_OPTION) {
														pelicula.setTituloDistribucion(tituloDistribucion);
														pelicula.setTituloOriginal(tituloOriginal);;
														pelicula.setFechaEstreno(fechaEstreno);
														pelicula.setTipoProyeccion(tipoProyeccion);
														pelicula.setGenero(genero);
														pelicula.setPaisOrigen(paisOrigen);
														pelicula.setSinopsis(sinopsis);
														pelicula.setDuracion(duracion);
														pelicula.setTipoCensura(tipoCensura);
														pelicula.setEstadoProyeccion(estadoProyeccion);
														pelicula.setRecaudacion(recaudacion);
														listar();
														txtCodigo.requestFocus();								
														mensaje("Modificación exitosa");
													}
												} else {
													throw new Exception();
												}
											} catch (Exception e) {
												mensaje("Ingrese la recaudación correcta (S/.)");
												txtRecaudacion.setText("");
												txtRecaudacion.requestFocus();
											}
										} else {
											throw new Exception();
										}
									} catch (Exception e) {
										mensaje("Ingrese la Duración correcta (en minutos)");
										txtDuracion.setText("");
										txtDuracion.requestFocus();
									}
								} else {
									mensaje("Ingrese la Sinopsis correcta");
									txtSinopsis.setText("");
									txtSinopsis.requestFocus();
								}
							} else {
								mensaje("Ingrese el País de origen correcto");
								txtPaisOrigen.setText("");
								txtPaisOrigen.requestFocus();
							}
						} else {
							mensaje("Ingrese el Género correcto");
							txtGenero.setText("");
							txtGenero.requestFocus();
						}
					} else {
						mensaje("Ingrese la Fecha de Estreno correcta");
						txtFechaEstreno.setText("");
						txtFechaEstreno.requestFocus();
					}
				} else {
					mensaje("Ingrese el Título Original correcto");
					txtTituloOriginal.setText("");
					txtTituloOriginal.requestFocus();
				}
			} else {
				mensaje("Ingrese el Título de Distribución correcto");
				txtTituloDistribucion.setText("");
				txtTituloDistribucion.requestFocus();
			}
		} catch (Exception e) {
			mensaje("Ingrese CÓDIGO correcto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
	}
	
	void eliminarPelicula() {
		try {
			Pelicula pelicula = arregloPeliculas.buscar(leerCodigo());
			if (pelicula != null) {
				int respuesta = confirmar("¿Seguro que desea eliminar al pelicula seleccionado?",
						"Seleccionar una opción");
						
				if (respuesta == JOptionPane.YES_OPTION) {
					arregloPeliculas.eliminar(pelicula);
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
		txtTituloDistribucion.setText("");
		txtTituloOriginal.setText("");
		txtFechaEstreno.setText("");
		cboTipoProyeccion.setSelectedIndex(0);
		txtGenero.setText("");
		txtPaisOrigen.setText("");
		txtSinopsis.setText("");
		txtDuracion.setText("");
		cboTipoCensura.setSelectedIndex(0);
		cboEstadoProyeccion.setSelectedIndex(0);
		txtRecaudacion.setText("");
	}
	
	// Habilita los cuadros de texto y combobox para ingresar/seleccionar datos
	void habilitarEntradas(boolean valor) {		
		txtTituloDistribucion.setEditable(valor);
		txtTituloOriginal.setEditable(valor);
		txtFechaEstreno.setEditable(valor);
		cboTipoProyeccion.setEnabled(valor);
		txtGenero.setEditable(valor);
		txtPaisOrigen.setEditable(valor);
		txtSinopsis.setEditable(valor);
		txtDuracion.setEditable(valor);
		cboTipoCensura.setEnabled(valor);
		cboEstadoProyeccion.setEnabled(valor);
		txtRecaudacion.setEditable(valor);
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
	
	String leerTituloDistribucion() {
		return txtTituloDistribucion.getText().trim();
	}
	
	String leerTituloOriginal() {
		return txtTituloOriginal.getText().trim();
	}
	
	String leerFechaEstreno() {
		return txtFechaEstreno.getText().trim();
	}
	
	int leerTipoProyeccion() {
		return cboTipoProyeccion.getSelectedIndex();
	}
	
	String leerGenero() {
		return txtGenero.getText().trim();
	}
	
	String leerPaisOrigen() {
		return txtPaisOrigen.getText().trim();
	}
	
	String leerSinopsis() {
		return txtSinopsis.getText().trim();
	}
	
	int leerDuracion() {
		return Integer.parseInt(txtDuracion.getText().trim());
	}
	
	int leerTipoCensura() {
		return cboTipoCensura.getSelectedIndex();
	}
	
	int leerEstadoProyeccion() {
		return cboEstadoProyeccion.getSelectedIndex();
	}
	
	Double leerRecaudacion() {
		return Double.parseDouble(txtRecaudacion.getText().trim());
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedTxtTituloDistribucion(ActionEvent e) {
		txtTituloOriginal.requestFocus();
	}
	
	protected void actionPerformedTxtTituloOriginal(ActionEvent e) {
		txtFechaEstreno.requestFocus();
	}
	
	protected void actionPerformedTxtFechaEstreno(ActionEvent e) {
		cboTipoProyeccion.requestFocus();
	}
	
	protected void actionPerformedTxtGenero(ActionEvent e) {
		txtPaisOrigen.requestFocus();
	}
	
	protected void actionPerformedTxtFechaAfiliacion(ActionEvent e) {
		txtSinopsis.requestFocus();
	}
	
	protected void actionPerformedTxtDuracion(ActionEvent e) {
		cboTipoCensura.requestFocus();
	}
	
	protected void actionPerformedCboTipoProyeccion(ActionEvent e) {
		txtGenero.requestFocus();
	}
	
	protected void actionPerformedTxtSinopsis(ActionEvent e) {
		txtDuracion.requestFocus();
	}
	
	protected void actionPerformedCboEstadoProyeccion(ActionEvent e) {
		txtRecaudacion.requestFocus();
	}
	
	protected void actionPerformedTxtRecaudacion(ActionEvent e) {
		btnIngresar.requestFocus();
	}
	
	protected void actionPerformedCboTipoCensura(ActionEvent e) {
		cboEstadoProyeccion.requestFocus();
	}
	
	// Actualiza el archivo
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		if (arregloPeliculas.existeArchivo()) {
			int respuesta = confirmar("¿Seguro que desea actualizar \"" + arregloPeliculas.getArchivo() + "\"?");
			if (respuesta == JOptionPane.YES_OPTION) {
				arregloPeliculas.grabarPeliculas();
				mensaje("\"" + arregloPeliculas.getArchivo() + "\" ha sido actualizado");
			} else {
				mensaje("No se actualizó \"" + arregloPeliculas.getArchivo() + "\"");
			}
		} else {
			// Si no existe el archivo es creado
			arregloPeliculas.grabarPeliculas();
			mensaje("\"" + arregloPeliculas.getArchivo() + "\" ha sido creado");
		}
	}
}
