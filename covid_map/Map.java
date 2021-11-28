import java.lang.reflect.Array;
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

    public ArrayList<Country> getCountries(){
        return countryList;
    }


    public void loadMap(Object[] shapes, String[] names){
        // /*
       for(int i = 0; i < shapes.length; i++) {
           Country country = new Country(shapes[i], names[i]);
           countryList.add(country);
           countryMap.put(country.getName(), country);
        }
        //*/
    }

    public void setInterval(int start, int end){
        dataHandler.setInterval(start, end);
        int maxNumberOfCases = 0;
        int minNumberOfCases = 500_000_000;
        for(Country country: this.countryList) {
            int cases = dataHandler.getCasesPerMillionPopulation(country.getName());
            if(maxNumberOfCases < cases){
                maxNumberOfCases = cases;
            }
            if(minNumberOfCases > cases){
                minNumberOfCases = cases;
            }
            //country.setColour();
        }

        int interval = maxNumberOfCases - minNumberOfCases;

        System.out.println("INTERVAL: " + maxNumberOfCases + " .. "+ minNumberOfCases +" .. kivonat: " + (maxNumberOfCases - minNumberOfCases));
        for(Country country: this.countryList) {
            int cases = dataHandler.getCasesPerMillionPopulation(country.getName());

            System.out.println("CASES: " + cases);

            double percentage =  ((double)(cases - minNumberOfCases) / interval) * 100;
            if(Double.isNaN(percentage)){
                percentage = 0.0;
            }
            if(Double.isInfinite(percentage)){
                percentage = 100.0;
            }
            System.out.println("PERCENTAGE: " + percentage);
            country.setCasesPercent(percentage);
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
