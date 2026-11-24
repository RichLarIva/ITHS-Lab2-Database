USE lab2_db;

SELECT CONCAT(e.first_name, ' ', e.last_name) AS full_name,
       d.office_name,
       ac.card_number
FROM employee AS e
    INNER JOIN department AS d on e.department_id = d.department_id
    LEFT JOIN access_card ac on e.employee_id = ac.employee_id;

SELECT d.office_name,
       CONCAT(e.first_name, ' ', e.last_name) AS full_name,
       ac.card_number
FROM department AS d
    LEFT JOIN employee AS e on e.department_id = d.department_id
    LEFT JOIN access_card ac on e.employee_id = ac.employee_id;

# Kör för Richard (employee_id = 1) (Då han har 2 kompetenser)
SELECT
    e.employee_id,
    CONCAT(e.first_name, ' ',e.last_name)
    AS full_name,
       e.email,
       e.hire_date,
       d.office_name,
       d.office_city,
       ac.card_number,
       ac.issue_date,
       ac.expiry_date,
       c.name AS competency_name,
       c.description AS competency_description
FROM employee AS e
         LEFT JOIN department AS d ON e.department_id = d.department_id
         LEFT JOIN access_card AS ac ON e.employee_id = ac.employee_id
         LEFT JOIN employee_competency AS ec ON e.employee_id = ec.employee_id
         LEFT JOIN competency AS c ON ec.competency_id = c.competency_id
WHERE e.employee_id = 1;

# Nu för Erik som bara har en Kompetens men ingen passerkort och för Per John som inte har någon passerkort eller kompetens
SELECT
    e.employee_id,
    CONCAT(e.first_name, ' ',e.last_name)
                  AS full_name,
    e.email,
    e.hire_date,
    d.office_name,
    d.office_city,
    ac.card_number,
    ac.issue_date,
    ac.expiry_date,
    c.name AS competency_name,
    c.description AS competency_description
FROM employee AS e
         LEFT JOIN department AS d ON e.department_id = d.department_id
         LEFT JOIN access_card AS ac ON e.employee_id = ac.employee_id
         LEFT JOIN employee_competency AS ec ON e.employee_id = ec.employee_id
         LEFT JOIN competency AS c ON ec.competency_id = c.competency_id
WHERE e.employee_id = 2 OR e.employee_id = 3;


# Nu jämför vi inner join vs left join med department

# 1. INNER JOIN
SELECT d.office_name, e.first_name, e.last_name
FROM department AS d
         INNER JOIN employee AS e ON d.department_id = e.department_id;

# 2. LEFT JOIN
SELECT d.office_name, e.first_name, e.last_name
FROM department AS d
         LEFT JOIN employee AS e ON d.department_id = e.department_id;