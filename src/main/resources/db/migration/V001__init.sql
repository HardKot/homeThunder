CREATE TYPE GENDER AS ENUM ('Male', 'Female');

CREATE TABLE users (
    id UUID PRIMARY KEY default gen_random_uuid(),

    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255),

    gender GENDER NOT NULL,
    birthday DATE,

    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255),

    username VARCHAR(255) NOT NULL,

    password bytea NOT NULL,

    enabled boolean default true,

    avatar_id UUID,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP
);
