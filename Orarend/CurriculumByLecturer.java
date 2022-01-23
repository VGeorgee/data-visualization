import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurriculumByLecturer {
    private static Map<String, CurriculumByLecturer> lecturers = new HashMap<>();
    public static Map<String, CurriculumByLecturer> getLecturers(){
        return lecturers;
    }
    public static CurriculumByLecturer getLecturer(String lecturerName){
        return lecturers.get(lecturerName);
    }
    public static void build(List<Course> courses) {
        for(Course course: courses){
            String lecturer = course.getLecturer().getName();
            if(!lecturers.containsKey(lecturer)){
                lecturers.put(lecturer, new CurriculumByLecturer());
            }
            lecturers.get(lecturer).increment(course.getCurriculum().getName());
        }
    }

    private Map<String, Integer> curriculumCount;

    public CurriculumByLecturer() {
        this.curriculumCount = new HashMap<>();
    }

    public void increment(String curriculumName){
        if(!curriculumCount.containsKey(curriculumName)){
            curriculumCount.put(curriculumName, 0);
        }
        int value = curriculumCount.get(curriculumName) + 1;
        curriculumCount.replace(curriculumName, value);
    }


    @Override
    public String toString() {
        return "CurriculumByLecturer{" +
                "curriculumCount=" + curriculumCount +
                '}';
    }
}

