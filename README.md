# API REST com Padrões de Projeto (Singleton, Strategy e Facade)

## 📖 Introdução
Este projeto tem como objetivo demonstrar a aplicação prática de padrões de projeto (Singleton, Strategy e Facade) em uma API REST desenvolvida com Java e Spring Boot.

A API permite o cadastro de clientes associados a um endereço, que é obtido dinamicamente a partir do CEP informado. Para isso, a aplicação verifica se existe o endereço com CEP já cadastrado na base de dados, ou consulta a API [ViaCep](https://viacep.com.br/) caso não exista.

A arquitetura foi organizada em três camadas principais:
- Presentation → responsável por expor os endpoints REST e DTOs.
- Core → concentra o domínio, regras de negócio e padrões de projeto.
- Infrastructure → cuida da persistência, integração externa e configurações técnicas.

Além disso, o projeto utiliza Swagger/OpenAPI para documentação interativa dos endpoints, permitindo explorar e testar a API diretamente pelo navegador.

Com essa abordagem, o projeto não apenas resolve um caso de uso real (cadastro de cliente com endereço via CEP), mas também serve como guia didático para entender como aplicar boas práticas de design de software em aplicações Spring modernas.

---

## 🛠️ Ferramentas utilizadas
- Spring Web → Criação de endpoints REST.
- Spring Data JPA → Persistência e abstração de acesso ao banco de dados.
- H2 In-Memory Database → Banco de dados em memória para testes e desenvolvimento.
- Rest Client → Consumo de APIs externas.
- Swagger/OpenAPI (Springdoc) → Documentação e interface interativa para explorar os endpoints da API.

## 📐 Padrões de Projeto no Contexto Spring
- #### Singleton
Spring já utiliza Singleton por padrão no ciclo de vida dos beans.

Quando anotamos uma classe com @Service, @Repository ou @Component, o Spring cria uma única instância (singleton) e a gerencia no container de IoC. Isso evita a necessidade de implementar manualmente o padrão.

- #### Strategy
O padrão Strategy se encaixa muito bem com o uso de interfaces e múltiplas implementações no Spring.

Neste projeto foi definida uma interface de comportamento (```AddressSearchStrategy```) e criar diferentes implementações (```AddressLocalDatabaseSearchStrategy``` e ```AddressViaCepSearchStrategy```).

O Spring se encarrega de injetar dinamicamente todas implementações em um Map.

- #### Facade
O padrão Facade é aplicado quando queremos simplificar o acesso a subsistemas complexos.

No Spring, isso geralmente aparece em camadas de serviço que encapsulam chamadas a múltiplos repositórios, integrações externas ou regras de negócio.

O controller, por exemplo, pode chamar apenas um método da fachada, sem precisar conhecer os detalhes internos.

## ▶️ Passos para execução
1. Clone o repositório:

```bash
git clone https://github.com/gabriel-olv/design-pattern-java.git
```

2. Acesse a pasta do projeto:

```bash
cd design-pattern-java
```

3. Compile e execute com Maven:

```bash
mvn spring-boot:run
```

4. Após iniciar a aplicação, acesse:

```bash
http://localhost:8080/swagger-ui.html
```
Lá você pode:

- Explorar todos os endpoints.

- Testar requisições diretamente pelo navegador.


