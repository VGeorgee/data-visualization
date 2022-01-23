int DAY_COUNT = 5;
int CELL_PER_DAY = 6;

int CELL_X_MARGIN = 50;
int CELL_Y_MARGIN = 50;

String[] DAYS = new String[]{"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek"};
String[] DAY_IDS = new String[]{"H", "K", "Sz", "Cs", "P"};
String[] SCHEDULES = new String[]{"8-10", "10-12", "12-14", "14-16", "16-18", "18-20"};
String[] SCHEDULE_IDS = new String[]{"8", "10", "12", "14", "16", "18"};

public class Timetable {
    private int x;
    private int y;
    private TimetableCell[][] cells;

    public Timetable (int x, int y) {
        this.x = x + CELL_X_MARGIN;
        this.y = y + CELL_Y_MARGIN;
        this.cells = new TimetableCell[DAY_COUNT][CELL_PER_DAY];
        for (int i = 0; i < DAY_COUNT; ++i) {
            for (int j = 0; j < CELL_PER_DAY; ++j) {
                int cx = i * CELL_WIDTH + this.x;
                int cy = j * CELL_HEIGHT + this.y;
                this.cells[i][j] = new TimetableCell(cx, cy, DAY_IDS[i], SCHEDULE_IDS[j]);
            }
        }
    }

    public void draw(){
        for (int i = 0; i < DAY_COUNT; ++i) {
            for (int j = 0; j < CELL_PER_DAY; ++j) {
                this.cells[i][j].draw();
            }
        }
        this.printMetaData();
    }

    private void printMetaData(){
        textSize(20);
        textAlign(CENTER);
        fill(0);
        for (int i = 0; i < DAY_COUNT; ++i) {
            text(DAYS[i], this.x + (i * CELL_WIDTH) + (CELL_WIDTH / 2), this.y - 10);
        }
        
        for (int i= 0; i < CELL_PER_DAY; ++i) {
            text(SCHEDULES[i], this.x - 35, this.y + (i * CELL_HEIGHT) + 50);
        }
    }

    public TimetableCell getHovered(){
        for (int i = 0; i < DAY_COUNT; ++i) {
            for (int j = 0; j < CELL_PER_DAY; ++j) {
                if(this.cells[i][j].isHovered()){
                    return this.cells[i][j];
                }
            }
        }
        return null;
    }
}

