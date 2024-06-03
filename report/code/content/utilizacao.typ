#let utilizacao = {
  [
    = Utilização da aplicação

    Nesta secção, abordamos a forma de utilização da nossa aplicação, ajudando no processo desde como iniciar, até às funcionalidades presentes e como elas operam.

    == Funcionamento geral

A aplicação segue uma abordagem sequencial através de menus de linha de comando (CLI), que nos permite navegar pelas restantes funcionalidades da aplicação. Esta estrutura de menus simplifica a interação do utilizador com o sistema, fornecendo uma experiência intuitiva e direcionada. Ao utilizar os menus, os utilizadores podem facilmente explorar e aceder às diversas funcionalidades disponíveis na aplicação. Além disso, a natureza sequencial dos menus promove uma navegação fluida e organizada, facilitando a utilização e compreensão do sistema.

    
    == Início da aplicação <Inicio_da_aplicação>
Para iniciar a aplicação, é essencial verificar se todas as dependências estão instaladas, incluindo o Gradle, JUnit5 e JavaDoc. Posteriormente, procede-se à compilação da aplicação utilizando o comando específico, conforme indicado no ficheiro README.md que acompanha o projeto. Uma vez compilada com sucesso, a aplicação está pronta para ser executada através do segundo comando fornecido no mesmo ficheiro. Esta abordagem garante que a aplicação seja executada de forma correta e sem problemas relacionados com dependências ausentes ou compilação inadequada.

Comandos para compilar  e executar a aplicação, respetivamente:
#set align(center)
#grid(
  columns: 2,
  column-gutter: 20pt,

block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```bash
        $./gradlew build
        ```
      )
,
block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```bash
        $./gradlew run --console=plain
        ```
      )
    
  )
#set align(left)

Ao iniciar o programa, somos apresentados com o seguinte menu: A primeira opção permite-nos inicializar a aplicação no modo utilizador ou no modo admin e se queremos começar com um estado já existente ou recomeçar a aplicação, sendo que as diferenças entre estes modos serão desenvolvidas posteriormente. A segunda opção explica as identidades da aplicação e as suas principais características. A terceira opção apresenta os autores do programa e, por último, temos a opção de sair do mesmo.
#set align(center)
 
#block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
        1. Init the application
        2. Help
        3. Authors
        4. Exit
        Select the option:
        ```
      )


#set align(left)


    

    == Modo MakeItFitView

    Este modo implementa métodos partilhados por ambas as views, user view e admin view.

    /*
          Estes são os pontos comums (muda o nome):
    
    detalhes do utilizador----------
    atualizar utilizador------------
    
    adicionar atividade ao utilizador---------
    remover atividades do utilizador--------
    listar atividades do utilizador----------

    adicionar plano de treino ao utilizador-------
    remover plano de treino ao utilizador-------
    adicionar atividade ao plano de treino do utilizador------
    remover atividade do plano de treino do utilizador-----
    listar os planos de treino do utilizador------

    avançar no tempo---------

    salvar o estado do sistema

          Estes são os pontos únicos do utilizador:

    login ---------------------

          Estes são os pontos únicos do admistrador:

    Criar utilizador
    Listar todos os utilizadores

    Listar todos os planos de treino

    Executar estatisticas
    */
 
    === Interagir com utilizador
    
    Para interagir com o utilizador, temos duas opções disponíveis: visualizar as informações do utilizador ou atualizar as suas informações pessoais.

    Opções existentes:
    #set align(center)
      #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
        1. User Details
        2. Update User info
        ```
      )
     

    #grid(
      rows: 2,
      row-gutter: 10pt,
      columns: 2,
      column-gutter: 40pt,
      
      [Exemplo de visualizar as informações através do modo utilizador:],
      [Exemplo de uma atualização das informações através do modo utilizador: ],
      block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
       [Teste] Getting user details ...
        == (User details) ==
        Code:
          c528ab5a-1c87-44b9-8ac9-49fa354cc0b5
        Name: Teste
        Age: 20
        Gender: Male
        Weight: 70.00 kg
        Height: 180 cm
        Bpm: 110
        Level: 6
        Address: Rua Teste Teste
        Phone: 999999999
        Email: teste@mail.com
        Activities: []
        Frequency: 3
        ====================
        
        ```
    
      )
      ,      
          block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
          
            ```java
        1. Update Name
        2. Update Age
        3. Update Gender
        4. Update Weight
        5. Update Height
        6. Update BPM
        7. Update Level
        8. Update Address
        9. Update Phone
        10. Update Email
        11. Exit
        Select the option:    
      
        ```
        
      )
    )
     #set align(left)
    
    === Interagir com atividades <Interagir_com_atividade>
    Com atividades temos 3 opções de manipulação como adicionar, remover uma atividade e listar as várias atividades que um utilizador tem. 

    Opções existentes:
    #set align(center)
 #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
        3. Add activity
        4. Remove activity
        5. List activities
        ```
      )
         #set align(left)
      
