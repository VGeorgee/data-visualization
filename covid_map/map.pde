
public class Map {

    PShape original;
    ArrayList<PShape> countries;

    private int offsetx;
    private int offsety;

    private  color unHoverColor;
    private  color hoverColor;

    public Map (String fileName, int offsetx, int offsety) {
        unHoverColor = color(100, 100, 100);
        hoverColor = color(200, 200, 200);
        original = loadShape(fileName); 
        countries = new ArrayList<PShape>();
        this.offsetx = offsetx;
        this.offsety = offsety;

        for(int i = 0; i < this.original.getChildCount(); i++) {
            
            PShape child = this.original.getChild(i);
            /*
            child.beginShape();
            child.fill(255);
            child.endShape(CLOSE);
*/
            countries.add(child);
        }
    }



    public void draw() {
        shape(original, this.offsetx, this.offsety);
        for (int i = 0; i < this.original.getChildCount(); ++i) {
            PShape country = this.countries.get(i);
            if(country.contains(getMouseX(), getMouseY())){
//println(slider.getValueI());
                color c = color(slider.getValueF());
                country.setFill(c);

                println(countriesData.getAllCasesForCountry(country.getName()));
            } else {
                country.setFill(unHoverColor);
            }
        }
    }

    public void fillCountry(){
        
        countries.get(5).setFill(color(30, 244, 244));
    }

    private int getMouseX(){
        return mouseX - this.offsetx;
    }


    private int getMouseY(){
        return mouseY - this.offsety;
    }
}
