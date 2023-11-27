package dao;
import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import vo.PersonaVo;

import conexion.Conexion;

import vo.PersonaVo;

public class PersonaDao {

	/**
	 * Usa el objeto enviado para almacenar la persona
	 * @param miPersona
	 */
	public void registrarPersona(PersonaVo miPersona) {
		Conexion conex = new Conexion();

		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO persona VALUES ('"
					+ miPersona.getIdPersona() + "', '"
					+ miPersona.getNombrePersona() + "', '"
					+ miPersona.getEdadPersona() + "', '"
					+ miPersona.getProfesionPersona() + "', '"
					+ miPersona.getTelefonoPersona() + "')");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"No se Registro, verifique la consola para ver el error",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public PersonaVo consultarUsuario(int doc) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		PersonaVo miUsuario=new PersonaVo();
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM usuario where documento= ? ";
		
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setInt(1, doc);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miUsuario=new PersonaVo();
					miUsuario.setIdPersona(result.getInt("documento"));
					miUsuario.setNombrePersona(result.getString("nombre"));
					miUsuario.setProfesionPersona(result.getString("profesion"));
					miUsuario.setEdadPersona(result.getInt("edad"));
					miUsuario.setTelefonoPersona(result.getInt("telefono"));		
				}		
				   miConexion.desconectar();
			}else{
				miUsuario=null;
			}
			
			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: "+e.getMessage());
		}
		
		return miUsuario;
	}
	public ArrayList<PersonaVo> buscarUsuariosConMatriz() {

		Conexion conex = new Conexion();
		ArrayList<PersonaVo> miLista = new ArrayList<PersonaVo>();
		PersonaVo persona;
		try {
			Statement estatuto = conex.getConnection().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM persona");

			while (rs.next()) {
				persona = new PersonaVo();
				persona.setIdPersona(rs.getInt("documento"));
				persona.setNombrePersona(rs.getString("nombre"));
				persona.setEdadPersona(Integer.parseInt(rs.getString("edad")));
				persona.setProfesionPersona(rs.getString("profesion"));
				persona.setTelefonoPersona(Integer.parseInt(rs.getString("telefono")));
				miLista.add(persona);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
					JOptionPane.ERROR_MESSAGE);

		}
		return miLista;
	
	}
	public ArrayList<PersonaVo> buscarUsuarioConMatriz(int Doc) {

		Conexion conex = new Conexion();
		ArrayList<PersonaVo> miLista = new ArrayList<PersonaVo>();
		PersonaVo persona;
		try {
			if (existeUsuario(Doc)) {
			Statement estatuto = conex.getConnection().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM persona WHERE documento="+Doc+"");

			while (rs.next()) {
				persona = new PersonaVo();
				persona.setIdPersona(rs.getInt("documento"));
				persona.setNombrePersona(rs.getString("nombre"));
				persona.setEdadPersona(Integer.parseInt(rs.getString("edad")));
				persona.setProfesionPersona(rs.getString("profesion"));
				persona.setTelefonoPersona(Integer.parseInt(rs.getString("telefono")));
				miLista.add(persona);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();
			}else {
	            JOptionPane.showMessageDialog(null, "No existe un usuario con el documento especificado", "Información", JOptionPane.ERROR_MESSAGE);
	        }

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
					JOptionPane.ERROR_MESSAGE);

		}
		return miLista;
	}
	
	
	public void eliminarUsuario(int documentoUsuario) {
	    Conexion conex = new Conexion();
	    try {
	        // Verificar si el usuario con el documento especificado existe
	        if (existeUsuario(documentoUsuario)) {
	            Statement estatuto = conex.getConnection().createStatement();
	            String consultaSQL = "DELETE FROM persona WHERE documento = " + documentoUsuario+"";
	            estatuto.executeUpdate(consultaSQL);
	            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
	            estatuto.close();
	            conex.desconectar();
	        } else {
	            JOptionPane.showMessageDialog(null, "No existe un usuario con el documento especificado", "Información", JOptionPane.ERROR_MESSAGE);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al intentar eliminar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	
	private boolean existeUsuario(int documentoUsuario) {
	    Conexion conex = new Conexion();
	    try {
	        Statement estatuto = conex.getConnection().createStatement();
	        String consultaSQL = "SELECT COUNT(*) FROM persona WHERE documento = " + documentoUsuario;
	        ResultSet resultado = estatuto.executeQuery(consultaSQL);

	        if (resultado.next()) {
	            int count = resultado.getInt(1);
	            return count > 0;
	        }

	        estatuto.close();
	        conex.desconectar();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public PersonaVo buscarPersonaPorDocumento(int documento) {
	    Conexion conex = new Conexion();
	    PersonaVo persona = null; // Inicializar como nulo en caso de que no se encuentre

	    try {
	        Statement estatuto = conex.getConnection().createStatement();
	        String consultaSQL = "SELECT * FROM persona WHERE documento = " + documento;
	        ResultSet rs = estatuto.executeQuery(consultaSQL);

	        if (rs.next()) {
	            // Si se encuentra la persona, crear un objeto PersonaVo con los datos
	            persona = new PersonaVo();
	            persona.setIdPersona(rs.getInt("documento"));
	            persona.setNombrePersona(rs.getString("nombre"));
	            persona.setEdadPersona(rs.getInt("edad"));
	            persona.setProfesionPersona(rs.getString("profesion"));
	            persona.setTelefonoPersona(rs.getInt("telefono"));
	        }

	        rs.close();
	        estatuto.close();
	        conex.desconectar();

	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
	    }

	    return persona; // Devolver el objeto PersonaVo (puede ser nulo si no se encuentra)
	}


	
}