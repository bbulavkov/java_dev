CREATE SCHEMA java_lessons;

CREATE TABLE IF NOT EXISTS java_lessons.users (

                                                  id SERIAL PRIMARY KEY ,
                                                  name VARCHAR(100),
                                                  age INT
);