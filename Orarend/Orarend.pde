import java.util.List;

int WINDOW_WIDTH = 1680;
int WINDOW_HEIGHT = 1050;
color DEFAULT_BACKGROUND_COLOR = color(224, 217, 195);
TimetableCell ttc;
void setup() {
  size(1680, 1000);
  List<FileEntry> list = FileReader.readFile("D:\\GIT\\Processing\\data-visualization\\Orarend\\orarend_utf_8.csv");
  FileEntrySanitizer mapper = new FileEntrySanitizer(list);
  mapper.filterLecturers();
  mapper.simplifyLecturers();

  DatabaseBuilder dbb = new DatabaseBuilder();
  dbb.buildDatabase(mapper.getEntries());

  Database db = Database.getInstance();
  
  text(db.lecturers.get(0).getName(), 40, 40, 100, 50);
 ttc = new TimetableCell(20, 20);
}

void draw() {
  background(DEFAULT_BACKGROUND_COLOR);
  ttc.draw();
  println(ttc.containsMouse());
}
