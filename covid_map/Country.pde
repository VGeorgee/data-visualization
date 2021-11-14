public class Country {

    String name;
    ArrayList<Integer> cases;

    public Country (String countryName) {
        name = countryName;
        cases = new ArrayList<Integer>();
    }

    public void add(int dailyCase){
        cases.add(dailyCase);
    }

    public int getAllCases(){
        int sum = 0;
        for(int i = 0; i < cases.size(); i++){
            sum += cases.get(i);
        }
        return sum;
    }
}
