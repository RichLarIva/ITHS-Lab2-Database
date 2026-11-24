USE lab2_db;

CREATE TABLE IF NOT EXISTS competency (
    competency_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee_competency(
    employee_id INT NOT NULL,
    competency_id INT NOT NULL,
    PRIMARY KEY(employee_id, competency_id),
    CONSTRAINT fk_empcomp_employee
        FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
    CONSTRAINT fk_empcomp_competency
        FOREIGN KEY (competency_id) REFERENCES competency(competency_id)
);