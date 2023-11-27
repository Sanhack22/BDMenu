package vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dao.PersonaDao;
import vo.PersonaVo;

public class VentanaConsultarLista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTable miTabla;
    JScrollPane miBarra;
	
	public VentanaConsultarLista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
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
			ArrayList<PersonaVo>miLista=miPersonaDao1.buscarUsuariosConMatriz();

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
