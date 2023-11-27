package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.PersonaDao;
import vo.PersonaVo;

public class VentanaRegistro extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel labelTitulo;
	private JTextField textCod, textNombre, textEdad, textTelefono,textProfesion;
	private JLabel cod, nombre, edad, telefono, profesion;
	private JButton botonRegistrar, botonCancelar;
	
	public VentanaRegistro() {
		botonRegistrar = new JButton();
		botonRegistrar.setBounds(110, 200, 120, 25);
		botonRegistrar.setText("Registrar");

		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 200, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE PERSONAS");
		labelTitulo.setBounds(91, 24, 264, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cod = new JLabel();
		cod.setText("Codigo");
		cod.setBounds(20, 80, 80, 25);
		getContentPane().add(cod);

		nombre = new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 120, 80, 25);
		getContentPane().add(nombre);

		telefono = new JLabel();
		telefono.setText("telefono");
		telefono.setBounds(290, 160, 80, 25);
		getContentPane().add(telefono);

		edad = new JLabel();
		edad.setText("Edad");
		edad.setBounds(290, 120, 80, 25);
		getContentPane().add(edad);

		profesion = new JLabel();
		profesion.setText("Profesion");
		profesion.setBounds(20, 160, 80, 25);
		getContentPane().add(profesion);

		textCod = new JTextField();
		textCod.setBounds(80, 80, 80, 25);
		getContentPane().add(textCod);

		textNombre = new JTextField();
		textNombre.setBounds(80, 120, 190, 25);
		getContentPane().add(textNombre);

		textTelefono = new JTextField();
		textTelefono.setBounds(340, 160, 80, 25);
		getContentPane().add(textTelefono);

		textEdad = new JTextField();
		textEdad.setBounds(340, 120, 80, 25);
		getContentPane().add(textEdad);

		textProfesion = new JTextField();
		textProfesion.setBounds(80, 160, 190, 25);
		getContentPane().add(textProfesion);

		botonRegistrar.addActionListener(this);
		botonCancelar.addActionListener(this);


		
		getContentPane().add(botonCancelar);
		getContentPane().add(botonRegistrar);
		getContentPane().add(labelTitulo);

		setSize(480, 650);
		setTitle("Registrar Persona");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==botonRegistrar) {
			PersonaDao miPersonaDao = new PersonaDao();
			try {
				PersonaVo miPersona = new PersonaVo();
				miPersona.setIdPersona(Integer.parseInt(textCod.getText()));
				miPersona.setNombrePersona(textNombre.getText());
				miPersona.setTelefonoPersona(Integer.parseInt(textTelefono.getText()));
				miPersona.setEdadPersona(Integer.parseInt(textEdad.getText()));
				miPersona.setProfesionPersona(textProfesion.getText());
				miPersonaDao.registrarPersona(miPersona);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos", "Error",JOptionPane.ERROR_MESSAGE);
			} 
			}
		
	}

}
