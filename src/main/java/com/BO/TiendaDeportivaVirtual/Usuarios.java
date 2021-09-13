package com.BO.TiendaDeportivaVirtual;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TiendaDeportivaVirtual.UsuarioDao;
import com.VO.TiendaDeportivaVirtual.UsuarioVo;

import antlr.collections.List;

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
	public void eliminarPersona(UsuarioVo Usuario)
	{
		UsuarioDao Dao= new UsuarioDao();
		Dao.eliminarPersona(Usuario);
	}
	@RequestMapping("/consultarUsuario")
	public List<UsuarioVo>consultarPersonas()
	{
		UsuarioDao Dao= new UsuarioDao();
		return Dao.consultarPersonas();
	}
	@RequestMapping("/login")
	public UsuarioVo login() 
	{
		UsuarioDao Dao = new UsuarioDao();
		return Dao.login();
		
	}
}
