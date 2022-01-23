import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectByLecturer {


    private static Map<String, SubjectByLecturer> lecturers = new HashMap<>();
    public static Map<String, SubjectByLecturer> getLecturers(){
        return lecturers;
    }
    public static SubjectByLecturer getLecturer(String lecturerName){
        return lecturers.get(lecturerName);
    }
    public static void build(List<Course> courses) {
        for(Course course: courses){
            String lecturer = course.getLecturer().getName();
            if(!lecturers.containsKey(lecturer)){
                lecturers.put(lecturer, new SubjectByLecturer());
            }
            lecturers.get(lecturer).increment(course.getSubject().getName());
        }
    }

    private Map<String, Integer> subjectCount;

    public SubjectByLecturer() {
        this.subjectCount = new HashMap<>();
    }

    public void increment(String subjectName){
        if(!subjectCount.containsKey(subjectName)){
            subjectCount.put(subjectName, 0);
        }
        int value = subjectCount.get(subjectName) + 1;
        subjectCount.replace(subjectName, value);
    }

    @Override
    public String toString() {
        return "SubjectByLecturer{" +
                "subjectCount=" + subjectCount +
                '}';
    }
}
