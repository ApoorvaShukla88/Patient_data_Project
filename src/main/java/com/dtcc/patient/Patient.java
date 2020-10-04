package com.dtcc.patient;

import java.util.Date;

public class Patient {
    private String firstName;
    private String lastName;
    private Date dob;
    private String patientID;
    //private String Address;
    //private boolean hisOrLat;
    private char gender;
    //private long phoneNumber;
    //private long acctNumber;

    Patient(){}
    Patient(String firstName, String lastName, Date dob, String patientID, char gen){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.patientID = patientID;
        this.gender = gen;
    }

}
