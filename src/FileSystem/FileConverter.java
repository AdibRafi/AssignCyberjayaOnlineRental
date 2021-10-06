package FileSystem;

import DataSystem.AdminData;
import DataSystem.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileConverter {
    //pre converter
    private static String[] lineSplitter(String lineToBeSplit) throws FileNotFoundException {
        return lineToBeSplit.split("-");
    }
    private static String addDashIntoString(String[] stringToBeAdded) {
        StringBuilder content = new StringBuilder();
        for (String s : stringToBeAdded) {
            content.append(s);
            content.append("-");
        }
        content.deleteCharAt(content.length()-1);
        return content.toString();
    }
    //cari single line
    public static String[] getSingleLineInfo(String filePath, String accountID) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("src/FileSystem/" + filePath));
        reader.useDelimiter("-|\n");
        String[] result = new String[5];
        while (reader.hasNextLine()) {
            String data = reader.next();
            if (data.equals(accountID)) {
                result[0] = data;
                for (int i = 1; i < 5; i++) {
                    result[i] = reader.next();
                }
            }
        }
        reader.close();
        return result;
    }
    //todo: make read the WHOLE FILE (especially utk location)

    //append file
    public static void appendFile(String filePath,String[] info) throws IOException {
        String content = addDashIntoString(info);
        List<String> fileContent = new ArrayList<>();
        fileContent.add(content);
        Files.write(Paths.get("src/FileSystem/" + filePath), fileContent,
                StandardOpenOption.APPEND);
    }
    private static void updateFile(String filePath, String[] oldInfo, String[] newInfo) throws IOException {
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
        System.out.println(fileContent);
    }
    public static void main(String[] args) throws IOException {
        AdminData data = new AdminData();
//        System.out.println(Arrays.toString(getSingleLineInfo("account.txt","TN2345")));
        data.setMainInfo(getSingleLineInfo("account.txt","TN2345"));


        String[] oldInfo = data.getMainInfo();
        data.setGender("female");
        String[] newInfo = data.getMainInfo();
        updateFile("testWrite.txt",oldInfo,newInfo);
    }
}
