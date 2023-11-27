package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.PersonaDao;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaEliminar extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoUsuario;
	private JButton btnEliminarUsuario;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public VentanaEliminar() {
		setBounds(100, 100, 387, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("ELIMINAR USUARIO");
		title.setFont(new Font("Tahoma", Font.PLAIN, 18));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(89, 11, 189, 39);
		contentPane.add(title);
		
		txtCodigoUsuario = new JTextField();
		txtCodigoUsuario.setBounds(96, 109, 182, 20);
		contentPane.add(txtCodigoUsuario);
		txtCodigoUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo :");
		lblNewLabel.setBounds(40, 112, 46, 14);
		contentPane.add(lblNewLabel);
		
		btnEliminarUsuario = new JButton("Eliminar");
		btnEliminarUsuario.addActionListener(this);
		btnEliminarUsuario.setBounds(130, 167, 89, 23);
		contentPane.add(btnEliminarUsuario);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnEliminarUsuario) {
			PersonaDao miPersonaDao = new PersonaDao();
			miPersonaDao.eliminarUsuario(Integer.parseInt(txtCodigoUsuario.getText()));
		}
		
	}
}
