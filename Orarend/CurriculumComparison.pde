


int CURRICULUM_COMPARISON_X = 900;
int CURRICULUM_COMPARISON_Y = 50;

int CURRICULUM_COMPARISON_WIDTH = 700;
int CURRICULUM_COMPARISON_HEIGHT = 400;

List<Curriculum> selectedCurriculums;
Curriculum currentCurriculum;
int currentCurriculumIndex;

color CURRICULUM_COMPARISON_DIAGRAM_BACKGROUND_COLOR = color(240, 240, 240);
color CURRICULUM_COMPARISON_TEXT_COLOR = color(0, 0, 0);
int CURRICULUM_COMPARISON_TEXT_SIZE = 24;
boolean showCurriculumComparison = false;


int CURRICULUM_CIRCLE_WIDTH = 10;
int CURRICULUM_COMPARISON_LINE_WIDTH = 2;

int MAX_COURSES_PER_SEMESTER = 15;
int MAX_SEMESTERS = 9;

int SEMESTER_MARGIN = 30;
int COURSE_MARGIN = 30;

String CURRICULUM_COMPARISON_COLOR_ENTITY_KEY = "CurriculumComparison";


void initCurriculumComparison(){
    selectedCurriculums = new ArrayList<>();
    currentCurriculumIndex = 0;
    currentCurriculum = Database.getInstance().curriculums.get(currentCurriculumIndex);
}


void selectCurriculum(){
    if(currentCurriculum.isSelected()){
        selectedCurriculums.remove(currentCurriculum);
    } else {
        selectedCurriculums.add(currentCurriculum);
    }
    currentCurriculum.select();
}

void nextCurriculum(){
    currentCurriculumIndex++;
    currentCurriculumIndex %= Database.getInstance().curriculums.size();
    currentCurriculum = Database.getInstance().curriculums.get(currentCurriculumIndex);
}

void previousCurriculum(){
    currentCurriculumIndex--;
    if(currentCurriculumIndex < 0){
        currentCurriculumIndex = Database.getInstance().curriculums.size() - 1;
    }
    currentCurriculum = Database.getInstance().curriculums.get(currentCurriculumIndex);
}


void drawCurriculumComparison(){
    if(showCurriculumComparison){
        drawComparisonDiagram();
        drawCurriculumData();
    }
}

double getStepSizeY(){
    return CURRICULUM_COMPARISON_HEIGHT / (double) MAX_COURSES_PER_SEMESTER;
}

int getPositionYForCourseCount(int courseCount){
    return (int) (CURRICULUM_COMPARISON_Y + (CURRICULUM_COMPARISON_HEIGHT - (getStepSizeY() * courseCount)) );
}

double getStepSizeX(){
    return CURRICULUM_COMPARISON_WIDTH / (double) MAX_SEMESTERS;
}

int getPositionXForSemesterNumber(int semesterNumber){
    return (int) (CURRICULUM_COMPARISON_X + (getStepSizeX() * semesterNumber) + SEMESTER_MARGIN);
}

void drawComparisonDiagram(){
    fill(CURRICULUM_COMPARISON_DIAGRAM_BACKGROUND_COLOR);
    rect(CURRICULUM_COMPARISON_X, CURRICULUM_COMPARISON_Y, CURRICULUM_COMPARISON_WIDTH, CURRICULUM_COMPARISON_HEIGHT);

    strokeWeight(1);
    fill(CURRICULUM_COMPARISON_TEXT_COLOR);
    textSize(CURRICULUM_COMPARISON_TEXT_SIZE);
    for(int i = 0; i < MAX_SEMESTERS; i++){
        text((i + 1) + "", getPositionXForSemesterNumber(i), CURRICULUM_COMPARISON_Y + CURRICULUM_COMPARISON_HEIGHT + 30);
    }
    for(int i = 0; i < MAX_COURSES_PER_SEMESTER; i++){
        line(CURRICULUM_COMPARISON_X, getPositionYForCourseCount(i),CURRICULUM_COMPARISON_X + CURRICULUM_COMPARISON_WIDTH, getPositionYForCourseCount(i));
        text((i + 1) + "", CURRICULUM_COMPARISON_X - 30 ,getPositionYForCourseCount(i));
    }
    String currentCurriculumName = currentCurriculum.getName();
    fill(0);
    text(currentCurriculumName, CURRICULUM_COMPARISON_X, CURRICULUM_COMPARISON_Y - 25);
    fill(ColorDatabase.getColor(CURRICULUM_COMPARISON_COLOR_ENTITY_KEY, currentCurriculumName));
    noStroke();
    if(currentCurriculum.isSelected()){
        circle(CURRICULUM_COMPARISON_X - 20, CURRICULUM_COMPARISON_Y - 35, 15);
    }
}

void drawCurriculumData(){
    strokeWeight(CURRICULUM_COMPARISON_LINE_WIDTH);
    for(Curriculum curriculum: selectedCurriculums){
        int previousX = 0;
        int previousY = 0;
        color currentColor = ColorDatabase.getColor(CURRICULUM_COMPARISON_COLOR_ENTITY_KEY, curriculum.getName());
        fill(currentColor);
        stroke(currentColor);
        for(int semester = 0; semester < MAX_SEMESTERS; semester++){
            int currentX = getPositionXForSemesterNumber(semester);
            int currentY = getPositionYForCourseCount(curriculum.getNumberOfSubjectsForSemester(semester));
            circle(currentX, currentY, CURRICULUM_CIRCLE_WIDTH);
            if(previousX != 0 && previousY != 0){
                line(previousX, previousY, currentX, currentY);
            }
            previousX = currentX;
            previousY = currentY;
        }
    }
}
