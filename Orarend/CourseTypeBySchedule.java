import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseTypeBySchedule extends CountDerived {

    @Override
    public String dataMapper(Course course) {
        return course.getType().name();
    }

    @Override
    public String keyMapper(Course course) {
        return course.getDay().getName() + course.getSchedule().getStart();
    }
}
