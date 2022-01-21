import Types.CourseType;
import Types.Enrollment;
import Types.Requirement;
import entities.*;

import javax.xml.crypto.Data;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseBuilder {
    private Map<String, Lecturer> lecturers;
    private Map<String, Subject> subjects;
    private Map<String, Course> courses;
    private Map<String, Room> rooms;
    private Map<String, Schedule> schedules;
    private Map<String, Curriculum> curriculums;
    private Map<String, Day> days;

    public DatabaseBuilder() {
        this.lecturers = new HashMap<>();
        this.subjects = new HashMap<>();
        this.courses = new HashMap<>();
        this.rooms = new HashMap<>();
        this.schedules = new HashMap<>();
        this.curriculums = new HashMap<>();
        this.days = new HashMap<>();
    }

    public void buildDatabase(List<FileEntry> entries){
        Database database = Database.getInstance();

        for(FileEntry entry: entries){
            Requirement requirement = getRequirement(entry.requirementType);
            Enrollment enrollment = getEnrollment(entry.enrollmentType);
            CourseType courseType = getCourseType(entry.courseType);
            Subject subject = createSubject(entry.subjectCode, entry.subjectName, requirement, enrollment);
            Lecturer lecturer = createLecturer(entry.lecturers);
            ScheduleTokens scheduleTokens = new ScheduleTokens(entry.scheduleInformation);
            Day day = createDay(scheduleTokens.getDay());
            Room room = createRoom(scheduleTokens.getRoom());
            Schedule schedule = createSchedule(scheduleTokens.getStart(), scheduleTokens.getEnd());
            Curriculum curriculum = createCurriculum(entry.curriculum);
            Course course = createCourse(entry.courseCode, courseType, lecturer, room, day, schedule, subject, curriculum);

            lecturer.addSubject(subject);
            lecturer.addCurriculum(curriculum);
            lecturer.addCourse(course);
            day.addCourse(course);
            subject.addCourse(course);
            room.addCourse(course);

            database.courses.add(course);
        }

        for (Map.Entry<String, Subject> entry : subjects.entrySet()){
            database.subjects.add(entry.getValue());
        }

        for (Map.Entry<String, Lecturer> entry : lecturers.entrySet()){
            database.lecturers.add(entry.getValue());
        }

        for (Map.Entry<String, Room> entry : rooms.entrySet()){
            database.rooms.add(entry.getValue());
        }

        for (Map.Entry<String, Schedule> entry : schedules.entrySet()){
            database.schedules.add(entry.getValue());
        }

        for (Map.Entry<String, Curriculum> entry : curriculums.entrySet()){
            database.curriculums.add(entry.getValue());
        }

        for (Map.Entry<String, Day> entry : days.entrySet()){
            database.days.add(entry.getValue());
        }
    }

    private Lecturer createLecturer(String lecturerName){
        if(!this.lecturers.containsKey(lecturerName)){
            Lecturer lecturer = new Lecturer(lecturerName);
            this.lecturers.put(lecturerName, lecturer);
        }
        return this.lecturers.get(lecturerName);
    }

    private Schedule createSchedule(int start, int end) {
        String key = start + end + "";
        if(!this.schedules.containsKey(key)){
            Schedule schedule = new Schedule(start, end);
            this.schedules.put(key, schedule);
        }
        return this.schedules.get(key);
    }

    private Room createRoom(String roomName){
        if(!this.rooms.containsKey(roomName)){
            Room room = new Room(roomName);
            this.rooms.put(roomName, room);
        }
        return this.rooms.get(roomName);
    }

    private Day createDay(String dayName){
        if(!this.days.containsKey(dayName)){
            Day day = new Day(dayName);
            this.days.put(dayName, day);
        }
        return this.days.get(dayName);
    }

    private Curriculum createCurriculum(String curriculumName){
        if(!this.curriculums.containsKey(curriculumName)){
            Curriculum curriculum = new Curriculum(curriculumName);
            this.curriculums.put(curriculumName, curriculum);
        }
        return this.curriculums.get(curriculumName);
    }

    private Subject createSubject(String subjectCode, String subjectName, Requirement requirement, Enrollment enrollment){
        if(!this.subjects.containsKey(subjectCode)){
            Subject subject = new Subject(subjectCode, subjectName, requirement, enrollment);
            this.subjects.put(subjectCode, subject);
        }
        return this.subjects.get(subjectCode);
    }

    private Course createCourse(String courseCode,
                                CourseType courseType,
                                Lecturer lecturer,
                                Room room, Day day,
                                Schedule schedule,
                                Subject subject,
                                Curriculum curriculum){
        if(!this.courses.containsKey(courseCode)){
            Course course = new Course(courseCode, courseType, lecturer, room, day, schedule, curriculum);
            this.courses.put(courseCode, course);
        }
        return this.courses.get(courseCode);
    }

    private Requirement getRequirement(String requirementType){
        Requirement requirement;
        switch (requirementType){
            case "Kollokvium": {requirement = Requirement.KOLLOKVIUM; break;}
            case "Gyakorlati jegy": {requirement = Requirement.GYAKORLATI_JEGY; break;}
            default: requirement = Requirement.GYAKORLATI_JEGY;
        }
        return requirement;
    }

    private Enrollment getEnrollment(String enrollmentType){
        Enrollment enrollment;
        switch (enrollmentType){
            case "Kötelező": {enrollment = Enrollment.KOTELEZO; break;}
            case "Szabadon választható": {enrollment = Enrollment.SZABADON_VALASZTHATO; break;}
            case "Kötelezően választott": {enrollment = Enrollment.KOTELEZOEN_VALASZTOTT; break;}
            default: enrollment = Enrollment.KOTELEZO;
        }
        return enrollment;
    }

    private CourseType getCourseType(String courseTypeName){
        CourseType courseType;
        switch (courseTypeName){
            case "Elmélet": {courseType = CourseType.ELMELET; break;}
            case "Labor": {courseType = CourseType.LABOR; break;}
            case "Gyakorlat": {courseType = CourseType.GYAKORLAT; break;}
            default: courseType = CourseType.GYAKORLAT;
        }
        return courseType;
    }
}


class ScheduleTokens{
    private String day;
    private String room;
    private int start;
    private int end;

    public ScheduleTokens(String schedule) {
        String[] tokens = schedule.split(":");
        day = tokens[0].replace("\"", "");
        start = Integer.parseInt(tokens[1]);
        end = Integer.parseInt(tokens[2].split("-")[1]);

        int startOfRoom = tokens[3].indexOf("(") + 1;
        int endOfRoom = tokens[3].indexOf(")");

        room = tokens[3].substring(startOfRoom, endOfRoom);
    }

    public String getDay() {
        return day;
    }

    public String getRoom() {
        return room;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

}
