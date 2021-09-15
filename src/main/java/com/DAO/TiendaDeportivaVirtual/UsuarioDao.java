package com.DAO.TiendaDeportivaVirtual;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.VO.TiendaDeportivaVirtual.UsuarioVo;



public class UsuarioDao extends Conexion {
	public void registrarPersona(UsuarioVo Usuario) {
		try {
			Conectar();
			PreparedStatement sentencia = Conexion.prepareStatement("Insert into usuarios(cedula_usuario, nombre_usuario, email_usuario, usuario, contraseña) values (?,?,?,?,?)");
			sentencia.setLong(1, Usuario.getCedula_usuario());
			sentencia.setString(2, Usuario.getNombre_usuario());
			sentencia.setString(3, Usuario.getEmail_usuario());
			sentencia.setString(4, Usuario.getUsuario());
			sentencia.setString(5, Usuario.getContraseña());
			sentencia.executeUpdate();
			Desconectar();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void actualizarPersona(UsuarioVo Usuario) {
		try {
			Conectar();
			PreparedStatement sentencia = Conexion.prepareStatement("Update usuarios set email_usuario = ?, nombre_usuario = ?, contrase�a = ?, usuario = ? where cedula_usuario = ?");
			
			sentencia.setString(1, Usuario.getNombre_usuario());
			sentencia.setString(2, Usuario.getEmail_usuario());
			sentencia.setString(3, Usuario.getUsuario());
			sentencia.setString(4, Usuario.getContraseña());
			sentencia.setLong(5, Usuario.getCedula_usuario());
			sentencia.executeUpdate();
			Desconectar();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void eliminarPersona(Long cedulaUsuario) {
		try {
			Conectar();
			PreparedStatement sentencia = Conexion.prepareStatement("delete from usuarios where cedula_usuario = ?");
			sentencia.setLong(1, cedulaUsuario);
			sentencia.executeUpdate();
			Desconectar();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<UsuarioVo> consultarPersona(long cedula_usuario) {
		try {
			ArrayList<UsuarioVo> Usuarios = new ArrayList<UsuarioVo>();
			Conectar();
			PreparedStatement sentencia = Conexion.prepareStatement("select * from usuarios where cedula_usuario= ?");
			sentencia.setLong(1, cedula_usuario);
			ResultSet datos = sentencia.executeQuery();
			while (datos.next()) {
				UsuarioVo Usuario = new UsuarioVo();
				Usuario.setCedula_usuario(datos.getLong("cedula_usuario"));
				Usuario.setNombre_usuario(datos.getString("nombre_usuario"));
				Usuario.setEmail_usuario(datos.getString("email_usuario"));
				Usuario.setContraseña(datos.getString("contraseña"));
				Usuario.setUsuario(datos.getString("usuario"));
				Usuarios.add(Usuario);
			}
			Desconectar();
			return Usuarios;
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void login(String Usuario, String Contraseña) {
		try {
			Conectar();
			PreparedStatement sentencia = Conexion.prepareStatement("select * from usuarios where usuario = ? and contraseña = ?");
			sentencia.setString(1, Usuario);
			sentencia.setString(2, Contraseña);
			ResultSet datos = sentencia.executeQuery();
			if (datos != null) {
				JOptionPane.showMessageDialog(null,"Bienvenido, ingreso exitoso"); 
			Desconectar();
			} else {
				JOptionPane.showMessageDialog(null,"Error el usuario o contraseña no existen");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}