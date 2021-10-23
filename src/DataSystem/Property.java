package DataSystem;

import FileSystem.FileConverter;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Property extends Data {
    private String propertyID;
    private String houseType;
    private String price;
    private String rentalRate;
    private String activeProperty;
    private String furnishedStatus;
    private String squareFeet;

    // alamat
    private String address1;
    private String address2;
    private String cityName;
    private String postcode;
    private String state;

    // facilities
    private String numOfBath;
    private String numOfBed;
    private String numOfParking;
    private String haveWifi;
    private String haveSwimmingPool;
    private String haveAirCond;

    public Property(){}

    public String getValueOfRentalRate(String price, String sqFt) {
        float num = Float.parseFloat(price)/Float.parseFloat(sqFt);
        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(2);
        return f.format(num);
    }

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

    public String[] getPropertyInfoForDisplay(){
        return new String[]{
                getName(), getHouseType(), getPrice(), getActiveProperty(),
                getFurnishedStatus(), getSquareFeet(), getNumOfBed(),
                getNumOfBath(), getNumOfParking(),
                getAddress1() + "," + getAddress2(), getCityName(),
                getPostcode(), getState(), getAccountID(), getPropertyID()
        };
    }


    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getActiveProperty() {
        return activeProperty;
    }
    public void setActiveProperty(String activeProperty) {
        this.activeProperty = activeProperty;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getHaveAirCond() {
        return haveAirCond;
    }
    public void setHaveAirCond(String haveAirCond) {
        this.haveAirCond = haveAirCond;
    }
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getPropertyID() {
        return propertyID;
    }
    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }
    public String getRentalRate() {
        return rentalRate;
    }
    public void setRentalRate(String rentalRate) {
        this.rentalRate = rentalRate;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public String getNumOfParking() {
        return numOfParking;
    }
    public void setNumOfParking(String numOfParking) {
        this.numOfParking = numOfParking;
    }
    public String getNumOfBed() {
        return numOfBed;
    }
    public void setNumOfBed(String numOfBed) {
        this.numOfBed = numOfBed;
    }
    public String getNumOfBath() {
        return numOfBath;
    }
    public void setNumOfBath(String numOfBath) {
        this.numOfBath = numOfBath;
    }
    public String getHouseType() {
        return houseType;
    }
    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }
    public String getHaveWifi() {
        return haveWifi;
    }
    public void setHaveWifi(String haveWifi) {
        this.haveWifi = haveWifi;
    }
    public String getHaveSwimmingPool() {
        return haveSwimmingPool;
    }
    public void setHaveSwimmingPool(String haveSwimmingPool) {
        this.haveSwimmingPool = haveSwimmingPool;
    }
    public String getSquareFeet() {
        return squareFeet;
    }
    public void setSquareFeet(String squareFeet) {
        this.squareFeet = squareFeet;
    }
    public String getFurnishedStatus() {
        return furnishedStatus;
    }
    public void setFurnishedStatus(String furnishedStatus) {
        this.furnishedStatus = furnishedStatus;
    }





    public static void main(String[] args) throws IOException {
        String[][] data = FileConverter.readAllLines("location.txt");
        String[] info = FileConverter.getSingleLineInfo("location.txt","AG5372");
        System.out.println(Arrays.toString(info));
        Property n = new Property();
        n.setPropertyInfo(info);
        System.out.println(n.getCityName());
        System.out.println(Arrays.toString(n.getPropertyInfo()));
    }
}
