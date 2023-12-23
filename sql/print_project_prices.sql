WITH project_prices AS (
    SELECT
        p.ID,
        SUM(w.salary) * EXTRACT(MONTH FROM AGE(p.finish_date, p.start_date)) AS PRICE
    FROM
        project p
            JOIN project_worker pw ON p.ID = pw.project_id
            JOIN worker w ON pw.worker_id = w.ID
    GROUP BY
        p.ID
)
SELECT
    p.ID AS PROJECT_ID,
    COALESCE(pp.PRICE, 0) AS PRICE
FROM
    project p
        LEFT JOIN project_prices pp ON p.ID = pp.ID
ORDER BY
    PRICE DESC;
