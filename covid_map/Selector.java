import java.util.ArrayList;

public class Selector {
    private ArrayList<Country> selected;

    public ArrayList<Country> getSelected(){
        return selected;
    }

    public void add(Country country){
        if(!selected.contains(country)){
            country.setSelected(true);
            selected.add(country);
        }
    }

    public void remove(Country country){
        if(selected.contains(country)) {
            country.setSelected(false);
            selected.remove(country);
        }
    }

    private Selector(){
        selected = new ArrayList<>();
    }

    private static Selector INSTANCE;
    public static Selector getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Selector();
        }
        return INSTANCE;
    }
}
