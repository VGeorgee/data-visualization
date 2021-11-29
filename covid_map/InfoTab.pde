final int INFO_TAB_WIDTH = 100;
final int INFO_TAB_HEIGHT = 200;
final int INFO_TAB_X_OFFSET = 10;
final int INFO_TAB_Y_OFFSET = 10;
final int INFO_TAB_STROKE_WIDTH = 2;

int getInfoTabPaddingX(){
  return mouseX + INFO_TAB_X_OFFSET+ INFO_TAB_STROKE_WIDTH;
}

int getInfoTabPaddingY(){
  return mouseX + INFO_TAB_X_OFFSET+ INFO_TAB_STROKE_WIDTH;
}

final color INFO_TAB_BACKGROUND = color(255, 166, 77);

void showInfoTab(Country country){
  strokeWeight(INFO_TAB_STROKE_WIDTH);
  fill(INFO_TAB_BACKGROUND);
  rect(mouseX + INFO_TAB_X_OFFSET, mouseY + INFO_TAB_Y_OFFSET, INFO_TAB_WIDTH, INFO_TAB_HEIGHT);
    
  fill(255);
}
