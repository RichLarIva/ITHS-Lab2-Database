package tech.larssonivarsson.richard.lab2.model;

import java.util.Objects;

public class Department {
    private final int departmentId;
    private final String officeName;
    private final String officeCity;

    public Department(int departmentId, String officeName, String officeCity) {
        this.departmentId = departmentId;
        this.officeName = Objects.requireNonNull(officeName, "officeName cannot be null");
        this.officeCity = Objects.requireNonNull(officeCity, "officeCity cannot be null");
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public String getOfficeCity() {
        return officeCity;
    }

    @Override
    public String toString() {
        return officeName + " (" + officeCity + ")";
    }
}
