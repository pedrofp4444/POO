#let implementacao = {
  [
    = Implementação

    Nesta secção do relatório, será apresentada a implementação, onde é representado o culminar de esforços meticulosos e de um planeamento estratégico. Este relatório oferece uma visão detalhada dos processos, estratégias e resultados alcançados durante a fase de execução. Vamos explorar os objetivos definidos, as soluções desenvolvidas para ultrapassar desafios, proporcionando uma avaliação abrangente do sucesso da implementação.

    == Contextos base da aplicação

    Utilizando o padrão Abstract Factory, implementamos as entidades fundamentais da nossa aplicação, as atividades, os utilizadores e, por último, os planos de treino. Optamos por organizar por packages, de forma a manter a estrutura clara e organizada. As atividades estão agrupadas num package separado, com diferentes implementações e tipos de atividades, desta forma é possível garantir que a responsabilidade de calcular as calorias fica a cargo de cada subclasse, permitindo assim personalização no calculo calórico de cada atividade.
    
    Da mesma forma, os utilizadores seguem uma estrutura semelhante, com um package para os diferentes tipos de utilizadores, facilitando a necessidade de ter obrigatoriamente de um certo tipo de utilizador. De forma adicional, os utilizadores com o tipo profissional adquirem uma variável de instância exclusiva, denominada especialização, que indica o tipo de atividade mais praticada pelo utilizador, que é atualizada automaticamente de acordo com a atividade mais realizada pelo utilizador. 
    
    Quanto aos planos de treino, estão integralmente contidos dentro de um único package, facilitando sua gestão e manutenção.

    == Saltos temporais no sistema

    De forma a simular um contexto real de uma aplicação, é possível replicar saltos temporais usando o padrão Observer. Isso permite atualizar dinamicamente todas as informações à medida que o tempo avança. Assim, as calorias gastas em atividades passadas e a inclusão de novas atividades num plano de treino para um utilizador são automaticamente atualizadas à medida que o tempo avança. Com o objetivo de garantir uma implementação o mais modular possível, optamos por abstrair a classe Date, criando a MakeItFitDate, uma classe personalizada que nos permite ajustar facilmente como o tempo é tratado na nossa aplicação.

    == Realização de estatísticas sobre o estado do programa

    O *_QueriesManager_*  é a classe responsável na implementação da resolução de estatísticas da aplicação. Esta classe acessa a informação dos utilizadores e dos planos de treinos.
   Assim, sempre que ocorrer uma alteração temporal ou forem adicionadas novas informações, os resultados serão recalculados.

    Todas as estatísticas pedidas foram implementadas:
  + Qual é o utilizador que mais calorias despendeu num período ou desde sempre?
  + Qual o utilizador que mais atividades realizou num período ou desde sempre?
  + Qual o tipo de atividade mais realizada?
  + Quantos quilómetros é que um utilizador realizou num período ou desde sempre?
  + Quantos metros de altimetria é que um utilizar totalizou num período ou desde sempre?
  + Qual o plano de treino mais exigente em função do dispêndio de calorias proposto?
  + Listar as atividades de um utilizador.

  A resolução de todas as estatísticas segue um procedimento uniforme. Ao recebermos a entrada de dados, o primeiro passo é verificar a sua validade. Após validar os dados, procedemos a uma análise abrangente, percorrendo todas as informações relevantes. É importante destacar que este processo é iterativo. Por fim, ao atualizarmos ou adicionarmos novos dados, reavaliamos e recalculamos as estatísticas pertinentes. Esta abordagem garante que os resultados sejam sempre atualizados e precisos.

    == Criação de atividades "Hard"

    As atividades podem ser consideradas "Hard", ou seja, com uma dificuldade acrescida, por esse motivo e de forma a respeitar a modularidade decidimos implementar uma interface, denominada "HardInterface". Posteriormente as atividades que sejam consideradas dessa categoria apenas necessitam de implementar a interface descrita. 
    
    == Gerar um plano de treino com objetivos

    Como requisito final, o utilizador pode criar um plano de treino baseado em objetivos, entre eles, se deseja atividades "Hard", o número máximo de atividades por dia, o número máximo de atividades distintas, a recorrência semanal e o principal, o número mínimo de calorias que se pretende obter com o plano de treino em criação.
    Respeitando os objetivos anteriormente descritos, e restrições impostas por nós, como número máximo de repetições por exercício, número mínimo e máximo dos atributos das atividades entre outras, a nossa aplicação gera um plano de treino personalizado ao utilizador.

    No decorrer do desenvolvimento, surgiu a necessidade de escolher atividades para adicionar ao plano de treino de forma aleatória, dado isto, e não conseguindo alcançar uma melhor solução, optámos por construir uma classe separada para que crie facilidade de resolução do problema caso se venha a evidenciar o expediente.
    
    == Salvaguarda do estado da aplicação

    Para garantir a continuidade e conveniência para o utilizador, implementámos uma funcionalidade de salvaguarda do estado da aplicação, utilizando técnicas de serialização das instâncias e escrita em binário nos ficheiros. Isto permite que o utilizador retome a sua atividade, mesmo após fechar e reabrir a aplicação. Todos os dados relacionados com os planos de treino, preferências do utilizador e histórico de atividades são armazenados de forma segura e eficiente através desta abordagem. Com esta funcionalidade, proporcionamos uma experiência contínua e sem preocupações para todos os nossos utilizadores.
  ]
}
