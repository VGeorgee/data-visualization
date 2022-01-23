import java.util.Arrays;
import java.util.Objects;

public class FileEntry {
    String subjectCode;
    String subjectName;
    String courseCode;
    String enrollmentType;
    String requirementType;
    int semesterNumber;
    int credits;
    String courseType;
    String lecturers;
    String scheduleInformation;
    String curriculum;
    boolean isCollection;
    boolean isLecture;

    public FileEntry(String subjectCode, String subjectName, String courseCode, String enrollmentType, String requirementType, int semesterNumber, int credits, String courseType, String lecturers, String scheduleInformation, String curriculum) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.courseCode = courseCode;
        this.enrollmentType = enrollmentType;
        this.requirementType = requirementType;
        this.semesterNumber = semesterNumber;
        this.credits = credits;
        this.courseType = courseType;
        this.lecturers = lecturers;
        this.scheduleInformation = scheduleInformation;

        this.curriculum = mergeCurriculum(curriculum);
        this.isCollection = courseCode.endsWith("-*");
        this.isLecture = courseType.equals("Elmélet");
    }

    private boolean isLecture(String courseCode) {
        if(courseCode.contains("-")){
            String[] tokens = courseCode.split("-");
            return tokens[0].endsWith("E");
        }
        return courseCode.endsWith("E");
    }

    private String mergeCurriculum(String curriculum){
        String[] tokens = curriculum.split(" ");
        if(tokens.length > 1 && tokens[tokens.length - 1].length() == 4){
            tokens = Arrays.copyOf(tokens, tokens.length - 1);
        }
        String joined = String.join(" ", tokens);
        return joined;
    }

    public void setLecturers(String lecturers) {
        this.lecturers = lecturers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileEntry fileEntry = (FileEntry) o;
        return lecturers.equals(fileEntry.lecturers) && scheduleInformation.equals(fileEntry.scheduleInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lecturers, scheduleInformation);
    }

    @Override
    public String toString() {
        return courseCode + " " + lecturers + " --->  " + scheduleInformation + "\t\t\t" + curriculum;
    }
}
