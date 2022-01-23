import java.util.HashMap;
import java.util.Map;

public class ColorDatabase {
    public static Map<String, Map<String, Integer>> colors = new HashMap<>();

    public static int getColor(String entityKey, String key){
        if(!colors.containsKey(entityKey)){
            colors.put(entityKey, new HashMap<>());
        }
        Map<String, Integer> entityColors = colors.get(entityKey);
        if(!entityColors.containsKey(key)){
            entityColors.put(key, ((int)(Math.random() * (Integer.MAX_VALUE - 1))) | 0xFF000000);
        }
        return entityColors.get(key);
    }

    public static Map<String, Integer> getColorsForEntity(String entityKey){
        return colors.get(entityKey);
    }
}
