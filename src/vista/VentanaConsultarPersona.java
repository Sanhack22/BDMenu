package vista;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.PersonaDao;
import vo.PersonaVo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaConsultarPersona extends JFrame  {
	JTable miTabla;
    JScrollPane miBarra;
    public VentanaConsultarPersona() {
        // Configuración de la ventana
        setTitle("Ventana de Búsqueda");
        setSize(603, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        inicializarComponentes();
        contruirTabla();
    }
    


    private void contruirTabla() {
    	String titulos[]= {"ID","Nombre","Edad","Profesion","Telefono"};
    	String informacion[][]= obtenerMatriz();
    	miTabla = new JTable(informacion,titulos);
    	miBarra.setViewportView(miTabla);
	}



	private String[][] obtenerMatriz() {
		PersonaDao miPersonaDao1 = new PersonaDao();
		int Doc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento"));
		ArrayList<PersonaVo>miLista=miPersonaDao1.buscarUsuarioConMatriz(Doc);

		String matrizInfo[][]=new String[miLista.size()][5];
		
		for (int i = 0; i < miLista.size(); i++) {
			
			matrizInfo[i][0]=miLista.get(i).getIdPersona()+"";
			matrizInfo[i][1]=miLista.get(i).getNombrePersona()+"";
			matrizInfo[i][2]=miLista.get(i).getEdadPersona()+"";
			matrizInfo[i][3]=miLista.get(i).getProfesionPersona()+"";
			matrizInfo[i][4]=miLista.get(i).getTelefonoPersona()+"";
			
		}
		
		return matrizInfo;
	}



	private void inicializarComponentes() {
    	miBarra = new JScrollPane();
    	miBarra.setBounds(10, 86, 567, 165);
    	getContentPane().add(miBarra);
	}




	
}

