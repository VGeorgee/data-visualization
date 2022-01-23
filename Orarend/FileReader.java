import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class FileReader {

    public static List<FileEntry> readFile(String fileName) {
        try{
            File file = new File(fileName);
            //Scanner sc = new Scanner(new FileInputStream(file), "utf-8");
            Scanner sc = new Scanner(new FileInputStream(file));
            ArrayList<FileEntry> list = new ArrayList<>();

            sc.nextLine();

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                FileEntry fe = convertLineToFileEntry(line);
                if(fe.scheduleInformation.length() > 0){
                    list.add(fe);
                }
            }
            return list;
        } catch (Exception ex){
            System.out.println(ex);
            return null;
        }
    }

    public static FileEntry convertLineToFileEntry(String line){
        String[] tokens = line.split(";");
        String semester = tokens[5];
        if(semester.equals("")){
            semester = "-1";
        }
        String credits = tokens[6];
        if(credits.equals("")){
            credits = "-1";
        }

        System.out.println(tokens[11]);

        FileEntry fe = new FileEntry(
                tokens[0],
                tokens[1],
                tokens[2],
                tokens[3],
                tokens[4],
                Integer.parseInt(semester),
                Integer.parseInt(credits),
                tokens[7],
                tokens[8],
                tokens[9],
                tokens[11]);
        return fe;
    }


    public static List<FileEntry> readFileAndFilter(String fileName){
        List<FileEntry> list = readFile(fileName);
        List<FileEntry> result = new ArrayList<>();
        Set<FileEntry> set = new HashSet<>();
        for(FileEntry entry : list){
            if(!set.contains(entry)){
                set.add(entry);
                result.add(entry);
            } else {
                System.out.println(entry);
            }
        }

        return result;
    }


}
