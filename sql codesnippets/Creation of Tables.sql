USE lab2_db;

CREATE TABLE IF NOT EXISTS department(
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    office_name VARCHAR(100) NOT NULL,
    office_city VARCHAR(100) NOT NULL 
);

CREATE TABLE IF NOT EXISTS employee(
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(150) UNIQUE,
    hire_date DATE NOT NULL,
    department_id INT NOT NULL,
    CONSTRAINT fk_employee_department 
        FOREIGN KEY (department_id) REFERENCES department(department_id)
);

CREATE TABLE IF NOT EXISTS access_card(
    employee_id INT PRIMARY KEY,
    card_number VARCHAR(50) NOT NULL UNIQUE,
    issue_date DATE NOT NULL,
    expiry_date DATE NOT NULL,
    CONSTRAINT fk_employee_id
        FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);