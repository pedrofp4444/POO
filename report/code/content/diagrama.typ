#let diagrama = {
  [
    = Diagrama de classes

    Nesta secção do relatório, será apresentada a construção do sistema com base no diagrama de classes. A ferramenta "Visual Paradigm" @visualParadigm foi utilizada para modelar o sistema, empregando a notação UML (Unified Modeling Language) para a representação gráfica das classes e as suas relações.

    O diagrama de classes é uma parte crucial do design do sistema, pois oferece uma visão estrutural dos componentes da aplicação. Descreve as classes que compõem o sistema, os seus atributos e métodos, além de ilustrar as relações entre as classes, como herança, associação e dependência.

    Ao apresentar o diagrama de classes, esta secção fornecerá uma visão abrangente da estrutura do sistema, destacando as classes principais, as suas responsabilidades, atributos e métodos, bem como as interações entre elas. Isso garantirá uma base sólida para entender a arquitetura do sistema e como ele foi projetado para atender aos requisitos estabelecidos inicialmente.

    == Modelação das Atividades

    Começou-se por modelar as atividades de acordo com o padrão Abstract Factory anteriormente apresentado. Nesse contexto, criou-se uma interface denominada "ActivityInterface", que obriga à implementação de métodos essenciais ao bom funcionamento da aplicação, como calculateCaloricWaste().

    #figure(
        kind: image,
        caption: [Representação da interface "ActivityInterface" no diagrama de classes.],
        image("../images/diagrama-1.png", width: 40%)
    )

    Em seguida, estabeleceu-se a classe abstrata "Activity", uma vez que o método mencionado anteriormente deve ser implementado de forma específica por cada tipo de atividade. Assim, ele é declarado como _abstract_ na classe "Activity", tornando-a também abstrata.

    #figure(
        kind: image,
        caption: [Representação da classe abstrata "Activity" no diagrama de classes.],
        image("../images/diagrama-2.png", width: 70%)
    )

    A seguir, foram criadas subclasses de "Activity" que representam os tipos previstos nos requisitos: "Distance" (_extends_ "Activity") e "Repetitions" (_extends_ "Activity"). Além disso, existem mais duas classes derivadas destas: "DistanceWithAltimetry" (_extends_ "Distance") e "RepetitionsWithWeight" (_extends_ "Repetitions").

    #grid(
      columns: 1,
      row-gutter: 10pt,
      [#figure(
        kind: image,
        caption: [Representação da classe abstrata "Repetitions" no diagrama de classes.],
        image("../images/diagrama-3.png", width: 110%)
      )], 
      [#figure(
        kind: image,
        caption: [Representação da classe abstrata "Distance" no diagrama de classes.],
        image("../images/diagrama-4.png", width: 110%)
      )],
      [#figure(
        kind: image,
        caption: [Representação da classe abstrata "RepetitionsWithWeights" no diagrama de classes.],
        image("../images/diagrama-5.png", width: 110%)
      )],       
      [#figure(
        kind: image,
        caption: [Representação da classe abstrata "DistanceWithAltimetry" no diagrama de classes.],
        image("../images/diagrama-6.png", width: 110%)
      )], 
    )

    Todas estas classes são abstratas, pois não implementam o método calculateCaloricWaste() diretamente, passando essa responsabilidade para as suas subclasses, como "PushUp" (_extends_ "Repetitions"), "WeightSquat" (_extends_ "RepetitionsWithWeight"), "Running" (_extends_ "Distance") e "Trail" (_extends_ "DistanceWithAltimetry"). Estas últimas implementam o método conforme necessário, herdando características e métodos das suas superclasses e cumprindo a obrigatoriedade de implementar os métodos específicos.

    #grid(
      columns: 1,
      row-gutter: 10pt,
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "PushUp" no diagrama de classes.],
        image("../images/diagrama-7.png", width: 110%)
      )], 
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "Running" no diagrama de classes.],
        image("../images/diagrama-8.png", width: 110%)
      )],
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "WeightSquat" no diagrama de classes.],
        image("../images/diagrama-9.png", width: 110%)
      )],       
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "Trail" no diagrama de classes.],
        image("../images/diagrama-10.png", width: 110%)
      )], 
    )

    Adicionalmente, define-se ainda a interface "Hard" para servir como identificador e colocar nas atividades o fator de serem difíceis ou não, permitindo facilidade de caracterização das atividades.

    #figure(
        kind: image,
        caption: [Representação da interface "Hard" no diagrama de classes.],
        image("../images/diagrama-11.png", width: 40%)
      )
    
    == Modelação dos Utilizadores

    Na modelação dos utilizadores, foi adotado o padrão Abstract Factory, criando uma estrutura consistente para a gestão de diferentes tipos de utilizadores na aplicação. O ponto de partida foi a definição da interface "UserInterface", que impõe a implementação de métodos essenciais para o correto funcionamento da aplicação.

    #figure(
        kind: image,
        caption: [Representação da interface "UserInterface" no diagrama de classes.],
        image("../images/diagrama-12.png", width: 30%)
      )

    Em seguida, estabeleceu-se a classe abstrata "User", responsável por implementar métodos comuns a todos os tipos de utilizadores e servir como base para as subclasses específicas. A classe "User" não contém métodos abstratos que devem ser implementados pelas subclasses mas previne que não hajam instâncias de "User" e sim dos seu tipos, de acordo com suas particularidades.

    #figure(
        kind: image,
        caption: [Representação da classe abstrata "User" no diagrama de classes.],
        image("../images/diagrama-13.png", width: 80%)
      )

    A partir dessa base, foram criadas três subclasses que representam os tipos de utilizadores previstos nos requisitos: "Amateur" (_extends_ "User"), "Occasional" (_extends_ "User") e "Professional" (_extends_ "User"). Cada uma dessas subclasses determina certas características que os distinguem entre si.

    #grid(
      columns: 1,
      row-gutter: 10pt,
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "Amateur" no diagrama de classes.],
        image("../images/diagrama-14.png", width: 110%)
      )], 
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "Occasional" no diagrama de classes.],
        image("../images/diagrama-15.png", width: 110%)
      )],
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "Professional" no diagrama de classes.],
        image("../images/diagrama-16.png", width: 110%)
      )],
    )

    Além disso, a aplicação possui um gestor de utilizadores, denominado "UserManager". Este gestor é responsável pela administração de todos os utilizadores na aplicação, mantendo um _Map_ que armazena os diferentes utilizadores registados, permitindo a fácil recuperação e gestão dos mesmos.

    #figure(
        kind: image,
        caption: [Representação da classe concreta "UserManager" no diagrama de classes.],
        image("../images/diagrama-17.png", width: 110%)
    )

    == Modelação dos Planos de Treino

    Na modelação dos planos de treino, foi adotada uma estrutura simples e eficaz para a gestão e implementação dos mesmos na aplicação. A classe concreta "TrainingPlan" representa um plano de treino específico e contém os dados e métodos necessários para definir e manipular um plano de treino, como a lista de atividades, data de início, e código do utilizador que tem o plano de treino.

    #figure(
        kind: image,
        caption: [Representação da classe concreta "TrainingPlan" no diagrama de classes.],
        image("../images/diagrama-18.png", width: 50%)
    )

    Além disso, a aplicação deverá incluir um gestor específico para planos de treino, denominado "TrainingPlanManager". Este gestor é responsável pela criação, armazenamento e gestão dos planos de treino na aplicação. Mantém um _Map_ que armazena os diferentes planos de treino. Também lida com a geração de planos de treino personalizados com base nas preferências e características do utilizador. Isso inclui a seleção das atividades mais adequadas, a programação de sessões de treino e a definição de metas alcançáveis para cada utilizador.

    #figure(
        kind: image,
        caption: [Representação da classe concreta "TrainingPlanManager" no diagrama de classes.],
        image("../images/diagrama-19.png", width: 120%)
    )
    
    == Modelação das classes de utilitários

    === Utilitários

    Começamos por criar a classe "MakeItFitDate" para acrescentar uma camada de abstração à gestão do tempo na nossa aplicação, desta forma garantimos, que ainda sofrendo alterações externos podemos manter a funcionalidade integra.

    #figure(
        kind: image,
        caption: [Representação da classe concreta "MakeItFitDate" no diagrama de classes.],
        image("../images/diagrama-20.png", width: 50%)
    )

    De seguida, com a possibilidade de interação com o utilizador, surge a necessidade de validar os endereços de email providenciados.

    #figure(
        kind: image,
        caption: [Representação da classe concreta "EmailValidator" no diagrama de classes.],
        image("../images/diagrama-21.png", width: 70%)
    )

    === Tempo

    Para uma melhor modularização e gestão do tempo na aplicação, previmos a criação de uma classe especifica para o efeito.

    #figure(
        kind: image,
        caption: [Representação da classe concreta "TimeManager" no diagrama de classes.],
        image("../images/diagrama-22.png", width: 40%)
    )

    === Menu

    Na unidade curricular foi-nos incentivado o uso de menus modulares que permitissem incutir versatilidade e conforto ao projeto, do qual surgiu a sugestão de criar um "Menu", que controla o comportamento dos "MenuItem", este que por si só, se associa a duas interfaces para otimização de utilização, a "PreCondition" e "Handler".

    #align(center)[
    #grid(
      columns: 1,
      row-gutter: 10pt, 
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "Menu" no diagrama de classes.],
        image("../images/diagrama-23.png", width: 30%)
      )],
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "MenuItem" no diagrama de classes.],
        image("../images/diagrama-24.png", width: 80%)
      )],
      [#figure(
        kind: image,
        caption: [Representação da interface "PreCondition" no diagrama de classes.],
        image("../images/diagrama-25.png", width: 25%)
      )],
      [#figure(
        kind: image,
        caption: [Representação da interface "Handler" no diagrama de classes.],
        image("../images/diagrama-26.png", width: 24%)
      )],
    )
    ]

    === Estatísticas

    Construção de um gestor para as estatísticas pedidas no enunciado do projeto.
    
    #figure(
        kind: image,
        caption: [Representação da classe concreta "QueriesManager" no diagrama de classes.],
        image("../images/diagrama-27.png", width: 90%)
    )

    === Exceções

    Com o seguimento do projeto surgiu o objetivo de especificar algumas exceções já presentes na tecnologia e, como tal, dedicámos algumas classes à sua definição e implementação.

    #align(center)[
    #grid(
      columns: 1,
      row-gutter: 10pt, 
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "ExistingEntityConflictException" no diagrama de classes.],
        image("../images/diagrama-28.png", width: 50%)
      )],
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "InvalidTypeException" no diagrama de classes.],
        image("../images/diagrama-29.png", width: 50%)
      )],
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "EntityDoesNotExistException" no diagrama de classes.],
        image("../images/diagrama-30.png", width: 50%)
      )],
    )
    ]

    == Modelação do MVC

    Na modelação do MVC (Model-View-Controller), estruturámos a nossa aplicação com base nos três componentes principais: Modelo, Controlador e Vistas. O modelo representa a lógica de dados da aplicação, enquanto o controlador gere as interações entre o utilizador e o sistema, e as vistas apresentam os dados ao utilizador.

    O nosso modelo, denominado "MakeItFit", é responsável por encapsular as funcionalidades principais da aplicação, incluindo a gestão de utilizadores, atividades e planos de treino. O modelo também é responsável pela manipulação de dados e pela aplicação das regras previstas.

    #figure(
        kind: image,
        caption: [Representação da classe concreta "MakeItFit" no diagrama de classes.],
        image("../images/diagrama-31.png", width: 110%)
    )

    O controlador, denominado "MakeItFitController", atua como intermediário entre o modelo e as vistas. Ele processa as entradas do utilizador, recebidas através das vistas, e coordena as respostas adequadas, atualizando o modelo conforme necessário e transmitindo os dados atualizados para as vistas.

    #figure(
        kind: image,
        caption: [Representação da classe concreta "MakeItFitController" no diagrama de classes.],
        image("../images/diagrama-32.png", width: 110%)
    )
    
    Quanto às vistas, criámos duas subclasses da "MakeItFitView": "UserView" e "AdminView". A "UserView" é voltada para a interação com utilizadores comuns, fornecendo uma interface para realizar atividades, visualizar planos de treino e acompanhar o progresso. A "AdminView" é destinada aos administradores da aplicação, permitindo-lhes gerir utilizadores, atividades e planos de treino de uma maneira mais abrangente.

    #align(center)[
    #grid(
      columns: 2,
      row-gutter: 10pt, 
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "AdminView" no diagrama de classes.],
        image("../images/diagrama-33.png", width: 80%)
      )],
      [#figure(
        kind: image,
        caption: [Representação da classe abstrata "MakeItFitView" no diagrama de classes.],
        image("../images/diagrama-34.png", width: 50%)
      )],
      [#figure(
        kind: image,
        caption: [Representação da classe concreta "UserView" no diagrama de classes.],
        image("../images/diagrama-35.png", width: 50%)
      )],
    )
    ]

    == Modelação final

    Finalmente, foram estabelecidas todas as relações entre as várias representações apresentadas, algumas que, com o avançar do projeto, sofreram pequenas alterações. Como o diagrama de classes final não é apresentável no espaço reservado para este ficheiro, está disponibilizado como anexo externo na mesma diretoria do relatório atual.
  ]
}
