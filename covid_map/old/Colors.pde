
public class Colors {

    private Colors INSTANCE = new Colors();

    public Colors getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Colors();
        }
        return INSTANCE;
    }

    private Colors(){

    }



}
 color mapCasesColor(int number, int min, int max){
   int red = (int)map(number, min, max, 0, 255);
   int green = 0;
   int blue = 0;

   return color(red, green, blue);
}
