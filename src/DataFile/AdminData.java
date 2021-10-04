package DataFile;

public class AdminData extends Data{
    public AdminData(){};
    public AdminData(String name,int userRequestNotification){
        setName(name);
        setUserRequestNotification(userRequestNotification);
    }

    public AdminData(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    private String adminPassword;
    private int userRequestNotification;

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public int getUserRequestNotification() {
        return userRequestNotification;
    }

    public void setUserRequestNotification(int userRequestNotification) {
        this.userRequestNotification = userRequestNotification;
    }
}
