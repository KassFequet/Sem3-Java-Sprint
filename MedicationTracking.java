import java.time.LocalDate;
import java.util.*;

/**
 * The MedicationTracking class manages doctors, patients, medications, and prescriptions
 * in the pharmacy system. It provides methods for adding, editing, deleting, searching,
 * assigning, and generating reports for these entities.
 */
public class MedicationTracking {
    /**
     * List of all doctors in the system.
     */
    private List<Doctor> doctors;

    /**
     * List of all patients in the system.
     */
    private List<Patient> patients;

    /**
     * List of all medications in the system.
     */
    private List<Medication> medications;

    /**
     * List of all prescriptions in the system.
     */
    private List<Prescription> prescriptions;

    /**
     * Scanner for user input.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a MedicationTracking system and initializes sample data.
     */
    public MedicationTracking() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        medications = new ArrayList<>();
        prescriptions = new ArrayList<>();
        sampleData();
    }

    /**
     * Populates the system with sample doctors, patients, medications, and prescriptions.
     */
    public void sampleData() {

        Doctor D1 = new Doctor("100", "Maggie Green", 30, "709-529-9827", "Cardiology");
        Doctor D2 = new Doctor("101", "Rory Charles", 55, "709-376-9726", "Neurology");
        Doctor D3 = new Doctor("102", "Melissa Smith", 43, "709-827-9721", "Oncology");
        doctors.add(D1);
        doctors.add(D2);
        doctors.add(D3);

        Patient P1 = new Patient("200", "Leonard Walsh", 26, "709-264-8254");
        Patient P2 = new Patient("201", "Mary Lawson", 28, "709-286-3810");
        Patient P3 = new Patient("202", "Marcus Beaudoin", 32, "709-329-8265");
        patients.add(P1);
        patients.add(P2);
        patients.add(P3);

        Medication M1 = new Medication("300", "Amoxicillin", "500mg", 200);
        Medication M2 = new Medication("301", "Lisinopril", "10mg", 150);
        Medication M3 = new Medication("302", "Sertraline", "50mg", 100);
        medications.add(M1);
        medications.add(M2);
        medications.add(M3);

        Prescription PR1 = new Prescription("400", D1, P1, M1, LocalDate.of(2025, 8, 13));
        Prescription PR2 = new Prescription("401", D2, P1, M2, LocalDate.of(2023, 1, 20));
        Prescription PR3 = new Prescription("402", D2, P1, M3, LocalDate.of(2024, 12, 25));
        prescriptions.add(PR1);
        prescriptions.add(PR2);
        prescriptions.add(PR3);
    }

    // Search Methods

    /**
     * Searches for a doctor by name and prints the result.
     * @param name The name of the doctor.
     * @return The Doctor object if found, otherwise null.
     */
    public Doctor getDoctorByName(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                System.out.println(doctor);
                return doctor;
            }
        }
        System.out.println("Doctor not found.");
        return null;
    }

    /**
     * Searches for a doctor by name without printing.
     * @param name The name of the doctor.
     * @return The Doctor object if found, otherwise null.
     */
    public Doctor getDoctorByNameNoPrint(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        return null;
    }

    /**
     * Searches for a patient by name and prints the result.
     * @param name The name of the patient.
     * @return The Patient object if found, otherwise null.
     */
    public Patient getPatientByName(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                System.out.println(patient);
                return patient;
            }
        }
        System.out.println("Patient not found.");
        return null;
    }

    /**
     * Searches for a patient by name without printing.
     * @param name The name of the patient.
     * @return The Patient object if found, otherwise null.
     */
    public Patient getPatientByNameNoPrint(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    /**
     * Searches for a medication by name and prints the result.
     * @param name The name of the medication.
     * @return The Medication object if found, otherwise null.
     */
    public Medication getMedicationByName(String name) {
        for (Medication medication : medications) {
            if (medication.getName().equalsIgnoreCase(name)) {
                System.out.println(medication);
                return medication;
            }
        }
        System.out.println("Medication not found.");
        return null;
    }

    /**
     * Searches for a medication by name without printing.
     * @param name The name of the medication.
     * @return The Medication object if found, otherwise null.
     */
    public Medication getMedicationByNameNoPrint(String name) {
        for (Medication medication : medications) {
            if (medication.getName().equalsIgnoreCase(name)) {
                return medication;
            }
        }
        return null;
    }

    /**
     * Checks if a patient ID already exists in the system.
     *
     * @param id The patient ID to check.
     * @return true if the patient ID exists, false otherwise.
     */
    public boolean patientIdExists(String id) {
        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a doctor ID already exists in the system.
     *
     * @param id The doctor ID to check.
     * @return true if the doctor ID exists, false otherwise.
     */
    public boolean doctorIdExists(String id) {
        for (Doctor d : doctors) {
            if (d.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a medication ID already exists in the system.
     *
     * @param id The medication ID to check.
     * @return true if the medication ID exists, false otherwise.
     */
    public boolean medicationIdExists(String id) {
        for (Medication m : medications) {
            if (m.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a prescription ID already exists in the system.
     *
     * @param id The prescription ID to check.
     * @return true if the prescription ID exists, false otherwise.
     */
    public boolean prescriptionIdExists(String id) {
        for (Prescription p : prescriptions) {
            if (p.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Add and Delete Methods

    /**
     * Adds a new doctor to the system.
     * @param doctor The Doctor object to add.
     */
    public void addNewDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    /**
     * Adds a new patient to the system.
     * @param patient The Patient object to add.
     */
    public void addNewPatient(Patient patient) {
        patients.add(patient);
    }

    /**
     * Adds a new medication to the system.
     * @param medication The Medication object to add.
     */
    public void addNewMedication(Medication medication) {
        medications.add(medication);
    }

    /**
     * Deletes a doctor by name and prints the result.
     * @param name The name of the doctor to delete.
     */
    public void deleteDoctor(String name) {
        if (doctors.removeIf(d -> d.getName().equalsIgnoreCase(name))) {
            System.out.println("Doctor deleted successfully.");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    /**
     * Deletes a doctor by name without printing.
     * @param name The name of the doctor to delete.
     */
    public void deleteDoctorNoPrint(String name) {
        if (doctors.removeIf(d -> d.getName().equalsIgnoreCase(name))) {
            System.out.println("Doctor deleted successfully.");
        }
    }

    /**
     * Deletes a medication by name and prints the result.
     * @param name The name of the medication to delete.
     */
    public void deleteMedication(String name) {
        if (medications.removeIf(m -> m.getName().equalsIgnoreCase(name))) {
            System.out.println("Medication deleted successfully.");
        } else {
            System.out.println("Medication not found.");
        }
    }

    /**
     * Deletes a medication by name without printing.
     * @param name The name of the medication to delete.
     */
    public void deleteMedicationNoPrint(String name) {
        if (medications.removeIf(m -> m.getName().equalsIgnoreCase(name))) {
            System.out.println("Medication deleted successfully.");
        }
    }
    
    /**
     * Deletes a patient by name and prints the result.
     * @param name The name of the patient to delete.
     */
    public void deletePatient(String name) {
        if (patients.removeIf(p -> p.getName().equalsIgnoreCase(name))) {
            System.out.println("Patient deleted successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    /**
     * Deletes a patient by name without printing.
     * @param name The name of the patient to delete.
     */
    public void deletePatientNoPrint(String name) {
        if (patients.removeIf(p -> p.getName().equalsIgnoreCase(name))) {
            System.out.println("Patient deleted successfully.");
        }
    }
    
    // Edit Methods

    /**
     * Edits the details of a patient identified by ID.
     * @param id The ID of the patient to edit.
     * @param newName The new name for the patient.
     * @param newAge The new age for the patient.
     * @param newPhone The new phone number for the patient.
     */
    public void editPatient(String id, String newName, int newAge, String newPhone) {
        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(id)) {
                p.setName(newName);
                p.setAge(newAge);
                p.setPhoneNumber(newPhone);
                return;
            }
        }
    }

    /**
     * Edits the details of a doctor identified by ID.
     * @param id The ID of the doctor to edit.
     * @param newName The new name for the doctor.
     * @param newAge The new age for the doctor.
     * @param newPhone The new phone number for the doctor.
     * @param newSpec The new specialization for the doctor.
     */
    public void editDoctor(String id, String newName, int newAge, String newPhone, String newSpec) {
        for (Doctor d : doctors) {
            if (d.getId().equalsIgnoreCase(id)) {
                d.setName(newName);
                d.setAge(newAge);
                d.setPhoneNumber(newPhone);
                d.setSpecialization(newSpec);
                return;
            }
        }
    }

    /**
     * Edits the details of a medication identified by ID.
     * @param id The ID of the medication to edit.
     * @param newName The new name for the medication.
     * @param newDose The new dosage for the medication.
     * @param newQty The new quantity in stock for the medication.
     * @param newExpiry The new expiry date for the medication.
     */
    public void editMedication(String id, String newName, String newDose, int newQty, LocalDate newExpiry) {
        for (Medication m : medications) {
            if (m.getId().equalsIgnoreCase(id)) {
                m.setName(newName);
                m.setDosage(newDose);
                m.setQuantityInStock(newQty);
                m.setExpiryDate(newExpiry);
                return;
            }
        }
    }

    // Reports

    /**
     * Generates and prints a system report of all doctors, patients, medications, and prescriptions.
     */
    public void generateSystemReport() {
        System.out.println("\n===== SYSTEM REPORT =====");
        System.out.println("\n--- Doctors ---");
        doctors.forEach(System.out::println);

        System.out.println("\n--- Patients ---");
        patients.forEach(System.out::println);

        System.out.println("\n--- Medications ---");
        medications.forEach(System.out::println);

        System.out.println("\n--- Prescriptions ---");
        prescriptions.forEach(System.out::println);
    }

    /**
     * Generates and prints a report of all expired medications.
     */
    public void generateExpiredMedicationReport() {
        System.out.println("\n===== EXPIRED MEDICATION REPORT =====");
        LocalDate today = LocalDate.now();
        boolean hasExpired = false;
        for (Medication m : medications) {
            if (m.getExpiryDate().isBefore(today)) {
                System.out.println(m);
                hasExpired = true;
            }
        }
        if (!hasExpired) {
            System.out.println("No expired medications found.");
        }
    }

    /**
     * Generates and prints a report of all prescriptions issued by a specific doctor.
     * @param doctor The doctor whose prescriptions are to be reported.
     */
    public void generatePrescriptionsByDoctorReport(Doctor doctor) {
        System.out.println("\n===== PRESCRIPTIONS FOR DR. " + doctor.getName().toUpperCase() + " =====");
        boolean found = false;
        for (Prescription p : prescriptions) {
            if (p.getDoctor().equals(doctor)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No prescriptions found for Dr. " + doctor.getName() + ".");
        }
    }

    /**
     * Generates and prints a report of all non-expired prescriptions for a specific patient.
     * @param patient The patient whose prescriptions are to be reported.
     */
    public void generatePrescriptionsByPatientReport(Patient patient) {
        System.out.println("\n===== PRESCRIPTIONS FOR PATIENT " + patient.getName().toUpperCase() + " =====");
        boolean found = false;
        LocalDate today = LocalDate.now();
        for (Prescription p : prescriptions) {
        if (p.getPatient().equals(patient)) {
            if (p.getPrescriptionExpiry().isAfter(today) || p.getPrescriptionExpiry().isEqual(today)) {
                System.out.println(p.getMedication().getName());
                found = true;
            }
        }
    }
    if (!found) {
        System.out.println("No non-expired prescriptions found for patient " + patient.getName() + ".");
    }
    }

    // Additional Methods

    /**
     * Accepts a new prescription and adds it to the system after validating inputs.
     * @param id The ID of the prescription.
     * @param doctor The doctor issuing the prescription.
     * @param patient The patient receiving the prescription.
     * @param medication The medication prescribed.
     * @param dateString The date the prescription was issued in YYYY-MM-DD format.
     */
    public void acceptPrescription(String id, Doctor doctor, Patient patient, Medication medication, String dateString) {
        if (doctor == null) {
            System.out.println("Doctor not found - Prescription not created.");
            return;
        }
        if (patient == null) {
            System.out.println("Patient not found - Prescription not created.");
            return;
        }
        if (medication == null) {
            System.out.println("Medication not found - Prescription not created.");
            return;
        }
        LocalDate dateIssued;
        try {
            dateIssued = LocalDate.parse(dateString);
        } catch (Exception unused) {
            System.out.println("Invalid date format - Prescription not created.");
            return;
        }

        Prescription prescription = new Prescription(id, doctor, patient, medication, dateIssued);
        prescriptions.add(prescription);
        System.out.println("\nPrescription added | " + prescription + "\n");
    }

    /**
     * Restocks a medication by name and prints the result.
     * @param medicationName The name of the medication to restock.
     * @param quantity The quantity to add to stock.
     */
    public void restockMedication(String medicationName, int quantity) {
        Medication medication = getMedicationByNameNoPrint(medicationName);
        if (medication != null) {
            medication.setQuantityInStock(medication.getQuantityInStock() + quantity);
            System.out.println("\n" + medication.getName() + " restocked successfully | New quantity: " + medication.getQuantityInStock());
        } else {
            System.out.println("\nMedication not found.");
        }
    }

    /**
     * Assigns a patient to a doctor by their names and prints the result.
     * @param doctorName The name of the doctor.
     * @param patientName The name of the patient.
     */
    public void assignPatientToDoctor(String doctorName, String patientName) {
        Doctor doctor = getDoctorByNameNoPrint(doctorName);
        Patient patient = getPatientByNameNoPrint(patientName);
        if (doctor != null && patient != null) {
            doctor.addPatient(patient);
            System.out.println("\nSuccessfully assigned " + patient.getName() + " to Dr. " + doctor.getName() + "!\n");
        } else {
            System.out.println("\nAssignment failed. Check names and try again.\n");
        }
    }

}
