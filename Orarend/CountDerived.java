import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class CountDerived implements ICountMapper{
    private Map<String, Map<String, Integer>> counts;
    public Map<String, Map<String, Integer>> getCounts(){
        return counts;
    }
    public Map<String, Integer> getCount(String key){
        return counts.get(key);
    }


    public CountDerived() {
        counts = new HashMap<>();
    }

    public void filteredBuild(List<Course> courses){
        List<Course> filtered = this.filterCourses(courses);
        this.build(filtered);
    }

    public void build(List<Course> courses) {
        for(Course course: courses){
            String key = this.keyMapper(course);
            if(!counts.containsKey(key)){
                counts.put(key, new HashMap<>());
            }
            this.increment(counts.get(key), dataMapper(course));
            this.increment(counts.get(key), "sum");
        }
    }

    private List<Course> filterCourses(List<Course> courses){
        HashMap<String, Course> filter = new HashMap<>();
        List<Course> filtered = new ArrayList<>();
        for(Course course: courses){
            String key = course.getLecturer().getName() + course.getSchedule().getStart() + course.getDay().getName();
            if(!filter.containsKey(key)){
                filter.put(key, course);
                filtered.add(course);
            }
        }
        return filtered;
    }

    public abstract String dataMapper(Course course);
    public abstract String keyMapper(Course course);

    public void increment(Map<String, Integer> map, String key){
        this.incrementBy(map, key, 1);
    }

    public void incrementBy(Map<String, Integer> map, String key, int by){
        if(!map.containsKey(key)){
            map.put(key, 0);
        }
        int value = map.get(key) + by;
        map.replace(key, value);
    }

    @Override
    public String toString() {
        return "CourseTypeByLecturer{" +
                "courseTypeCount=" + counts +
                "} => " + counts.get("sum");
    }
}


class CurriculumByLecturer extends CountDerived{

    public CurriculumByLecturer(List<Course> courses) {
        this.build(courses);
    }

    @Override
    public String dataMapper(Course course) {
        return course.getCurriculum().getName();
    }

    @Override
    public String keyMapper(Course course) {
        return course.getLecturer().getName();
    }

    @Override
    public String getEntityKey() {
        return "Curriculum";
    }
}


class CurriculumBySchedule extends CountDerived {
    @Override
    public String dataMapper(Course course) {
        return course.getCurriculum().getName();
    }

    @Override
    public String keyMapper(Course course) {
        return course.getDay().getName() + course.getSchedule().getStart();
    }

    public CurriculumBySchedule(List<Course> courses) {
        this.build(courses);
    }

    @Override
    public String getEntityKey() {
        return "Curriculum";
    }
}

class CourseTypeByLecturer extends CountDerived {
    public CourseTypeByLecturer(List<Course> courses) {
        this.filteredBuild(courses);
    }

    @Override
    public String dataMapper(Course course) {
        return course.getType().name();
    }

    @Override
    public String keyMapper(Course course) {
        return course.getLecturer().getName();
    }

    @Override
    public String getEntityKey() {
        return "CourseType";
    }
}


class SubjectByLecturer extends CountDerived {
    public SubjectByLecturer(List<Course> courses) {
        this.build(courses);
    }

    @Override
    public String dataMapper(Course course) {
        return course.getSubject().getName();
    }

    @Override
    public String keyMapper(Course course) {
        return course.getLecturer().getName();
    }

    @Override
    public String getEntityKey() {
        return "Subject";
    }
}

class CourseTypeBySchedule extends CountDerived {

    public CourseTypeBySchedule(List<Course> courses) {
        this.filteredBuild(courses);
    }

    @Override
    public String dataMapper(Course course) {
        return course.getType().name();
    }

    @Override
    public String keyMapper(Course course) {
        return course.getDay().getName() + course.getSchedule().getStart();
    }

    @Override
    public String getEntityKey() {
        return "CourseType";
    }
}
