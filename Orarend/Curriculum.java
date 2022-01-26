import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Curriculum {
    private String name;
    private List<Course> courses;
    private List<Subject> subjects;
    private boolean selected;

    public Curriculum(String name) {
        this.name = name;
        courses = new ArrayList<>();
        subjects = new ArrayList<>();
        this.selected = false;
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

    public void select(){
        this.selected = !this.selected;
    }

    public boolean isSelected(){
        return this.selected;
    }

    public void addSubject(Subject subject){
        if(!this.subjects.contains(subject)){
            this.subjects.add(subject);
        }
    }


    public int getNumberOfSubjectsForSemester(int semester){
        int numberOfCourses = 0;
        for(Subject subject: this.subjects){
            if(subject.getSemester() == semester){
                numberOfCourses++;
            }
        }
        return numberOfCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curriculum that = (Curriculum) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
