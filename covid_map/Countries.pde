public class Countries {

    private String[] countryNames = { "Albania", "Andorra", "Austria", "Belarus", "Belgium", "Bosnia", "Bulgaria", "Croatia", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Kosovo", "Latvia", "Liechtenstein", "Lithuania", "Luxembourg", "Moldova", "Montenegro", "Netherlands", "Norway", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Ukraine", "United Kingdom"};
// MACEDONIA AND SERBIA IS MISSING FROM DATA
    ArrayList<Country> countriesList = new ArrayList<Country>();
    HashMap<String, Country> countriesMap = new HashMap<>();

    private int maxCase;
    private int minCase;
    
    public int getMaxCase() {
      return maxCase;
    }
    
    public int getMinCase(){
      return minCase;
    }

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
            country.initialize();
        }
    }
    
    public void setInterval(int start, int end)  {
      for( Country country: countriesList) {
        country.setInterval(start, end);
      }

      minCase = countriesList.get(0).getSumOfCases();
      maxCase = 0;
      for( Country country: countriesList) {
        if(country.getSumOfCases() > 0) {
          if(maxCase < country.getSumOfCases()){
            maxCase = country.getSumOfCases();
          }
          if(minCase > country.getSumOfCases()) {
            minCase = country.getSumOfCases();
          } 
        }
      }
    }

    public int getAllCasesForCountry(String countryName){
        return countriesMap.get(countryName).getAllCases();
    }
    
    public Country getDataOfCountry(String countryName) {
      return countriesMap.get(countryName);
    }

}
