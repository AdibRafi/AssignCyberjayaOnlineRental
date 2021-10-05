package DataSystem;

public abstract class Data {
    private String accountID;
    private String name;
    private String password;
    private String phoneNumber;
    private String gender;

    public void setAllInfo(String[] info){
        this.accountID = info[0];
        this.name = info[1];
        this.password = info[2];
        this.phoneNumber = info[3];
        this.gender = info[4];
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
