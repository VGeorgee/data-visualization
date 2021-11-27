public class DataHandler {
    private int [][] cases;
    private int [][] deaths;
    private int [][] vaccinated;
    private int [] 	population;

    private int startInterval;
    private int endInterval;

    private Mapper mapper;

    public void loadData(String cases, String deaths, String vaccinated, String population){

    }

    public void setInterval(int start, int end){
        this.startInterval = start;
        this.endInterval = end;
    }

    public int getDeaths(String countryName) {
        return getSumInInterval(deaths, countryName, startInterval, endInterval);
    }

    public int getDeathsOnInterval(String countryName, int start, int end){
        return getSumInInterval(deaths, countryName, start, end);
    }

    public int getMaxDeaths(){
        return 0; // !TODO
    }
    public int getMaxDeathsOnInterval(int start, int end){
        return 0; // !TODO
    }
    public int getDeathsWithPeriod(int from){
        return 0; // !TODO
    }

    public int getCases(String countryName){
        return getSumInInterval(cases, countryName, startInterval, endInterval);
    }

    public int getCasesOnInterval(String countryName, int start, int end){
        return getSumInInterval(cases, countryName, start, end);
    }
    public int getMaxCases(){
        return 0; // !TODO
    }
    public int getMaxCasesOnInterval(int start, int end){
        return 0; // !TODO
    }
    public int getCasesWithPeriod(int from){
        return 0; // !TODO
    }

    public int getVaccinated(String countryName){
        return getSumInInterval(vaccinated, countryName, startInterval, endInterval);
    }
    public int getVaccinatedOnInterval(String countryName, int start, int end){
        return getSumInInterval(vaccinated, countryName, start, end);
    }
    public int getMaxVaccinated(){
        return 0; // !TODO
    }
    public int getMaxVaccinatedOnInterval(int start, int end){
        return 0; // !TODO
    }
    public int getVaccinatedWithPeriod(int from){
        return 0; // !TODO
    }

    private int getSumInInterval(int[][] dataset, String countryName, int start, int end){
        if(start < 0 || end >= dataset[0].length){
            System.out.println("INVALID INTERVAL!");
            return 0;
        }
        final int indexOfCountry = mapper.countryIndex(countryName);
        if(indexOfCountry >= cases.length){
            System.out.println("INVALID COUNTRY NAME!");
            return 0;
        }
        final int[] countryData = dataset[indexOfCountry];
        final int sum = countryData[start] -  countryData[end];
        return sum;
    }

    public int getPopulation(String countryName){
        final int countryIndex = mapper.countryIndex(countryName);
        if(countryIndex >= population.length){
            System.out.println("INVALID COUNTRY INDEX WITH NAME [" + countryName + "]");
            return 0;
        }
        return population[countryIndex];
    }
    public int getPopulationMultiplier(String countryName){
        return 1_000_000 / getPopulation(countryName);
    }

    private static DataHandler INSTANCE;
    private DataHandler() {
        mapper = Mapper.getInstance();
    }
    public static DataHandler getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataHandler();
        }
        return INSTANCE;
    }
}
