import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room {
    private String room;
    private List<Course> courses;

    public Room(String room) {
        this.room = room;
        this.courses = new ArrayList<>();
    }

    public String getRoom() {
        return room;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room1 = (Room) o;
        return room.equals(room1.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room);
    }

    @Override
    public String toString() {
        return room;
    }
}
