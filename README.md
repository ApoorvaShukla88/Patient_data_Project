# Patient_data_Project

We have been given a text file of about 50 HL7 messages.  

### Goals

1. Identify the patient information in the PID segments and then parse that information into patient-specific fields (e.g. last name, first name, dob).
2. Design a Patient class to hold the data retrieved from the messages.  The class should have at least ten data elements.  Do not make them all strings.  For example, the dob should be stored in a Java Date object.  
Try to include at least one Boolean field as well.
Create one Patient object from each HL7 message and then populate:
1)	an array of Patient objects
2)	an ArrayList of Patient objects
Also write a toString() method for the Patient class and then use that to display snapshot information for each patient in the console.
Export the toString() method calls to an external text file named patient-summary.txt.

Due Date: 10/26/2020
