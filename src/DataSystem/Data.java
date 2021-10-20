package DataSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Data {

    private String accountID;
    private String name;
    private String password;
    private String phoneNumber;
    private String gender;


    public static int checkTypeUser(String accountID) {
        int result = 0;
        String letter = accountID.substring(0, 2);
        String num = accountID.substring(2);
        if (letter.matches("[A-Z]+") && num.matches("[0-9]+")) {
            if (letter.contains("AD")) {
                result = 2;
            } else if (letter.contains("AG")) {
                result = 1;
            }
        }
        return result;
    }
    public static int checkPropertyType(String propertyID) {
        // AP - 0, CD - 1, HO - 2, RM - 3
        int result = 0;
        String letter = propertyID.substring(0, 2);
        String num = propertyID.substring(2);
        if (letter.matches("[A-Z]+") && num.matches("[0-9]+")) {
            if (letter.contains("CD")) {
                result = 1;
            } else if (letter.contains("HO")) {
                result = 2;
            } else if (letter.contains("RM")) {
                result = 3;
            }
        }
        return result;
    }

    public void setMainInfo(String[] mainInfo) {
        setAccountID(mainInfo[0]);
        setName(mainInfo[1]);
        setPassword(mainInfo[2]);
        setPhoneNumber(mainInfo[3]);
        setGender(mainInfo[4]);
    }

    public String[] getMainInfo() {
        String[] result = new String[5];
        result[0] = this.getAccountID();
        result[1] = this.getName();
        result[2] = this.getPassword();
        result[3] = this.getPhoneNumber();
        result[4] = this.getGender();
        return result;
    }

    public static String[][] sortData(String [][] arr){
        String[][] acc = new String[arr.length][arr[0].length+2];

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
            for (int k = 1; k < arr[0].length+1; k++) {
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
            for (int k = 0; k < arr[j].length+1; k++) {
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
    public static String[] changeValue(String[] data, String propertyID) {
        // AP - 0, CD - 1, HO - 2, RM - 3
        int num = checkPropertyType(propertyID);
        if (num == 0)
            data[1] = "Apartment";
        else if (num == 1)
            data[1] = "Condominium";
        else if (num == 2)
            data[1] = "Landed House";
        else
            data[1] = "Room";
        return data;
    }

    public static String[][] removeColumnFromData(String[][] data,int columnNum) {
        int rows = data.length;
        int column = data[0].length;
        String[][] result = new String[rows][column-1];
        int p=0;
        for (int i = 0; i < rows; i++) {
            int q = 0;
            for (int j = 0; j < column; j++) {
                if (j == columnNum)
                    continue;
                result[p][q] = data[i][j];
                ++q;
            }
            ++p;
        }
        return result;
    }
    public static String[][] removeColumnFromData(String[][] data, boolean haveWifi,
                                             boolean haveSwimmingPool, boolean haveAirCond) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        int q = 0;
        for (int i = 0; i < data.length; i++) {
            Boolean wifi = Boolean.valueOf(data[i][9]);
            Boolean swimPool = Boolean.valueOf(data[i][10]);
            Boolean airCond = Boolean.valueOf(data[i][11]);
            if (wifi.equals(haveWifi) && swimPool.equals(haveSwimmingPool)
                    && airCond.equals(haveAirCond)) {
                list.add(new ArrayList<>());
                for (int j = 0; j < data[i].length; j++) {
                    list.get(q).add(data[i][j]);
                }
                q++;
            }
        }
        String[][] result = new String[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                result[i][j] = list.get(i).get(j);
            }
        }
        return result;

    }









    public String getAccountID() {
        return accountID;
    }
    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
