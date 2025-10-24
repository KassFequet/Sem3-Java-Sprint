import java.time.LocalDate;

public class Prescription {
    private final String id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate dateIssued;
    private LocalDate prescriptionExpiry;

    // Constructor
    public Prescription(Doctor doctor, Patient patient, Medication medication, LocalDate dateIssued, LocalDate prescriptionExpiry) {
        this.id = generateRandomID();
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.dateIssued = dateIssued;
        this.prescriptionExpiry = prescriptionExpiry;
    }

}
