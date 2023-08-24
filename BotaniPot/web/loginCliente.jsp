<%@page import="src\java\prototipobotani\Cliente.java"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Cliente cli = new Cliente();
        cli.setEmail(email);
        cli.setSenha(senha);
        cli.loginCliente();
        
        if (cli != null) {
            response.sendRedirect("paginaInicial.jsp?nomecliente=" + cli.getNome() + " &idCliente=" + cli.getIdCliente());
            }
        %>
    </body>
</html>
