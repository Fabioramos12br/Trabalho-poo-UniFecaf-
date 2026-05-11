# 🚗 Sistema de Gerenciamento de Veículos (POO + JDBC)

> **🚩 IMPORTANTE:** Este projeto possui finalidade estritamente acadêmica e de estudo. Foi desenvolvido para praticar conceitos de Programação Orientada a Objetos (POO), integração de Java com bancos de dados relacionais (JDBC) e estruturação básica de aplicações Spring Boot.

## 📌 Sobre o Projeto
O sistema permite o cadastro, consulta, atualização e exclusão (CRUD) de carros e motocicletas, vinculando-os a marcas previamente cadastradas no banco de dados. A aplicação utiliza uma interface via linha de comando (CLI) para interação com o usuário.

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java 17+
- **Framework:** Spring Boot (para inicialização da aplicação)
- **Banco de Dados:** MySQL 8.0
- **Driver de Conexão:** JDBC (Java Database Connectivity)
- **Gerenciador de Dependências:** Maven

## 🗄️ Estrutura do Banco de Dados
O projeto utiliza três tabelas principais com relacionamentos de Chave Estrangeira (Foreign Key):

```sql
-- Tabela de Marcas
create table tbl_marca (
    id int not null primary key auto_increment,
    nome varchar(200) not null
);

-- Tabela de Carros
create table tbl_carro(
    id int not null primary key auto_increment,
    id_marca int not null,
    modelo varchar(200) not null,
    ano_fab int not null,
    cor varchar(100) not null,
    preco decimal(10,2) not null,
    quilometragem float not null,
    stt_disp boolean default TRUE,
    foreign key(id_marca) references tbl_marca(id) 
);

-- Tabela de Motos (Estrutura similar a carros)
```

## 🚀 Funcionalidades
1.  **Gerenciamento de Marcas:** Cadastro de nomes de fabricantes.
2.  **Cadastro de Veículos:** Vinculação dinâmica entre o veículo e a marca (o sistema busca o ID da marca automaticamente através do nome fornecido).
3.  **Consultas com JOIN:** Listagem de veículos exibindo o nome amigável da marca em vez de apenas o ID numérico.
4.  **Validação de Dados:** Verificação se uma marca existe no banco antes de permitir o cadastro do veículo.
5.  **CRUD Completo:** Funções para editar dados técnicos e remover registros do sistema.

## 📂 Estrutura de Pastas
- `src/main/java/model`: Contém as classes de entidade (`Carro`, `Moto`, `Marca`) e a lógica de captura de dados.
- `src/main/java/Controller`: Contém a lógica de negócio e as consultas SQL (`CarroController`, `MarcaController`, etc.).
- `src/main/java/database`: Classe de configuração da conexão JDBC.
- `src/main/java/br/com/unifecaf/demo/App.java`: Ponto de entrada da aplicação.

## ⚙️ Como executar
1.  Certifique-se de ter o **MySQL** instalado e rodando.
2.  Execute o script SQL contido em `src/main/resources/database/banco.txt` para criar o banco de dados e as tabelas.
3.  Ajuste as credenciais (usuário e senha) no arquivo `src/main/java/database/Conexao.java`.
4.  Execute a aplicação através da classe `App.java`.
5.  Interaja com o menu no console do seu IDE.

## 🧠 Conceitos Aplicados
- **Encapsulamento:** Uso de atributos privados e métodos getters/setters.
- **Persistência de Dados:** Uso de `Statement` e `ResultSet` para manipulação de dados SQL.
- **Tratamento de Exceções:** Blocos `try-catch` para lidar com erros de conversão e falhas de conexão.
- **Relacional:** Uso de subqueries SQL para simplificar a experiência do usuário final.

---
*Este projeto foi desenvolvido como parte do currículo da faculdade para a disciplina de Programação Orientada a Objetos.*
