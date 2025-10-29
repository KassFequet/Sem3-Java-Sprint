import java.time.LocalDate;

public class Prescription {
    private String id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate dateIssued;
    private LocalDate prescriptionExpiry;

    // Constructor
    public Prescription(String id, Doctor doctor, Patient patient, Medication medication, LocalDate dateIssued) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.dateIssued = dateIssued;
        this.prescriptionExpiry = generateExpiry(dateIssued);
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public LocalDate getPrescriptionExpiry() {
        return prescriptionExpiry;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public void setDateIssued(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
        this.prescriptionExpiry = generateExpiry(dateIssued);
    }

    // Helper method to generate expiry date one year from date issued
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
