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
        Integer vidCliente             = Integer.parseInt(request.getParameter("idCliente"));
        String  vNomeCliente           = request.getParameter("nomeCliente");
        // resgata id e nome do cliente para continuar utilizando dentro do sistema até dar logoff -- fim
        
        String nome                    = request.getParameter("nomeHorta"); 
        Integer umidadePercentual      = Integer.parseInt(request.getParameter("porcentagemAgua"));
        Integer solarPercentual        = Integer.parseInt(request.getParameter("porcentagemSol"));
        Double aguaRecomendada         = Double.parseDouble(request.getParameter("aguaRecomendada"));
        
        
        
        Horta hor = new Horta();
        hor.setIdCliente(vidCliente);
        hor.setNome(nome);
        hor.setUmidadePercentual(umidadePercentual);
        hor.setSolarPercentual(solarPercentual);
        hor.setAguaRecomendada(aguaRecomendada);
        
        if (hor.incluirHorta()) {
            response.sendRedirect("paginaInicial.jsp?idCliente=" + vidCliente + "&nomecliente=" + vNomeCliente);
            }
            else {
            alert("Deu ruim");
            }
        %>
    </body>
</html>