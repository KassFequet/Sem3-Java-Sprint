import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    // Instance variables / lists
    private String specialization;
    private List<Patient> patients;

    public Doctor(String id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    // Getters and Setters / Manipulation Methods

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    
    // to String method
    public String toString() {
        return super.toString() + " | Specialization: " + specialization + " | Patients: " + patients.size();
    }
}