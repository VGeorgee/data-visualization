import java.io.File;
import java.util.Scanner;

public class DataLoader {

    final static int NUMBER_OF_COUNTRIES = 39;
    final static int MAX_NUMBER_OF_DATA = 676;

    static int[][] load(String fileName) {
        final Mapper mapper = Mapper.getInstance();
        Scanner scanner;
        try{
            final File file = new File(fileName);
            scanner = new Scanner(file);
        } catch (Exception ex){
            System.out.println(ex.toString());
            return new int[1][1];
        }

        final int[][] result = new int[39][MAX_NUMBER_OF_DATA];

        String[] header = scanner.nextLine().split(",");
        while(scanner.hasNextLine()){
            String[] tokens = parseLine(scanner.nextLine());
            final int dateIndex = mapper.dateIndex(tokens[0]);

            for(int i = 1; i < header.length; i++){
                final int countryIndex = mapper.countryIndex(header[i]);
                int value = tokens[i].equals("") ? 0 : Integer.parseInt(tokens[i]);
                result[countryIndex][dateIndex] = value;// + result[countryIndex][dateIndex - 1];
            }
        }

        return result;
    }
    /*
    static int[][] loadDeaths(String fileName){
        final Mapper mapper = Mapper.getInstance();
        return new int[1][1];
    }*/

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
        final int[] result = new int[NUMBER_OF_COUNTRIES];
        scanner.nextLine();
        while(scanner.hasNextLine()){
            String[] tokens = scanner.nextLine().split(",");
            result[mapper.countryIndex(tokens[0])] = Integer.parseInt(tokens[1]);
        }
        return result;
    }

    static String[] parseLine(String line){
        Scanner sc = new Scanner(line);
        sc.useDelimiter(",");
        String[] result = new String[1000];
        int resultSize = 0;
        while (sc.hasNext()) {
            result[resultSize++] = sc.next();
        }
        result[resultSize++] = "";
        return result;
    }
}
