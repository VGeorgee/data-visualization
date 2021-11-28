import java.util.ArrayList;
import java.util.Collections;

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
        Collections.sort(selected);
    }

    public void remove(Country country){
        if(selected.contains(country)) {
            country.setSelected(false);
            selected.remove(country);
        }
        Collections.sort(selected);
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
