import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Subject {
    private String code;
    private String name;
    private Requirement requirementType;
    private Enrollment enrollmentType;
    private int semester;
    private List<Course> courses;

    private int hash;

    public Subject(String code, String name, Requirement requirementType, Enrollment enrollmentType) {
        this.code = code;
        this.name = name;
        this.requirementType = requirementType;
        this.enrollmentType = enrollmentType;
        this.hash = Objects.hash(code, name, requirementType, enrollmentType);
        this.courses = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSemester(){
        return this.semester;
    }

    public void addSemester(int semester){
        this.semester = semester;
    }

    public Requirement getRequirementType() {
        return requirementType;
    }

    public Enrollment getEnrollmentType() {
        return enrollmentType;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return code.equals(subject.code) && name.equals(subject.name) && requirementType == subject.requirementType && enrollmentType == subject.enrollmentType;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", requirementType=" + requirementType +
                ", enrollmentType=" + enrollmentType +
                ", hash=" + hash +
                '}';
    }
}
