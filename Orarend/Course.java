import java.util.Objects;

public class Course {
    private String code;
    private CourseType type;
    private Lecturer lecturer;
    private Room room;
    private Day day;
    private Schedule schedule;
    private Curriculum curriculum;
    private Subject subject;

    public Course(String code, CourseType type, Lecturer lecturer, Room room, Day day, Schedule schedule, Curriculum curriculum) {
        this.code = code;
        this.type = type;
        this.lecturer = lecturer;
        this.room = room;
        this.day = day;
        this.schedule = schedule;
        this.curriculum = curriculum;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public String getCode() {
        return code;
    }

    public CourseType getType() {
        return type;
    }

    public Room getRoom() {
        return room;
    }

    public Day getDay() {
        return day;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return code.equals(course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return code;
    }
}
