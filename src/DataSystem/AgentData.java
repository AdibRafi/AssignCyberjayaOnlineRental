package DataSystem;

//todo: cari ways to get multiple data values with 1 accountID
public class AgentData extends Data{
    AgentData(){};
    private String locationID;

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getLocationID() {
        return locationID;
    }

}
