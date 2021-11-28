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

        final int[][] result = new int[NUMBER_OF_COUNTRIES][MAX_NUMBER_OF_DATA];

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

    static int[][] loadVaccinations(String fileName){
        final String[] header = new String[]{
                "location",
                "iso_code",
                "date",
                "total_vaccinations",
                "people_vaccinated",
                "people_fully_vaccinated",
                "total_boosters",
                "daily_vaccinations_raw",
                "daily_vaccinations",
                "total_vaccinations_per_hundred",
                "people_vaccinated_per_hundred",
                "people_fully_vaccinated_per_hundred",
                "total_boosters_per_hundred",
                "daily_vaccinations_per_million",
                "daily_people_vaccinated",
                "daily_people_vaccinated_per_hundred"
        };
        final int headerLocation = 0;
        final int headerDate = 2;
        final int headerVaccinations = 3;

        final Mapper mapper = Mapper.getInstance();
        Scanner scanner;
        try{
            final File file = new File(fileName);
            scanner = new Scanner(file);
        } catch (Exception ex){
            System.out.println(ex.toString());
            return new int[1][1];
        }

        final int[][] result = new int[NUMBER_OF_COUNTRIES][MAX_NUMBER_OF_DATA];

        scanner.nextLine();
        int indexOfDate = 0;
        int indexOfCountry = 0;
        while(scanner.hasNextLine()){
            String[] tokens = parseLine(scanner.nextLine());
            indexOfCountry = mapper.countryIndex(tokens[headerLocation]);
            indexOfDate = mapper.dateIndex(tokens[headerDate]);

            if(!tokens[headerVaccinations].equals("")){
                result[indexOfCountry][indexOfDate] = Integer.parseInt(tokens[headerVaccinations]);
            } else {
                result[indexOfCountry][indexOfDate] = result[indexOfCountry][indexOfDate - 1];
            }
        }

        for(int i = 0; i < NUMBER_OF_COUNTRIES; i++){
            fillEndOfArray(result[i]);
        }
/*
        while(indexOfDate < MAX_NUMBER_OF_DATA){
            result[indexOfCountry][indexOfDate] = result[indexOfCountry][indexOfDate - 1];
            indexOfDate++;
        }
*/
        return result;
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

    static void fillEndOfArray(int[] array){
        int i = array.length - 1;
        while(array[i] == 0) i--;
        while(++i < array.length){
            array[i] = array[i - 1];
        }
    }
}
