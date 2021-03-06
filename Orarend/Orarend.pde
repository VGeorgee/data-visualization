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
DatabaseBuilder databaseBuilder; 

Timetable timeTable;
void setup() {
  size(1680, 1000);
  List<FileEntry> list = FileReader.readFile("D:\\GIT\\Processing\\data-visualization\\Orarend\\orarend_utf_8.csv");
  FileEntrySanitizer mapper = new FileEntrySanitizer(list);
  mapper.filterLecturers();
  mapper.simplifyLecturers();

  databaseBuilder = new DatabaseBuilder();
  databaseBuilder.buildDatabase(mapper.getEntries());

  Database db = Database.getInstance();

  curriculumBySchedule = new CurriculumBySchedule(db.courses);
  courseTypeBySchedule = new CourseTypeBySchedule(db.courses);
  courseTypeByLecturer = new CourseTypeByLecturer(db.courses);
  curriculumByLecturer = new CurriculumByLecturer(db.courses);
  subjectByLecturer = new SubjectByLecturer(db.courses);

  selectedDataset = curriculumBySchedule;
  selectedLecturerDataset = courseTypeByLecturer;

  ColorDatabase.setBaseColors();
  timeTable = new Timetable(40, 40, false);
  initLecturerInfoTab();
  initCurriculumComparison();
  initLecturerComparer();
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
  drawCurriculumComparison();
  showLecturerComparison();
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
  else if(key == 'm') {
    showCellsByMaxData = !showCellsByMaxData;
  } 
  else if(key == 'i'){
    changeShow();
  } 
  else if(key == ' '){
    selectCurrentLecturer();
  }
  else if(key == 'e'){
    previousCurriculum();
  }
  else if(key == 'r'){
    nextCurriculum();
  }
  else if(key == 't'){
    selectCurriculum();
  }
  update();
}

void changeShow(){
    showCurriculumComparison = !showCurriculumComparison;
    showInfoTab = !showInfoTab;
}
