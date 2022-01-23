import java.util.HashMap;
import java.util.Map;

public class ColorDatabase {
    public static Map<String, Map<String, Integer>> colors;

    public static int getColorsFor(String entityKey, String key){
        if(!colors.containsKey(entityKey)){
            colors.put(entityKey, new HashMap<>());
        }
        Map<String, Integer> entityColors = colors.get(entityKey);
        if(!entityColors.containsKey(key)){
            entityColors.put(entityKey, (int)(Math.random() * (Integer.MAX_VALUE - 1)));
        }
        return entityColors.get(entityKey);
    }
}
