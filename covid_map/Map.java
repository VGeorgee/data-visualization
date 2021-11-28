import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    private ArrayList<Country> countryList;
    private HashMap<String, Country> countryMap;
    private Selector selector;
    private DataHandler dataHandler;

    private int offsetX;
    private int offsetY;
    public void setOffset(int x, int y){
        offsetX = x;
        offsetY = y;
    }

    public void select(String countryName) {
        final Country country = countryMap.get(countryName);
        if(country == null){
            System.out.println("Country not found[" + countryName + "]");
        } else {
            selector.add(country);
        }
    }

    public void unselect(String countryName) {
        final Country country = countryMap.get(countryName);
        if(country == null){
            System.out.println("Country not found[" + countryName + "]");
        } else {
            selector.remove(country);
        }
    }


    public void draw(){
        // /*
        for(Country shape: countryList){
            shape.draw();
        }
        // */
    }

    public void loadMap(String fileName){
        /*
       PShape map = loadShape(fileName);
       for(int i = 0; i < map.getChildCount(); i++) {
            PShape child = map.getChild(i);
           Country country = new Country(child, child.getName());
           shapeList.add(country);
           shapeMap.put(country.getName(), country);
        }
        //*/
    }

    public void setInterval(int start, int end){
        dataHandler.setInterval(start, end);
        for(Country country: this.countryList) {

        }
    }


    private Map(){
        countryList = new ArrayList<>();
        countryMap = new HashMap<>();
        selector = Selector.getInstance();
        dataHandler = DataHandler.getInstance();
    }
    private static Map INSTANCE;
    public static Map getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Map();
        }
        return INSTANCE;
    }
}
