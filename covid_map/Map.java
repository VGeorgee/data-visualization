import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    private ArrayList<Country> shapeList;
    private HashMap<String, Country> shapeMap;
    private Selector selector;

    private int offsetX;
    private int offsetY;
    public void setOffset(int x, int y){
        offsetX = x;
        offsetY = y;
    }

    public void select(String countryName) {
        final Country country = shapeMap.get(countryName);
        if(country == null){
            System.out.println("Country not found[" + countryName + "]");
        } else {
            country.setSelected(true);
            selector.add(country);
        }
    }

    public void unselect(String countryName) {
        final Country country = shapeMap.get(countryName);
        if(country == null){
            System.out.println("Country not found[" + countryName + "]");
        } else {
            country.setSelected(false);
            selector.remove(country);
        }
    }


    public void draw(){

    }


    private Map(){
        shapeList = new ArrayList<>();
        shapeMap = new HashMap<>();
        selector = Selector.getInstance();
    }
    private static Map INSTANCE;
    public static Map getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Map();
        }
        return INSTANCE;
    }
}
