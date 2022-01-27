import java.util.Map;
int CELL_HEIGHT = 50;
int CELL_WIDTH = 150;

color CELL_STROKE_COLOR = color(0);
color CELL_FILL_COLOR = color(200, 200, 200);
int CELL_STROKE_WEIGHT = 2;
int SUBCELL_STROKE_WEIGHT = 0;

boolean showCellsByMaxData = false;

class TimetableCell {
    int x;
    int y;
    String day;
    String schedule;
    private boolean dataType;


    public TimetableCell(int x, int y, String day, String schedule, boolean dataType){
        this.x = x;
        this.y = y;
        this.day = day;
        this.schedule = schedule;
        this.dataType = dataType;
        this.draw();
    }

    public void draw(){
        stroke(CELL_STROKE_COLOR);
        strokeWeight(CELL_STROKE_WEIGHT);
        fill(CELL_FILL_COLOR);
        rect(this.x, this.y, CELL_WIDTH, CELL_HEIGHT);

        this.showData();
    }

    public boolean isHovered(){
        return mouseX > this.x && mouseX < (this.x + CELL_WIDTH) && mouseY > this.y && mouseY < (this.y + CELL_HEIGHT) ;
    }

    public String toString(){
        return this.day + " " + this.schedule;
    }

    private String getKey(){
        return this.day + this.schedule;
    }

    public void changeDataType(){
        this.dataType = true;
    }


    private int getMaxData(){
        Map<String, Map<String, Integer>> cellData = selectedDataset.getCounts();
        int maxData = 0;
        for(Map.Entry<String, Map<String, Integer>> entry: cellData.entrySet()){
            if(entry.getValue().containsKey("sum") && maxData < entry.getValue().get("sum")){
                maxData = entry.getValue().get("sum");
            }
        }
        return maxData;
    }


    public void showData(){
        if(this.dataType == false){
            this.showOriginalData();
        } else {
            this.showComparisonData();
        }
    }

    

    public void showOriginalData(){
        Map<String, Integer> cellData = selectedDataset.getCount(this.getKey());
        
        int maxData = 0;
        if(showCellsByMaxData){
            maxData = getMaxData();
        }

        strokeWeight(SUBCELL_STROKE_WEIGHT);
        if(cellData != null){
            int subRectX = this.x;
            int subRectY = this.y;
            int divide = showCellsByMaxData ? maxData : cellData.get("sum");
            for(Map.Entry<String, Integer> entry: cellData.entrySet()){
                if(!entry.getKey().equals("sum")){
                    int numberOfCurrentData = entry.getValue();
                    int subRectWidth =(int)(CELL_WIDTH * (numberOfCurrentData / (double)divide));
                    
                    color subRectColor = ColorDatabase.getColor(selectedDataset.getEntityKey(),entry.getKey());

                    fill(subRectColor);

                    rect(subRectX, subRectY, subRectWidth, CELL_HEIGHT);
                    textSize(12);
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(""+numberOfCurrentData, subRectX + (subRectWidth / 2) , subRectY + (CELL_HEIGHT / 2));
                    subRectX += subRectWidth;
                }
            }
        }
    }

    private void showComparisonData(){
        ArrayList<Lecturer> lecturersToShow = new ArrayList<>();
        for(Lecturer lecturer: selectedLecturers){
            if(lecturer.getCourseForSchedule(day, schedule) != null){
                lecturersToShow.add(lecturer);
            }
        }
        if(lecturersToShow.size() > 0) {
            int margin = CELL_WIDTH / (lecturersToShow.size() + 1);
            
            int currentX = this.x + margin;
            int d = margin < 45 ? margin : 45;
            d -= 5;
            noStroke();
            for(int i = 0; i < lecturersToShow.size(); i++){
                color c = ColorDatabase.getColor("Lecturers", lecturersToShow.get(i).getName());
                fill(c);
                circle(currentX, this.y + CELL_HEIGHT / 2, d);
                currentX += margin;
            }
        }
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
