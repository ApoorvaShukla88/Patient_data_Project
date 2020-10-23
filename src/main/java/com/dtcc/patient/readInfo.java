package com.dtcc.patient;
import java.text.SimpleDateFormat;

public class readInfo {

    static Patient getPatientInfo(String[] arrayPID) {
        Patient patient = new Patient();
        patient.incrementObject();

        if (arrayPID.length > 0) {
            for (int i = 0; i < arrayPID.length; i++) {
                switch (i) {
                    case 1:
                        // Retrieve Set ID
                        if (!arrayPID[i].isEmpty()) {
                            patient.setSetID(Integer.parseInt(arrayPID[i]));
                        }
                        break;
                    case 3:
                        // Retrieve Patient ID
                        String[] arrayPatientID = arrayPID[i].split("\\^");
                        if (arrayPatientID.length > 0)
                            patient.setPatientID((arrayPatientID[0]));
                        break;
                    case 5:
                        // Retrieve Patient Name Information
                        String[] arrayName = arrayPID[i].split("\\^");
                        if (arrayName.length > 0) {
                            for (int j = 0; j < arrayName.length; j++) {
                                switch (j) {
                                    case 0:
                                        patient.setLastName(arrayName[j]);
                                        break;
                                    case 1:
                                        patient.setFirstName(arrayName[j]);
                                        break;
                                    case 2:
                                        patient.setMiddleInitial(arrayName[j]);
                                        break;
                                    case 3:
                                        patient.setSuffix(arrayName[j]);
                                        break;
                                    case 4:
                                        patient.setPrefix(arrayName[j]);
                                        break;
                                }
                            }
                        }
                        break;
                    case 7:
                        // RETRIVE DATE-OF-BIRTH
                        try {
                            if (!arrayPID[i].isEmpty()) {

                                patient.setDob(DateFormat.covertStringToDate(arrayPID[i], "yyyyMMdd"));
                            }
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                        break;
                    case 8:
                        // RETRIVE SEX

                        if (!arrayPID[i].isEmpty()) {
                            patient.setSex(arrayPID[i].charAt(0));
                        }
                        break;
                    case 11:
                        // Retrieve Patient Address Information
                        String[] arrayAddress = arrayPID[11].split("\\^");
                        if (arrayAddress.length > 0) {
                            Address address = new Address();
                            String addressError = "";
                            for (int j = 0; j < arrayAddress.length; j++) {
                                switch (j) {
                                    case 0:
                                        address.setStreet(arrayAddress[j]);
                                        break;
                                    case 2:
                                        address.setCity(arrayAddress[j]);
                                        break;
                                    case 3:
                                        address.setState(arrayAddress[j]);
                                        break;
                                    case 4:
                                        if (!arrayAddress[j].equals("")) {
                                            try {
                                                String zipCode = arrayAddress[j].substring(0, 5);
                                                address.setZipcode(Integer.parseInt(zipCode));
                                            } catch (Exception ex) {
                                                address.setZipcode(0);
                                                addressError = "PID " + patient.getPatientID()
                                                        + " Data Incosistency in address field "
                                                        + (new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"))
                                                        .format(new java.util.Date());
                                            }
                                        }
                                    case 5:
                                        address.setCountry(arrayAddress[j]);
                                        break;
                                }
                            }
                            patient.setAddress(address);
                            if (addressError.startsWith("PID")) {
                                try {
                                    PatientInfoOutput.writeErrorPID(addressError);
                                } catch (Exception ex) {
                                    System.out.println(ex);
                                }
                            }
                        }
                        break;
                    case 13:
                        // Retrieve Phone number
                        if (!arrayPID[i].isEmpty()) {
                            StringBuilder strPhoneNumber = new StringBuilder();

                            if (arrayPID[i].contains("^")) {
                                String[] arrayPhoneNumber = arrayPID[i].split("\\^");
                                if (arrayPhoneNumber.length > 0) {
                                    for (int j = 0; j < arrayPhoneNumber.length; j++) {

                                        switch (j) {
                                            case 5:
                                                strPhoneNumber.append(arrayPhoneNumber[j]);
                                                break;
                                            case 6:
                                                strPhoneNumber.append(arrayPhoneNumber[j]);
                                                break;
                                        }
                                    }
                                }
                            } else if (arrayPID[i].contains("(")) {
                                strPhoneNumber.append(arrayPID[i].substring(1, 4));
                                strPhoneNumber.append(arrayPID[i].substring(5, 8));
                                strPhoneNumber.append(arrayPID[i].substring(9, 13));
                            } else {
                                strPhoneNumber.append(arrayPID[i]);
                            }

                            strPhoneNumber.insert(3, "-");
                            strPhoneNumber.insert(7, "-");
                            patient.setPhoneNumber(strPhoneNumber.toString());
                        }
                        break;
                    case 15:
                        // Retrieve Primary Language
                        String[] arrayLanguage = arrayPID[15].split("\\^");
                        if (arrayLanguage.length > 0) {
                            for (int j = 0; j < arrayLanguage.length; j++) {
                                switch (j) {
                                    case 1:
                                        patient.setPrimaryLanguage(arrayLanguage[j]);
                                        break;
                                }
                            }
                        }
                    case 16:
                        // RETRIEVE MARITAL STATUS
                        if (!arrayPID[i].isEmpty()) {
                            patient.setMaritalStatus(arrayPID[i].charAt(0));
                        }
                        break;
                    case 19:
                        // Retrieve SSN
                        if (!arrayPID[i].isEmpty()) {
                            StringBuilder strSSN = new StringBuilder();
                            strSSN.append(arrayPID[i]);
                            strSSN.insert(3, "-");
                            strSSN.insert(6, "-");
                            patient.setSsn(strSSN.toString());
                        }
                        break;
                    case 26:
                        // Retrieve Citizenship
                        patient.setCitizenship(arrayPID[i]);
                        break;
                    case 29:
                        // RETRIEVE Date of Death
                        try {
                            if (!arrayPID[i].isEmpty()) {
                                patient.setDod(DateFormat.covertStringToDate(arrayPID[i], "yyyymmdd"));
                            }
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                        break;

                    case 30:
                        // RETRIEVE PATIENT-DEATH-ID
                        if (!arrayPID[i].isEmpty()) {
                            if (arrayPID[i] == "NO") {
                                patient.setPatientDeathInd(false);
                            } else {
                                patient.setPatientDeathInd(true);
                            }
                            patient.setPatientDeathInd(Boolean.parseBoolean(arrayPID[i]));
                        }
                        break;
                }
            }
//			System.out.println(patient.getNumOfObjects());
        }
        return patient;
    }
}

















































//        String pid = input.nextLine();
//        while ((pid.startsWith("PID"))) {
//            boolean regex = pid.startsWith("PID");
//            Pattern pattern = Pattern.compile(String.valueOf(regex), Pattern.CASE_INSENSITIVE);
//            System.out.println(pattern);
//        }
//        ArrayList<String> pidfeilds = new ArrayList<String>();
//        while ((input.hasNext())){
//            String line = input.nextLine();
//            if(line.equalsIgnoreCase(String.valueOf(pattern))){
//                String[] pidline = line.split("|");
//                for(String e : pidline){
//                    System.out.println(e);
//                }
//
//            }
                //       }
//        Matcher matcher =   pattern.matcher();
//        while (matcher.find())
//        {
//            System.out.print("Start index: " + matcher.start());
//            System.out.print(" End index: " + matcher.end() + " ");
//            System.out.println(matcher.group());
//        }

    //String nextLine = input.nextLine();
    // if (nextLine.contains(searchKey)) {
    //Got all the PID line and printing it to console
//                System.out.println(nextLine);
    //System.out.println(pidfeilds);

//                String[] pidline = nextLine.split("\\|");
//                pidline[3] = (null == pidline[3]) ? "N/A" : pidline[3].equalsIgnoreCase("") ? "N/A" : pidline[3];
//                pidline[5] = null == pidline[5] ? "N/A" : pidline[5].equalsIgnoreCase("") ? "N/A" : pidline[5];
//                pidline[6] = null == pidline[6] ? "N/A" : pidline[6].equalsIgnoreCase("") ? "N/A" : pidline[6];
//                pidline[8] = null == pidline[8] ? "N/A" : pidline[8].equalsIgnoreCase("") ? "N/A" : pidline[8];
//                pidline[10] = null == pidline[10] ? "N/A" : pidline[10].equalsIgnoreCase("") ? "N/A" : pidline[10];
//                //pidline[11] = null == pidline[11] ? "N/A" : pidline[11].equalsIgnoreCase("") ? "N/A" : pidline[10];
//                //pidline[14] = null == pidline[14] ? "N/A" : pidline[10].equalsIgnoreCase("") ? "N/A" : pidline[10];
//                Date dob = null == pidline[7] ? new Date() : pidline[7].equalsIgnoreCase("") ? new Date() :
//                        new SimpleDateFormat("yyyymmdd").parse(pidline[7]);
//
//                pidfeilds.add(new Patient(pidline[5], pidline[6], dob, pidline[3], pidline[8].charAt(0), pidline[10]));
//                        //pidline[11], pidline[14]));
//                //System.out.println(pidfeilds);Long.parseLong(source[index]new Long(String value)







