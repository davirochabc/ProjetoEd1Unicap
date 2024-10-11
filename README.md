<h1>Projeto Java</h1>
<h2>Alunos: João Victor Muniz Rocha e Davi Rocha de Barros Carvalho</h2>
<p>Este é um sistema de gerenciamento para uma clínica médica, eventos e um restaurante, desenvolvido em Java. 
  Ele permite gerenciar consultas médicas, eventos e reservas de mesas e pedidos em um restaurante.
  O sistema possui menus interativos e funcionalidades específicas para cada um dos três módulos.</p>
<h2>Estrutura do projeto</h2>
<p>O projeto é dividido em três módulos principais:</p>
<h3>1. Clínica Médica</h3>
<p>Gerencia pacientes e médicos, incluindo funcionalidades para:</p>
<h4>
  
-  Adicionar médicos<br> 
  
-  Remover médicos <br>
  
-  Adicionar pacientes<br>

-  Remover pacientes<br>

-  Adicionar consultas<br>

-  Remover consultas<br>

-  Buscar pacientes e médicos<br>
</h4>

<h3>2. Evento</h3>
<p>Gerencia eventos e participantes, incluindo funcionalidades para:</p>
<h4>
  
-  Adicionar evento<br> 
  
-  Remover evento <br>
  
-  Adicionar participantes<br>

-  Remover participantes<br>

-  Buscar eventos<br>

-  Buscar inscrições<br>

-  Imprimir lista de eventos<br>
</h4>

<h3>3. Restaurante</h3>
<p>Gerencia mesas e pedidos, incluindo funcionalidades para:</p>
<h4>
  
-  Reservar mesas<br> 
  
-  Fazer pedidos <br>
  
-  Adicionar pedidos<br>

-  Fechar contas<br>

-  Buscar mesas e pedidos<br>

</h4>
<h2>Linha de raciocínio</h2>
<h3>Pastas:</h3>
<p>Criei uma pasta entities para ser mais fácil a importação das classes e comecei criando todas as classes, constructors e getters and setters.</p>
<h3>Lógica das List</h3>
<p>Visualizei quem seriam as classes que iriam iniciar minhas List e fariam as funções de busca e impressão (CliniaMedica, Restaurante, Mesas e Evento)</p><br>
  <p>Porém me chamou a atenção a classe Restaurante. Não faria sentido criar uma List de pedidos na classe Restaurante, haja vista que só existe pedido se estiver alguem em alguma mesa. Logo, fiz a lista de pedidos na classe mesa e instanciar ela de acordo com a mesa, ficou mais facil de entender e mais simples de atualizar os dados corretamente.</p>
<h3>Lógica por tras do Main</h3>  
<p>Após organizar todas as classes e List, instanciei todos os construtores no main para a manipulação nos switch case ficasse mais simples. Fiz um menu principal para o usuario decidir em que setor ele quer manipular e fiz 3 funções, uma para cada setor</p>

