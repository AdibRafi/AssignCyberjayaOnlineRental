package DataSystem;

import FileSystem.FileConverter;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Represent Property data of the program
 * @author Adib
 */
public class Property extends Data {
    private String propertyID;
    private String houseType;
    private String price;
    private String rentalRate;
    private String activeProperty;
    private String furnishedStatus;
    private String squareFeet;

    private String address1;
    private String address2;
    private String cityName;
    private String postcode;
    private String state;

    private String numOfBath;
    private String numOfBed;
    private String numOfParking;
    private String haveWifi;
    private String haveSwimmingPool;
    private String haveAirCond;

    /**
     * Property constructor
     * @author Adib
     */
    public Property(){}

    /**
     * Calculate the value of rental rate
     * @param price price of property
     * @param sqFt square feet of property
     * @return rental rate
     * @author Adib
     */
    public String getValueOfRentalRate(String price, String sqFt) {
        float num = Float.parseFloat(price)/Float.parseFloat(sqFt);
        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(2);
        return f.format(num);
    }

    /**
     * Checking the property type
     * @param propertyID propertyID to be checked
     * @return property type
     * @author Adib
     */
    private static String checkPropertyType(String propertyID) {
        String letter = propertyID.substring(0, 2);
        String num = propertyID.substring(2);
        String result = "Apartment";
        if (letter.matches("[A-Z]+") && num.matches("[0-9]+")) {
            if (letter.contains("CD"))
                result = "Condominium";
            else if (letter.contains("HO"))
                result = "Landed House";
            else if (letter.contains("RM"))
                result = "Room";
        }
        return result;
    }

    /**
     * Setting property info into class variables
     * @param dataFromFile Desired info to be set
     * @throws IOException Occurred when I/O operation is interrupted or failed
     * @author Adib
     */
    public void setPropertyInfo(String[] dataFromFile) throws IOException {
        setMainInfo(FileConverter.getSingleLineInfo("account.txt",dataFromFile[0]));
        setAccountID(dataFromFile[0]);
        setPropertyID(dataFromFile[1]);
        setPrice(dataFromFile[2]);
        setActiveProperty(dataFromFile[3]);
        setFurnishedStatus(dataFromFile[4]);
        setSquareFeet(dataFromFile[5]);
        setRentalRate(dataFromFile[6]);
        setNumOfBed(dataFromFile[7]);
        setNumOfBath(dataFromFile[8]);
        setNumOfParking(dataFromFile[9]);
        setHaveWifi(dataFromFile[10]);
        setHaveSwimmingPool(dataFromFile[11]);
        setHaveAirCond(dataFromFile[12]);
        setAddress1(dataFromFile[13]);
        setAddress2(dataFromFile[14]);
        setCityName(dataFromFile[15]);
        setPostcode(dataFromFile[16]);
        setState(dataFromFile[17]);
        setHouseType(checkPropertyType(dataFromFile[1]));
    }

    /**
     * Getting property info
     * @return property info
     * @author Adib
     */
    public String[] getPropertyInfo(){
        String[] result = new String[18];
        result[0] = getAccountID();
        result[1] = getPropertyID();
        result[2] = getPrice();
        result[3] = getActiveProperty();
        result[4] = getFurnishedStatus();
        result[5] = getSquareFeet();
        result[6] = getRentalRate();
        result[7] = getNumOfBed();
        result[8] = getNumOfBath();
        result[9] = getNumOfParking();
        result[10] = getHaveWifi();
        result[11] = getHaveSwimmingPool();
        result[12] = getHaveAirCond();
        result[13] = getAddress1();
        result[14] = getAddress2();
        result[15] = getCityName();
        result[16] = getPostcode();
        result[17] = getState();
        return result;
    }

    /**
     * Getting property info to be display in MainDisplay
     * @return property info
     * @author Adib
     */
    public String[] getPropertyInfoForDisplay(){
        return new String[]{
                getName(), getHouseType(), getPrice(), getActiveProperty(),
                getFurnishedStatus(), getSquareFeet(), getNumOfBed(),
                getNumOfBath(), getNumOfParking(),
                getAddress1() + "," + getAddress2(), getCityName(),
                getPostcode(), getState(), getAccountID(), getPropertyID()
        };
    }


    /**
     * Getting address2 from class variable
     * @return address2
     * @author Adib
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Set address2 from class variable
     * @param address2 Assign value of address 2
     * @author Adib
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * Getting activeProperty from class variable
     * @return activeProperty
     * @author Adib
     */
    public String getActiveProperty() {
        return activeProperty;
    }

    /**
     * Set activeProperty from class variable
     * @param activeProperty Assign value of activeProperty
     * @author Adib
     */
    public void setActiveProperty(String activeProperty) {
        this.activeProperty = activeProperty;
    }

    /**
     * Getting cityName from class variable
     * @return cityName
     * @author Adib
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Set cityName from class variable
     * @param cityName Assign value of cityName
     * @author Adib
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Getting haveAirCond from class variable
     * @return haveAirCond
     * @author Adib
     */
    public String getHaveAirCond() {
        return haveAirCond;
    }

