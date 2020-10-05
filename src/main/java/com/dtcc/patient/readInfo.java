package com.dtcc.patient;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class readInfo {
   

    public static void main(String[] args) throws FileNotFoundException, ParseException {

      Patient patient = new Patient();
        String result = "";
        File file = new File("messages.txt");
        //Read the file
        Scanner input = new Scanner(file);
        // if line starts with PID
        final String searchKey = "PID|";
        ArrayList<Patient> pidfeilds = new ArrayList<Patient>();
        while (input.hasNextLine())
        {
            String nextLine = input.nextLine();
            if (nextLine.contains(searchKey)) {
                //Got all the PID line and printing it to console
//                System.out.println(nextLine);
                //pidfeilds.addAll(Collections.singleton(nextLine));
                //System.out.println(pidfeilds);
                String[] pidline = nextLine.split("\\|");
                pidline[3] = null == pidline[1] ? "N/A" : pidline[1].equalsIgnoreCase("") ? "N/A" : pidline[3];
                pidline[5] = null == pidline[5] ? "N/A" : pidline[5].equalsIgnoreCase("") ? "N/A" : pidline[5];
                pidline[6] = null == pidline[6] ? "N/A" : pidline[6].equalsIgnoreCase("") ? "N/A" : pidline[6];
                pidline[8] = null == pidline[8] ? "N/A" : pidline[8].equalsIgnoreCase("") ? "N/A" : pidline[8];
                pidline[10] = null == pidline[10] ? "N/A" : pidline[10].equalsIgnoreCase("") ? "N/A" : pidline[10];
                Date dob = null == pidline[7] ? new Date() : pidline[1].equalsIgnoreCase("") ? new Date() :
                        new SimpleDateFormat("yyyymmdd").parse(pidline[7]);

                pidfeilds.add(new Patient(pidline[5], pidline[6], dob, pidline[3], pidline[8].charAt(0), pidline[10]));
                //System.out.println(pidfeilds);
            }
            for (Patient p: pidfeilds) {
                System.out.println(p.toString());
            }



//                for (String e : pidline) {
//                    System.out.println(e);
//                    pidline[3] = patient.
//                }


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

            }}





