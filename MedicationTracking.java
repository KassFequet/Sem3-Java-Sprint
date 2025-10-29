import java.time.LocalDate;
import java.util.*;

public class MedicationTracking {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    private Scanner scanner = new Scanner(System.in);

    public MedicationTracking() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        medications = new ArrayList<>();
        prescriptions = new ArrayList<>();
        sampleData();
    }

    //Sample Data
    public void sampleData() {

        Doctor D1 = new Doctor("D100", "Maggie Green", 30, "709-529-9827", "Cardiology");
        Doctor D2 = new Doctor("D101", "Rory Charles", 55, "709-376-9726", "Neurology");
        Doctor D3 = new Doctor("D102", "Melissa Smith", 43, "709-827-9721", "Oncology");
        doctors.add(D1);
        doctors.add(D2);
        doctors.add(D3);

        Patient P1 = new Patient("P100", "Leonard Walsh", 26, "709-264-8254");
        Patient P2 = new Patient("P101", "Mary Lawson", 28, "709-286-3810");
        Patient P3 = new Patient("P102", "Marcus Beaudoin", 32, "709-329-8265");
        patients.add(P1);
        patients.add(P2);
        patients.add(P3);

        Medication M1 = new Medication("M100", "Amoxicillin", "500mg", 200);
        Medication M2 = new Medication("M101", "Lisinopril", "10mg", 150);
        Medication M3 = new Medication("M102", "Sertraline", "50mg", 100);
        medications.add(M1);
        medications.add(M2);
        medications.add(M3);

        Prescription PR1 = new Prescription("PR100", D1, P1, M1, LocalDate.of(2025, 8, 13));
        Prescription PR2 = new Prescription("PR101", D2, P1, M2, LocalDate.of(2023, 1, 20));
        Prescription PR3 = new Prescription("PR102", D2, P1, M3, LocalDate.of(2024, 12, 25));
        prescriptions.add(PR1);
        prescriptions.add(PR2);
        prescriptions.add(PR3);
    }

    // Search Methods

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

        public Doctor getDoctorByNameNoPrint(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        return null;
    }

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

        public Patient getPatientByNameNoPrint(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

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

        public Medication getMedicationByNameNoPrint(String name) {
        for (Medication medication : medications) {
            if (medication.getName().equalsIgnoreCase(name)) {
                return medication;
            }
        }
        return null;
    }

    // Add and Delete Methods
    
    public void addNewDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addNewPatient(Patient patient) {
        patients.add(patient);
    }

    public void addNewMedication(Medication medication) {
        medications.add(medication);
    }

    public void deleteDoctor(String name) {
        if (doctors.removeIf(d -> d.getName().equalsIgnoreCase(name))) {
            System.out.println("Doctor deleted successfully.");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    public void deleteMedication(String name) {
        if (medications.removeIf(m -> m.getName().equalsIgnoreCase(name))) {
            System.out.println("Medication deleted successfully.");
        } else {
            System.out.println("Medication not found.");
        }
    }
    
    public void deletePatient(String name) {
        if (patients.removeIf(p -> p.getName().equalsIgnoreCase(name))) {
            System.out.println("Patient deleted successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }
    

    // Edit Methods

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


    // Assign Patient to Doctor

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


    // Reports

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

    public void generateExpiredMedicationReport() {
        System.out.println("\n===== EXPIRED MEDICATION REPORT =====");
        LocalDate today = LocalDate.now();
        boolean hasExpired = false;
        for (Medication m : medications) {
            if (m.getExpiryDate().isBefore(today)) {
                System.out.println(m + " | Expired on: " + m.getExpiryDate());
                hasExpired = true;
            }
        }
        if (!hasExpired) {
            System.out.println("No expired medications found.");
        }
    }

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

    //Accept a prescription
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

    public void restockMedication(String medicationName, int quantity) {
        Medication medication = getMedicationByNameNoPrint(medicationName);
        if (medication != null) {
            medication.setQuantityInStock(medication.getQuantityInStock() + quantity);
            System.out.println("\n" + medication.getName() + " restocked successfully | New quantity: " + medication.getQuantityInStock());
        } else {
            System.out.println("\nMedication not found.");
        }
    }


}
