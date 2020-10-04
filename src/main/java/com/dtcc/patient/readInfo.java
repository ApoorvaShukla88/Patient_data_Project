package com.dtcc.patient;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class readInfo {
   

    public static void main(String[] args) throws FileNotFoundException {
        String result = "";
        File file = new File("messages.txt");
        //Read the file
        Scanner input = new Scanner(file);
        // if line starts with PID
        final String searchKey = "PID|";
        ArrayList<String> pidfeilds = new ArrayList<String>();
        while (input.hasNextLine())
        {
            String nextLine = input.nextLine();
            if (nextLine.contains(searchKey)) {
                //Got all the PID line and printing it to console
//                System.out.println(nextLine);
                //pidfeilds.addAll(Collections.singleton(nextLine));
                //System.out.println(pidfeilds);

                String[] pidline = nextLine.split("\\|");
                for (String e : pidline) {
                    System.out.println(e);
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

            }}}





