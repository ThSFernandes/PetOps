CREATE SEQUENCE seq_tutor START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE seq_endereco START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE seq_pet START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE seq_funcionario START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE seq_servico START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE seq_agendamento START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE TABLE Tutor (
    id_tutor           NUMBER PRIMARY KEY,
    nome_tutor         VARCHAR2(50) NOT NULL,
    cpf                VARCHAR2(11) NOT NULL,
    telefone           VARCHAR2(15),
    email              VARCHAR2(100),
    id_endereco        NUMBER,
    data_nascimento    DATE
);

CREATE TABLE Endereco (
    id_endereco    NUMBER PRIMARY KEY,
    id_tutor       NUMBER,
    logradouro     VARCHAR2(100),
    bairro         VARCHAR2(50),
    numero_casa    VARCHAR2(10),
    complemento    VARCHAR2(50),
    cidade         VARCHAR2(50),
    estado         VARCHAR2(2),
    FOREIGN KEY (id_tutor) REFERENCES Tutor(id_tutor)
);

CREATE TABLE Pet (
    id_pet           NUMBER PRIMARY KEY,
    id_tutor         NUMBER NOT NULL,
    nome_pet         VARCHAR2(30) NOT NULL,
    especie          VARCHAR2(20),
    raca             VARCHAR2(30),
    porte            VARCHAR2(10),
    sexo             VARCHAR2(10),
    data_nascimento  DATE,
    FOREIGN KEY (id_tutor) REFERENCES Tutor(id_tutor)
);

CREATE TABLE Funcionario (
    id_funcionario      NUMBER PRIMARY KEY,
    nome_funcionario    VARCHAR2(50) NOT NULL,
    telefone            VARCHAR2(15),
    funcao              VARCHAR2(20) NOT NULL,
    crmv                VARCHAR2(20)
);

CREATE TABLE Servico (
    id_servico     NUMBER PRIMARY KEY,
    nome_servico   VARCHAR2(50) NOT NULL,
    valor          NUMBER(10,2) NOT NULL
);

CREATE TABLE Agendamento (
    id_agendamento              NUMBER PRIMARY KEY,
    data_marcada                DATE NOT NULL,
    status                      VARCHAR2(20),
    observacoes                 VARCHAR2(255),
    id_pet                      NUMBER NOT NULL,
    id_funcionario_veterinario  NUMBER,
    id_funcionario_groomer      NUMBER,
    FOREIGN KEY (id_pet) REFERENCES Pet(id_pet),
    FOREIGN KEY (id_funcionario_veterinario) REFERENCES Funcionario(id_funcionario),
    FOREIGN KEY (id_funcionario_groomer) REFERENCES Funcionario(id_funcionario)
);

CREATE TABLE Agendamento_Servico_Adicional (
    id_agendamento   NUMBER NOT NULL,
    id_servico       NUMBER NOT NULL,
    PRIMARY KEY (id_agendamento, id_servico),
    FOREIGN KEY (id_agendamento) REFERENCES Agendamento(id_agendamento),
    FOREIGN KEY (id_servico) REFERENCES Servico(id_servico)
);