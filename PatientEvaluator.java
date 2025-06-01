import java.io.*;       // Import everything in the java.io package
import java.util.*;     // Import everything in the java.util package

/**
 * Evaluates patients from a file, sorts them, and writes output.
 */
public class PatientEvaluator {
    /**
     * Entry point for running the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) throws Exception {
        // Create a Scanner, input, for user input
        Scanner input = new Scanner(System.in);
        
        // Get the user's home directory
        String home = System.getProperty("user.home");
    
        // Create a new File item from the default path to take the text input. If it doesn't exist, allow the user to input a path
        File inputFile = new File(home + "/Desktop/PatientList.txt");
        while (!inputFile.exists()) {
            System.out.println("Input file not found at: " + inputFile.getAbsolutePath() + "\nEnter full path to the input file:");
            inputFile = new File(input.nextLine());
        }
        
        // Create a new File to output the results to on the user's desktop
        System.out.print("Enter output file name (no extension): ");
        String outputName = input.nextLine();
        File outputFile = new File(home + "/Desktop/" + outputName + ".txt");
        
        // Call upon the methods to read the file, evaluate the patient conditions, sort them based on risk, and write it to the output file
        ArrayList<Patient> patients = parseFile(inputFile);
        selectionSort(patients);
        writeOutput(outputFile, patients);
        
        // Let the user know that it was successfully completed, and close the input Scanner
        System.out.println("Output written to: " + outputFile.getAbsolutePath());
        input.close();
    }
    
    /**
     * Parses a file containing patient data and returns a list of Patient or HighRiskPatient objects.
     *
     * @param file the input file containing patient information
     * @return a list of patients
     * @throws Exception if file reading fails
     */
    static ArrayList<Patient> parseFile(File file) throws Exception {
        // Create a Scanner, scan, to scan the input file
        Scanner scan = new Scanner(file);
        // Create an empty ArrayList of Patients
        ArrayList<Patient> patients = new ArrayList<>();
        
        // Read the lines of the (properly formatted) file, and assign the values to variables
        while (scan.hasNextLine()) {
            String name = scan.nextLine();
            scan.nextLine(); // Skip the age
            scan.nextLine(); // Skip the gender
            // Split the next line after the colon and space for the temperature
            double temp = Double.parseDouble(scan.nextLine().split(": ")[1]);
            
            // Split the next line after the colon and space for the symptoms
            ArrayList<String> symptoms = parseList(scan.nextLine().split(": ")[1]);
            
            // Split the line after the colon and space for the medical history
            ArrayList<String> history = parseList(scan.nextLine().split(": ")[1]);
            
            // Evaluate the Patient's risk score
            int score = new Patient(name, temp, symptoms, history).calculateRisk();
            
            // If the Patient's risk score is above 6, they are considered to be at high risk
            if (score > 6) {
                patients.add(new HighRiskPatient(name, temp, symptoms, history));
            }
            else {
                patients.add(new Patient(name, temp, symptoms, history));
            }
            
            // At the end of the file, stop
            if (!scan.hasNextLine()){
                break;
            }
            else {
                scan.nextLine(); // Skip the blank line
            }
        }
        // Close the Scanner and return the patients ArrayList
        scan.close();
        return patients;
    }

    /**
     * Parses a comma-separated string into a list of strings.
     *
     * @param the comma-separated string
     * @return a list of strings
     */
    static ArrayList<String> parseList(String s) {
        // Split the String Arraylist based on the comma and space
        String[] parts = s.split(", ");
        // Return the String[] parts as an ArrayList<String>
        return new ArrayList<>(Arrays.asList(parts));
    }
    
    /**
     * Sorts a list of patients by their risk score using selection sort.
     *
     * @param patients the list of patients to sort
     */
    static void selectionSort(ArrayList<Patient> list) {
        // Selection sort the values in the ArrayList
        for (int i = 0; i < list.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).calculateRisk() > list.get(maxIndex).calculateRisk()) {
                    maxIndex = j;
                }
            }
            Patient temporary = list.get(i);
            list.set(i, list.get(maxIndex));
            list.set(maxIndex, temporary);
        }
    }
    
    /**
     * Writes the sorted patient data to the given output file.
     *
     * @param file     the file to write output to
     * @param patients the sorted list of patients
     * @throws IOException if writing fails
     */
    static void writeOutput(File f, ArrayList<Patient> list) throws IOException {
        // Create a new FileWriter, writer, to write the output to
        FileWriter writer = new FileWriter(f);
        
        // Write each patient and their risk score on a new line
        for (Patient p : list) {
            writer.write(p.toString() + "\n");
        }
        
        // Close the writer
        writer.close();
    }
}