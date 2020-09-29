package com.dtcc.patient;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class readInfo {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("messages.txt");
        //Read the file
        Scanner input = new Scanner(file);
        // if line starts with PID
        String regex    =   "^PID";
        Pattern pattern =   Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher =   pattern.matcher(CharSequence);
        while (matcher.find())
        {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }

    }




}
