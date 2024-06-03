#let mvc = {
  [
    = Model-View-Controller

    Nesta secção, abordamos o conceito de MVC (Model-View-Controller) e a sua aplicação na nossa aplicação. O padrão MVC é uma abordagem amplamente reconhecida que separa a lógica de dados, a apresentação e o controlo de uma aplicação. Esta organização modular não apenas facilita a manutenção e escalabilidade do sistema, mas também melhora a clareza e flexibilidade do código. Aqui, explicamos como o padrão MVC foi implementado na nossa aplicação, destacando as vantagens e desafios associados a essa estrutura.

    == Conceito do MVC

    O padrão de design MVC (Model-View-Controller) é um dos mais utilizados na programação orientada aos objetos para a organização de aplicações, principalmente em casos com interfaces de utilizador. O padrão separa a lógica do programa em três componentes distintos: o Modelo (Model), a Vista (View) e o Controlador (Controller), proporcionando uma estrutura clara e modular para o desenvolvimento de aplicações.

    *Modelo (Model)*: O modelo representa a camada de dados da aplicação e é responsável pela lógica de dados. Ele define a estrutura dos dados e mantém seu estado, além de gerir operações como armazenamento, recuperação e manipulação dos dados. O modelo não interage diretamente com a vista, o que permite uma maior independência entre as camadas.

    *Vista (View)*: A vista é responsável pela apresentação dos dados ao utilizador. Ela recebe informações do controlador e exibe os dados do modelo de acordo com os requisitos da interface de utilizador. As vistas devem ser flexíveis para se adaptarem a diferentes estilos de apresentação e dispositivos.

    *Controlador (Controller)*: O controlador atua como intermediário entre o modelo e a vista. Ele recebe entradas do utilizador através da vista e processa essas entradas, manipulando o modelo de acordo com as ações do utilizador. Em seguida, o controlador atualiza a vista com os dados do modelo atualizados.

    Ao utilizar o padrão MVC, conseguimos separar as responsabilidades de cada componente, o que torna o código mais organizado e facilita a manutenção e a escalabilidade da aplicação. Além disso, esta separação permite a reutilização de código, já que as mudanças numa camada não necessariamente impactam as outras.

    == Implementação do modelo

    De acordo com a modelagem do diagrama de classes e a correta implementação do padrão Facade, conseguimos avançar com a implementação do MVC. Centralizando todos os métodos funcionais numa única classe chamada "MakeItFit", passámos a disponibilizar esses métodos no nosso controlador, o "MakeItFitController". Este controlador inclui algumas variáveis de instância, como o email e o nome, para aprimorar a distinção entre as informações passadas para as vistas e a manipulação de dados.

    Desta forma, a vista não tem acesso direto aos dados, pois, a cada solicitação, o email é associado diretamente aos métodos que posteriormente acionam métodos do modelo ("MakeItFit"). Adicionalmente, as vistas armazenam variáveis de instância, como o tipo de atividade ou utilizador atualmente selecionado, para otimizar o processamento das informações.

    Todos os métodos na vista ("MakeItFitView") são responsáveis por interagir com o utilizador e por enviar as informações corretas para o controlador ("MakeItFitController"), que, por sua vez, as filtra, processa e encaminha ao modelo ("MakeItFit"). Além disso, os menus foram adicionados para oferecer uma orientação sequencial na aplicação e apresentar de forma consistente as opções disponíveis ao utilizador para uso da plataforma.
  ]
}
