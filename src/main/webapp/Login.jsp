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
    userVo.setUsuario(request.getParameter("usuario"));
    userVo.setContraseña(request.getParameter("contraseña"));
    user.login(userVo.getUsuario(), userVo.getContraseña());
%>
<head>
<title>Page Redirection</title>
</head>
<body>
    <h1>Using GET Method to Read Form Data</h1>
    <ul>
        <li><p>
                <b>Usuario</b>
                <%= request.getParameter("usuario")%>
            </p></li>
        <li><p>
                <b>Contraseña</b>
                <%= request.getParameter("contraseña")%>
            </p></li>
    </ul>
</body>
</html>