public class Country {

    private String name;
    private ArrayList<Integer> cases;


    private int startInterval;
    private int endInterval;
    private int sumOfCasesInInterval;

    public Country (String countryName) {
        name = countryName;
        cases = new ArrayList<Integer>();
    }

    public int getSumOfCases() {
        return sumOfCasesInInterval;
    }


    public void add(int dailyCase){
        cases.add(dailyCase);
    }

    public void initialize() {
        setInterval(0, this.cases.size());
    }

    public void setInterval(int start, int end) {
        if(!isValidInterval(start, end)){
            return;
        }
        this.startInterval = start;
        this.endInterval = end;
        sumOfCasesInInterval = 0;
        for(int i = start; i < end; i++){
            sumOfCasesInInterval += cases.get(i);
        }
    }

    private boolean isValidInterval(int a, int b){
        //return !((a >= b) || (a < 0) || (b >= this.cases.size()));
        return true;
    }


    public int getAllCases(){
        int sum = 0;
        for(int i = 0; i < cases.size(); i++){
            sum += cases.get(i);
        }
        return sum;
    }
}
