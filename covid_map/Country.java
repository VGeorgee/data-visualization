import java.util.Objects;

public class Country {
    private Object shape;
    private String name;
    private boolean selected;

    public Country(Object shape, String name) {
        this.shape = shape;
        this.name = name;
    }

    private void draw(){

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return name.equals(country.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
