import java.lang.reflect.Array;
import java.util.ArrayList;

public class Selector {
    private ArrayList<Country> selected;

    public ArrayList<Country> getSelected(){
        return selected;
    }

    public void add(Country country){
        selected.add(country);
    }

    public void remove(Country country){
        selected.remove(country);
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
