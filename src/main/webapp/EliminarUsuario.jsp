<%@ page
    import="
        java.io.*,
        java.util.*,
        com.BO.TiendaDeportivaVirtual.*,
        com.VO.TiendaDeportivaVirtual.*"
%>
<html>
<% 
    Usuarios user =new Usuarios();
    UsuarioVo userVo=new UsuarioVo();
    long cedula= Long.parseLong(request.getParameter("cedula_usuario"));
    userVo.setCedula_usuario(cedula);
    user.eliminarPersona(userVo);
%>
<head>
<title>Page Redirection</title>
</head>
<body>
    <h1>Using GET Method to Read Form Data</h1>
    <ul>
        <li><p>
                <b>C�dula</b>
                <%= request.getParameter("cedula_usuario")%>
            </p></li>
        <li><p>
                <b>Nombre Completo</b>
                <%= request.getParameter("nombre_usuario")%>
            </p></li>
        <li><p>
                <b>Correo Electr�nico</b>
                <%= request.getParameter("email_usuario")%>
            </p></li>
        <li><p>
                <b>Usuario</b>
                <%= request.getParameter("usuario")%>
        </p></li>
        <li><p>
                <b>Contrase�a</b>
                <%= request.getParameter("contrase�a")%>
        </p></li>
    </ul>
</body>
</html>