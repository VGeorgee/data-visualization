import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileEntrySanitizer {
    private Map<String, List<FileEntry>> courses;
    private List<FileEntry> entries;
    private List<FileEntry> lectures;

    public FileEntrySanitizer(List<FileEntry> entries){
        this.courses = new HashMap<>();
        this.entries = entries;
        this.lectures = new ArrayList<>();
    }

    public List<FileEntry> getEntries(){
        return this.entries;
    }

    public void filterLecturers() {
        for(FileEntry entry: this.entries){
            if(!courses.containsKey(entry.subjectName)){
                courses.put(entry.subjectName, new ArrayList<>());
            }
            courses.get(entry.subjectName).add(entry);
            if(entry.isLecture){
                this.lectures.add(entry);
            }
        }


        for(FileEntry lecture: this.lectures){
           // System.out.println(lecture);
            List<FileEntry> coursesForLecture = this.courses.get(lecture.subjectName);
            for(FileEntry course: coursesForLecture){
                this.removeLecturer(course, lecture.lecturers);
            }
        }


        for(FileEntry course: this.entries) {
            if(course.lecturers.contains(", ") && !course.requirementType.equals("Gyakorlati jegy")){
                System.out.println(course);
            }
        }


    }

    private void removeLecturer(FileEntry course, String lecturer){
        if(course.lecturers.contains(", ") && course.lecturers.contains(lecturer)){
            String[] lecturers = course.lecturers.split(", ");
            course.setLecturers(lecturers[lecturers[0].equals(lecturer) ? 1 : 0]);
        }
    }

    public void simplifyLecturers(){
        for(FileEntry entry: this.entries){
            if(entry.lecturers.contains(", ")){
                entry.lecturers = entry.lecturers.split(", ")[0];
            }
        }
    }

}
