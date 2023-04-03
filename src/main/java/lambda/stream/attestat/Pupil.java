package lambda.stream.attestat;

import java.util.List;
import java.util.Objects;

public class Pupil {
    private String name;
    private List<Subject> subjects;

    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public Pupil() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pupil pupil = (Pupil) o;
        return Objects.equals(name, pupil.name) && Objects.equals(subjects, pupil.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subjects);
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
