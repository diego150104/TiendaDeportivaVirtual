<%@ page
    import="
        java.io.*,
        java.util.*,
        com.BO.TiendaDeportivaVirtual.*,
        com.VO.TiendaDeportivaVirtual.*"
%>
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
    user.registrarPersona(userVo); 
%>
<head>
<title>Page Redirection</title>
</head>
<body>
    <h1>Using GET Method to Read Form Data</h1>
    <ul>
        <li><p>
                <b>Cédula</b>
                <%= request.getParameter("cedula_usuario")%>
            </p></li>
    </ul>
</body>
</html>