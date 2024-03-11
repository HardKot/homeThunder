
CREATE TABLE users (
    id UUID PRIMARY KEY default gen_random_uuid(),

    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255),

    gender VARCHAR(255) NOT NULL,
    birthday DATE,

    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255),

    password VARCHAR(255),

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP
);
