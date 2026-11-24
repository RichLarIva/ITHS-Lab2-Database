USE lab2_db;

SELECT concat(e.first_name, ' ', e.last_name ) AS full_name, d.office_name
FROM employee AS e
        INNER JOIN department AS d ON e.department_id = d.department_id;

SELECT d.office_name, concat(e.first_name, ' ', e.last_name ) AS full_name
FROM department AS d
         LEFT JOIN employee AS e ON e.department_id = d.department_id;