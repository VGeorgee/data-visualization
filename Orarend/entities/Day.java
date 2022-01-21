package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day {
    private String day;

    private List<Course> courses;


    public Day(String day) {
        this.day = day;
        this.courses = new ArrayList<>();
    }

    public String getDay() {
        return day;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day1 = (Day) o;
        return day.equals(day1.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day);
    }

    @Override
    public String toString() {
        return "Day{" +
                "day='" + day + '\'' +
                ", courses=" + courses +
                '}';
    }
}

