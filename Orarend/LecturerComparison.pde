

int LECTURER_COMPARER_TIMETABLE_X = 50;
int LECTURER_COMPARER_TIMETABLE_Y = 450;
Timetable lecturerTimetable;




void initLecturerComparer(){
    lecturerTimetable = new Timetable(LECTURER_COMPARER_TIMETABLE_X, LECTURER_COMPARER_TIMETABLE_Y, true);
}

void showLecturerComparison(){
    println(lecturerTimetable);
    lecturerTimetable.draw();
}