    /**
     * Set haveAirCond from class variable
     * @param haveAirCond Assign value of haveAirCond
     * @author Adib
     */
    public void setHaveAirCond(String haveAirCond) {
        this.haveAirCond = haveAirCond;
    }

    /**
     * Getting address1 from class variable
     * @return address1
     * @author Adib
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Set address1 from class variable
     * @param address1 Assign value of address1
     * @author Adib
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * Getting state from class variable
     * @return state
     * @author Adib
     */
    public String getState() {
        return state;
    }

    /**
     * Set state from class variable
     * @param state Assign value of state
     * @author Adib
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Getting propertyID from class variable
     * @return propertyID
     * @author Adib
     */
    public String getPropertyID() {
        return propertyID;
    }

    /**
     * Set propertyID from class variable
     * @param propertyID Assign value of propertyID
     * @author Adib
     */
    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    /**
     * Getting rentalRate from class variable
     * @return rentalRate
     * @author Adib
     */
    public String getRentalRate() {
        return rentalRate;
    }

    /**
     * Set rentalRate from class variable
     * @param rentalRate Assign value of rentalRate
     * @author Adib
     */
    public void setRentalRate(String rentalRate) {
        this.rentalRate = rentalRate;
    }

    /**
     * Getting price from class variable
     * @return price
     * @author Adib
     */
    public String getPrice() {
        return price;
    }

    /**
     * Set price from class variable
     * @param price Assign value of price
     * @author Adib
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Getting postcode from class variable
     * @return postcode
     * @author Adib
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Set postcode from class variable
     * @param postcode Assign value of postcode
     * @author Adib
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * Getting numOfParking from class variable
     * @return numOfParking
     * @author Adib
     */
    public String getNumOfParking() {
        return numOfParking;
    }

    /**
     * Set numOfParking from class variable
     * @param numOfParking Assign value of numOfParking
     * @author Adib
     */
    public void setNumOfParking(String numOfParking) {
        this.numOfParking = numOfParking;
    }

    /**
     * Getting numOfBed from class variable
     * @return numOfBed
     * @author Adib
     */
    public String getNumOfBed() {
        return numOfBed;
    }

    /**
     * Set numOfBed from class variable
     * @param numOfBed Assign value of numOfBed
     * @author Adib
     */
    public void setNumOfBed(String numOfBed) {
        this.numOfBed = numOfBed;
    }

    /**
     * Getting numOfBath from class variable
     * @return numOfBath
     * @author Adib
     */
    public String getNumOfBath() {
        return numOfBath;
    }

    /**
     * Set numOfBath from class variable
     * @param numOfBath Assign value of numOfBath
     * @author Adib
     */
    public void setNumOfBath(String numOfBath) {
        this.numOfBath = numOfBath;
    }

    /**
     * Getting houseType from class variable
     * @return houseType
     * @author Adib
     */
    public String getHouseType() {
        return houseType;
    }

    /**
     * Set houseType from class variable
     * @param houseType Assign value of houseType
     * @author Adib
     */
    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    /**
     * Getting haveWifi from class variable
     * @return haveWifi
     * @author Adib
     */
    public String getHaveWifi() {
        return haveWifi;
    }

    /**
     * Set haveWifi from class variable
     * @param haveWifi Assign value of haveWifi
     * @author Adib
     */
    public void setHaveWifi(String haveWifi) {
        this.haveWifi = haveWifi;
    }

    /**
     * Getting haveSwimmingPool from class variable
     * @return haveSwimmingPool
     * @author Adib
     */
    public String getHaveSwimmingPool() {
        return haveSwimmingPool;
    }

    /**
     * Set haveSwimmingPool from class variable
     * @param haveSwimmingPool Assign value of haveSwimmingPool
     * @author Adib
     */
    public void setHaveSwimmingPool(String haveSwimmingPool) {
        this.haveSwimmingPool = haveSwimmingPool;
    }

    /**
     * Getting squareFeet from class variable
     * @return squareFeet
     * @author Adib
     */
    public String getSquareFeet() {
        return squareFeet;
    }

    /**
     * Set squareFeet from class variable
     * @param squareFeet Assign value of squareFeet
     * @author Adib
     */
    public void setSquareFeet(String squareFeet) {
        this.squareFeet = squareFeet;
    }

    /**
     * Getting furnishedStatus from class variable
     * @return furnishedStatus
     * @author Adib
     */
    public String getFurnishedStatus() {
        return furnishedStatus;
    }

    /**
     * Set furnishedStatus from class variable
     * @param furnishedStatus Assign value of furnishedStatus
     * @author Adib
     */
    public void setFurnishedStatus(String furnishedStatus) {
        this.furnishedStatus = furnishedStatus;
    }





//    public static void main(String[] args) throws IOException {
//        String[][] data = FileConverter.readAllLines("location.txt");
//        String[] info = FileConverter.getSingleLineInfo("location.txt","AG5372");
//        System.out.println(Arrays.toString(info));
//        Property n = new Property();
//        n.setPropertyInfo(info);
//        System.out.println(n.getCityName());
//        System.out.println(Arrays.toString(n.getPropertyInfo()));
//    }
}
