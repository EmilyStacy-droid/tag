package org.improving.tag;
//getName
//getDateOfBirth
//getAddress
//getCity
//getState
//getZip

import javax.naming.Name;
import java.util.Date;

public class Person {
    private String name = "Emily" ;
    private String address = "123 marble street";
    private Date dateOfBirth = new Date();
    private String city = "Dallas";
    private String state = "Texas";
    private int zipCode = 75001;

    public String getName() {
        return name;
    }

    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }

    public int getZipCode(){
        return zipCode;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

}
