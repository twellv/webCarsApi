# WebCars API

WebCars é uma plataforma para venda de carros desenvolvida utilizando tecnologias modernas para garantir eficiência e escalabilidade. Este repositório contém o código-fonte do backend, implementado em Java utilizando Spring Boot.

## Funcionalidades

- Cadastro de usuários
- Cadastro de carros
- Busca de carros por diferentes critérios
- Autenticação e autorização de usuários
- Integração com banco de dados PostgreSQL
- Testes unitários e de integração

## Tecnologias Utilizadas

- **Java**: Linguagem principal utilizada para o desenvolvimento do backend.
- **Spring Boot**: Framework utilizado para criar aplicações Java robustas e escaláveis.
- **Maven**: Ferramenta de automação de build e gerenciamento de dependências.
- **JUnit 5**: Framework de testes utilizado para escrever e executar testes unitários.
- **Mockito**: Biblioteca utilizada para criar mocks e facilitar a escrita de testes unitários.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar dados da aplicação.
- **Postman**: Ferramenta utilizada para testar endpoints da API.

## Como Executar o Projeto

### Pré-requisitos

- Java 11 ou superior
- Maven
- PostgreSQL
- Docker (opcional)

### Configuração do Banco de Dados

1. Certifique-se de que o PostgreSQL está instalado e em execução.
2. Crie um banco de dados chamado `webcars`.
3. Configure as credenciais do banco de dados no arquivo `application.properties` localizado em `src/main/resources`:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/webcars
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update
    ```

### Executando a Aplicação

Você pode executar a aplicação de duas maneiras: utilizando o Maven ou Docker.

#### Utilizando Maven

1. Navegue até o diretório raiz do projeto.
2. Execute o comando:

    ```bash
    mvn spring-boot:run
    ```

#### Utilizando Docker

1. Navegue até o diretório raiz do projeto.
2. Execute o comando:

    ```bash
    docker-compose up
    ```

### Testando a API

Para testar os endpoints da API, você pode utilizar o Postman. Uma coleção de exemplo pode ser encontrada no repositório (`[WebCars.postman_collection.json](https://documenter.postman.com/preview/14054053-7a2f674e-8901-4951-bef4-01cbe15e658f?environment=&versionTag=latest&apiName=CURRENT&version=latest&documentationLayout=classic-double-column&documentationTheme=light&logo=https%3A%2F%2Fres.cloudinary.com%2Fpostman%2Fimage%2Fupload%2Ft_team_logo%2Fv1%2Fteam%2Fanonymous_team&logoDark=https%3A%2F%2Fres.cloudinary.com%2Fpostman%2Fimage%2Fupload%2Ft_team_logo%2Fv1%2Fteam%2Fanonymous_team&right-sidebar=303030&top-bar=FFFFFF&highlight=FF6C37&right-sidebar-dark=303030&top-bar-dark=212121&highlight-dark=FF6C37)`).

### Executando Testes

Para executar os testes unitários e de integração, utilize o seguinte comando:

```bash
mvn test


Contribuindo
Se você deseja contribuir para o projeto, sinta-se à vontade para abrir uma issue ou enviar um pull request. Toda ajuda é bem-vinda!

Licença
Este projeto está licenciado sob a MIT License - veja o arquivo LICENSE para mais detalhes.

Contato
Wellington Araujo de Lima
Email: wellingtonaraujotwellv@gmail.com
LinkedIn: Wellington Araujo
GitHub: twellv
