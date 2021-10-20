package DataSystem;

import FileSystem.FileConverter;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Property extends Data {
    private String propertyID;
    private String houseType;
    private String price;
    private String rentalRate;
    private String activeProperty;
    private String furnishedStatus;
    private String squareFeet;

    // alamat
    private String streetName;
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

    private static String getValueOfRentalRate(String price, String sqFt) {
        float num = Float.parseFloat(price)/Float.parseFloat(sqFt);
        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(2);
        return f.format(num);
    }

    public void setPropertyInfo(String[] dataFromFile) {
        setAccountID(dataFromFile[0]);
        setPropertyID(dataFromFile[1]);
        setPrice(dataFromFile[2]);
        setActiveProperty(dataFromFile[3]);
        setFurnishedStatus(dataFromFile[4]);
        setSquareFeet(dataFromFile[5]);
        setRentalRate(getValueOfRentalRate(dataFromFile[2],dataFromFile[5]));
        setNumOfBed(dataFromFile[6]);
        setNumOfBath(dataFromFile[7]);
        setNumOfParking(dataFromFile[8]);
        setHaveWifi(dataFromFile[9]);
        setHaveSwimmingPool(dataFromFile[10]);
        setHaveAirCond(dataFromFile[11]);
        setStreetName(dataFromFile[12]);
        setCityName(dataFromFile[13]);
        setPostcode(dataFromFile[14]);
        setState(dataFromFile[15]);
    }
    public String[] getPropertyInfoToDisplay(){
        String[] result = new String[17];
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
        result[13] = getStreetName();
        result[14] = getCityName();
        result[15] = getPostcode();
        result[16] = getState();
        return result;
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
    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
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
        String[] info = FileConverter.getSingleLineInfo("location.txt","AG2345");
        System.out.println(Arrays.toString(info));
        Property n = new Property();
        n.setPropertyInfo(info);
        System.out.println(n.getCityName());
        System.out.println(Arrays.toString(n.getPropertyInfoToDisplay()));
    }
}
