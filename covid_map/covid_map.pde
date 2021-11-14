import g4p_controls.*;

int OFFSET_X = -200;
int OFFSET_Y = -100;

Map map;
GSlider slider;

void setup() {
  size(1200, 1000);
  background(255);
  map = new Map("europe.svg", OFFSET_X, OFFSET_Y);
  slider = new GSlider(this, 0, 700, 500, 50, 30);
  slider.setEnabled(true);
  slider.setLimits(0, 255);
}

void draw() {
  map.draw();
}
