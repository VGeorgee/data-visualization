public class Country {
    private Object shape;
    private String name;
    private boolean isSelected;
    private boolean isHover;
    private int colour;


    static final int HOVER_BACKGROUND = 0xCC80AAFF;
    //static final int UNHOVER_BACKGROUND = 0xCC80AAFF;
    static final int SELECTED_STROKE = 0xCC00CCFF;
    static final int UNSELECTED_STROKE = 0xFFFFFFFF;

    public Country(Object shape, String name) {
        this.shape = shape;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    public void setColour(int colour){
        this.colour = colour;
    }

    public void draw(){
         /*
        if(isSelected){
            shape.setStroke(SELECTED_STROKE);
        } else {
            shape.setStroke(UNSELECTED_STROKE);
        }
        if(isHover){
            shape.setFill(HOVER_BACKGROUND);
        } else {
            shape.setFill(colour);
        }
         // */
    }

    public boolean isSelected(){
        return isSelected;
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
