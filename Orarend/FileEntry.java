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
        this.curriculum = curriculum;
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
        return "FileEntry{" +
                "courseCode='" + courseCode + '\'' +
                ", lecturers='" + lecturers + '\'' +
                '}';
    }
}
