WITH project_duration AS (
    SELECT
        id,
        client_id,
        start_date,
        finish_date,
        EXTRACT(MONTH FROM age(finish_date, start_date)) AS month_duration
    FROM
        project
)
SELECT
    p.id AS project_id,
    p.client_id,
    p.start_date,
    p.finish_date,
    p.month_duration
FROM
    project_duration p
WHERE
        p.month_duration = (SELECT MAX(month_duration) FROM project_duration);