ALTER TABLE Pet DROP COLUMN especie;
ALTER TABLE Pet DROP COLUMN raca;

ALTER TABLE Pet ADD (id_especie NUMBER NOT NULL);
ALTER TABLE Pet ADD (id_raca NUMBER NOT NULL);

CREATE SEQUENCE seq_especie START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE seq_raca START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

-- ESPECIE
CREATE TABLE Especie (
    id_especie      NUMBER PRIMARY KEY,
    nome_especie    VARCHAR2(50) NOT NULL
);

-- RACA
CREATE TABLE Raca (
    id_raca         NUMBER PRIMARY KEY,
    nome_raca       VARCHAR2(50) NOT NULL,
    id_especie      NUMBER NOT NULL,
    FOREIGN KEY (id_especie) REFERENCES Especie(id_especie)
);

ALTER TABLE Pet
  ADD CONSTRAINT fk_pet_especie FOREIGN KEY (id_especie) REFERENCES Especie(id_especie);

ALTER TABLE Pet
  ADD CONSTRAINT fk_pet_raca FOREIGN KEY (id_raca) REFERENCES Raca(id_raca);

-- PET_TUTOR
CREATE TABLE Pet_Tutor (
    id_pet    NUMBER NOT NULL,
    id_tutor  NUMBER NOT NULL,
    PRIMARY KEY (id_pet, id_tutor),
    FOREIGN KEY (id_pet) REFERENCES Pet(id_pet),
    FOREIGN KEY (id_tutor) REFERENCES Tutor(id_tutor)
);