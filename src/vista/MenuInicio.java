package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicio extends JFrame implements ActionListener {
	JButton btnRegistrar,btnConsultarLista,btnConsultarPersona,btnEliminarPersona;

    public MenuInicio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Menú Principal");
        getContentPane().setLayout(null);

        // Crear botones
         btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(41, 11, 134, 23);
        btnRegistrar.addActionListener(this);
        
         btnConsultarLista = new JButton("Consultar Lista");
        btnConsultarLista.setBounds(41, 69, 134, 23);
        btnConsultarLista.addActionListener(this);
         btnConsultarPersona = new JButton("Consultar Persona");
        btnConsultarPersona.setBounds(213, 69, 141, 23);
        btnConsultarPersona.addActionListener(this);
        
         btnEliminarPersona = new JButton("Eliminar Persona");
        btnEliminarPersona.setBounds(213, 11, 141, 23);
        btnEliminarPersona.addActionListener(this);

       

        // Crear un panel para organizar los botones
        JPanel panel = new JPanel();
        panel.setBounds(10, 47, 364, 168);
        panel.setLayout(null);
        panel.add(btnRegistrar);
        panel.add(btnConsultarLista);
        panel.add(btnConsultarPersona);
        panel.add(btnEliminarPersona);

        // Agregar el panel al JFrame
        getContentPane().add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

 

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnRegistrar) {
			VentanaRegistro miRegistro = new VentanaRegistro();
			miRegistro.setVisible(true);
		}
		else if (e.getSource()==btnConsultarPersona) {
			VentanaConsultarPersona miConsultarPersona = new VentanaConsultarPersona();
			miConsultarPersona.setVisible(true);
			
		}else if (e.getSource()==btnConsultarLista) {
			VentanaConsultarLista miConsultarLista = new VentanaConsultarLista();
			miConsultarLista.setVisible(true);
		}else if (e.getSource()==btnEliminarPersona) {
			VentanaEliminar miVentanaEliminar = new VentanaEliminar();
			miVentanaEliminar.setVisible(true);
			
		}
	}
    
    
}

