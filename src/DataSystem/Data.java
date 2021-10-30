package DataSystem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Represent User Data of the program
 * @author Adib
 */
public class Data {

    private String accountID;
    private String name;
    private String password;
    private String phoneNumber;
    private String gender;

    /**
     * Determine what type of user
     * @param accountID accountID to be checked
     * @return type of users, 0 = Tenant, 1 = Agent, 2 = Admin
     * @author Adib
     */
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

    /**
     * Setting info into class variables
     * @param mainInfoFromFile Desired info to be set
     * @author Adib
     */
    public void setMainInfo(String[] mainInfoFromFile) {
        setAccountID(mainInfoFromFile[0]);
        setName(mainInfoFromFile[1]);
        setPassword(mainInfoFromFile[2]);
        setPhoneNumber(mainInfoFromFile[3]);
        setGender(mainInfoFromFile[4]);
    }

    /**
     * Getting main info of user
     * @return main info of user
     * @author Adib
     */
    public String[] getMainInfo() {
        String[] result = new String[5];
        result[0] = this.getAccountID();
        result[1] = this.getName();
        result[2] = this.getPassword();
        result[3] = this.getPhoneNumber();
        result[4] = this.getGender();
        return result;
    }

    /**
     * Removing column from 2d array
     * @param data Desired data that wanted to be removed
     * @param columnNum Index number of data's column
     * @return Data that already removed
     * @author Adib
     */
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

    /**
     * Getting accountID from class variable
     * @return accountID
     * @author Adib
     */
    public String getAccountID() {
        return accountID;
    }

    /**
     * Set accountID from class variable
     * @param accountID Assign value of accountID
     * @author Adib
     */
    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    /**
     * Getting name from class variable
     * @return name
     * @author Adib
     */
    public String getName() {
        return name;
    }

    /**
     * Set name from class variable
     * @param name Assign value of name
     * @author Adib
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getting password from class variable
     * @return password
     * @author Adib
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password from class variable
     * @param password Assign value for password
     * @author Adib
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getting gender from class variable
     * @return gender
     * @author Adib
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set gender from class variable
     * @param gender Assign value for gender
     * @author Adib
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Getting phoneNumber from class variable
     * @return phoneNumber
     * @author Adib
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set phoneNumber from class variable
     * @param phoneNumber Assign value of phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
