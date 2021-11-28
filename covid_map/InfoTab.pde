
final int INFO_TAB_WIDTH = 200;
final int INFO_TAB_HEIGHT = 200;

final int INFO_TAB_STROKE_WIDTH = 10;
final color INFO_TAB_BACKGROUND = color(255, 166, 77);

void showInfoTab(Country country){
  strokeWeight(INFO_TAB_STROKE_WIDTH);
  fill(INFO_TAB_BACKGROUND);
  rect(mouseX, mouseY, INFO_TAB_WIDTH, INFO_TAB_HEIGHT);
    
  fill(255);
}
