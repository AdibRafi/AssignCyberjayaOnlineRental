package FileSystem;

import DataSystem.AdminData;
import DataSystem.AgentData;
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
    private static String[] lineSplitter(String lineToBeSplit){
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
                break;
            }
        }
        reader.close();
        return result;
    }
    //todo: make read the WHOLE FILE (especially utk location)
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

    //append file
    public static void appendFile(String filePath,String[] info) throws IOException {
        String content = addDashIntoString(info);
        List<String> fileContent = new ArrayList<>();
        fileContent.add(content);
        Files.write(Paths.get("src/FileSystem/" + filePath), fileContent,
                StandardOpenOption.APPEND);
    }
    // update file
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
        Data data = new Data();
//        System.out.println(Arrays.toString(getSingleLineInfo("account.txt","TN2345")));
        data.setMainInfo(getSingleLineInfo("account.txt","AD1234"));
        System.out.println(data.getPassword());


//        String[] oldInfo = data.getMainInfo();
//        data.setGender("female");
//        String[] newInfo = data.getMainInfo();
//        updateFile("testWrite.txt",oldInfo,newInfo);
//        String[][] n = readAllLines("account.txt");
//        AdminData[] data1 = new AdminData[n.length];
//        for (int i = 0; i < 3; i++) {
//            data1[i] = new AdminData();
//            data1[i].setMainInfo(getSingleLineInfo("account.txt",n[i][0]));
//        }
//        System.out.println(Arrays.toString(data1[0].getMainInfo()));
//        System.out.println(Arrays.toString(data1[1].getMainInfo()));
//        System.out.println(Arrays.toString(data1[2].getMainInfo()));
//
//        data1[0].setPhoneNumber("test");
//        System.out.println(data1[0].getPhoneNumber());
//        System.out.println(data1[0].getAccountID());

//        String[][] arr = new String[6][5];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i][0] = n[i];
//        }
//        System.out.println(arr[4][0]);
//        System.out.println(Arrays.toString(lineSplitter(arr[4][0])));
//        String[] p = lineSplitter(arr[4][0]);
//        for (int i = 0; i < arr[4].length; i++) {
//            arr[4][i] = p[i];
//        }
//        System.out.println(arr[4][1]);

    }
}
