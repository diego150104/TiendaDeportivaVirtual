package com.DAO.TiendaDeportivaVirtual;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.VO.TiendaDeportivaVirtual.ClienteVo;


public class ClienteDao extends Conexion {
	public void registrarPersona(ClienteVo Persona ) {
		try {
			Conectar();
			PreparedStatement sentencia = Conexion.prepareStatement("Insert into clientes(cedula_cliente, direccion_cliente, email_cliente, nombre_cliente, telefono_cliente) values (?,?,?,?,?)");
			sentencia.setLong(1, Persona.getCedula_cliente());
			sentencia.setString(2, Persona.getDireccion_cliente());
			sentencia.setString(3, Persona.getEmail_cliente());
			sentencia.setString(4, Persona.getNombre_cliente());
			sentencia.setString(5, Persona.getTelefono_cliente());
			sentencia.executeUpdate();
			Desconectar();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void actualizarPersona(Long cedulaCliente, ClienteVo Persona) {
		try {
			Conectar();
			PreparedStatement sentencia = Conexion.prepareStatement("Update clientes set direccion_client = ?, email_cliente = ?, nombre_cliente = ?, telefono_cliente = ? where cedula_cliente = ?");
			
			sentencia.setString(1, Persona.getDireccion_cliente());
			sentencia.setString(2, Persona.getEmail_cliente());
			sentencia.setString(3, Persona.getNombre_cliente());
			sentencia.setString(4, Persona.getTelefono_cliente());
			sentencia.setLong(5, cedulaCliente);
			sentencia.executeUpdate();
			Desconectar();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void eliminarPersona(Long cedulaCliente, ClienteVo Persona) {
		try {
			Conectar();
			PreparedStatement sentencia = Conexion.prepareStatement("delete from clientes where cedula_cliente = ?");
			
			sentencia.setLong(1, cedulaCliente);
			sentencia.executeUpdate();
			Desconectar();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<ClienteVo> consultarPersonas() {
		try {
			List<ClienteVo> Personas = new ArrayList();
			Conectar();
			PreparedStatement sentencia = Conexion.prepareStatement("select * from clientes");
			ResultSet datos = sentencia.executeQuery();
			while (datos.next()) {
				ClienteVo Persona = new ClienteVo();
				Persona.setCedula_cliente(datos.getLong("cedula_cliente"));
				Persona.setDireccion_cliente(datos.getString("direccion_cliente"));
				Persona.setEmail_cliente(datos.getString("email_cliente"));
				Persona.setNombre_cliente(datos.getString("nombre_cliente"));
				Persona.setTelefono_cliente(datos.getString("telefono_cliente"));
				Personas.add(Persona);
			}
			Desconectar();
			return Personas;
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}
