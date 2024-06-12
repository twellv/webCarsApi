WebCars API
WebCars é uma plataforma para venda de carros desenvolvida utilizando tecnologias modernas para garantir eficiência e escalabilidade. Este repositório contém o código-fonte do backend, implementado em Java utilizando Spring Boot.

Funcionalidades
Cadastro de usuários
Cadastro de carros
Busca de carros por diferentes critérios
Autenticação e autorização de usuários
Integração com banco de dados PostgreSQL
Testes unitários e de integração
Tecnologias Utilizadas
Java: Linguagem principal utilizada para o desenvolvimento do backend.
Spring Boot: Framework utilizado para criar aplicações Java robustas e escaláveis.
Maven: Ferramenta de automação de build e gerenciamento de dependências.
JUnit 5: Framework de testes utilizado para escrever e executar testes unitários.
Mockito: Biblioteca utilizada para criar mocks e facilitar a escrita de testes unitários.
PostgreSQL: Banco de dados relacional utilizado para armazenar dados da aplicação.
Postman: Ferramenta utilizada para testar endpoints da API.
Como Executar o Projeto
Pré-requisitos
Java 11 ou superior
Maven
PostgreSQL
Docker (opcional)
Configuração do Banco de Dados
Certifique-se de que o PostgreSQL está instalado e em execução.
Crie um banco de dados chamado webcars.
Configure as credenciais do banco de dados no arquivo application.properties localizado em src/main/resources:
  spring.datasource.url=jdbc:postgresql://localhost:5432/webcars
  spring.datasource.username=seu_usuario
  spring.datasource.password=sua_senha
  spring.jpa.hibernate.ddl-auto=update

  Executando a Aplicação
Você pode executar a aplicação de duas maneiras: utilizando o Maven ou Docker.

Utilizando Maven
Navegue até o diretório raiz do projeto.

Execute o comando: mvn spring-boot:run

Utilizando Docker
Navegue até o diretório raiz do projeto.

Execute o comando: docker-compose up

Testando a API
Para testar os endpoints da API, você pode utilizar o Postman. Uma coleção de exemplo pode ser encontrada no repositório (WebCars.postman_collection.json).

Executando Testes
Para executar os testes unitários e de integração, utilize o seguinte comando: mvn test

Contribuindo
Se você deseja contribuir para o projeto, sinta-se à vontade para abrir uma issue ou enviar um pull request. Toda ajuda é bem-vinda!

Licença
Este projeto está licenciado sob a MIT License - veja o arquivo LICENSE para mais detalhes.

Contato
Wellington Araujo de Lima
Email: wellingtonaraujotwellv@gmail.com
LinkedIn: Wellington Araujo
GitHub: twellv
