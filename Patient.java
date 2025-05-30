import java.util.ArrayList;

public class Patient {
    public static void main(String[] args) {
        private String name;
        private int age;
        private String gender;
        private ArrayList<String> symptoms;
        private double temperature;
        
        public Patient(String name, int age, String gender, ArrayList<String> symptoms, double temperature) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.symptoms = symptoms;
            this.temperature = temperature;
        }
        
        // Get values
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
        public String getGender() {
            return gender;
        }
        public ArrayList<String> getSymptoms() {
            return symptoms;
        }
        public double getTemperature() {
            return temperature;
        }
        
        @Override
        public String toString() {
            return (name + "\nAge: " + age + "\nGender: " + gender + "°C\nSymptoms: " + symptoms + "\nTemp: " + temperature);
        }
    }
}