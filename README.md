📋 Sistema de Cadastro de Clientes em Java (Swing)
📌 Descrição

Este projeto consiste em um sistema simples de cadastro de clientes desenvolvido em Java utilizando Swing para interface gráfica.

A aplicação permite inserir, validar e exibir dados de clientes em uma tabela, com foco em práticas de desenvolvimento para alunos iniciantes/intermediários.

🚀 Funcionalidades
Cadastro de clientes com:
Nome
Data de nascimento
CPF
Email
Celular
Validação de campos obrigatórios
Validação de CPF (cálculo dos dígitos verificadores)
Máscaras de entrada:
CPF (###.###.###-##)
Data (##/##/####)
Celular ((##) #####-####)
Exibição dos dados em tabela (JTable)
Interface moderna com FlatLaf
🖥️ Tecnologias Utilizadas
Java
Swing (Interface gráfica)
FlatLaf (Look and Feel moderno)
JTable / DefaultTableModel
JFormattedTextField (máscaras)
📂 Estrutura do Projeto
CadastroClientes.java

O projeto é composto por uma única classe principal que contém:

Interface gráfica
Lógica de cadastro
Validação de CPF
Classe interna Cliente
⚙️ Como Executar o Projeto
1. Pré-requisitos
Java JDK 8 ou superior
IDE (IntelliJ, Eclipse ou NetBeans)
2. Adicionar a biblioteca FlatLaf

Se estiver usando Maven, adicione no pom.xml:

<dependency>
  <groupId>com.formdev</groupId>
  <artifactId>flatlaf</artifactId>
  <version>3.4</version>
</dependency>

Se NÃO estiver usando Maven:

Baixe o .jar do FlatLaf
Adicione ao projeto (Build Path / Libraries)
3. Executar

Basta rodar a classe:

CadastroClientes.java
🧠 Validação de CPF

O sistema implementa uma validação básica de CPF que:

Remove caracteres especiais
Verifica tamanho (11 dígitos)
Evita sequências repetidas (ex: 11111111111)
Calcula os dígitos verificadores
🖼️ Interface

A aplicação possui:

Formulário na parte superior
Tabela de clientes na parte inferior
Botões:
Salvar
Exibir na Tabela
⚠️ Possíveis Melhorias

Este projeto pode evoluir para:

💾 Persistência em arquivo (.txt ou .json)
🗄️ Integração com banco de dados (MySQL/PostgreSQL)
🔍 Busca de clientes
✏️ Edição e exclusão de registros
🌐 Versão com JavaFX
📊 Paginação na tabela
🧑‍💻 Autor

Projeto desenvolvido para fins educacionais em curso de TI, com foco no aprendizado de:

Programação Java
Interfaces gráficas
Boas práticas de validação
📄 Licença

Este projeto é livre para uso acadêmico e estudos.
