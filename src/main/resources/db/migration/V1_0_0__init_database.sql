CREATE SCHEMA users;

CREATE SCHEMA immovables;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,

    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255) NULL,
    birthday DATE NULL,

    phone VARCHAR(255) NULL,
    email VARCHAR(255) NOT NULL UNIQUE,

    password VARCHAR(255) NOT NULL,
    salt VARCHAR(255) NOT NULL,

    update_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
) ;

CREATE TABLE immovables.apartment_buildings (
    id SERIAL PRIMARY KEY,

    city VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    house VARCHAR(255) NOT NULL,

    update_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
) ;

CREATE TABLE immovables.flats (
    id SERIAL PRIMARY KEY,

    number INTEGER NOT NULL,
    buildId INTEGER NOT NULL REFERENCES immovables.apartment_buildings(id),
    floor INTEGER NOT NULL,
    entrance INTEGER NOT NULL,

    update_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
) ;

CREATE TABLE users.residents (
    id SERIAL PRIMARY KEY,

    userId INTEGER NOT NULL REFERENCES users(id),
    flatId INTEGER NOT NULL REFERENCES immovables.flats(id),

    startDate DATE NOT NULL,
    leaveDate DATE NULL,

    update_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
) ;

CREATE TABLE users.workers (
    id SERIAL PRIMARY KEY,
    userID INTEGER NOT NULL REFERENCES users(id),

    position VARCHAR(255) NOT NULL,
    startDate DATE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    firedDate DATE NULL,

    update_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);