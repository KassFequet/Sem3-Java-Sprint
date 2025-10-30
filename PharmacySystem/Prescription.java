package PharmacySystem;
import java.time.LocalDate;

/**
 * Represents a prescription in the pharmacy system.
 * Stores information such as ID, doctor, patient, medication, date issued, and expiry date.
 */

public class Prescription {
    /**
     * The unique ID of the prescription.
     */
    private String id;

    /**
     * The doctor who issued the prescription.
     */
    private Doctor doctor;

    /**
     * The patient for whom the prescription is issued.
     */
    private Patient patient;

    /**
     * The medication prescribed.
     */
    private Medication medication;

    /**
     * The date the prescription was issued.
     */
    private LocalDate dateIssued;
    /**
     * The expiry date of the prescription (one year from date issued).
     */
    private LocalDate prescriptionExpiry;

    /**
     * Constructs a new Prescription with the specified details.
     * The expiry date is set to one year from the date issued.
     *
     * @param id         The unique ID of the prescription.
     * @param doctor     The doctor who issued the prescription.
     * @param patient    The patient for whom the prescription is issued.
     * @param medication The medication prescribed.
     * @param dateIssued The date the prescription was issued.
     */
    public Prescription(String id, Doctor doctor, Patient patient, Medication medication, LocalDate dateIssued) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.dateIssued = dateIssued;
        this.prescriptionExpiry = generateExpiry(dateIssued);
    }

    /**
     * Gets the unique ID of the prescription.
     *
     * @return The prescription ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the doctor who issued the prescription.
     *
     * @return The doctor.
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Gets the patient for whom the prescription is issued.
     *
     * @return The patient.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Gets the medication prescribed.
     *
     * @return The medication.
     */
    public Medication getMedication() {
        return medication;
    }

    /**
     * Gets the date the prescription was issued.
     *
     * @return The date issued.
     */
    public LocalDate getDateIssued() {
        return dateIssued;
    }

    /**
     * Gets the expiry date of the prescription.
     *
     * @return The prescription expiry date.
     */
    public LocalDate getPrescriptionExpiry() {
        return prescriptionExpiry;
    }

    /**
     * Sets the unique ID of the prescription.
     *
     * @param id The new prescription ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the doctor who issued the prescription.
     *
     * @param doctor The new doctor.
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Sets the patient for whom the prescription is issued.
     *
     * @param patient The new patient.
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Sets the medication prescribed.
     *
     * @param medication The new medication.
     */
    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    /**
     * Sets the date the prescription was issued and updates the expiry date.
     *
     * @param dateIssued The new date issued.
     */
    public void setDateIssued(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
        this.prescriptionExpiry = generateExpiry(dateIssued);
    }

    /**
     * Helper method to generate the expiry date one year from the date issued.
     *
     * @param dateIssued The date the prescription was issued.
     * @return The expiry date (one year from date issued).
     */
    private LocalDate generateExpiry (LocalDate dateIssued) {
        return dateIssued.plusYears(1);
    }

    // to String method
    public String toString() {
        return ("ID: " + id +
        " | Doctor: " + doctor.getName() +
        " | Patient: " + patient.getName() +
        " | Medication: " + medication.getName() +
        " | Date Issued: " + dateIssued +
        " | Prescription Expiry: " + prescriptionExpiry);
    }

}
