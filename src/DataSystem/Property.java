package DataSystem;

import FileSystem.FileConverter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Property {
    private String locationID;
    private String houseType;
    private int price;
    private int rentalRate;
    private boolean activeProperty;

    // alamat
    private int houseNum;
    private String streetName;
    private String cityName;
    private int postcode;
    private String state;

    // facilities
    private int numOfBath;
    private int numOfBed;
    private int numOfParking;
    private boolean haveWifi;
    private boolean haveSwimmingPool;
    private boolean haveAirCond;

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

    public static String[][] checkFacilities(String[][] data, boolean haveWifi,
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

    public static void changeValue(String[] data, String propertyID) {
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
    }

    public static void main(String[] args) throws IOException {
        String[][] data = FileConverter.readAllLines("location.txt");
        System.out.println(Arrays.deepToString(checkFacilities(data,false,true,true)));
    }
}
