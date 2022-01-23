import java.util.Map;

public interface ICountMapper {
    public Map<String, Map<String, Integer>> getCounts();
    public Map<String, Integer> getCount(String key);
    public String getEntityKey();
}
