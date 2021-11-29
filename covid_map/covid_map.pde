import g4p_controls.*;


int OFFSET_X = -200;
int OFFSET_Y = -100;

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

  slider = new GSlider(this, 0, 700, 500, 50, 30);
  
  dataHandler = DataHandler.getInstance();
  final String path = "D://GIT//Processing//data-visualization//covid_map//datasets//";
  dataHandler.loadData(
    path + "cases.csv",
    path + "deaths.csv",
    path + "vaccinations.csv",
    path + "population.csv"
  );
  calculateColorOfCountries();

  slider.setEnabled(true);
  slider.setLimits(0, 675);
  setUpSlider();
}

int sliderValue = 0;

void draw() {
  background(255);
  drawCountries();
  if(sliderValue != slider.getValueI()){
    sliderValue = slider.getValueI();
    map.setInterval(sliderValue, 670);
    calculateColorOfCountries();
  }
  checkInfoSlider();
  drawSelectedInfo();
}