Exemplo de como adicionar uma atividade através do modo utilizador:

#set align(center)
       #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
        [Teste] Adding activity to user ...
        [Teste] Please select the activity (PushUp | WeightSquat | Running | Trail): Trail
        [APP] Please enter the following information:
        [APP] Date (dd/mm/aaaa): 20/06/2024
        [APP] Duration (minutes): 60
        [APP] Designation: pedalar
        [APP] Distance (meters): 5000
        [APP] Elevation gain (meters): 200
        [APP] Elevation loss (meters): 100
        [APP] Trail type ([0] Easy, [1] Medium, [2] Hard): 1
        [Teste] Activity added to user successfully.
        ```
      )
         #set align(left)
Exemplo de como listar uma atividade através do modo utilizador:
#set align(center)
       #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
[Teste] Listing activities ...
[Activity:
  Trail, Code: 43eacc53-d486-486c-b2e8-954a4ffb2cbf, Designation: pedalar, Expected Duration: 60 minutes, Realization Date: 20/06/2024, Caloric Waste: 0 calories, Distance: 5000.0 meters, Elevation Gain: 200.0 meters, Elevation Loss: 100.0 meters, Trail Type: 1]
        ```
      )
         #set align(left)
Exemplo de como remover uma atividade através do modo utilizador:
#set align(center)
       #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
[Teste] Removing activity from user ...
[Teste] Please insert the code of the activity: 43eacc53-d486-486c-b2e8-954a4ffb2cbf
[Teste] Activity removed successfully.

        ```
      )
      #set align(left)



      
    === Interagir com planos de treino
    Para manipular os planos de treino, dispomos de seis opções: criar um plano de treino, onde é possível gerar ou adicionar várias atividades; remover um plano de treino, com a opção de gerar ou adicionar diversas atividades; adicionar e remover uma atividade específica de um plano de treino; e listar os planos de treino disponíveis.

    Opções existentes:

    #set align(center)
       #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
6. Create training plan
7. Remove training plan
8. Add activity to a training plan
9. Remove activity from a training plan
10. List all training plans

        ```
      )
    #set align(left)

    Exemplo de uma geração de treino através do modo utilizador:
        #set align(center)
       #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
[teste] Creating training plan ...
[teste] Please enter the start date (dd/mm/aaaa): 13/05/2024
[teste] Training plan created successfully.
1. Construct plan
2. Generate plan
3. Exit
Select the option: 2
[teste] Generating training plan ...
[teste] Do you want to add hard activities? (y/n): n
[teste] Please insert the maximum number of activities per day (max 3): 1
[teste] Please insert the maximum number of different activities: 2
[teste] Please insert the weekly recurrence expected (max 7): 2
[teste] Please insert the minimum number of calories to be consumed: 999
[teste] Training plan generated successfully.


        ```
      )
    #set align(left)

    Exemplo de uma listagem de planos de treinos através do modo utilizador: 

    #set align(center)
       #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
[teste] Listing all training plans ...
[  == (Training plan details) ==
Training Plan: a2592c28-a639-46e3-8e39-bff4a6bd1dc2
        User Code: dc2a6915-d579-4365-8a36-fe6edbb28f7a
        Start Date: 13/05/2024
        Activities(Iterations / Activity):
        [(3, Activity: WeightSquat, Code: ad5b6e1d-e583-4203-bee4-9c73547bc8b9, Designation: WeightSquat created automatically, Expected Duration: 14 minutes, Realization Date: 13/05/2024, Caloric Waste: 0 calories, Repetitions: 19, Series: 4, Weight: 52.0 Kg)]]
        

        ```
      )
    #set align(left)

 Exemplo de como remover um plano de treino através do modo utilizador:

    #set align(center)
       #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
[teste] Removing training plan ...
[teste] Please insert the code of the training plan: a2592c28-a639-46e3-8e39-bff4a6bd1dc2
[teste] Training plan removed successfully.
        

        ```
      )
    #set align(left)

    As opções de adicionar uma tarefa e remover uma tarefa são muito semelhantes o que foi referido  @Interagir_com_atividade com a particularidade de primeiramente é necessário fornecer o código do plano de treino.11

    === Simulação temporal

    É possível simular a progressão e o retrocesso do tempo dentro da nossa aplicação. Quando avançamos no tempo, o número de atividades realizadas por um utilizador aumenta, refletindo-se também na atualização das estatísticas do programa.
    
#set align(center)
    
#grid(columns: 2,
column-gutter: 30pt,
rows: 2,
row-gutter: 10pt,
[Opção em questão:],
[Demonstração do avanço com o tempo através do modo utilizador:],

block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
11. Advance time

        ```
      )
