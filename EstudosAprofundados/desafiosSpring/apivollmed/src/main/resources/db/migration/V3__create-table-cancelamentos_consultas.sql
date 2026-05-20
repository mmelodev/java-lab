use vollmed_api;
CREATE TABLE cancelamentos_consultas
(
    id          BIGINT PRIMARY KEY,
    consulta_id BIGINT       NOT NULL,
    motivo      VARCHAR(255) NOT NULL,
    CONSTRAINT fk_cancelamento_consulta FOREIGN KEY (consulta_id) REFERENCES consulta (id)
);