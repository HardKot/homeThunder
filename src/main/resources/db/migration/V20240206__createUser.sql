CREATE TABLE entityTable (
    id UUID PRIMARY KEY default gen_random_uuid(),
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TYPE GENDER AS ENUM ('MALE', 'FEMALE');

CREATE TABLE users (

    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255),

    gender GENDER NOT NULL,
    birthday DATE,

    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255),

    avatarId UUID
) INHERITS (entityTable);
