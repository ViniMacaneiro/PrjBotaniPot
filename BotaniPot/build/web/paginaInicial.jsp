<!DOCTYPE html>

    <head>
        <title>BotanyPot</title>
        <meta charset="UTF-16">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Estilos/paginaInicial.css" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Dosis:200,300,regular,500,600,700,800" rel="stylesheet" />
        <link rel="shortcut icon" href="Imagens/icone.png"/>
    </head>
    
        <div class="box" onload="consultarClienteId()">
            <div class="caixaSelecao">
                <img src="Imagens/icone.png" alt="icone">
                <a href="index.html" class="iconeLogout"></a>
                    <h1 class="tituloPagina">BotaniPot</h1> <br>
                    <hr id="linhaVerde">
                    <div id="texto">
                        <%
                        out.write("Bem vindo " + request.getParameter("nomecliente"));
                        %>                        
                        <button type="button" value="Cadastrar Horta" class="botaoCadastro" id="abrirModal">Cadastrar Horta</button>
                        
                        <div id="modal" class="modal">
                            <div class="modal-conteudo">
                                <span class="fechar" id="fecharModal"></span>
                                <ul>
                                    <li><h2>Cadastrar Horta</h2></li>
                                    <li><form action="cadastraHorta.jsp" method="post">
                                            <input type="text" class="cadastrarNome" placeholder="Nome da Horta" name="nomeHorta" required>
                                            <% int    vIdCliente = Integer.parseInt(request.getParameter("idCliente")); 
                                               String nomeCliente = request.getParameter("nomecliente");
                                            %>
                                            <input type='hidden' id='idCliente' name='idCliente' value="<% out.write(""+vIdCliente);%>">
                                            <input type='hidden' id='nomeCliente' name='nomeCliente' value="<% out.write(nomeCliente);%>">

                                            <label id="titulo"><b>Tipo de solo</b></label><br>
                                            <input type="radio" name="solo" value="seco" onclick="soloSeco()"> Seco <br>
                                            <input type="radio" name="solo" value="encharcado" onclick="soloEncharcado()"> Encharcado <br>
                                            <input type="radio" name="solo" value="umido" onclick="soloUmido()"> Úmido <br>
                                            <input type="radio" name="solo" value="personalizado" checked id="personalizado"> Personalizado <br>
                                            
                                            <label><b>Porcentagem de Umidade</b></label>
                                            <input type="range" id="sliderAgua" name="porcentagemAgua" min="0" max="100" step="1">
                                            <span id="valorSliderAgua">50%</span> <br>
                                            
                                            <label><b>Porcentagem de Luz Solar</b></label>
                                            <input type="range" id="sliderSol" name="porcentagemSol" min="0" max="100" step="1">
                                            <span id="valorSliderSol">50%</span> <br>
                                            
                                            <input type="number" class="cadastrarNome" placeholder="Quantidade de Água (ml)" name="aguaRecomendada" required value="">
                                            
                                            <input type="submit" class="cadastroHorta">
                                            </form>
                                      </li>
                                </ul>
                            </div>
                        </div>
                                                                        <!-- Área do Java -->
                        <script>
                            const abrirModalBtn                 = document.getElementById('abrirModal');
                            const modal                         = document.getElementById('modal');
                            const fecharModalBtn                = document.getElementById('fecharModal');

                            abrirModalBtn.addEventListener('click', function () {
                                modal.style.display             = 'block';
                            });

                            fecharModalBtn.addEventListener('click', function () {
                                modal.style.display             = 'none';
                            });

                            window.addEventListener('click', function (event) {
                                if (event.target === modal) {
                                    modal.style.display         = 'none';
                                }
                            });
                        </script>
                        
                        <script>
                            const sliderAgua                    = document.getElementById('sliderAgua');
                            const valorSliderAgua               = document.getElementById('valorSliderAgua');

                            sliderAgua.addEventListener('input', function() {
                              const valorA = sliderAgua.value;
                              valorSliderAgua.textContent       = valorA + '%';
                            });                            
                        </script>
                        
                        <script>
                            const sliderSol                     = document.getElementById('sliderSol');
                            const valorSliderSol                = document.getElementById('valorSliderSol');

                            sliderSol.addEventListener('input', function() {
                              const valorS                      = sliderSol.value;
                              valorSliderSol.textContent        = valorS + '%';
                            });                            
                        </script>
                        
                        <script>
                            const sliderSol02                   = document.getElementById('sliderSol');
                            const valorSliderSol02              = document.getElementById('valorSliderSol');
                            const sliderAgua02                  = document.getElementById('sliderAgua');
                            const valorSliderAgua02             = document.getElementById('valorSliderAgua');
                            const aguaRecomendada               = document.getElementById('aguaRecomendada');
                            const solo                          = document.getElementById('solo');
    
                            function soloSeco() {
                                sliderAgua02.value              = 30;
                                sliderSol02.value               = 70;
                                valorSliderAgua02.textContent   = '30%';
                                valorSliderSol02.textContent    = '70%';
                                aguaRecomendada.textContent     = '50';
                            }
                            
                            function soloEncharcado() {
                                sliderAgua02.value              = 60;
                                sliderSol02.value               = 50;
                                valorSliderAgua02.textContent   = '60%';
                                valorSliderSol02.textContent    = '50%';
                                aguaRecomendada.value           = '200';
                            }
                            
                            function soloUmido() {
                                sliderAgua02.value              = 50;
                                sliderSol02.value               = 40;
                                valorSliderAgua02.textContent   = '50%';
                                valorSliderSol02.textContent    = '40%';
                                aguaRecomendada.value           = 100;
                            }
                        </script>
                        
                        <script>
                            
                            function pegarId () {
                                Integer idPegado = idCliente;
                            
                            return = idPegado;}
                            
                            
                        </script>
                        
                    </div>
            </div>
        </div>
            
    
