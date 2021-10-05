package FileSystem;

import DataSystem.AdminData;
import DataSystem.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FileConverter {
    public static int checkTypeUser(String accountID) {
        int result = 0;
        String letter = accountID.substring(0, 2);
        String num = accountID.substring(2);
        if (letter.matches("[A-Z]+") && num.matches("[0-9]+")) {
            if (letter.contains("AD")) {
                result = 2;
            } else if (letter.contains("TN")) {
                result = 1;
            }
        }
        return result;
    }
    public static String[] accountMainInfo(String accountID) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("src/FileSystem/account.txt"));
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
    public static void main(String[] args) throws FileNotFoundException {
        AdminData data = new AdminData();
        data.setAllInfo(accountMainInfo("AD1234"));
        System.out.println(data.getName());
        System.out.println(data.getPassword());
        System.out.println(data.getPhoneNumber());
        System.out.println(data.getGender());
        System.out.println(checkTypeUser("ADIB"));
    }
}
