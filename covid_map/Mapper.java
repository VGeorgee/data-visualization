import java.util.HashMap;

public class Mapper {
    private HashMap<String, Integer> dates = new HashMap<>();
    private HashMap<String, Integer> countries = new HashMap<>();

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

    private static Mapper INSTANCE;
    public static Mapper getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Mapper();
        }
        return INSTANCE;
    }
}
