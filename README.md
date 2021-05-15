# Boas vindas ao repositório do projeto Central de Erros!

Em projetos modernos é cada vez mais comum o uso de arquiteturas baseadas em serviços ou microsserviços. Nestes ambientes complexos, erros podem surgir em diferentes camadas da aplicação (backend, frontend, mobile, desktop) e mesmo em serviços distintos. Desta forma, é muito importante que os desenvolvedores possam centralizar todos os registros de erros em um local, de onde podem monitorar e tomar decisões mais acertadas. Neste projeto vamos implementar uma API Rest para centralizar registros de erros de aplicações.

---

## ✨ Funcionalidades

- 🛡 Permite a autenticação do sistema que deseja utilizar a API gerando o Token de Acesso.
- 🌍 Pode ser acessado por multiplos sistemas.
- 📦 Permite gravar registros de eventos de log salvando informações de Level(error, warning, info), Descrição do Evento, LOG do Evento, ORIGEM(Sistema ou Serviço que originou o evento), DATA(Data do evento), QUANTIDADE(Quantidade de Eventos de mesmo tipo).
- 📋 Permite a listagem dos eventos juntamente com a filtragem por qualquer parâmetro especificado acima.
- 📄 Suporta Paginação.
- ⚙️ Suporta Ordenação por diferentes tipos de atributos.
- 🛡 A consulta de listagem não retorna os LOGs dos Eventos.
- 📦 Permite a busca de um evento por um ID, dessa maneira exibindo o LOG desse evento em específico.

---

## 🔧 Instalação

Clone localmente:

```bash
$ git clone git@github.com:alvarovascon/API-central-de-erros.git
$ cd API-central-de-erros
$ mvn clean install
$ mvn spring-boot:run
```
Para testar a aplicação acesse http://localhost:8080/, deve retornar uma mensagem com o link da documentação.

---

## 📦 Deploy

https://api-central-de-erros-java.herokuapp.com/

---

## 📋 Tabelas de endpoints

| Endpoint | Verbo | Função |
| :--- | :---: | :---: |
| /events | GET | Lista eventos de erro | 
| /events | POST | Registra novo evento de erro |
| /oauth/token + parametros de login  | GET | Autentica/Solicita token |
| /events/{id} | GET | Busca evento de erro por id | 
| /events/level/count/{level} | GET | Retorna número de eventos por nível | 
| /events/date/{date} | GET | Busca eventos por data | 
| /events/level/{level} | GET | Busca eventos por nível(level) | 
| /events/log/{log} | GET | Busca eventos por log | 
| /events/origin/{origin} | GET | Busca eventos por origem | 
| /user | GET | Lista usuários cadastrados | 
| /user | POST | Registra novo usuário | 
| /user/{id} | GET | Busca usuários por id | 

---

## 📌 Documentação

Documentação da API disponivel em https://api-central-de-erros-java.herokuapp.com/swagger-ui.html#/

---

## 🛠️ Construído com

* [Java 8](https://docs.oracle.com/javase/8/) - Linguagem de programação
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [PostgreSQL 10](https://www.postgresql.org/) - Banco de Dados
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework
* [Swagger](https://swagger.io/) - Documentação API
* [JUnit](https://junit.org/junit4/) - Testes Unitários

---

## ✒️ Autores

<table>
  <tr>
    <td align="center"><a href="https://github.com/alvarovascon"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/69821227?v=4" width="100px;" alt=""/><br /><sub><b>Álvaro Vasconcelos</b></sub></a><br /><a href="https://github.com/alvarovascon" title="Álvaro Vasconcelos"></a></td>
        <td align="center"><a href="https://github.com/zezomenon"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/59895062?v=4" width="100px;" alt=""/><br /><sub><b>Israel Menon</b></sub></a><br /><a href="https://github.com/zezomenon" title="Israel Menon"></a></td>
    <td align="center"><a href="https://github.com/Letsft"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/69821892?s=400&u=be0329d3ad2d8b19523267a9a988d453bee7a918&v=4" width="100px;" alt=""/><br /><sub><b>Letícia Ferreira Teixeira</b></sub></a><br /><a href="https://github.com/Letsft" title="Letícia Ferreira Teixeira"></a></td>
    <td align="center"><a href="https://github.com/Jr3564"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/66075313?v=4" width="100px;" alt=""/><br /><sub><b>Rodolfo Martins</b></sub></a><br /><a href="https://github.com/Jr3564" title="Rodolfo Martins"></a></td>
  </tr>
</table>

---

## **:star2: Agradecimentos**

<div align=center>

<table style="width:100%">
  <tr align=center>
    <th><strong>CI&T</strong></th>
    <th><strong>trybe</strong></th>
    <th><strong>codenation</strong></th>
  </tr>
  <tr align=center>
    <td>
      <a href="https://www.ciandt.com/">
        <img width="100" height="100" src="https://brasscom.org.br/wp-content/uploads/2019/08/Logo-CIT-com-identidade-visual.jpg">
      </a>
    </td>
    <td>
      <a href="https://www.betrybe.com">
        <img width="100" height="100" src="https://pbs.twimg.com/profile_images/1335930580010225667/cFKy_fC3_400x400.jpg">
      </a>
    </td>
    <td>
      <a href="https://www.codenation.dev">
        <img width="100" height="100" src="https://yt3.ggpht.com/ytc/AAUvwnhDuX53Uk1pTu5EvEU6ZaRYzDcTAyxh3LQ6AHnmXA=s900-c-k-c0x00ffffff-no-rj">
      </a>
    </td>
  </tr>
</table>

</div>
