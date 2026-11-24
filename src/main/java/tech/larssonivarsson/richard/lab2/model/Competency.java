package tech.larssonivarsson.richard.lab2.model;

import java.util.Objects;

public class Competency {
    private final int competencyId;
    private final String name;
    private final String description;

    public Competency(int competencyId, String name, String description) {
        this.competencyId = competencyId;
        this.name = Objects.requireNonNull(name, "name cannot be null");
        this.description = Objects.requireNonNull(description, "description cannot be null");
    }

    public int getCompetencyId() {
        return competencyId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(competencyId);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (!(obj instanceof Competency that)) return false;
        return competencyId == that.competencyId;
    }

    @Override
    public String toString() {
        return name + " (" + description + ")";
    }
}
