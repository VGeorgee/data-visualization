
final int INFO_Y = 0;
final int INFO_WIDTH = 500;
final int INFO_X = 700;
final int INFO_HEIGHT = 850;
final color INFO_STROKE = color(236, 217, 198);

final int INFO_COUNTRY_HEIGHT = 20;
final int INFO_COUNTRY_START = INFO_X ;

final int IDStart = INFO_COUNTRY_START + INFO_WIDTH / 2;;
final int IDEnd = INFO_COUNTRY_HEIGHT;
final int COUNTRY_OFFSET_FROM_TOP = 30;

final int INFO_LEFT_GAP = 10;
final int vaccinationRectStart = INFO_COUNTRY_START + INFO_LEFT_GAP;
//int vaccinationRectEnd = INFO_COUNTRY_START + INFO_LEFT_GAP;

final int VACCINATION_RECT_MAX_LENGTH = (INFO_WIDTH / 5) * 2;

final int COUNTRY_ID_GAP = 15;

final int DEATH_TEXT_START = IDStart + COUNTRY_ID_GAP + 10;
final int DEATH_INTERVAL = 20;

int MAX_DEATHS = 0;

void drawSelectedInfo(){
  textAlign(CENTER);
  drawInfoBorder();
  ArrayList<Country> selected = Selector.getInstance().getSelected();
  drawInfoText();
  MAX_DEATHS = 0;
  for(int i = 0; i < selected.size(); i++) {
    int deaths = dataHandler.getDeathsPerMillionPopulation(selected.get(i).getName(), DEATH_INTERVAL);
    if(deaths > MAX_DEATHS){
      MAX_DEATHS = deaths;
    }
  }
  
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
  //text(country.getID(), INFO_COUNTRY_START + TextStart * 8, (INFO_COUNTRY_HEIGHT) * nth + 30);
  text(country.getID(), IDStart, IDEnd * nth + COUNTRY_OFFSET_FROM_TOP);
  drawVaccinationRect(country, nth);
  drawDeathsRect(country, nth);
  

  
}

void drawVaccinationRect(Country country, int nth){
  float vaccinationPercent = dataHandler.getVaccinatedPercentage(country.getName());
  color vaccinationColor = mapVaccinationPercentageColor(vaccinationPercent);
  fill(vaccinationColor);
  final int rectWidth = (int) map(vaccinationPercent, 0, 100, 0, VACCINATION_RECT_MAX_LENGTH);
  
  rect(IDStart - COUNTRY_ID_GAP, IDEnd * nth + COUNTRY_OFFSET_FROM_TOP / 2,  -rectWidth, INFO_COUNTRY_HEIGHT );
  
  
  fill(0);
  final int deathsTextStart = DEATH_TEXT_START + rectWidth;
  text((int)vaccinationPercent, IDStart - COUNTRY_ID_GAP - 10 - rectWidth,  IDEnd * nth + COUNTRY_OFFSET_FROM_TOP / 2 + 15);
  
  fill(0);
}

void drawDeathsRect(Country country, int nth){
  int deaths = dataHandler.getDeathsPerMillionPopulation(country.getName(), DEATH_INTERVAL);
  color deathsColor = mapDeathsColor(deaths);
  fill(deathsColor);
  final int rectWidth = (int) map(deaths, 0, MAX_DEATHS, 0, VACCINATION_RECT_MAX_LENGTH);
  rect(IDStart + COUNTRY_ID_GAP, IDEnd * nth + COUNTRY_OFFSET_FROM_TOP / 2,  rectWidth, INFO_COUNTRY_HEIGHT );
  
  fill(0);
  final int deathsTextStart = DEATH_TEXT_START + rectWidth;
  text(deaths, deathsTextStart,  IDEnd * nth + COUNTRY_OFFSET_FROM_TOP / 2 + 15);
  
  fill(0);
}

void drawInfoText(){
  textSize(20);
  fill(0);
  int TextStart = INFO_WIDTH / 8;
  text("VACCINATION", INFO_COUNTRY_START + TextStart * 2, INFO_COUNTRY_HEIGHT);
  text("DEATHS", INFO_COUNTRY_START + TextStart * 6, INFO_COUNTRY_HEIGHT);
  textSize(14);
  text("% adult population fully vaccinated", INFO_COUNTRY_START + TextStart * 2, INFO_COUNTRY_HEIGHT *2);
  text("per 1 million population", INFO_COUNTRY_START + TextStart * 6, INFO_COUNTRY_HEIGHT * 2);
}



color mapVaccinationPercentageColor(float percentage){
  if(percentage < 70.0){
    int red = 255;
    int green = (int) map(percentage, 70, 0, 255, 0);
    int blue = 0;
    return color(red, green, blue);
  } else {
    int red = 0;
    int green = 255;
    int blue = (int) map(percentage, 70, 100, 128, 255);
    return color(red, green, blue);
  }
}

float deathRange = 30.0;
color mapDeathsColor(int deaths){
  //println(deaths + " " + MAX_DEATHS + " " +  (deaths / (float)MAX_DEATHS));
  float deathsPercentage = (deaths / (float)MAX_DEATHS) * 100.0;
   if(deathsPercentage > deathRange){
    int red = 255;
    int green = (int) map(deathsPercentage, deathRange, 100, 255, 0);
    int blue = 0;
    return color(red, green, blue);
  } else {
    int red = 0;
    int green = 255;
    int blue = (int) map(deathsPercentage, deathRange, 0, 128, 255);
    return color(red, green, blue);
  }
}
