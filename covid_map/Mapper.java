import java.util.HashMap;

public class Mapper {
    private HashMap<String, Integer> dates;
    private HashMap<String, Integer> countries;

    int dateIndex(String date) {
        if(!dates.containsKey(date)){
            dates.put(date, dates.size());
        }
        return dates.get(date);
    }
    int countryIndex(String countryName) {
        if (!countries.containsKey(countryName)) {
            countries.put(countryName, countries.size());
        }
        return countries.get(countryName);
    }

    int getDateSize(){
        return dates.size();
    }
    int getCountriesSize(){
        return countries.size();
    }



    private static Mapper INSTANCE;
    private Mapper(){
        dates = new HashMap<>();
        countries = new HashMap<>();
        dates.put("PlaceHolder", 0);
    }
    public static Mapper getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Mapper();
        }
        return INSTANCE;
    }
}
