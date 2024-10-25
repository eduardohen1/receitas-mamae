# Projeto Receitas

📚 Este projeto é um exemplo de aplicação Java Spring para gerenciamento de receitas.

## Tecnologias utilizadas

- <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Spring_Boot.svg/640px-Spring_Boot.svg.png" alt="Spring Boot Icon" width="30" style="vertical-align:middle; margin-right:10px;"> **Java Spring Boot** - Framework de desenvolvimento web em Java.
- <img src="https://www.h2database.com/html/images/h2-logo-2.png" alt="H2 Database Icon" width="30" style="vertical-align:middle; margin-right:10px;"> **H2 Database** - Banco de dados em memória para desenvolvimento e testes.
- <img src="https://cdn.worldvectorlogo.com/logos/openapi-1.svg" alt="OpenAPI Icon" width="30" style="vertical-align:middle; margin-right:10px;"> **Swagger** - Ferramenta para documentação e teste de APIs.
- <img src="https://upload.wikimedia.org/wikipedia/commons/5/52/Apache_Maven_logo.svg" alt="Maven Icon" width="30" style="vertical-align:middle; margin-right:10px;"> **Maven** - Gerenciador de dependências e build do projeto.

## Estrutura do projeto

- 📁 `src/main/java/br/com/ehmf/receitas`: Pasta raiz do código-fonte Java.
- 📁 `src/main/java/br/com/ehmf/receitas/Config`: Contém arquivos de configuração da aplicação como OpenAPI/Swagger e configuração de CORS.
- 📁 `src/main/java/br/com/ehmf/receitas/Controller`: Contém o controlador `ReceitasController` com os endpoints relacionados às receitas.
- 📁 `src/main/java/br/com/ehmf/receitas/Enum`: Contém o arquivo de Enumerador de `TipoReceita`.
- 📁 `src/main/java/br/com/ehmf/receitas/Exception`: Contém arquivo de Exception personalizada.
- 📁 `src/main/java/br/com/ehmf/receitas/Model`: Contém os arquivos de Entidades `Receitas`, `Ingredientes` e `ModoPreparo`.
- 📁 `src/main/java/br/com/ehmf/receitas/Repository`: Contém a interface `ReceitasRepository` para operações de CRUD no banco de dados.
- 📁 `src/main/java/br/com/ehmf/receitas/Service/Interfaces`: Contém a interface `ReceitasServiceInterfaces` para as operações do service.
- 📁 `src/main/java/br/com/ehmf/receitas/Service`: Contém a classe `ReceitasService` com a lógica de negócio relacionada às receitas.
- 📁 `src/main/resources`: Pasta de recursos da aplicação.
- 📄 `src/main/resources/application.yaml`: Arquivo de configuração da aplicação.
- 📄 `src/main/resources/application.properties`: Arquivo de configuração da aplicação.
- 📄 `.gitignore`: Arquivo de configuração do Git para ignorar arquivos e pastas.
- 📄 `mvnw` e `mvnw.cmd`: Scripts para executar o Maven Wrapper.
- 📄 `pom.xml`: Arquivo de configuração do Maven.
- 📄 `README.md`: Documentação do projeto.

## URLs de auxílio

- 🔗 [Swagger UI](http://localhost:8080/swagger-ui/index.html): Documentação da API em Swagger.
- 🔗 [H2 Console](http://localhost:8080/h2-console): Console do banco de dados H2.

💁‍♂️ Espero que isso ajude!
