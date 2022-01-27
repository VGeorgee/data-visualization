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
    
    public static void setBaseColors(){
        colors.put("Curriculum", new HashMap<>());
        colors.get("Curriculum").put("Mérnök informatikus BSc nappali", 0xFFfc0303);
        colors.get("Curriculum").put("Mérnökinformatikus MSc nappali", 0xFFfc7703);
        colors.get("Curriculum").put("Programtervező informatikus BSc nappali", 0xFFfcdf03);
        colors.get("Curriculum").put("Programtervező informatikus MSc nappali", 0xFFc2fc03);
        colors.get("Curriculum").put("Gazdaságinformatikus BSc nappali", 0xFFb5b293);
        colors.get("Curriculum").put("Gazdaságinformatikus MSc nappali", 0xFF03fc90);
        colors.get("Curriculum").put("Informatika(-X)tanár_2013_(osztatlan MSc) nappali (közös képzési szakasz)", 0xFF03e3fc);
        colors.get("Curriculum").put("Infokommunikációs hálózatok szakirány nappali", 0xFF038cfc);
        colors.get("Curriculum").put("Informatika(-Matematika/fizika)tanár_2018_(osztatlan MSc) nappali (közös képzési szakasz)", 0xFF0318fc);
        colors.get("Curriculum").put("E-gazdasági szakirány nappali", 0xFF8403fc);
        colors.get("Curriculum").put("\"Informatika(-Matematika/fizika)tanár_2018_(osztatlan MSc) nappali (általános iskolai) - \"\"4+1\"\"\"", 0xFFfc03fc);
        colors.get("Curriculum").put("\"Informatika(-X)tanár_2013_(osztatlan MSc) nappali (általános iskolai) - \"\"4+1\"\"\"", 0xFF03a652);
        colors.get("Curriculum").put("\"Informatika(-X)tanár_2018_(osztatlan MSc) nappali (általános iskolai) - \"\"4+1\"\"\"", 0xFF34a603);
        colors.get("Curriculum").put("Vállalatirányítási szakirány nappali", 0xFFa6a103);
        colors.get("Curriculum").put("\"Informatika(-Matematika)tanár_2013_(osztatlan MSc) nappali (általános iskolai) - \"\"4+1\"\"\"", 0xFF0393a6);
        colors.get("Curriculum").put("Informatika(-Matematika)tanár_2013_(osztatlan MSc) nappali (közös képzési szakasz)", 0xFF575100);
        colors.get("Curriculum").put("Informatika(-X)tanár_2018_(osztatlan MSc) nappali (közös képzési szakasz)\"", 0xFF570054);
    }
}
