import g4p_controls.*;


int OFFSET_X = -200;
int OFFSET_Y = -100;

int SLIDER_X = 0;
int SLIDER_Y = 700;
int SLIDER_LENGTH = 500;

Map map;
Selector selector;
DataHandler dataHandler;

GSlider slider;

void loadShapes(){
  map = Map.getInstance();
  PShape mapShape = loadShape("europe.svg");
  //shape(mapShape, OFFSET_X, OFFSET_Y);
  int countryCount = mapShape.getChildCount();
  String[] countryNames = new String[countryCount];
  Object[] countryShapes = new Object[countryCount];
  for(int i = 0; i < countryCount; i++){
    PShape country =  mapShape.getChild(i);
    countryShapes[i] = country;
    countryNames[i] = country.getName();
  }
  map.loadMap(countryShapes, countryNames);
}

void setup() {
  GToggleGroup gg = new GToggleGroup();
  size(1200, 1000);
  background(255);
  loadShapes();
  // new Map("europe.svg", OFFSET_X, OFFSET_Y);
 // countriesData = new Countries("all_cases_2.csv");

  slider = new GSlider(this, SLIDER_X, SLIDER_Y, SLIDER_LENGTH, 50, 30);
  
  dataHandler = DataHandler.getInstance();
  final String path = "/Users/gyorgyvereb/egyetem/data-visualization/covid_map/datasets/";
  dataHandler.loadData(
    path + "cases.csv",
    path + "deaths.csv",
    path + "vaccinations.csv",
    path + "population.csv"
  );
  calculateColorOfCountries();

  slider.setEnabled(true);
  slider.setLimits(0, 500);
  setUpSlider();
  initLerp();
}

int sliderValue = 0;

void draw() {
  background(INFO_STROKE);
  drawCountries();
  if(sliderValue != slider.getValueI()){
    sliderValue = slider.getValueI();
    map.setInterval(1, sliderValue);
    calculateColorOfCountries();
  }
  checkInfoSlider();
  drawSelectedInfo();

  drawInfo();
}
