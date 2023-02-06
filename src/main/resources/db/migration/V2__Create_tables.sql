CREATE TABLE IF NOT EXISTS java_lessons.users
(

    id   SERIAL PRIMARY KEY,
    name VARCHAR(100),
    age  INT
);


CREATE TABLE IF NOT EXISTS java_lessons.account
(
    id    SERIAL PRIMARY KEY,
    money INT
);