CREATE TABLE worker
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(1000) NOT NULL
        CHECK (length(name) >= 2 AND length(name) <= 1000),
    birthday DATE CHECK (extract(YEAR FROM birthday) > 1900),
    level VARCHAR NOT NULL
        CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior')),
    salary INT CHECK (salary >= 100 AND salary <= 100000)
);

CREATE TABLE client
(
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL
        CHECK (length(name) >= 2 AND length(name) <= 1000)
);

CREATE TABLE project
(
    id SERIAL PRIMARY KEY,
    client_id INT,
    start_date DATE,
    finish_date DATE,
    FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE project_worker
(
    project_id INT,
    worker_id INT,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY (project_id) REFERENCES project(id),
    FOREIGN KEY (worker_id) REFERENCES worker(id)
);