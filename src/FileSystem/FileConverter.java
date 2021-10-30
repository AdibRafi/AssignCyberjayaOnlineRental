package FileSystem;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Represent file related program
 * @author Adib
 */
public class FileConverter {
    //pre converter

    /**
     * Getting a value of formatted String and split into String[]
     * @param lineToBeSplit Formatted String to be split
     * @return Split string
     * @author Adib
     */
    public static String[] lineSplitter(String lineToBeSplit){
        return lineToBeSplit.split("-");
    }

    /**
     * Adding '-' into a String[]
     * @param stringToBeAdded String[] to be added a '-'
     * @return String already been added '-'
     * @author Adib
     */
    public static String addDashIntoString(String[] stringToBeAdded) {
        StringBuilder content = new StringBuilder();
        for (String s : stringToBeAdded) {
            content.append(s);
            content.append("-");
        }
        content.deleteCharAt(content.length()-1);
        return content.toString();
    }

    /**
     * Retrieved info from file
     * @param filePath Desired filePath in FileSystem package
     * @param accountID Desired accountID to be retrieved from file
     * @return Info from file
     * @throws IOException occurred when I/O operations is interrupted or failed
     * @author Adib
     */
    public static String[] getSingleLineInfo(String filePath, String accountID) throws IOException {
        String[][] info = readAllLines(filePath);
        int x = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i][0].equals(accountID))
                x = i;
        }
        return info[x];
    }

    /**
     * Retrieved info from file
     * @param filepath Desired filePath in FileSystem package
     * @param accountID Desired accountID to be retrieved from file
     * @param propertyID Desired propertyID to be retrieved from file
     * @return Info from file
     * @throws IOException Occurred when I/O operations is interrupted or failed
     * @author Adib
     */
    public static String[] getSingleLineInfo(String filepath, String accountID, String propertyID) throws IOException {
        String[][] info = readAllLines(filepath);
        int x = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i][0].equals(accountID) && info[i][1].equals(propertyID))
                x = i;
        }
        return info[x];
    }

    /**
     * Read all lines and Retrieved Info from file
     * @param filePath Desired filePath in FileSystem package
     * @return All info from file
     * @throws IOException Occurred when I/O operations is interrupted or failed
     * @author Adib
     */
    public static String[][] readAllLines(String filePath) throws IOException {
        List<String> file = new ArrayList<>(
                Files.readAllLines(Path.of("src/FileSystem/" + filePath), StandardCharsets.UTF_8)
        );
        String[] row = new String[file.size()];
        for (int i = 0; i < file.size(); i++) {
            row[i]= file.get(i);
        }
        String[][] lineSplit = new String[row.length][lineSplitter(row[0]).length];
        for (int i = 0; i < row.length; i++) {
            String[] k = lineSplitter(row[i]);
            for (int j = 0; j < k.length; j++) {
                lineSplit[i][j] = k[j];
            }
        }
        return lineSplit;
    }

    /**
     * Append info into a file
     * @param filePath Desired filePath in FileSystem package
     * @param info Info to be put into a file
     * @throws IOException Occurred when I/O operations is interrupted or failed
     * @author Adib
     */
    public static void appendFile(String filePath,String[] info) throws IOException {
        String content = addDashIntoString(info);
        List<String> fileContent = new ArrayList<>();
        fileContent.add(content);
        Files.write(Paths.get("src/FileSystem/" + filePath), fileContent,
                StandardOpenOption.APPEND);
    }

    /**
     * Removing specific line in file
     * @param filePath Desired filePath in FileSystem package
     * @param ID Desired ID in file to be removed
     * @throws IOException Occurred when I/O operations is interrupted or failed
     * @author Adib
     */
    public static void removeSingleLine(String filePath, String ID) throws IOException {
        List<String> file = new ArrayList<>(
                Files.readAllLines(Path.of("src/FileSystem/" + filePath), StandardCharsets.UTF_8)
        );
        List<String> row = new ArrayList<>();
        ID = addDashIntoString(getSingleLineInfo(filePath, ID));
        int q = 0;
        for (int i = 0; i < file.size(); i++) {
            if (file.get(i).equals(ID))
                continue;
            row.add(q,file.get(i));
            ++q;
        }
        Files.write(Paths.get("src/FileSystem/"+filePath),row);
    }

    /**
     * Removing specific line in file
     * @param filePath Desired filePath in FileSystem package
     * @param accountID Desired account ID in file to be removed
     * @param propertyID Desired propertyID in file to be removed
     * @throws IOException Occurred when I/O operations is interrupted or failed
     * @author Adib
     */
    public static void removeSingleLine(String filePath, String accountID, String propertyID) throws IOException {
        String[][] allInfo = readAllLines("location.txt");
        List<String> file = new ArrayList<>(
                Files.readAllLines(Path.of("src/FileSystem/" + filePath), StandardCharsets.UTF_8)
        );
        List<String> row = new ArrayList<>();
        for (String[] strings : allInfo) {
            if (strings[0].equals(accountID) && strings[1].equals(propertyID)){
                accountID = addDashIntoString(getSingleLineInfo(filePath, accountID));
                break;
            }
        }
        int q = 0;
        for (int i = 0; i < file.size(); i++) {
            if (file.get(i).equals(accountID)){
                continue;
            }
            row.add(q,file.get(i));
            ++q;
        }
        Files.write(Paths.get("src/FileSystem/"+filePath),row);
    }

    /**
     * Change a specific line into a new line in file
     * @param filePath Desired filePath in FileSystem package
     * @param oldInfo Info to be searched in file
     * @param newInfo Info to be replaced
     * @throws IOException Occurred when I/O operations is interrupted or failed
     * @author Adib
     */
    public static void updateFile(String filePath, String[] oldInfo, String[] newInfo) throws IOException {
        String old = addDashIntoString(oldInfo);
        String newOne = addDashIntoString(newInfo);
        List<String> fileContent = new ArrayList<>(
                Files.readAllLines(Path.of("src/FileSystem/" + filePath), StandardCharsets.UTF_8));
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).equals(old)) {
                fileContent.set(i, newOne);
                break;
            }
        }
        Files.write(Path.of("src/FileSystem/" + filePath), fileContent, StandardCharsets.UTF_8);
    }

//    public static void main(String[] args) throws IOException {
//        Data data = new Data();
//        System.out.println(Arrays.toString(getSingleLineInfo("location.txt", "AG2345","CD0030")));
//    }
}
