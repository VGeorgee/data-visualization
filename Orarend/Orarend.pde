import java.util.List;

int WINDOW_WIDTH = 1680;
int WINDOW_HEIGHT = 1050;
color DEFAULT_BACKGROUND_COLOR = color(224, 217, 195);

ICountMapper selectedDataset;
ICountMapper selectedLecturerDataset;
CurriculumByLecturer curriculumByLecturer;
CurriculumBySchedule curriculumBySchedule;
CourseTypeByLecturer courseTypeByLecturer;
CourseTypeBySchedule courseTypeBySchedule;
SubjectByLecturer subjectByLecturer;

Timetable timeTable;
void setup() {
  size(1680, 1000);
  List<FileEntry> list = FileReader.readFile("D:\\GIT\\Processing\\data-visualization\\Orarend\\orarend_utf_8.csv");
  FileEntrySanitizer mapper = new FileEntrySanitizer(list);
  mapper.filterLecturers();
  mapper.simplifyLecturers();

  DatabaseBuilder dbb = new DatabaseBuilder();
  dbb.buildDatabase(mapper.getEntries());

  Database db = Database.getInstance();

  curriculumBySchedule = new CurriculumBySchedule(db.courses);
  courseTypeBySchedule = new CourseTypeBySchedule(db.courses);
  courseTypeByLecturer = new CourseTypeByLecturer(db.courses);
  curriculumByLecturer = new CurriculumByLecturer(db.courses);
  subjectByLecturer = new SubjectByLecturer(db.courses);

  selectedDataset = curriculumBySchedule;
  selectedLecturerDataset = courseTypeByLecturer;
  timeTable = new Timetable(50, 50);
  initLecturerInfoTab();
  update();
}

void draw() {
  delay(1);
}

void update(){
  background(DEFAULT_BACKGROUND_COLOR);
  timeTable.draw();
 // text(selectedDataset.getCounts().get("H12").toString(), 40, 40, 1000, 500);
  drawInfoTab();
  calculatePieChartData();
  updateCurrentLecturerData();
  drawLecturerDataInfoTab();
}


void keyPressed(){
  if(key == 'j'){
    selectedDataset = curriculumBySchedule;
  } 
  else if(key == 'k'){
    selectedDataset = courseTypeBySchedule;
  }
  else if(key == 'q'){
    selectPreviousLecturer();
  }
  else if(key == 'w'){
    selectNextLecturer();
  }
  else if(key == 'f'){
    selectedLecturerDataset = courseTypeByLecturer;
  }
  else if(key == 'g'){
    selectedLecturerDataset = curriculumByLecturer;
  }
  else if(key == 'h'){
    selectedLecturerDataset = subjectByLecturer;
  }
  update();
}
