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


    // Add and Delete Methods
    
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addMedication(Medication medication) {
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

}