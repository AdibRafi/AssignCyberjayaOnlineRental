package Agent;

import DataSystem.Data;
import FileSystem.FileConverter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class sort {
    //sort file
    public static String[][] sortFile(String [][] arr){
        String[][] acc = new String[arr.length][6];

        System.out.println("test");
        for (int j = 0; j < arr.length; j++) {
            if (String.valueOf(Data.checkTypeUser(arr[j][0])).equals("2")) {
                acc[j][0] = "0";
            }
            if (String.valueOf(Data.checkTypeUser(arr[j][0])).equals("0")) {
                acc[j][0] = "1";
            }
            if (String.valueOf(Data.checkTypeUser(arr[j][0])).equals("1")) {
                acc[j][0] = "2";
            }
        }

        for (int j = 0; j < arr.length; j++) {
            for (int k = 1; k < 6; k++) {
                acc[j][k] = arr[j][k - 1];
            }
        }

        //sort accId(admin > user > tenant)
        Arrays.sort(acc, new Comparator<String[]>(){
            @Override
            public int compare(final String[] first, final String[] second){
                String indicator2 = first[0];
                String indicator1 = second[0];
                return indicator2.compareTo(indicator1);

            }
        });

        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < 6; k++) {
                if(k == 5){
                    acc[j][k] = null;
                }
                else {
                    acc[j][k] = acc[j][k + 1];
                }
            }
        }
        return acc;
    }
    public static void main(String[] args) throws IOException {
        Data data = new Data();
        String[][] n = FileConverter.readAllLines("account.txt");
        //test
        n = sortFile(n);
        System.out.println("new sorted array");
        for (int j = 0; j < n.length; j++) {
            for (int k = 0; k < 5; k++) {
                System.out.print(n[j][k] + " ");
            }
            System.out.println();
        }
    }
}
