import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CountDerived implements ICountMapper{
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

    @Override
    public Map<String, Map<String, Integer>> getCountedData() {
        return this.counts;
    }

    public void increment(Map<String, Integer> map, String key){
        if(!map.containsKey(key)){
            map.put(key, 0);
        }
        int value = map.get(key) + 1;
        map.replace(key, value);
    }

    @Override
    public String toString() {
        return "CourseTypeByLecturer{" +
                "courseTypeCount=" + counts +
                '}';
    }
}
