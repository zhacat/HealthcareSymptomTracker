# HealthcareSymptomTracker
A simple project to order patients in healthcare waiting systems based on priority.

## Required
By default, the input file will be patientList.txt, on your desktop. If it doesn't exist, you will be asked to provide the **full** path to the input file.<br>
The output file will be automatically put on your desktop. Enter only the file name (without the path or file extension), and the file will be created with the output information.<br>
The **input file** must be a .txt file of a list of patients, each separated by a line break, in the following format:

[_NAME (String)_]<br>
Age: [_AGE (int)_]<br>
Gender: [_GENDER (int)_]<br>
Temperature (°C): [_TEMPERATURE (double)_]<br>
Symptoms: [_SYMPTOMS (Strings separated by commas)_]<br>
History: [_(optional) MEDICAL HISTORY (String separated by commas)_]<br>

## How it works
- Based on the patient's temperature, symptoms, and medical history, they are given a "risk score".<br>
- Based on the risk scores, the patients are reordered using selection sort. The higher the risk score, the more critical their condition is considered, and the higher up they will be on the output file.<br>
- If a patient's score is **above 6**, they are considered a HighRiskPatient, a subclass of the Patient class, which will be indicated on the output file.<br>
- The resulting list of patients/high risk patients and their risk scores are written on the output file which will be created at the designated location on the user's desktop.
