CREATE TABLE restaurante (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    telefone VARCHAR(50) NOT NULL,
    capacidade_total INTEGER NOT NULL
);

CREATE TABLE cliente (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(50) NOT NULL
);

CREATE TABLE mesa (
    id BIGSERIAL PRIMARY KEY,
    numero INTEGER NOT NULL,
    capacidade INTEGER NOT NULL,
    status VARCHAR(20) NOT NULL,
    restaurante_id BIGINT NOT NULL,
    CONSTRAINT fk_mesa_restaurante FOREIGN KEY (restaurante_id)
        REFERENCES restaurante(id)
        ON DELETE CASCADE
);

CREATE TABLE reserva (
    id BIGSERIAL PRIMARY KEY,
    data_hora TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,
    cliente_id BIGINT NOT NULL,
    mesa_id BIGINT NOT NULL,
    CONSTRAINT fk_reserva_cliente FOREIGN KEY (cliente_id)
        REFERENCES cliente(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_reserva_mesa FOREIGN KEY (mesa_id)
        REFERENCES mesa(id)
        ON DELETE CASCADE
);