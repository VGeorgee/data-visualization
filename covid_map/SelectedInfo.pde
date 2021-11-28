final int INFO_X = 700;
final int INFO_Y = 0;
final int INFO_WIDTH = 500;
final int INFO_HEIGHT = 800;
final color INFO_STROKE = color(236, 217, 198);

final int INFO_COUNTRY_HEIGHT = 30;
final int INFO_COUNTRY_START = INFO_X;


void drawSelectedInfo(){
  drawInfoBorder();
  ArrayList<Country> selected = Selector.getInstance().getSelected();
  drawInfoText();
  for(int i = 0; i < selected.size(); i++) {
    drawCountryInfo(selected.get(i), i + 2);
  }
}

void drawInfoBorder(){
  stroke(INFO_STROKE);
  strokeWeight(2);
  fill(INFO_STROKE);
  rect(INFO_X, INFO_Y, INFO_WIDTH, INFO_HEIGHT);
}

void drawCountryInfo(Country country, int nth){
  textSize(10);
  int TextStart = INFO_WIDTH / 16;
  text(country.getName(), INFO_COUNTRY_START + TextStart * 7, (INFO_COUNTRY_HEIGHT) * nth);
}

void drawInfoText(){
  textSize(20);
  fill(0);
  int TextStart = INFO_WIDTH / 8;
  text("VACCINATION", INFO_COUNTRY_START + TextStart, INFO_COUNTRY_HEIGHT);
  text("DEATHS", INFO_COUNTRY_START + TextStart * 6, INFO_COUNTRY_HEIGHT);
}
