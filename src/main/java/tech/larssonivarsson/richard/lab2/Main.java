package tech.larssonivarsson.richard.lab2;

import tech.larssonivarsson.richard.lab2.model.AccessCard;
import tech.larssonivarsson.richard.lab2.model.Competency;
import tech.larssonivarsson.richard.lab2.model.Department;
import tech.larssonivarsson.richard.lab2.model.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void main() {
        // Create the departments (Accurate to the testdata in the database)
        Department development = new Department(1, "Development", "Björkstaden");
        Department sales = new Department(2, "Sales", "Nåntuna");
        Department hr = new Department(3, "HR", "Mariehamn");

        // Creation of the employees (Per Johan does not have an email)
        Employee richard = new Employee(1, "Richard", "Loftén", "richard.loften@work.it",
                LocalDate.of(2026, 5, 13), development);
        Employee erik = new Employee(2, "Erik", "Matteus", "erik.matteus@work.it",
                LocalDate.of(2007, 2, 10), development);
        Employee perJohan = new Employee(3, "Per Johan", "Fenrix", null,
                LocalDate.of(2026, 11, 24), sales);
        Employee maria = new Employee(4, "Maria", "Josefsson", "maria.josefsson@work.it",
                LocalDate.of(2020, 9, 12), sales);

        // Connect the access card to Richard and Maria
        richard.setAccessCard(new AccessCard("WOIT-1051",
                LocalDate.of(2026, 5, 13), LocalDate.of(2028, 12, 31)));
        maria.setAccessCard(new AccessCard("WOIT-1023",
                LocalDate.of(2025, 2, 1), LocalDate.of(2027, 12, 31)));

        // Create competencies (shared instances across employees, plus one unassigned)
        Competency java = new Competency(1, "Java", "Objektorienterad programmering och applikationsutveckling i Java");
        Competency sql = new Competency(2, "SQL", "Relationsdatabaser, datamodellering och SQL-frågor");
        Competency projektledning = new Competency(3, "Projektledning", "Planering och ledning av agila utvecklingsprojekt");

        // Connect competencies to employees (Per Johan has none; Projektledning has no employees)
        richard.addCompetency(java);
        richard.addCompetency(sql);
        erik.addCompetency(java);
        maria.addCompetency(sql);

        List<Employee> employeeList = List.of(richard, erik, perJohan, maria);
        List<Competency> competencyList = List.of(java, sql, projektledning);

        IO.println("---------- Personalregister ----------");
        for (Employee emp : employeeList) {
            String emailInfo = emp.getEmail().orElse("Ingen email");
            String cardInfo = emp.getAccessCard()
                    .map(AccessCard::toString)
                    .orElse("Inget passerkort");
            String competencyInfo = emp.getCompetencies().isEmpty()
                    ? "Inga kompetenser"
                    : emp.getCompetencies().stream()
                    .map(Competency::getName)
                    .collect(Collectors.joining(", "));

            String output = String.format(
                    "Anställd: %s\n\tAnställningsdatum: %s\n\tEmail: %s\n\tAvdelning: %s\n\tPasserkort: %s\n\tKompetenser: %s",
                    emp.getFullName(),
                    emp.getHireDate(),
                    emailInfo,
                    emp.getDepartment(),
                    cardInfo,
                    competencyInfo);

            IO.println(output);
        }

        IO.println("\n---------- Registrerade kompetenser ----------");
        for (Competency comp : competencyList) {
            long employeeCount = employeeList.stream()
                    .filter(emp -> emp.getCompetencies().contains(comp))
                    .count();

            IO.println(String.format("%s (antal anställda: %d)", comp, employeeCount));
        }
    }
}