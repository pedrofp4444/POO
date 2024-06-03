#let introducao = {
  [
    = Introdução
    
    Este relatório tem como objetivo abordar o projeto prático da Unidade Curricular de Programação Orientada a Objetos (POO) do ano letivo 2023/2024. Serão discutidas as decisões tomadas, as funcionalidades implementadas pelo grupo, bem como o método de raciocínio adotado para o desenvolvimento do projeto final. O objetivo deste trabalho consistiu no desenvolvimento de uma aplicação abrangente para a gestão de atividades físicas e planos de treino.
  
    O enunciado do projeto estabeleceu requisitos progressivos, desde funcionalidades básicas de criação e gestão de entidades até recursos avançados, como a geração automática de planos de treino de acordo com objetivos específicos dos utilizadores. Ao longo deste relatório, abordaremos as decisões de design, a arquitetura de classes adotada, bem como os desafios enfrentados e as soluções implementadas para atender a todos os requisitos propostos.

    == Organização de requisitos

    Para dar início ao projeto, procedeu-se a uma análise detalhada dos requisitos apresentados no enunciado, que serviu de base para definir os três pilares fundamentais da aplicação:

      - *Atividades*: Engloba o registo, classificação e gestão de uma variedade de atividades físicas, desde as que envolvem distância e altimetria até as que consistem em séries de repetições com ou sem pesos.
      
      - *Utilizadores*: Inclui a criação e gestão de perfis de utilizadores, contemplando diferentes níveis de experiência e objetivos, como profissionais, amadores e praticantes ocasionais.
    
      - *Planos de treino*: Abrange a elaboração de planos de treino personalizados para cada utilizador, levando em consideração os tipos de atividade, frequência, intensidade e objetivos pessoais.
    
    Desses pilares, foram definidos os seguintes requisitos generalizados para uma primeira fase de planeamento:

    + *Gestão de atividades e planos de treino:*
      
      - Desenvolver uma aplicação que permita gerir diferentes tipos de atividades físicas, como corrida, ciclismo, pilates, levantamento de pesos, entre outras.
      
      - Permitir a criação de planos de treino para utilizadores, indicando as atividades a realizar e seus detalhes.
    
    + *Registo e acompanhamento das atividades:*
    
      - Permitir que cada utilizador registe a realização de atividades, associando detalhes como data, duração, designação e outros, para acompanhamento posterior.
      
      - Calcular o consumo calórico com base no perfil do utilizador e na atividade realizada.

    + *Simulação de avanço do tempo:*

      - Permitir a simulação de avanço do tempo para realizar atividades agendadas automaticamente e atualizar os registos dos utilizadores.

    + *Suporte a diversos tipos de atividades:*
  
      - Incluir uma variedade de atividades, desde aquelas que envolvem distância e altimetria até as que consistem em séries de repetições, com ou sem pesos.
      
      - Registar o tempo gasto em cada atividade e calcular o consumo calórico conforme a fórmula estipulada.
    
    + *Classificação das atividades em níveis de dificuldade:*

      - Diferenciar atividades consideradas "Hard" de outras, como trail no monte e ciclismo de montanha.

    + *Gestão de diferentes tipos de utilizadores:*
    
      - Permitir a existência de diferentes tipos de utilizadores (profissionais, amadores, ocasionais), com fácil extensão para adicionar novos tipos através de código.
    
      - Definir um fator multiplicativo para cada tipo de utilizador, a ser utilizado no cálculo das calorias.
    
    + *Registo detalhado de utilizadores:*

      - Manter registos do código do utilizador, nome, morada, email, telemóvel, altura, peso, frequência cardíaca média e outros.
      
      - Associar atividades realizadas aos utilizadores, sejam elas isoladas ou parte de um plano de treino.
      
    + * Criação e gestão de planos de treino:*
    
      - Permitir a construção de planos de treino, especificando parâmetros para construção automático ou introdução manual para processos detalhados.
      
      - Considerar se as atividades serão realizadas uma única vez ou em várias iterações.
      
    + *Geração automática de planos de treino personalizados:*

      - Criar planos de treino específicos para cada utilizador, considerando seus objetivos em termos de tipo de exercício e consumo calórico esperado.

    == Estratégia de desenvolvimento

    O grupo decidiu implementar o desenvolvimento do projeto seguindo a metodologia Scrum e utilizar a plataforma Trello como ferramenta para planear, acompanhar e distribuir as tarefas entre os três membros do grupo. Dentro desta metodologia, as atividades são organizadas em sprints, com prazos definidos, permitindo o acompanhamento do progresso e a avaliação regular dos resultados.

    Em relação ao código, como observável no bloco de código em baixo, optámos por um modelo padrão de programação em Java, aplicando boas práticas de produção de código, como convenções de nomenclatura, organização lógica e modularização de código. Isso assegura clareza e consistência, facilita a manutenção e maximiza a legibilidade. Também adotámos o padrão Javadoc para documentar as classes, métodos e parâmetros, oferecendo uma referência clara e estruturada para futuros desenvolvedores. Como ferramenta de compilação utilizamos Gradle 8.6.

    #align(center)[
      #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
        /**
         * Creates a new training plan based on the provided specifications.
         *
         * @param userCode  The code of the user for whom the training plan will be created.
         * @param startDate The start date of the new training plan.
         * @return The code of the created training plan.
         * @throws IllegalArgumentException If the provided arguments are not valid.
         */
        public UUID createTrainingPlan(UUID userCode, MakeItFitDate startDate) throws IllegalArgumentException {
            TrainingPlan trainingPlan = this.trainingPlanManager.createTrainingPlan(userCode, startDate);
            this.trainingPlanManager.insertTrainingPlan(trainingPlan);
            return trainingPlan.getCode();
        }
        ```
      )
    ]

    Para a realização de testes, recorremos à biblioteca JUnit 5. Esta biblioteca fornece ferramentas modernas e flexíveis para a criação de testes unitários, permitindo a definição de conjuntos de testes com verificações precisas para verificar o comportamento esperado das funcionalidades. Além disso, a JUnit 5 suporta a execução automatizada de testes, possibilitando a identificação precoce de problemas durante o desenvolvimento. Segue um exemplo descritivo de testes de inserção de um plano de treino:

    #align(center)[
      #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
        /**
         * Test the method insertTrainingPlan with a valid training plan
         */
        @Test
        public void testInsertTrainingPlanAndGetTrainingPlan() {
            UUID code = UUID.randomUUID();
            TrainingPlan trainingPlan = new TrainingPlan(UUID.randomUUID(), MakeItFitDate.of(2024, 4, 4));
    
            TrainingPlanManager manager = new TrainingPlanManager();
            manager.insertTrainingPlan(trainingPlan);
    
            TrainingPlan retrievedPlan = manager.getTrainingPlan(code);
    
            assertNotNull(retrievedPlan);
            assertEquals(trainingPlan, retrievedPlan);
        }
    
        /**
         * Test the method insertTrainingPlan with a null training plan
         */
        @Test
        public void testInsertTrainingPlanWithNullTrainingPlan() {
            TrainingPlanManager manager = new TrainingPlanManager();
            assertThrows(IllegalArgumentException.class, () -> {
                manager.insertTrainingPlan(null);
            });
        }
        ```
      )
    ]

    Na aplicação, pretendemos implementar a estratégia de agregação como parte do encapsulamento previsto em Programação Orientada aos Objetos (POO). A agregação é uma relação entre objetos em que um objeto contém ou possui referências a outros objetos, mas a vida desses objetos agregados não depende do objeto que os contém.

    Esta estratégia permite criar estruturas mais complexas a partir de objetos mais simples, promovendo a reutilização de código e a flexibilidade no design do sistema. Ao encapsular funcionalidades específicas em diferentes classes, agregamos essas classes em entidades maiores para oferecer funcionalidades mais amplas.

    Por exemplo, ao modelar componentes importantes da aplicação, como utilizadores, utilizamos a agregação para reunir características e comportamentos distintos em classes separadas. Em seguida, essas classes foram agregadas numa classe maior que as administra e as coordena.

    A aplicação desta estratégia não só promove o encapsulamento, permitindo que cada classe se concentre nas suas responsabilidades específicas, como também facilita a manutenção e a evolução do código. Isto porque as mudanças podiam ser feitas de forma isolada, sem impactar outras partes da aplicação.
    
    == Design patterns

    O grupo avançou com a projeção da aplicação ao estudar design patterns para identificar quais os padrões de desenvolvimento mais adequados aos requisitos. Um padrão que se destacou foi o *Abstract Factory*, que permite a criação de famílias de objetos relacionados ou dependentes sem definir explicitamente suas classes concretas. No contexto das atividades e dos utilizadores, este padrão é crucial para garantir a implementação correta de famílias de atividades e as suas interações, como ilustrado na @introducao-1 e na @introducao-2. O *Abstract Factory* possibilita a criação de objetos específicos para diferentes tipos de atividades, mantendo uma interface consistente e permitindo a extensão fácil do sistema para novos tipos de atividades e utilizadores.

    #align(center)[
      #grid(
        columns: 2,
        column-gutter: 20pt,
        [#figure(
        kind: image,
        caption: [Exemplo de representação gráfica do padrão Abstract Factory. @abstractFactory],
        image("../images/introducao-1.png")
      )<introducao-1>
    ],
        [#figure(
        kind: image,
        caption: [Exemplo de representação concetual do padrão Abstract Factory na aplicação.],
        image("../images/introducao-2.png")
      )<introducao-2>
        ],
      )
    ]

    Durante a investigação sobre padrões de design, identificámos o padrão *Facade* como especialmente relevante. Este padrão permite criar uma única interface de acesso para um conjunto de funcionalidades relacionadas, centralizando as operações e ocultando a complexidade interna das classes subjacentes. Ao encapsular as interações com subsistemas, o *Facade* simplifica a utilização da aplicação e garante uma maior modularidade e coesão, ao mesmo tempo em que previne o acesso direto ao conhecimento interno das classes, proporcionando assim uma camada de abstração adicional para o utilizador. Observe-se na @introducao-3 e @introducao-4 as representações gráfica e concetual, respetivamente.

    #align(center)[
      #grid(
        columns: 2,
        column-gutter: 20pt,
        [#figure(
        kind: image,
        caption: [Exemplo de representação gráfica do padrão Facade. @facade],
        image("../images/introducao-3.png")
      )<introducao-3>
    ],
        [#figure(
        kind: image,
        caption: [Exemplo de representação concetual do padrão Facade na aplicação.],
        image("../images/introducao-4.png")
      )<introducao-4>
        ],
      )
    ]

    Finalmente surgiu o padrão *Observer* que é um padrão comportamental que estabelece uma dependência entre objetos, de forma que quando um objeto muda de estado, todos os objetos dependentes dele são notificados e atualizados automaticamente. Este padrão é especialmente útil em casos como o da mudança da data na aplicação, permitindo uma arquitetura mais flexível e desacoplada, como mostrado na @introducao-5 e @introducao-6.

    #align(center)[
      #grid(
        columns: 2,
        column-gutter: 20pt,
        [#figure(
        kind: image,
        caption: [Exemplo de representação gráfica do padrão Observer. @observer],
        image("../images/introducao-5.png")
      )<introducao-5>
    ],
        [#figure(
        kind: image,
        caption: [Exemplo de representação concetual do padrão Observer na aplicação.],
        image("../images/introducao-6.png")
      )<introducao-6>
        ],
      )
    ]
  ]
}
