import g4p_controls.*;

import g4p_controls.*;

int OFFSET_X = -200;
int OFFSET_Y = -100;

Map map;
Countries countriesData;

GSlider slider;


void setup() {
  GToggleGroup gg = new GToggleGroup();
  size(1200, 1000);
  background(255);
  map = new Map("europe.svg", OFFSET_X, OFFSET_Y);
  countriesData = new Countries("all_cases_2.csv");

  slider = new GSlider(this, 0, 700, 500, 50, 30);
  GOption option = new GOption(this, 0, 500, 700, 50);
  option.setEnabled(true);
  GOption option2 = new GOption(this, 0, 550, 700, 50);
  GOption option3 = new GOption(this, 0, 600, 700, 50);

  gg.addControls(option, option2, option3);

  slider.setEnabled(true);
  slider.setLimits(0, 255);
}

int sliderValue = 0;

void draw() {
  map.draw();
  if(sliderValue != slider.getValueI()){
    sliderValue = slider.getValueI();
    countriesData.setInterval(0, sliderValue);
  }
}
