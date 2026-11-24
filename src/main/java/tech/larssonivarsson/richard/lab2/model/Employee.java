package tech.larssonivarsson.richard.lab2.model;

import java.time.LocalDate;
import java.util.*;

public class Employee {
    private final int employeeId;
    private final String firstName;
    private final String lastName;
    private final String email; // Nullable within the database
    private final LocalDate hireDate;
    private final Department department; // Obligatory (1)
    private AccessCard accessCard; // Optional (0..1)
    private final Set<Competency> competencies = new LinkedHashSet<>();

    public Employee(int employeeId, String firstName, String lastName, String email, LocalDate hireDate, Department department) {
        this.employeeId = employeeId;
        this.firstName = Objects.requireNonNull(firstName, "firstName cannot be null");
        this.lastName = Objects.requireNonNull(lastName, "lastName cannot be null");
        this.email = email;
        this.hireDate = Objects.requireNonNull(hireDate, "hireDate cannot be null");
        this.department = Objects.requireNonNull(department, "department cannot be null");
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public Optional<AccessCard> getAccessCard() {
        return Optional.ofNullable(accessCard);
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    public void addCompetency(Competency competency) {
        competencies.add(Objects.requireNonNull(competency, "competency cannot be null"));
    }

    public Set<Competency> getCompetencies() {
        return Collections.unmodifiableSet(competencies);
    }
}