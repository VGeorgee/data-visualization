
int CELL_HEIGHT = 80;
int CELL_WIDTH = 200;

color CELL_STROKE_COLOR = color(0);
color CELL_FILL_COLOR = color(245, 239, 66);
int STROKE_WEIGHT = 1;

class TimetableCell {
    int x;
    int y;
    String day;
    String schedule;

    public TimetableCell(int x, int y, String day, String schedule){
        this.x = x;
        this.y = y;
        this.day = day;
        this.schedule = schedule;
        this.draw();
    }

    public void draw(){
        stroke(CELL_STROKE_COLOR);
        strokeWeight(STROKE_WEIGHT);
        fill(CELL_FILL_COLOR);
        rect(this.x, this.y, CELL_WIDTH, CELL_HEIGHT);
    }

    public boolean isHovered(){
        return mouseX > this.x && mouseX < (this.x + CELL_WIDTH) && mouseY > this.y && mouseY < (this.y + CELL_HEIGHT) ;
    }

    public String toString(){
        return this.day + " " + this.schedule;
    }
}

/*

{key, value}
{"sum", value}
"Lecturer", 

{
    "h-10":{
        "szakok": {
            "a": 2,
            "b": 3,
            "c": 5
            "sum":10
        }
    }
}

colors:{
    "szakok":{
        "a": color,
        "b": color,
        "c": color,
    }
}

*/