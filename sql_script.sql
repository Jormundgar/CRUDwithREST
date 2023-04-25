CREATE TABLE employees
(
    id         SERIAL PRIMARY KEY NOT NULL,
    name       VARCHAR(15),
    surname    VARCHAR(25),
    department VARCHAR(20),
    salary     INT
);

INSERT INTO employees (name, surname, department, salary)
VALUES ('Dave', 'Batista', 'IT', 500),
       ('Mike', 'Lang', 'Sales', 700),
       ('Helen', 'Karter', 'HR', 850);