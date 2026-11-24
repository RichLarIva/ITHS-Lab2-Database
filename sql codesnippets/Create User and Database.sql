CREATE DATABASE IF NOT EXISTS lab2_db;

USE lab2_db;

CREATE USER IF NOT EXISTS 'lab2_user'@'localhost' IDENTIFIED BY '<PASSWORD>';
GRANT ALL PRIVILEGES ON lab2_db.* TO 'lab2_user'@'localhost';