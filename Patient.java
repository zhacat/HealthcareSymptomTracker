// Import ArrayList from the java.util package
import java.util.ArrayList;

/**
 * Represents a patient with medical data and a method to calculate their risk score.
 */
class Patient {
    // Patient's name
    protected String name;

    // Patient's body temperature
    protected double temperature;

    // List of symptoms the patient is experiencing
    protected ArrayList<String> symptoms;

    // Patient's medical history
    protected ArrayList<String> history;

    // Risk score for the patient (optional; may be recalculated)
    protected int score;

    /**
     * Constructs a Patient object with the given data.
     *
     * @param name        the name of the patient
     * @param temperature the temperature of the patient
     * @param symptoms    the list of symptoms the patient is experiencing
     * @param history     the list of the patient's medical history items
     */
    public Patient(String name, double temperature, ArrayList<String> symptoms, ArrayList<String> history) {
        this.name = name; // Initialize patient's name
        this.symptoms = symptoms; // Initialize list of symptoms
        this.temperature = temperature; // Initialize temperature
        this.history = history; // Initialize medical history
    }

    /**
     * Calculates and returns the risk score of the patient based on temperature, symptoms, and history.
     *
     * @return the calculated risk score
     */
    public int calculateRisk() {
        int score = 0; // Start with a base score of 0

        // Add 2 to the score if temperature is outside the normal range (35–39°C)
        if (!(temperature > 35.0 && temperature < 39.0)) {
            score += 2;
        }

        // Add 1 point per symptom
        score += symptoms.size();

        // Add 1 point per item in medical history
        score += history.size();

        return score; // Return the final risk score
    }

    /**
     * Returns the string representation of the patient.
     *
     * @return patient name and risk score
     */
    @Override
    public String toString() {
        // Format: "<name> | Risk score: <score>"
        return name + " | Risk score: " + calculateRisk();
    }
}
