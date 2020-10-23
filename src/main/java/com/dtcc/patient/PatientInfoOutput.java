package com.dtcc.patient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.File;

public class PatientInfoOutput {

    public static void writeToFile(Patient[] arrayPatient) throws IOException {

        String s;
        File file = new File("patient-summary.txt");

        if (file.exists()) {
            file.delete();
            file.createNewFile();
//			System.out.println("file already exits");
//			System.exit(1);
        }

        PrintWriter output = new PrintWriter(file);

        for (int i = 0; i < arrayPatient.length; i++) {
            s = arrayPatient[i].toString();
            // Logic to write data into file

            output.println(s);
        }
        output.close();
    }

    public static void writeErrorPID(String s) throws IOException {
        java.io.File file = new java.io.File("Data-Error-PID.txt");

        try (FileWriter fw = new FileWriter("Data-Error-PID.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(s);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}