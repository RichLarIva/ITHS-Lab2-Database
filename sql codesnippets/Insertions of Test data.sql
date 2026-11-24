USE lab2_db;

# Har ignore på alla så utifall att denna skulle köras flera gånger så blir det inte dubbletter

# 1. Avdelningar skall skapas först
INSERT IGNORE INTO lab2_db.department(department_id, office_name, office_city) VALUES
(1, 'Development', 'Björkstaden'),
(2, 'Sales', 'Nåntuna'),
(3, 'HR', 'Mariehamn');

# 2. Anställda efter då det kan ju inte kopplas till passerkort annars
INSERT IGNORE INTO lab2_db.employee(employee_id, first_name, last_name, email, hire_date, department_id) VALUES
(1, 'Richard', 'Loftén', 'richard.loften@work.it', '2026-05-13', 1),
(2, 'Erik', 'Matteus', 'erik.matteus@work.it', '2007-02-10', 1),
(3, 'Per Johan', 'Fenrix', NULL, '2026-11-24', 2),
(4, 'Maria', 'Josefsson', 'maria.josefsson@work.it', '2020-09-12', 2);

# 3. Passerkort, bara Richard och Maria får ett
INSERT IGNORE INTO lab2_db.access_card(employee_id, card_number, issue_date, expiry_date) VALUES
(1, 'WOIT-1051', '2026-05-13', '2028-12-31'),
(4, 'WOIT-1023', '2025-02-01', '2027-12-31');


# VG KRAV

#4. Kompetenser (Projektledning kopplas inte till någon anställd)
INSERT IGNORE INTO lab2_db.competency(competency_id, name, description) VALUES
(1, 'Java', 'Objektorienterad programmering och applikationsutveckling i Java.'),
(2, 'SQL', 'Relationsdatabaser, datamodellering och SQL-frågor.'),
(3, 'Projektledning', 'Planering och ledning av agila utvecklingsprojekt.');

# 5. Koppla kompetenser till anställda
# Richard (1): Java och SQL (Flera kompetenser)
# Erik (2): Java (En delad kompetens med Richard, saknar också passerkort)
# Per Johan (3): Inga kompetenser då han är helt ny
# Maria (4): SQL (Delas med richard)
INSERT IGNORE INTO lab2_db.employee_competency (employee_id, competency_id) VALUES
(1, 1),
(1, 2),
(2, 1),
(4, 2);