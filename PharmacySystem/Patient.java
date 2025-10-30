package PharmacySystem;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a patient in the pharmacy system.
 * Inherits from the Person class and maintains lists of medications and prescriptions.
 */
public class Patient extends Person {
    /**
     * The list of medications assigned to this patient.
     */
    private List<Medication> medications;
    /**
     * The list of prescriptions for this patient.
     */
    private List<Prescription> prescriptions;

    /**
     * Constructs a new Patient with the specified details.
     *
     * @param id          The unique ID of the patient.
     * @param name        The name of the patient.
     * @param age         The age of the patient.
     * @param phoneNumber The phone number of the patient.
     */
    public Patient(String id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    /**
     * Gets the list of medications assigned to this patient.
     *
     * @return The list of medications.
     */
    public List<Medication> getMedications() {
        return medications;
    }

    /**
     * Gets the list of prescriptions for this patient.
     *
     * @return The list of prescriptions.
     */
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    /**
     * Adds a medication to the patient's list.
     *
     * @param medication The medication to add.
     */
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    /**
     * Adds a prescription to the patient's list.
     *
     * @param prescription The prescription to add.
     */
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    /**
     * Removes a medication from the patient's list.
     *
     * @param medication The medication to remove.
     */
    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    /**
     * Removes a prescription from the patient's list.
     *
     * @param prescription The prescription to remove.
     */
    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    /**
     * Returns a string representation of the patient, including medication and prescription counts.
     *
     * @return A string with patient details.
     */
    public String toString() {
        return super.toString() + " | Medications: " + medications.size() + " | Prescriptions: " + prescriptions.size();
    }
}
