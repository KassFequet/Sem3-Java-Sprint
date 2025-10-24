import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    // Instance variables / lists
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    public Patient(String id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // Getters and Setters / Manipulation Methods
    public List<Medication> getMedications() {
        return medications;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    // to String method
    public String toString() {
        return super.toString() + " | Medications: " + medications.size() + " | Prescriptions: " + prescriptions.size();
    }
}
