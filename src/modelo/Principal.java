package modelo;

import javax.swing.SwingUtilities;

import vista.MenuInicio;

public class Principal {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuInicio();
            }
        });
    }
}