, 
block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
[teste] Advancing time ...
[teste] Please enter the number of days to advance: 10
[teste] Time advanced successfully.

        ```
      )
)    

#set align(left)
Um utilizador que ainda não começou o seu plano de treino antes do avanço de 10 dias.

#set align(center)

#block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
[teste] Getting user details ...
        == (User details) ==
        Code: f9e0837d-00b6-4d37-9647-5c1772a9bd6e
        Name: teste
        Age: 20
        Gender: Male
        Weight: 80.00 kg
        Height: 170 cm
        Bpm: 110
        Level: 6
        Address: rua teste
        Phone: 999888777
        Email: teste@mail.com
        Activities: []
        ====================
        ```
      )

      
      #set align(left)
Depois do avanço dos 10 dias:
      #set align(center)

      #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
[teste] Getting user details ...
        == (User details) ==
        Code: f9e0837d-00b6-4d37-9647-5c1772a9bd6e
        Name: teste
        Age: 20
        Gender: Male
        Weight: 80.00 kg
        Height: 170 cm
        Bpm: 110
        Level: 6
        Address: rua teste
        Phone: 999888777
        Email: teste@mail.com
        Activities: [Activity: PushUp, Code: 0b0a1cdb-c6b6-4d0a-8c92-adf6241d3456, Designation: PushUp created automatically, Expected Duration: 25 minutes, Realization Date: 15/05/2024, Caloric Waste: 155 calories, Repetitions: 17, Series: 3, ,  Activity: WeightSquat, Code: 3cbd8278-9e4f-4ea9-8b1e-550aa9603e3c, Designation: WeightSquat created automatically, Expected Duration: 37 minutes, Realization Date: 16/05/2024, Caloric Waste: 1640 calories, Repetitions: 11, Series: 1, Weight: 49.0 Kg
]
        ====================

        ```
      )




    #set align(left)

    === Guardar estado

    Após a utilização da aplicação, é sempre possível guardar o estado atual, incluindo todas as informações e registos realizados durante a sessão. Essa informação é armazenada de forma a permitir que, numa próxima utilização da aplicação, o utilizador possa retomar exatamente de onde parou, permitindo-lhe manter o seu progresso e registos ao longo do tempo, mesmo em diferentes sessões de utilização da aplicação.

    #set align(center)
    
#grid(columns: 2,
column-gutter: 30pt,
rows: 2,
row-gutter: 10pt,
[Opção em questão:],
[Demonstração de como guardar o estado através do modo utilizador:],

block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
12. Save system state

        ```
      )
, 
block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
[teste] Saving system state ...
[teste] Please enter the file name: savefile
[teste] System state saved successfully.
        ```
      )
)    

#set align(left)
    
    === Terminar aplicação

   Assim como em qualquer aplicação convencional, também é disponibilizada uma opção para sair do programa. Ao selecionar esta opção, o utilizador é encaminhado de volta ao menu inicial da aplicação. referido na @Inicio_da_aplicação
    
#set align(center)
    
#grid(columns: 2,
column-gutter: 30pt,
rows: 2,
row-gutter: 10pt,
[Opção em questão:],
[Demonstração de como guardar o estado através do modo utilizador:],

block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
13. Exit

        ```
      )
, 
block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
[teste] Saving system state ...
[teste] Please enter the file name: savefile
[teste] System state saved successfully.
        ```
      )
)    

#set align(left)
    
    == Modo utilizador

    === Autenticação
    
      Para um utilizador autenticar-se, é necessário introduzir o seu email. Caso o utilizador não exista, será necessário registar-se, fornecendo alguns dados como tipo de atleta, nome, idade, peso, altura, entre outros. Se o utilizador já existir, apenas será realizado o login.

        Exemplo de registar um utilizador:
          #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
        [APP] Please enter your email: teste@mail.com
        [APP] The email teste@mail.com does not exist.
        [APP] Would you like to create a new user? (y/n): y
        [APP] Creating user ...
        [APP] Please enter the type of user ( Amateur | Occasional | Professional): Occasional
        [APP] Please enter the following information:
        [APP] Name: Teste
        [APP] Age: 20
        [APP] Gender ( Male | Female | Other): Male
        [APP] Weight (Kg): 70
        [APP] Height (cm): 180
        [APP] Bpm: 110
        [APP] Level: 6
        [APP] Address: Rua Teste Teste
        [APP] Phone: 999999999
        [APP] Frequency: 3
        [Teste] User created successfully.
        ```
      )
      
