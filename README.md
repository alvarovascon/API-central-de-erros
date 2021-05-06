# Boas vindas ao repositório do projeto Central de Erros!

Em projetos modernos é cada vez mais comum o uso de arquiteturas baseadas em serviços ou microsserviços. Nestes ambientes complexos, erros podem surgir em diferentes camadas da aplicação (backend, frontend, mobile, desktop) e mesmo em serviços distintos. Desta forma, é muito importante que os desenvolvedores possam centralizar todos os registros de erros em um local, de onde podem monitorar e tomar decisões mais acertadas. Neste projeto vamos implementar uma API Rest para centralizar registros de erros de aplicações.

## ✨ Funcionalidades

- 🛡 Permite a autenticação do sistema que deseja utilizar a API gerando o Token de Acesso.
- 🌍 Pode ser acessado por multiplos sistemas.
- 📦 Permite gravar registros de eventos de log salvando informações de Level(error, warning, info), Descrição do Evento, LOG do Evento, ORIGEM(Sistema ou Serviço que originou o evento), DATA(Data do evento), QUANTIDADE(Quantidade de Eventos de mesmo tipo).
- 📋 Permite a listagem dos eventos juntamente com a filtragem por qualquer parâmetro especificado acima.
- 📄 Suporta Paginação.
- ⚙️ Suporta Ordenação por diferentes tipos de atributos.
- 🛡 A consulta de listagem não retorna os LOGs dos Eventos.
- 📦 Permite a busca de um evento por um ID, dessa maneira exibindo o LOG desse evento em específico.

## 📦 Desenvolvimento

Clone localmente:

```bash
$ git clone git@github.com:alvarovascon/API-central-de-erros.git
$ cd API-central-de-erros
$ mvn clean install
$ mvn spring-boot:run
```

### 📋 Tabelas de endpoints

| Endpoint | Verbo | Função | Retorno |
| :---: | :---: | :---: | :---: |
| /events | GET | Lista eventos de erro | |
| /events | POST | Registra novo evento de erro | |
| /events/{id} | GET | Busca evento de erro por id | |
| /events/level/count/{level} | GET | Retorna número de eventos por nível | |
| /events/date/{date} | GET | Busca eventos por data | |
| /events/level/{level} | GET | Busca eventos por nível(level) | |
| /events/log/{log} | GET | Busca eventos por log | |
| /events/origin/{origin} | GET | Busca eventos por origem | |
| /user | GET | Lista usuários cadastrados | |
| /user | POST | Registra novo usuário | |
| /user/{id} | GET | Busca usuários por id | |

## 📌 Documentação

Documentação da API disponivel em https://api-central-de-erros-java.herokuapp.com/swagger-ui.html#/


### 🔧 Instalação

Uma série de exemplos passo-a-passo que informam o que você deve executar para ter um ambiente de desenvolvimento em execução.

Diga como essa etapa será:

```
Dar exemplos
```

E repita:

```
Até finalizar
```

Termine com um exemplo de como obter dados do sistema ou como usá-los para uma pequena demonstração.

## ⚙️ Executando os testes

Explicar como executar os testes automatizados para este sistema.

### 🔩 Analise os testes de ponta a ponta

Explique que eles verificam esses testes e porquê.

```
Dar exemplos
```

### ⌨️ E testes de estilo de codificação

Explique que eles verificam esses testes e porquê.

```
Dar exemplos
```
## 🛠️ Construído com

Mencione as ferramentas que você usou para criar seu projeto

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - O framework web usado
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [ROME](https://rometools.github.io/rome/) - Usada para gerar RSS

## 🖇️ Colaborando

Por favor, leia o [COLABORACAO.md](https://gist.github.com/usuario/linkParaInfoSobreContribuicoes) para obter detalhes sobre o nosso código de conduta e o processo para nos enviar pedidos de solicitação.

## 📌 Versão

Nós usamos [SemVer](http://semver.org/) para controle de versão. Para as versões disponíveis, observe as [tags neste repositório](https://github.com/suas/tags/do/projeto). 

## ✒️ Autores

Mencione todos aqueles que ajudaram a levantar o projeto desde o seu início

* **Um desenvolvedor** - *Trabalho Inicial* - [umdesenvolvedor](https://github.com/linkParaPerfil)
* **Fulano De Tal** - *Documentação* - [fulanodetal](https://github.com/linkParaPerfil)

Você também pode ver a lista de todos os [colaboradores](https://github.com/usuario/projeto/colaboradores) que participaram deste projeto.

## 📄 Licença

Este projeto está sob a licença (sua licença) - veja o arquivo [LICENSE.md](https://github.com/usuario/projeto/licenca) para detalhes.

## 🎁 Expressões de gratidão

* Conte a outras pessoas sobre este projeto 📢
* Convide alguém da equipe para uma cerveja 🍺 
* Obrigado publicamente 🤓.
* etc.
