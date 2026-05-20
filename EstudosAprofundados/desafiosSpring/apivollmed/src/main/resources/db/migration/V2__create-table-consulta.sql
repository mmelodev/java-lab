CREATE TABLE consulta
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    medico_id   BIGINT                NULL,
    paciente_id BIGINT                NULL,
    data        datetime              NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_CONSULTA_MEDICO_ID FOREIGN KEY (medico_id) REFERENCES medicos (id),
    CONSTRAINT FK_CONSULTA_PACIENTE_ID FOREIGN KEY (paciente_id) REFERENCES pacientes (id)
);


