package com.dtcc.patient;

import java.util.Date;

public class Patient {
    private String firstName;
    private String lastName;
    private Date dob;
    private String patientID;
    private String Address;
    //private boolean hisOrLat;
    private char gender;
    private long phoneNumber;
    private long acctNumber;

    Patient(){}
    Patient(String firstName, String lastName, Date dob, String patientID, char gen, String Address, long phoneNumber,
            long acctNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.patientID = patientID;
        this.gender = gen;
        this.Address = Address;
        this.phoneNumber = phoneNumber;
        this.acctNumber = acctNumber;
    }

    public String toString(){
        return " PATIENTID :"+ this.patientID + " FIRSTNAME: "+ this.firstName + " " + " LASTNAME :" + this.lastName +
                " DOB :" + this.dob + " GENDER :" + this.gender + "" + " ADDRESS :" + this.Address;
    }

}
