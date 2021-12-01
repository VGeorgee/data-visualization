final int INFO_TAB_WIDTH = 120;
final int INFO_TAB_HEIGHT = 50;
final int INFO_TAB_X_OFFSET = 10;
final int INFO_TAB_Y_OFFSET = 10;
final int INFO_TAB_STROKE_WIDTH = 2;

int getInfoTabPaddingX(){
  return mouseX + INFO_TAB_X_OFFSET + INFO_TAB_STROKE_WIDTH + 20;
}

int getInfoTabPaddingY(){
  return mouseY + INFO_TAB_X_OFFSET + INFO_TAB_STROKE_WIDTH + 10;
}

final color INFO_TAB_BACKGROUND = color(255, 166, 77);

void showInfoTab(Country country){
  
  strokeWeight(INFO_TAB_STROKE_WIDTH);
  fill(INFO_TAB_BACKGROUND);
  rect(mouseX + INFO_TAB_X_OFFSET, mouseY + INFO_TAB_Y_OFFSET, INFO_TAB_WIDTH, INFO_TAB_HEIGHT);
  fill(0);
  textAlign(LEFT, CENTER);
  text(country.getName(), getInfoTabPaddingX(), getInfoTabPaddingY());
  fill(255);
  
}
