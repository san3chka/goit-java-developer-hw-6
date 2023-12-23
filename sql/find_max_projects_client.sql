SELECT c.name, count(p.id) as project_count
FROM client c
join project p ON c.id = p.client_id
GROUP BY c.id, c.name
HAVING count(p.id) =
       (SELECT max(project_count)
        FROM (SELECT count(id) AS project_count
        FROM project
        GROUP BY client_id) AS counts);