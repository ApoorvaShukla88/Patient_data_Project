package com.dtcc.patient;

import java.util.*;

public class Patient {
    // Patient class : to store Patient Information for each PID line
    private int setID;
    private String patientID, firstName, lastName, middleInitial, prefix, suffix, race, primaryLanguage, ssn,
            citizenship, phoneNumber;
    private char sex, maritalStatus;
    private boolean patientDeathInd;
    private Date dob, dod;
    private Address address;
    private static int numberOfObjects;

    public Patient() {
    }

    public int getSetID() {
        return setID;
    }

    public void setSetID(int setID) {
        this.setID = setID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    public void setPrimaryLanguage(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public char getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(char maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public boolean getPatientDeathInd() {
        return patientDeathInd;
    }

    public void setPatientDeathInd(boolean patientDeathInd) {
        this.patientDeathInd = patientDeathInd;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDod() {
        return dod;
    }

    public void setDod(Date dod) {
        this.dod = dod;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void incrementObject() {
        numberOfObjects++;
    }

    public int getNumOfObjects() {
        return numberOfObjects;
    }


    @lombok.SneakyThrows
    @Override
    public String toString() {
        return "Patient [setID=" + setID + ", patientID=" + patientID + ", firstName=" + firstName + ", lastName="
                + lastName + ", middleInitial=" + middleInitial + ", prefix=" + prefix + ", suffix=" + suffix
                + ", race=" + race + ", primaryLanguage=" + primaryLanguage + ", ssn=" + ssn + ", phoneNumber="
                + phoneNumber + ", sex=" + sex + ", dob=" + DateFormat.convertDateToString(dob, "MM/dd/yyyy")
                + ", patientDeathInd=" + patientDeathInd + ", dod=" + dod + ", address=" + address.getStreet() + " "
                + address.getCity() + " " + address.getState() + " " + address.getZipcode() + " " + address.getCountry()
                + "]";
    }

}