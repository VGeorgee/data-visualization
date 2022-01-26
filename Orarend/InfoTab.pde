import java.util.Map;

int INFO_TAB_X = 800;
int INFO_TAB_Y = 30;

int INFO_TAB_TEXT_WIDTH = 400;
int INFO_TAB_TEXT_HEIGHT = 40;
int INFO_TAB_TEXT_SIZE = 10;
int INFO_TAB_COLOR_CELL_WIDTH = 100;
int TEXT_Y_MARGIN = 15;
int INFO_TAB_COLOR_CELL_X = INFO_TAB_X + INFO_TAB_TEXT_WIDTH + TEXT_Y_MARGIN;
int INFO_TAB_COLOR_CELL_Y = INFO_TAB_Y;

boolean showInfoTab = true;

void drawInfoTab(){
    if(showInfoTab){
        Map<String, Integer> entries = ColorDatabase.getColorsForEntity(selectedDataset.getEntityKey());
        int y = INFO_TAB_Y;
        textSize(INFO_TAB_TEXT_SIZE);
        textAlign(RIGHT, TOP);
        for(Map.Entry<String, Integer> entry: entries.entrySet()){
            fill(0);
            text(entry.getKey(), INFO_TAB_X, y + TEXT_Y_MARGIN , INFO_TAB_TEXT_WIDTH, INFO_TAB_TEXT_HEIGHT);
            fill(entry.getValue());
            rect(INFO_TAB_COLOR_CELL_X, y, INFO_TAB_COLOR_CELL_WIDTH, INFO_TAB_TEXT_HEIGHT);
            y += INFO_TAB_TEXT_HEIGHT;
        }
    }
}