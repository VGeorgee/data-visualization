import java.util.ArrayList;
import java.util.List;

public class Database {
    public List<Lecturer> lecturers;
    public List<Subject> subjects;
    public List<Course> courses;
    public List<Room> rooms;
    public List<Schedule> schedules;
    public List<Curriculum> curriculums;
    public List<Day> days;

    private Database(){
        this.lecturers = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.schedules = new ArrayList<>();
        this.curriculums = new ArrayList<>();
        this.days = new ArrayList<>();
    }

    private static Database INSTANCE;

    public static Database getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    public Curriculum getCurriculum(String curriculumName){
        for(Curriculum curriculum: this.curriculums){
            if(curriculum.getName().equals(curriculumName)){
                return curriculum;
            }
        }
        return null;
    }
}
