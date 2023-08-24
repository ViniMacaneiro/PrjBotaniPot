<%@page import="prototipobotani.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String nome           = request.getParameter("nome");  
        String email          = request.getParameter("email");
        String senha          = request.getParameter("senha");
        String senhaConfirmar = request.getParameter("senhaConfirmar");
                    
        Cliente cli = new Cliente();
        cli.setNome(nome);
        cli.setEmail(email);
        cli.setSenha(senha);
        
        if (equals(senha) == equals(senhaConfirmar)) {
            if(cli.incluirCliente()){
                response.sendRedirect("index.html");
                } else {
                response.sendRedirect("erro.html");
                }
        } else {
            response.sendRedirect("senhaInvalida.html");
        }
        %>
    </body>
</html>
