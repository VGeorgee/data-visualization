import java.io.File;
import java.util.Scanner;

public class DataLoader {
    static int[][] loadCases(String fileName) {
        final Mapper mapper = Mapper.getInstance();
        Scanner scanner;
        try{
            final File file = new File(fileName);
            scanner = new Scanner(file);
        } catch (Exception ex){
            System.out.println(ex.toString());
            return new int[1][1];
        }
        return new int[1][1];
    }
    static int[][] loadDeaths(String fileName){
        final Mapper mapper = Mapper.getInstance();
        return new int[1][1];
    }
    static int[][] loadVaccinations(String fileName){
        final Mapper mapper = Mapper.getInstance();
        return new int[1][1];
    }
    static int[] loadPopulation(String fileName){
        final Mapper mapper = Mapper.getInstance();
        Scanner scanner;
        try{
            final File file = new File(fileName);
            scanner = new Scanner(file);
        } catch (Exception ex){
            System.out.println(ex.toString());
            return new int[1];
        }
        final int NUMBER_OF_COUNTRIES = 39;
        final int[] result = new int[NUMBER_OF_COUNTRIES];
        scanner.nextLine();
        while(scanner.hasNextLine()){
            String[] tokens = scanner.nextLine().split(",");
            result[mapper.countryIndex(tokens[0])] = Integer.parseInt(tokens[1]);
        }
        return result;
    }
}
