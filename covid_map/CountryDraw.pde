

void drawCountries(){
  ArrayList<Country> countries = map.getCountries();
  //println(countries.size());
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
        } else {
          countryShape.setFill(color(country.getColour()));
        }
        shape(countryShape, OFFSET_X, OFFSET_Y);
  }
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
