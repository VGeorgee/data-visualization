import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseEntity {
    private String name;
    private List<Course> courses;

    public BaseEntity(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    public String getName() {
        return name;
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
        return name.equals(day1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
