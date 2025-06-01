import java.util.ArrayList;

// Represents a patient classified as high risk, extending the base Patient class
public class HighRiskPatient extends Patient {

    // Constructs a HighRiskPatient with the same parameters as a regular Patient
    public HighRiskPatient(String name, double temperature, ArrayList<String> symptoms, ArrayList<String> history) {
        super(name, temperature, symptoms, history); // Call superclass constructor
    }

    // Returns a formatted string that includes a high-risk label
    @Override
    public String toString() {
        // Format: "<name> (High Risk Patient) | Risk score: <score>"
        return name + " (High Risk Patient) | Risk score: " + calculateRisk();
    }
}
