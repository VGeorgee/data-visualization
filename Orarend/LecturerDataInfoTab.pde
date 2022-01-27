import java.util.Map;
import java.util.ArrayList;

int LECTURER_DATA_INFO_TAB_START_X = 60;
int LECTURER_DATA_INFO_TAB_START_Y = 400;

int LECTURER_DATA_SUM_TEXT_X = LECTURER_DATA_INFO_TAB_START_X + 400;


int PIE_CHART_DIAMETER = 200;
int PIE_CHART_X = LECTURER_DATA_INFO_TAB_START_X + PIE_CHART_DIAMETER;
int PIE_CHART_Y = LECTURER_DATA_INFO_TAB_START_Y + PIE_CHART_DIAMETER;




String selectedLecturerName = null;
int selectedLecturerIndex = 0;
String[] lecturerNames;
Map<String, Integer> selectedLecturerData;
String entryKey;

List<Lecturer> selectedLecturers;

void drawLecturerDataInfoTab(){
    textSize(24);
    fill(0);
    textAlign(LEFT);
    text(selectedLecturerName, LECTURER_DATA_INFO_TAB_START_X, LECTURER_DATA_INFO_TAB_START_Y);
    text("Összes kurzus: " + courseTypeByLecturer.getCount(selectedLecturerName).get("sum"), LECTURER_DATA_SUM_TEXT_X, LECTURER_DATA_INFO_TAB_START_Y);
    Lecturer selectedLecturer = databaseBuilder.lecturers.get(selectedLecturerName);
    if(selectedLecturer.isSelected()){
        color c = ColorDatabase.getColor("Lecturers", selectedLecturer.getName());
        fill(c);
        noStroke();
        circle(LECTURER_DATA_INFO_TAB_START_X - 30, LECTURER_DATA_INFO_TAB_START_Y - 8, 35);
    }
}

void selectCurrentLecturer(){
    Lecturer selectedLecturer = databaseBuilder.lecturers.get(selectedLecturerName);
    if(selectedLecturer.isSelected()){
        selectedLecturers.remove(selectedLecturer);
    } else {
        selectedLecturers.add(selectedLecturer);
    }
    selectedLecturer.select();
}

void initLecturerInfoTab(){
    lecturerNames = new String[selectedLecturerDataset.getCounts().entrySet().size()];
    int i = 0;
    for(Map.Entry<String, Map<String, Integer>> entry: selectedLecturerDataset.getCounts().entrySet()){
        lecturerNames[i++] = entry.getKey();
    }
    selectedLecturerName = lecturerNames[selectedLecturerIndex];
    updateCurrentLecturerData();
    selectedLecturers = new ArrayList<>();
}

void updateCurrentLecturerData(){
    selectedLecturerData = selectedLecturerDataset.getCounts().get(selectedLecturerName);
    entryKey = selectedLecturerDataset.getEntityKey();
}

void selectNextLecturer(){
    selectedLecturerIndex++;
    selectedLecturerIndex %= lecturerNames.length;
    selectedLecturerName = lecturerNames[selectedLecturerIndex];
    updateCurrentLecturerData();
}

void selectPreviousLecturer(){
    selectedLecturerIndex--;
    if(selectedLecturerIndex == -1){
        selectedLecturerIndex = lecturerNames.length - 1;
    }
    selectedLecturerName = lecturerNames[selectedLecturerIndex];
    updateCurrentLecturerData();
}


int[] pieChartCalculatedData;
int[] pieChartDataColor;
void calculatePieChartData(){
    int count = selectedLecturerData.entrySet().size() - 1;
    int sum = selectedLecturerData.get("sum");
    int multiplier = 360 / sum;
    pieChartCalculatedData = new int[count];
    pieChartDataColor = new color[count];
    int i = 0;
    int filled = 0;
    for(Map.Entry<String, Integer> entry: selectedLecturerData.entrySet()) {
        if(!entry.getKey().equals("sum")){
            int calculated = entry.getValue() * multiplier;
            filled += calculated;
            pieChartCalculatedData[i] = calculated; 
            pieChartDataColor[i++] = ColorDatabase.getColor(entryKey, entry.getKey());
        }
    }
    pieChartCalculatedData[i - 1] += 360 - filled;
    pieChart();
}


void pieChart() {
  float lastAngle = 0;
  for (int i = 0; i < pieChartCalculatedData.length; i++) {
    fill(pieChartDataColor[i]);
    arc(PIE_CHART_X, PIE_CHART_Y, PIE_CHART_DIAMETER, PIE_CHART_DIAMETER, lastAngle, lastAngle+radians(pieChartCalculatedData[i]));
    lastAngle += radians(pieChartCalculatedData[i]);
  }
}