Exemplo de fazer login de um utilizador:
  #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
        [APP] Please enter your email: teste@mail.com
        [teste] Logged in successfully.
        ```
      )

    
    == Modo administrador
Agora no modo administrador, estão disponíveis opções adicionais para uma gestão mais eficaz da aplicação. Estas opções foram concebidas para proporcionar ao administrador um maior controlo sobre as funcionalidades e dados da aplicação, permitindo uma gestão mais personalizada e adaptada às necessidades específicas do sistema.

    
    === Remover utilizador

    O administrador tem a possibilidade de remover um utilizador, sendo necessário fornecer o email associado a esse utilizador.
    
#set align(center)
    
#grid(columns: 2,
column-gutter: 30pt,
rows: 2,
row-gutter: 10pt,
[Opção em questão:],
[Demonstração de como guarda um estado:],

block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
        3. Remove user

        ```
      )
, 
block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
[APP] Removing user ...
[APP] Enter the user's email: teste@mail.com
[APP] User removed successfully.
        ```
      )
)    

#set align(left)
    
    

    === Listar todos os utilizadores

No modo administrador, existe a possibilidade de listar todos os utilizadores registados na aplicação. Esta funcionalidade permite ao administrador ter uma visão geral de todos os utilizadores do sistema, facilitando a gestão e o acompanhamento das contas de utilizador. Além disso, através desta opção, o administrador pode aceder rapidamente às informações de cada utilizador, se necessário, para realizar operações específicas ou identificar padrões de utilização.

#set align(center)
#block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
== (All users) ==
[        == (User details) ==
        Code: 3257a805-c949-44c1-b969-cad54a1ccc1a
        Name: teste
        Age: 20
        Gender: Male
        Weight: 70.00 kg
        Height: 170 cm
        Bpm: 100
        Level: 4
        Address: Rua teste
        Phone: 999888777
        Email: teste@mail.com
        Activities: []
        ====================
,         == (User details) ==
        Code: 4321714d-9a23-4603-a984-a1898a03a8d2
        Name: teste2
        Age: 21
        Gender: Female
        Weight: 60.00 kg
        Height: 160 cm
        Bpm: 105
        Level: 2
        Address: Travessa Teste Teste
        Phone: 666555444
        Email: teste2@mail.com
        Activities: []
        Frequency: 3
        ====================
,         == (User details) ==
        Code: c57cd8e7-307c-49a2-91ef-8e09fbc22c29
        Name: teste3
        Age: 22
        Gender: Other
        Weight: 175.00 kg
        Height: 200 cm
        Bpm: 150
        Level: 7
        Address: Avenida teste
        Phone: 333222111
        Email: teste3@mail.com
        Activities: []
        Specialization: No specialization
        Frequency: 3
        ====================
]
==================



        ```
      )

      #set align(left)

    === Execução de estatísticas

 O administrador tem a possibilidade de realizar estatísticas 

  #set align(center)
 #block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
        3. Execute queries

        ```
      )

#set align(left)

 
 Assim sendo mesmo pode obter um maior conhecimento sobre a sua aplicação. A análise estatística permite ao administrador extrair informações valiosas, sobre o desempenho, utilização e tendências da aplicação. Essa compreensão mais profunda da aplicação pode ajudar o administrador a tomar decisões informadas e aprimorar continuamente a experiência do utilizador, bem como otimizar o funcionamento geral da aplicação.

#set align(center)
    
#grid(columns: 2,
column-gutter: 30pt,
rows: 2,
row-gutter: 10pt,
[Opção em questão:],
[Demonstração de da estatística "How many kms has a user has run in a period or ever since?":],

block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 4pt,
        ```java
        [teste3] Executing queries ...
[APP] Please select the query to execute:
1. How many kms has a user has run in a period or ever since?
2. How many meters of altimetry has a user totaled in a period or ever since?
3. What is the most demanding training plan depending on the proposed calorie expenditure?
4. what type of activity is most carried out?
5. Which user has burned the most calories over a period of time or ever?
6. Which user has carried out the most activities in a period or ever since?
7. List all activities from a user.
8. Exit

        ```
      )
, 
block(
          fill: rgb("#F0F8FF"),
          breakable: false,
          inset: 2pt,
          radius: 1pt,
        ```java
[teste3] Executing query ...
[APP] Enter the user's email: teste@mail.com
[APP] Do you choose a period of time? (y/n): y
[APP] Enter the start date (dd/mm/aaaa): 11/05/2024
[APP] Enter the end date (dd/mm/aaaa): 20/05/2024
Result: 9.76 kilometers
        ```
      )
)    

#set align(left)


      
  ]
}
