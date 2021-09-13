package com.DAO.TiendaDeportivaVirtual;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.VO.TiendaDeportivaVirtual.UsuarioVo;



public class UsuarioDao extends Conexion {
	public void registrarPersona(UsuarioVo Usuario) {
		try {
			Conectar();
			PreparedStatement sentencia = Conexion.prepareStatement("Insert into usuarios(cedula_usuario, email_usuario, nombre_usuario, contrase�a, usuario) values (?,?,?,?,?)");
			sentencia.setLong(1, Usuario.getCedula_usuario());
			sentencia.setString(2, Usuario.getEmail_usuario());
			sentencia.setString(3, Usuario.getNombre_usuario());
			sentencia.setString(4, Usuario.getContraseña());
			sentencia.setString(5, Usuario.getUsuario());
			sentencia.executeUpdate();
			Desconectar();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void actualizarPersona(Long cedulaUsuario, UsuarioVo Usuario) {
		try {
			Conectar();
			PreparedStatement sentencia = Conexion.prepareStatement("Update usuarios set email_usuario = ?, nombre_usuario = ?, contrase�a = ?, usuario = ? where cedula_usuario = ?");
			
			sentencia.setString(1, Usuario.getEmail_usuario());
			sentencia.setString(2, Usuario.getNombre_usuario());
			sentencia.setString(3, Usuario.getContraseña());
			sentencia.setString(4, Usuario.getUsuario());
			sentencia.setLong(5, cedulaUsuario);
			sentencia.executeUpdate();
			Desconectar();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void eliminarPersona(Long cedulaUsuario, UsuarioVo Usuario) {
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
	
	public List<UsuarioVo> consultarPersonas() {
		try {
			List<UsuarioVo> Usuarios = new ArrayList();
			Conectar();
			PreparedStatement sentencia = Conexion.prepareStatement("select * from clientes");
			ResultSet datos = sentencia.executeQuery();
			while (datos.next()) {
				UsuarioVo Usuario = new UsuarioVo();
				Usuario.setCedula_usuario(datos.getLong("cedula_usuario"));
				Usuario.setEmail_usuario(datos.getString("email_usuario"));
				Usuario.setNombre_usuario(datos.getString("nombre_usuario"));
				Usuario.setContraseña(datos.getString("contrase�a"));
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
	
	public UsuarioVo login(String Usuario, String Contraseña) {
		try {
			UsuarioVo entrar = new UsuarioVo();
			Conectar();
			PreparedStatement sentencia = Conexion.prepareStatement("select * from usuarios where usuario = ? and contrase�a = ?");
			sentencia.setString(1, Usuario);
			sentencia.setString(2, Contraseña);
			ResultSet datos = sentencia.executeQuery();
			if (datos != null) {
				entrar.setCedula_usuario(datos.getLong("cedula_usuario"));
				entrar.setEmail_usuario(datos.getString("email_usuario"));
				entrar.setNombre_usuario(datos.getString("nombre_usuario"));
				entrar.setContraseña(datos.getString("contrase�a"));
				entrar.setUsuario(datos.getString("usuario"));
				Desconectar();
				return entrar;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}