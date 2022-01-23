import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurriculumBySchedule {
    private static Map<String, CurriculumBySchedule> schedules = new HashMap<>();
    public static Map<String, CurriculumBySchedule> getSchedules(){
        return schedules;
    }
    public static CurriculumBySchedule getSchedule(String dateAndTime){
        return schedules.get(dateAndTime);
    }
    public static void build(List<Course> courses) {
        for(Course course: courses){
            String dateAndTime = course.getDay().getName() + course.getSchedule().getStart() + "";
            if(!schedules.containsKey(dateAndTime)){
                schedules.put(dateAndTime, new CurriculumBySchedule());
            }
            if(course.getCurriculum().getName().equals("")){
                System.out.println(course.getCurriculum());
            }
            schedules.get(dateAndTime).increment(course.getCurriculum().getName());
        }
    }

    private Map<String, Integer> curriculumCount;

    public CurriculumBySchedule() {
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
        return "CurriculumBySchedule{" +
                "curriculumCount=" + curriculumCount +
                '}';
    }
}
