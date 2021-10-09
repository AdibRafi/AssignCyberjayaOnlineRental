package DataSystem;

public abstract class Data {
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
