import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Parses data from a text file, ranks the patients based on risk, and returns an ordered list.
 */

public class PatientExaminer
{
    public static void main(String[] args)
    {
        // Get the user's home directory
        String home = System.getProperty("user.home");
        
        File inputFile = new File(home + "/Desktop/PatientList.txt");
        
        if (inputFile.exists()) {
            System.out.println("Looks like PatientList.txt already exists on your desktop. It'll be the input file be default.");
        }
        
        // Fallback
        while (!inputFile.exists()) { // Not sure if the loop is allowed here
            System.out.println("Input file not found at " + inputFile.getAbsolutePath());
            System.out.println("Enter the FULL path to the input file: ");
            String inputPath = input.nextLine();
            
            inputFile = new File(path);
            System.out.println();
        }
        
        System.out.print("Enter the NAME of the file you want to output to, excluding the path and format. ");
        System.out.println("(If it doesn't exist on your desktop, it will be automatically placed there and formatted as a .txt file): ");

        String outputFileName = input.nextLine();

        File outputFile = new File(home + "/Desktop/" + outputFileName + ".txt");
        
        public static ArrayList<Patient> examinePatients(file inputFile) {
            Scanner scan = new Scanner(inputFile);
            int lineNumber = 1;
            
        }
        
        public static String printList() {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                fileContent += line + "\n";
            }
        }
        
        FileWriter writer = new FileWriter(outputFile);
        writer.write(fileContent);
        writer.close();
        System.out.print("Output written to " + outputFile.getAbsolutePath());
        // Create a file named to output the ordered patients in
    }
}