import java.util.HashMap;

public class Mapper {
    private static HashMap<String, Integer> dates = new HashMap<>();
    private static HashMap<String, Integer> countries = new HashMap<>();

    static int dateIndex(String date) {
        if(!dates.containsKey(date)){
            dates.put(date, dates.size());
        }
        return dates.get(date);
    }
    static int countryIndex(String countryName) {
        if (!countries.containsKey(countryName)) {
            countries.put(countryName, countries.size());
        }
        return countries.get(countryName);
    }

    static int getDateSize(){
        return dates.size();
    }
}
