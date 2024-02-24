CREATE TABLE entityTable (
    id UUID PRIMARY KEY default gen_random_uuid(),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TYPE GENDER AS ENUM ('Male', 'Female');

CREATE TABLE users (

    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255),

    gender GENDER NOT NULL,
    birthday DATE,

    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255),


    password bytea NOT NULL,
    password_salt bytea NOT NULL,

    avatar_id UUID
) INHERITS (entityTable);
