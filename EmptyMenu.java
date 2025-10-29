import java.time.LocalDate;
import java.util.Scanner;

public class EmptyMenu {
<<<<<<< Updated upstream
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
                    processANewScript(scanner, medicationTracking);
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

    }
    
    private static void addNewDoctor(Scanner scanner, MedicationTracking system) {
        
    }
    
    private static void addNewMedication(Scanner scanner, MedicationTracking system) {
        
    }
    
    private static void processANewScript(Scanner scanner, MedicationTracking system) {
        
    }
    
    private static void generatePrescriptionsByDoctorReport(Scanner scanner, MedicationTracking system) {
        
    }
    
    private static void restockPharmacyDrugs(Scanner scanner, MedicationTracking system) {
        
    }
    
    private static void generatePrescriptionsByPatientReport(Scanner scanner, MedicationTracking system) {
        
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
=======
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
             System.out.println("10: Exit");
             int option = scanner.nextInt();
             scanner.nextLine();
             switch (option) {
                 case 1:
                     addANewPatient(scanner,medicationTracking);
                     break;
                 case 2:
                     addANewDoctor(scanner);
                     break;
                 case 3:
                     addNewMedicationToPharmacy(scanner, medicationTracking);
                     break;
                 case 4:
                     printPharmacyReport(medicationTracking);
                     break;
                 case 5:
                     checkExpiredMeds(medicationTracking);
                     break;
                 case 6:
                     processANewScript(scanner,medicationTracking);
                     break;
                 case 7:
                     printScriptsForSpecificDoctor(scanner,medicationTracking);
                     break;
                 case 8:
                     restockPharmacyDrugs(scanner,medicationTracking);
                     break;
                 case 9:
                     printAllScriptsForPatientByName(scanner,medicationTracking);
                     break;
                 case 10:
                     exit = true;
                     System.out.println("Exiting The System! Good Bye!");
                     break;
                 default:
                     System.out.println("Invalid option");
             }
         }
 
     }
 
     private static void printAllScriptsForPatientByName(Scanner scanner, MedicationTracking system) {
 
     }
 
     private static void restockPharmacyDrugs(Scanner scanner, MedicationTracking system) {
 
     }
 
     private static void printScriptsForSpecificDoctor(Scanner scanner, MedicationTracking system) {
 
     }
 
    private static void processANewScript(Scanner scanner, MedicationTracking system) {
        System.out.print("Enter prescription ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter doctor's name: ");
        String doctorString = scanner.nextLine();
        Doctor doctor = system.getDoctorByNameNoPrint(doctorString);

        System.out.print("Enter patient's name: ");
        String patientString = scanner.nextLine();
        Patient patient = system.getPatientByNameNoPrint(patientString);

        System.out.print("Enter medication name: ");
        String medicationString = scanner.nextLine();
        Medication medication = system.getMedicationByNameNoPrint(medicationString);

        System.out.print("Enter date issued (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();

        system.acceptPrescription(id, doctor, patient, medication, dateString);
    }
 
     private static void checkExpiredMeds(MedicationTracking system) {
 
     }
 
     private static void printPharmacyReport(MedicationTracking system) {
 
     }
 
     private static void addNewMedicationToPharmacy(Scanner scanner, MedicationTracking system) {
 
     }
 
     private static void addANewDoctor(Scanner scanner) {
     }
 
     private static void addANewPatient(Scanner scanner, MedicationTracking system) {
 
 
     }
 
 }
>>>>>>> Stashed changes
