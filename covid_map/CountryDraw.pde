

void drawCountries(){
  ArrayList<Country> countries = map.getCountries();
  //println(countries.size());
  Country hovered = null;
  for(Country country: countries){
      PShape countryShape = (PShape) country.getShape();
      
      boolean isHovered = countryShape.contains(getMouseX(), getMouseY());

      country.setHover(isHovered);
      
      if(isMouseClicked() && isHovered){
        if(country.isSelected()){
          map.unselect(country.getName());
        } else {
          map.select(country.getName());
        }
        useMouseClick();
      }
      
      
      setCountryStroke(country);
        
        
     if(country.isHover()){
       countryShape.setFill(color(Country.HOVER_BACKGROUND));
       hovered = country;
     } else {
       countryShape.setFill(color(country.getColour()));
     }
     shape(countryShape, OFFSET_X, OFFSET_Y);
  }
  
  if(hovered != null){
    showInfoTab(hovered);
  }
  //Mapper mapper = Mapper.getInstance();
  //text(mapper.getDate(0) + " - " +mapper.getDate(sliderValue), 200, 200);
}
   private int getMouseX(){
        return mouseX - OFFSET_X;
    }


    private int getMouseY(){
        return mouseY - OFFSET_Y;
    }
    

void setCountryStroke(Country country){
  if(country.isSelected()){
    setSelectedStroke((PShape)country.getShape());
  } else {
    setUnSelectedStroke((PShape)country.getShape());
  }
}
    
    
void setSelectedStroke(PShape shape){
  shape.setStroke(color(Country.SELECTED_STROKE));
  shape.setStrokeWeight(2);
}

void setUnSelectedStroke(PShape shape){
  shape.setStroke(color(Country.UNSELECTED_STROKE));
  shape.setStrokeWeight(2);
}

void calculateColorOfCountries(){
  ArrayList<Country> countries = map.getCountries();
  for(Country country: countries) {
    float percentage = (float)country.getCasesPercentage();
    country.setColour(mapCasesColor(percentage));
  }
}

float casesRange = 30.0;
color mapCasesColor(float percentage){
 
  //**
  
    int red = (int) map(percentage, 0, 50, 0, 255);
    int green = (int) map(percentage, 50, 100, 255, 0);
    int blue = 0;
    
    return color(red, green, blue);
  //*/
 
 /*
   if(percentage > casesRange){
    int red = (int) map(percentage, casesRange, 100, 255, 0);;
    int green = 0;
    int blue = 0;
    return color(red, green, blue);
  } else {
    int red = 0;
    int green = (int) map(percentage, casesRange, 0, 128, 255);
    int blue = 0;
    return color(red, green, blue);
  }
  //*/
}

int INFO_BAR_X = 0;
int INFO_BAR_Y = 650;
int INFO_BAR_LENGTH = 500;
int INFO_BAR_WIDTH = 50;
color[] lerped = new color[100];

void initLerp() {  
  for(int i = 0; i < 100; i++ ) {
    lerped[i] = mapCasesColor((float)i);
  }
}

void drawInfo() {
  for(int i = 0; i < 100; i++ ) {
    noStroke();
    fill(lerped[i]);
    rect(INFO_BAR_X + (i * 5), INFO_BAR_Y, 5, INFO_BAR_WIDTH);
  }

  textSize(24);
  fill(0);
  textAlign(LEFT);
  text("0%", INFO_BAR_X, INFO_BAR_Y - 15);
  text("100%", INFO_BAR_X + INFO_BAR_LENGTH - INFO_BAR_WIDTH, INFO_BAR_Y - 15);
}
