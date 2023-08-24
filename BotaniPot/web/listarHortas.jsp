<%@page import="src\java\prototipobotani\Horta.java"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%       
        // resgata id e nome do cliente para continuar utilizando dentro do sistema até dar logoff -- inicio
        Integer vidCliente             = Integer.parseInt(request.getParameter("idPegaHorta"));
        // resgata id e nome do cliente para continuar utilizando dentro do sistema até dar logoff -- fim
        
        Horta hor = new Horta();
        
        hor.setIdCliente(vidCliente);
        
        hor.listarHortas();
        %>
    </body>
</html>