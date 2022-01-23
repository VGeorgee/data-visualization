public class CourseTypeByLecturer extends CountDerived {

    @Override
    public String dataMapper(Course course) {
        return course.getType().name();
    }

    @Override
    public String keyMapper(Course course) {
        return course.getLecturer().getName();
    }
}
