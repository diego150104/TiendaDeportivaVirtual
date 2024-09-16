package com.BO.TiendaDeportivaVirtual;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TiendaDeportivaVirtual.UsuarioDao;
import com.VO.TiendaDeportivaVirtual.UsuarioVo;


@RestController
public class Usuarios {
	/*Registrar Usuarios*/
	@RequestMapping("/registrarUsuario")
	public void registrarPersona(UsuarioVo Usuario)
	{
		UsuarioDao Dao=new UsuarioDao();
		Dao.registrarPersona(Usuario);	
	}
	@RequestMapping("/ActualizarUsuario")
	public void actualizarPersona(UsuarioVo Usuario)
	{
		UsuarioDao Dao=new UsuarioDao();
		Dao.actualizarPersona(Usuario);	
	}
	@RequestMapping("eliminarUsuario")
	public void eliminarPersona(Long cedulaUsuario)
	{
		UsuarioDao Dao= new UsuarioDao();
		Dao.eliminarPersona(cedulaUsuario);
	}
	@RequestMapping("/consultarUsuario")
	public ArrayList<UsuarioVo> consultarPersona(long cedula_usuario){
		UsuarioDao Dao= new UsuarioDao();
		return Dao.consultarPersona(cedula_usuario);
	}
	@RequestMapping("/login")
	public void login(String Usuario, String Contraseña) 
	{
		UsuarioDao Dao = new UsuarioDao();
		Dao.login(Usuario, Contraseña);
		
	}
}
