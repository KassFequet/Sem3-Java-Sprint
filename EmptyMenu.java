import java.util.Scanner;

public class EmptyMenu {
    public static void main(String[] args) {
        MedicationTracking medicationTracking = new MedicationTracking();
        boolean exit = false;

        while (!exit){
            Scanner scanner = new Scanner(System.in);
            System.out.println("=====Welcome To The Pharmacy Med Tracking System=====");
            System.out.println("What would you like to do? ");
            System.out.println("1: Add A New Patient");
            System.out.println("2: Add A New Doctor");
            System.out.println("3: Add A New Medication To The Pharmacy");
            System.out.println("4: Print System Report");
            System.out.println("5: Check If Meds Are Expired");
            System.out.println("6: Process A New Prescription");
            System.out.println("7: Print All Scripts For Specific Doctor");
            System.out.println("8: Restock the drugs in the pharmacy");
            System.out.println("9: print all scripts for specific patient");
            System.out.println("10: Edit Patient");
            System.out.println("11: Edit Doctor");
            System.out.println("12: Edit Medication");
            System.out.println("13: Assign Patient to Doctor");
            System.out.println("14: Exit");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    addNewPatient(scanner, medicationTracking);
                    break;
                case 2:
                    addNewDoctor(scanner, medicationTracking);
                    break;
                case 3:
                    addNewMedication(scanner, medicationTracking);
                    break;
                case 4:
                    medicationTracking.generateSystemReport();
                    break;
                case 5:
                    medicationTracking.generateExpiredMedicationReport();
                    break;
                case 6:
                    acceptPrescription(scanner, medicationTracking);
                    break;
                case 7:
                    generatePrescriptionsByDoctorReport(scanner, medicationTracking);
                    break;
                case 8:
                    restockPharmacyDrugs(scanner, medicationTracking);
                    break;
                case 9:
                    generatePrescriptionsByPatientReport(scanner, medicationTracking);
                    break;
                case 10:
                    editPatient(scanner, medicationTracking);
                    break;
                case 11:
                    editDoctor(scanner, medicationTracking);
                    break;
                case 12:
                    editMedication(scanner, medicationTracking);
                    break;
                case 13:
                    assignPatientToDoctor(scanner, medicationTracking);
                    break;
                case 14:
                    exit = true;
                    System.out.println("Exiting The System! Good Bye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }

    private static void addNewPatient(Scanner scanner, MedicationTracking system) {
        System.out.print("Enter patient ID: ");
        scanner.nextLine();
        String id = scanner.nextLine();
        
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter patient phone number: ");
        String phoneNumber = scanner.nextLine();
        
        Patient newPatient = new Patient(id, name, age, phoneNumber);
        system.addNewPatient(newPatient);
        System.out.println("Patient added successfully!");
    }
    
    private static void addNewDoctor(Scanner scanner, MedicationTracking system) {
        System.out.print("Enter doctor's ID: ");
        scanner.nextLine();
        String id = scanner.nextLine();
        
        System.out.print("Enter doctor's name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter doctor's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter doctor's phone number: ");
        String phoneNumber = scanner.nextLine();
        
        System.out.print("Enter doctor's specialization: ");
        String specialization = scanner.nextLine();
        
        Doctor newDoctor = new Doctor(id, name, age, phoneNumber, specialization);
        system.addNewDoctor(newDoctor);
        System.out.println("Doctor added successfully!");
    }
    
    private static void addNewMedication(Scanner scanner, MedicationTracking system) {
        System.out.print("Enter medication id: ");
        scanner.nextLine();
        String id = scanner.nextLine();

        System.out.print("Enter medication name: ");
        String name = scanner.nextLine();

        System.out.print("Enter dosage:");
        String dosage = scanner.nextLine();

        System.out.print("Enter quantity in stock: ");
        int quantityInStock = scanner.nextInt();

        Medication newMedication = new Medication(id, name, dosage, quantityInStock);
        system.addNewMedication(newMedication);
        System.out.print("Medication added successfully!");
    }
    
    private static void processANewScript(Scanner scanner, MedicationTracking system) {

        System.out.println("\n===== Proccess a New Prescription =====");
        System.out.print("Enter the prescription ID: ");
        String id = scanner.nextLine();

        Doctor doctor = null;
        while (doctor == null) {
            System.out.print("Enter the doctor's name: ");
            String doctorInput = scanner.nextLine();
            doctor = system.getDoctorByNameNoPrint(doctorInput);
            if (doctor == null) {
                System.out.println("Doctor not found - Please try again");
            }
        }

        Patient patient = null;
        while (patient == null) {
            System.out.print("Enter the patient's name: ");
            String patientInput = scanner.nextLine();
            patient = system.getPatientByNameNoPrint(patientInput);
            if (patient == null) {
                System.out.println("Patient not found - Please try again");
            }
        }

        Medication medication = null;
        while (medication == null) {
            System.out.print("Enter the medication name: ");
            String medicationInput = scanner.nextLine();
            medication = system.getMedicationByNameNoPrint(medicationInput);
            if (medication == null) {
                System.out.println("Medication not found - Please try again");
            }
        }

        String date = null;
        boolean dateValid = false;
        while (!dateValid) {
            System.out.print("Enter date issued (YYYY-MM-DD): ");
            date = scanner.nextLine();
            try {
                java.time.LocalDate.parse(date);
                dateValid = true;
            } catch (Exception unused) {
                System.out.println("Invalid date format - Please try again");
            }
        }

        system.acceptPrescription(id, doctor, patient, medication, date);
    }
    
    private static void generatePrescriptionsByDoctorReport(Scanner scanner, MedicationTracking system) {
        System.out.print("Enter doctor name: ");
        scanner.nextLine();
        String doctorName = scanner.nextLine();
        
        Doctor doctor = system.getDoctorByName(doctorName);
        if (doctor != null) {
        system.generatePrescriptionsByDoctorReport(doctor);
        } else {
            System.out.println("Doctor not found.");
        }
    }
    
    private static void restockPharmacyDrugs(Scanner scanner, MedicationTracking system) {
        System.out.print("Enter medication name: ");
        scanner.nextLine();
        String medicationName = scanner.nextLine();
        
        System.out.print("Enter amount to restock: ");
        int amount = scanner.nextInt();
        
        system.restockMedication(medicationName, amount);
    }
    
    private static void generatePrescriptionsByPatientReport(Scanner scanner, MedicationTracking system) {
        System.out.println("Enter patient name: ");
        scanner.nextLine();
        String patientName = scanner.nextLine();

        Patient patient = system.getPatientByName(patientName);
        if (patient != null) {
            system.generatePrescriptionsByPatientReport(patient);
        } else {
            System.out.println("Patient not found.");
        }
    }
    
    private static void editPatient(Scanner scanner, MedicationTracking system) {
        
    }
    
    private static void editDoctor(Scanner scanner, MedicationTracking system) {
        
    }
    
    private static void editMedication(Scanner scanner, MedicationTracking system) {
        
    }
    
    private static void assignPatientToDoctor(Scanner scanner, MedicationTracking system) {
        
    }

}