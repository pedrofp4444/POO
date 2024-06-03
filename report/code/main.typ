#import "cover.typ": cover
#import "template.typ": *
#import "content/resumo.typ": resumo
#import "content/introducao.typ": introducao
#import "content/diagrama.typ": diagrama
#import "content/implementacao.typ": implementacao
#import "content/mvc.typ": mvc
#import "content/utilizacao.typ": utilizacao
#import "content/conclusao.typ": conclusao

#show: project

#cover(title: "MakeItFit", authors: (
  (name: "Afonso Santos", number: "a104276"), 
  (name: "Hélder Gomes", number: "a104100"), 
  (name: "Pedro Pereira", number: "a104082")), 
  "11 de maio de 2024")

#set page(numbering: "i", number-align: center)
#counter(page).update(1)

#resumo

#show outline: it => {
    show heading: set text(size: 18pt)
    it
}

#{
  show outline.entry.where(level: 1): it => {
    v(5pt)
    strong(it)
  }

  outline(
    title: [Índice], 
    indent: true, 
  )
}

#v(-0.4em)
#outline(
  title: none,
  target: figure.where(kind: "attachment"),
  indent: n => 1em,
)

#outline(
  title: [Lista de Figuras],
  target: figure.where(kind: image),
)

// Make the page counter reset to 1
#set page(numbering: "1", number-align: center)
#counter(page).update(1)

#introducao

#diagrama

#implementacao

#mvc

#utilizacao

#conclusao

#bibliography("content/bibliografia.bib", full: true)

#heading(numbering: none)[Lista de Siglas e Acrónimos]

/ POO: Programação Orientada aos Objetos
/ MVC: Model-View-Controller
/ UML: Unified Modeling Language
/ CLI: Command Line Interface

#heading(numbering: none)[Anexos]
#attachment(caption: "Logo da Universidade do Minho.", image("images/uminho.png"))
#attachment(caption: "Exemplo de representação gráfica do padrão Abstract Factory.", image("images/introducao-1.png"))
#attachment(caption: "Exemplo de representação concetual do padrão Abstract Factory na aplicação.", image("images/introducao-2.png"))
#attachment(caption: "Exemplo de representação gráfica do padrão Facade.", image("images/introducao-3.png"))
#attachment(caption: "Exemplo de representação concetual do padrão Facade na aplicação.", image("images/introducao-4.png"))
#attachment(caption: "Exemplo de representação gráfica do padrão Observer.", image("images/introducao-5.png"))
#attachment(caption: "Exemplo de representação concetual do padrão Observer na aplicação.", image("images/introducao-6.png"))
#attachment(caption: "Representação da interface \"ActivityInterface\" no diagrama de classes.", image("images/diagrama-1.png"))
#attachment(caption: "Representação da classe abstrata \"Activity\" no diagrama de classes.", image("images/diagrama-2.png"))
#attachment(caption: "Representação da classe abstrata \"Repetitions\" no diagrama de classes.", image("images/diagrama-3.png"))
#attachment(caption: "Representação da classe abstrata \"Distance\" no diagrama de classes.", image("images/diagrama-4.png"))
#attachment(caption: "Representação da classe abstrata \"RepetitionsWithWeights\" no diagrama de classes.", image("images/diagrama-5.png"))
#attachment(caption: "Representação da classe abstrata \"DistanceWithAltimetry\" no diagrama de classes.", image("images/diagrama-6.png"))
#attachment(caption: "Representação da classe concreta \"PushUp\" no diagrama de classes.", image("images/diagrama-7.png"))
#attachment(caption: "Representação da classe concreta \"Running\" no diagrama de classes.", image("images/diagrama-8.png"))
#attachment(caption: "Representação da classe concreta \"WeightSquat\" no diagrama de classes.", image("images/diagrama-9.png"))
#attachment(caption: "Representação da classe concreta \"Trail\" no diagrama de classes.", image("images/diagrama-10.png"))
#attachment(caption: "Representação da interface \"HardInterface\" no diagrama de classes.", image("images/diagrama-11.png"))
#attachment(caption: "Representação da interface \"UserInterface\" no diagrama de classes.", image("images/diagrama-12.png"))
#attachment(caption: "Representação da classe abstrata \"User\" no diagrama de classes.", image("images/diagrama-13.png"))
#attachment(caption: "Representação da classe concreta \"Amateur\" no diagrama de classes.", image("images/diagrama-14.png"))
#attachment(caption: "Representação da classe concreta \"Occasional\" no diagrama de classes.", image("images/diagrama-15.png"))
#attachment(caption: "Representação da classe concreta \"Professional\" no diagrama de classes.", image("images/diagrama-16.png"))
#attachment(caption: "Representação da classe concreta \"UserManager\" no diagrama de classes.", image("images/diagrama-17.png"))
#attachment(caption: "Representação da classe concreta \"TrainingPlan\" no diagrama de classes.", image("images/diagrama-18.png"))
#attachment(caption: "Representação da classe concreta \"TrainingPlanManager\" no diagrama de classes.", image("images/diagrama-19.png"))
#attachment(caption: "Representação da classe concreta \"MakeItFitDate\" no diagrama de classes.", image("images/diagrama-20.png"))
#attachment(caption: "Representação da classe concreta \"Emailvalidator\" no diagrama de classes.", image("images/diagrama-21.png"))
#attachment(caption: "Representação da classe concreta \"TimeManager\" no diagrama de classes.", image("images/diagrama-22.png"))
#attachment(caption: "Representação da classe concreta \"Menu\" no diagrama de classes.", image("images/diagrama-23.png"))
#attachment(caption: "Representação da classe concreta \"MenuItem\" no diagrama de classes.", image("images/diagrama-24.png"))
#attachment(caption: "Representação da interface \"PreCondition\" no diagrama de classes.", image("images/diagrama-25.png"))
#attachment(caption: "Representação da interface \"Handler\" no diagrama de classes.", image("images/diagrama-26.png"))
#attachment(caption: "Representação da classe concreta \"QueriesManager\" no diagrama de classes.", image("images/diagrama-27.png"))
#attachment(caption: "Representação da classe concreta \"ExistingEntityConflictException\" no diagrama de classes.", image("images/diagrama-28.png"))
#attachment(caption: "Representação da classe concreta \"InvalidTypeException\" no diagrama de classes.", image("images/diagrama-29.png"))
#attachment(caption: "Representação da classe concreta \"EntityDoesNotExistException\" no diagrama de classes.", image("images/diagrama-30.png"))
#attachment(caption: "Representação da classe concreta \"MakeItFit\" no diagrama de classes.", image("images/diagrama-31.png"))
#attachment(caption: "Representação da classe concreta \"MakeItFitController\" no diagrama de classes.", image("images/diagrama-32.png"))
#attachment(caption: "Representação da classe concreta \"AdminView\" no diagrama de classes.", image("images/diagrama-33.png"))
#attachment(caption: "Representação da classe abstrata \"MakeItFitView\" no diagrama de classes.", image("images/diagrama-34.png"))
#attachment(caption: "Representação da classe concreta \"UserView\" no diagrama de classes.", image("images/diagrama-35.png"))