import java.util.*;

public class Lecturer {
    private String name;
    private List<Subject> subjects;
    private Set<Subject> subjectSet;

    private List<Course> courses;
    private Set<Course> courseSet;

    private List<Curriculum> curriculums;
    private Set<Curriculum> curriculumSet;

    private boolean isSelected;

    public Lecturer(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
        this.subjectSet = new HashSet<>();

        this.courses = new ArrayList<>();
        this.courseSet = new HashSet<>();

        this.curriculums = new ArrayList<>();
        this.curriculumSet = new HashSet<>();
        this.isSelected = false;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Curriculum> getCurriculums() {
        return curriculums;
    }

    public void select(){
        this.isSelected = !this.isSelected;
    }

    public boolean isSelected(){
        return this.isSelected;
    }

    public void addCourse(Course course){
        //if(!courseSet.contains(course)){
        //    this.courseSet.add(course);
            this.courses.add(course);
       // }
    }

    public void addSubject(Subject subject){
       // if(this.subjectSet.contains(subject)) {
       //     this.subjectSet.add(subject);
            this.subjects.add(subject);
       // }
    }

    public void addCurriculum(Curriculum curriculum){
        this.curriculums.add(curriculum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecturer lecturer = (Lecturer) o;
        return Objects.equals(name, lecturer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

}
