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
    userVo.setContrase�a(request.getParameter("contrase�a"));
    user.login(userVo.getUsuario(), userVo.getContrase�a());
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
                <b>Contrase�a</b>
                <%= request.getParameter("contrase�a")%>
            </p></li>
    </ul>
</body>
</html>