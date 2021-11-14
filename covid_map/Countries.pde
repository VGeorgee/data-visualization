public class Countries {

    private String[] countryNames = { "Albania", "Andorra", "Austria", "Belarus", "Belgium", "Bosnia", "Bulgaria", "Croatia", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Kosovo", "Latvia", "Liechtenstein", "Lithuania", "Luxembourg", "Moldova", "Montenegro", "Netherlands", "Norway", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Ukraine", "United Kingdom"};
// MACEDONIA AND SERBIA IS MISSING FROM DATA
    ArrayList<Country> countriesList = new ArrayList<Country>();
    HashMap<String, Country> countriesMap = new HashMap<>();

    public Countries (String fileName) {
        Table table = loadTable(fileName, "header");
        
        for(String countryName: countryNames){

            Country country = new Country(countryName);
            
            countriesList.add(country);
            countriesMap.put(countryName, country);

            for (TableRow row : table.rows()) {
                String date = row.getString("date");
                int dailyCase = row.getInt(countryName);
                country.add(dailyCase);
            }

        }
    }

    public int getAllCasesForCountry(String countryName){
        return countriesMap.get(countryName).getAllCases();
    }

}
