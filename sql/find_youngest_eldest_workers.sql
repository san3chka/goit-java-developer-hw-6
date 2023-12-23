WITH youngest AS (
    SELECT
        'YOUNGEST' AS TYPE,
        NAME,
        BIRTHDAY
    FROM
        worker
    WHERE
            BIRTHDAY = (SELECT max(BIRTHDAY) FROM worker)
),
     eldest AS (
         SELECT
             'ELDEST' AS TYPE,
             NAME,
             BIRTHDAY
         FROM
             worker
         WHERE
                 BIRTHDAY = (SELECT min(BIRTHDAY) FROM worker)
     )
SELECT
    *
FROM
    youngest

UNION ALL

SELECT
    *
FROM
    eldest;