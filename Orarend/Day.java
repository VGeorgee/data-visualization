public class Day extends BaseEntity {

    public Day(String day) {
        super(day);
    }


    @Override
    public String toString() {
        return "Day{" +
                "day='" + getName() + '\'' +
                ", courses=" + getCourses() +
                '}';
    }
}

