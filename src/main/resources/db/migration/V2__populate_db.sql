INSERT INTO worker (name, birthday, level, salary)
VALUES
    ('John Doe', '1985-05-15', 'Trainee', 800),
    ('Jane Smith', '1988-12-03', 'Junior', 1200),
    ('Bob Johnson', '1982-08-20', 'Middle', 2500),
    ('Alice Williams', '1987-04-10', 'Senior', 5000),
    ('Charlie Brown', '1990-11-25', 'Trainee', 900),
    ('Emma Davis', '1984-02-18', 'Junior', 1300),
    ('Frank Wilson', '1989-09-07', 'Middle', 2800),
    ('Grace Miller', '1983-06-12', 'Senior', 5500),
    ('Henry Jones', '1992-03-28', 'Trainee', 950),
    ('Ivy Taylor', '1986-10-05', 'Junior', 1400);

INSERT INTO client (name)
VALUES
    ('Client 1'),
    ('Client 2'),
    ('Client 3'),
    ('Client 4'),
    ('Client 5');

INSERT INTO project(client_id, start_date, finish_date)
VALUES
    (1, '2022-11-19', current_date),
    (2, '2022-09-08', current_date),
    (3, '2022-11-11', current_date),
    (4, '2023-09-19', current_date),
    (5, '2021-10-23', current_date),
    (1, '2022-05-13', current_date),
    (2, '2022-06-09', current_date),
    (3, '2021-12-01', current_date),
    (4, '2022-07-28', current_date),
    (5, '2022-09-04', current_date);

INSERT INTO project_worker(project_id, worker_id)
VALUES
    (1, 1),
    (1, 2),

    (2, 2),
    (2, 5),

    (3, 7),
    (3, 9),

    (4, 5),
    (5, 4),
    (6, 7),

    (7, 6),
    (7, 10),

    (8, 2),
    (9, 4),
    (10, 8);