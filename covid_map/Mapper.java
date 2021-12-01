import java.util.HashMap;

public class Mapper {
    private HashMap<String, Integer> dates;
    private HashMap<String, Integer> countries;
    private HashMap<String, String> countryIDs;
    private HashMap<Integer, String> reverseDate;

    int dateIndex(String date) {
        if(!dates.containsKey(date)){
            dates.put(date, dates.size());
            reverseDate.put(dates.size() - 1, date);
        }
        return dates.get(date);
    }
    int countryIndex(String countryName) {
        if (!countries.containsKey(countryName)) {
            countries.put(countryName, countries.size());
        }
        return countries.get(countryName);
    }

    String getDate(int day) {
        return reverseDate.get(day);
    }

    String getCountryID(String name){
        return countryIDs.get(name);
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
        reverseDate = new HashMap<>();
        dates.put("PlaceHolder", 0);
        countryIDs = new HashMap<>();countryIDs.put("Albania", "ALB");
        countryIDs.put("Andorra","AND");
        countryIDs.put("Austria","AUT");
        countryIDs.put("Belarus","BLR");
        countryIDs.put("Belgium","BEL");
        countryIDs.put("Bosnia and Herzegovina","BIH");
        countryIDs.put("Bulgaria","BGR");
        countryIDs.put("Croatia","HRV");
        countryIDs.put("Czech Republic","CZE");
        countryIDs.put("Denmark","DNK");
        countryIDs.put("Estonia","EST");
        countryIDs.put("Finland","FIN");
        countryIDs.put("France","FRA");
        countryIDs.put("Germany","DEU");
        countryIDs.put("Greece","GRC");
        countryIDs.put("Hungary","HUN");
        countryIDs.put("Ireland","IRL");
        countryIDs.put("Italy","ITA");
        countryIDs.put("Kosovo","KOS");
        countryIDs.put("Latvia","LVA");
        countryIDs.put("Liechtenstein","LIE");
        countryIDs.put("Lithuania","LTU");
        countryIDs.put("Luxembourg","LUX");
        countryIDs.put("Macedonia","MKD");
        countryIDs.put("Moldova","MDA");
        countryIDs.put("Montenegro","MNE");
        countryIDs.put("Netherlands","NLD");
        countryIDs.put("Norway","NOR");
        countryIDs.put("Poland","POL");
        countryIDs.put("Portugal","PRT");
        countryIDs.put("Romania","ROU");
        countryIDs.put("Serbia","SRB");
        countryIDs.put("Slovakia","SVK");
        countryIDs.put("Slovenia","SVN");
        countryIDs.put("Spain","ESP");
        countryIDs.put("Sweden","SWE");
        countryIDs.put("Switzerland","CHE");
        countryIDs.put("Ukraine","UKR");
        countryIDs.put("United Kingdom","GBR");
    }
    public static Mapper getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Mapper();
        }
        return INSTANCE;
    }
}
