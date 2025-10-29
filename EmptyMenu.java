import java.util.Scanner;

public class EmptyMenu {
    public static void main(String[] args) {
        MedicationTracking medicationTracking = new MedicationTracking();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit){
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
            System.out.println("9: Print all scripts for specific patient");
            System.out.println("10: Edit Patient");
            System.out.println("11: Edit Doctor");
            System.out.println("12: Edit Medication");
            System.out.println("13: Assign Patient to Doctor");
            System.out.println("14: Search for Patient by Name");
            System.out.println("15: Search for Doctor by Name");
            System.out.println("16: Search for Medication by Name");
            System.out.println("17: Delete Patient");
            System.out.println("18: Delete Doctor");
            System.out.println("19: Delete Medication");
            System.out.println("20: Exit");
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
                    searchPatientByName(scanner, medicationTracking);
                    break;
                case 15:
                    searchDoctorByName(scanner, medicationTracking);
                    break;
                case 16:
                    searchMedicationByName(scanner, medicationTracking);
                    break;
                case 17:
                    deletePatient(scanner, medicationTracking);
                    break;
                case 18:
                    deleteDoctor(scanner, medicationTracking);
                    break;
                case 19:
                    deleteMedication(scanner, medicationTracking);
                    break;
                case 20:
                    exit = true;
                    System.out.println("Exiting The System! Good Bye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        scanner.close();
    }

    private static void addNewPatient(Scanner scanner, MedicationTracking system) {
        System.out.println("\n===== Add a New Patient =====");
        System.out.print("Enter patient ID: ");
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
        System.out.println("\nPatient added successfully!");
    }
    
    private static void addNewDoctor(Scanner scanner, MedicationTracking system) {
        System.out.println("\n===== Add a New Doctor =====");
        System.out.print("Enter doctor's ID: ");
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
        System.out.println("\nDoctor added successfully!");
    }
    
    private static void addNewMedication(Scanner scanner, MedicationTracking system) {
        System.out.println("\n===== Add a New Medication =====");
        System.out.print("Enter medication id: ");
        String id = scanner.nextLine();

        System.out.print("Enter medication name: ");
        String name = scanner.nextLine();

        System.out.print("Enter dosage:");
        String dosage = scanner.nextLine();

        System.out.print("Enter quantity in stock: ");
        int quantityInStock = scanner.nextInt();

        Medication newMedication = new Medication(id, name, dosage, quantityInStock);
        system.addNewMedication(newMedication);
        System.out.print("\nMedication added successfully!");
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
        System.out.println("\n===== Generate Prescriptions by Doctor Report =====");
        System.out.print("Enter doctor name: ");
        String doctorName = scanner.nextLine();
        
        Doctor doctor = system.getDoctorByNameNoPrint(doctorName);
        if (doctor != null) {
        system.generatePrescriptionsByDoctorReport(doctor);
        } else {
            System.out.println("Doctor not found.");
        }
    }
    
    private static void restockPharmacyDrugs(Scanner scanner, MedicationTracking system) {
        System.out.println("\n===== Restock Pharmacy Drugs =====");
        Medication medication = null;
        while (medication == null) {
            System.out.print("Enter the medication name to restock: ");
            String medicationName = scanner.nextLine();
            medication = system.getMedicationByNameNoPrint(medicationName);
            if (medication == null) {
                System.out.println("Medication not found - Please try again");
            }
        }
        
        System.out.print("Enter amount to restock: ");
        int amount = scanner.nextInt();
        
        system.restockMedication(medication.getName(), amount);
    }
    
    private static void generatePrescriptionsByPatientReport(Scanner scanner, MedicationTracking system) {
        System.out.println("\n===== Generate Prescriptions for Patient =====");
        Patient patient = null;
        while (patient == null) {
            System.out.print("Enter patient name: ");
            String patientName = scanner.nextLine();
            patient = system.getPatientByNameNoPrint(patientName);
            if (patient == null) {
                System.out.println("Patient not found - Please try again");
            }
        }
        
        system.generatePrescriptionsByPatientReport(patient);
    }
    
    private static void editPatient(Scanner scanner, MedicationTracking system) {
        System.out.println("\n===== Edit Patient Information =====");
        Patient patient = null;
        while (patient == null) {
            System.out.print("Enter patient name to edit patient information: ");
            String patientName = scanner.nextLine();
            patient = system.getPatientByNameNoPrint(patientName);
            if (patient == null) {
                System.out.println("Patient not found - Please try again");
            }
        }

            System.out.print("Enter a new name (leave blank if not changing): ");
            String updatedName = scanner.nextLine();
            if (updatedName.isEmpty()) updatedName = patient.getName();

            System.out.print("Enter a new age (leave blank if not changing): ");
            String ageInput = scanner.nextLine();
            int updatedAge = ageInput.isEmpty() ? patient.getAge() : Integer.parseInt(ageInput);

            System.out.print("Enter a new phone number (leave blank if not changing): ");
            String updatedPhone = scanner.nextLine();
            if (updatedPhone.isEmpty()) updatedPhone = patient.getPhoneNumber();

            system.editPatient(patient.getId(), updatedName, updatedAge, updatedPhone);

            System.out.println("\nUpdated Patient Information: " + patient + "\n");
        }
    

    private static void editDoctor(Scanner scanner, MedicationTracking system) {
        System.out.println("\n===== Edit Doctor Information =====");
        Doctor doctor = null;
        while (doctor == null) {
            System.out.print("Enter doctor name to edit doctor information: ");
            String doctorName = scanner.nextLine();
            doctor = system.getDoctorByNameNoPrint(doctorName);
            if (doctor == null) {
                System.out.println("Doctor not found - Please try again");
            }
        }

            System.out.print("Enter a new name (leave blank if not changing): ");
            String updatedName = scanner.nextLine();
            if (updatedName.isEmpty()) updatedName = doctor.getName();

            System.out.print("Enter a new age (leave blank if not changing): ");
            String ageInput = scanner.nextLine();
            int updatedAge = ageInput.isEmpty() ? doctor.getAge() : Integer.parseInt(ageInput);

            System.out.print("Enter a new phone number (leave blank if not changing): ");
            String updatedPhone = scanner.nextLine();
            if (updatedPhone.isEmpty()) updatedPhone = doctor.getPhoneNumber();

            System.out.print("Enter a new specialization (leave blank if not changing): ");
            String updatedSpecialization = scanner.nextLine();
            if (updatedSpecialization.isEmpty()) updatedSpecialization = doctor.getSpecialization();

            system.editDoctor(doctor.getId(), updatedName, updatedAge, updatedPhone, updatedSpecialization);

            System.out.println("\nUpdated Doctor Information: " + doctor + "\n");
    }

    
    private static void editMedication(Scanner scanner, MedicationTracking system) {
    System.out.println("\n===== Edit Medication Information =====");
    Medication medication = null;
    while (medication == null) {
        System.out.print("Enter medication name to edit medication information: ");
        String medName = scanner.nextLine();
        medication = system.getMedicationByNameNoPrint(medName);
        if (medication == null) {
            System.out.println("Medication not found - Please try again");
        }
    }

        System.out.print("Enter a new name (leave blank if not changing): ");
        String updatedName = scanner.nextLine();
        if (updatedName.isEmpty()) updatedName = medication.getName();

        System.out.print("Enter a new dosage (leave blank if not changing): ");
        String updatedDosage = scanner.nextLine();
        if (updatedDosage.isEmpty()) updatedDosage = medication.getDosage();

        System.out.print("Enter a new quantity in stock (leave blank if not changing): ");
        String quantityInput = scanner.nextLine();
        int updatedQuantity = quantityInput.isEmpty() ? medication.getQuantityInStock() : Integer.parseInt(quantityInput);

        System.out.print("Enter a new expiry date (YYYY-MM-DD, leave blank if not changing): ");
        String expiryInput = scanner.nextLine();
        java.time.LocalDate updatedExpiry = expiryInput.isEmpty() ? medication.getExpiryDate() : java.time.LocalDate.parse(expiryInput);

        system.editMedication(medication.getId(), updatedName, updatedDosage, updatedQuantity, updatedExpiry);

        System.out.println("\nUpdated Medication Information: " + medication + "\n");
    }
    

    private static void assignPatientToDoctor(Scanner scanner, MedicationTracking system) {
        System.out.println("\n===== Assign Patient to Doctor =====");
        String patientName = null;
        while (patientName == null) {
            System.out.print("Enter patient name to assign to a doctor: ");
            String patientInput = scanner.nextLine();
            Patient patient = system.getPatientByNameNoPrint(patientInput);
            if (patient != null) {
                patientName = patientInput;
            } else {
                System.out.println("Patient not found - Please try again");
            }
        }

        String doctorName = null;
        while (doctorName == null) {
            System.out.print("Enter doctor's name: ");
            String doctorInput = scanner.nextLine();
            Doctor doctor = system.getDoctorByNameNoPrint(doctorInput);
            if (doctor != null) {
                doctorName = doctorInput;
            } else {
                System.out.println("Doctor not found - Please try again");
            }
        }

        system.assignPatientToDoctor(doctorName, patientName);
    }

    private static void searchPatientByName(Scanner scanner, MedicationTracking system) {
        System.out.println("Enter patient's name to search: ");
        String patientName = scanner.nextLine();

        Patient patient = system.getPatientByNameNoPrint(patientName);
        if (patient != null) {
            System.out.println("Patient found: " + patient);
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void searchDoctorByName(Scanner scanner, MedicationTracking system) {
        System.out.println("Enter doctor's name to search: ");
        String doctorName = scanner.nextLine();

        Doctor doctor = system.getDoctorByNameNoPrint(doctorName);
        if (doctor != null) {
            System.out.println("Doctor found: " + doctor);
        } else {
            System.out.println("Doctor not found.");
        }
    }

    private static void searchMedicationByName(Scanner scanner, MedicationTracking system) {
        System.out.println("Enter medication's name to search: ");
        String medicationName = scanner.nextLine();

        Medication medication = system.getMedicationByNameNoPrint(medicationName);
        if (medication != null) {
            System.out.println("Medication found: " + medication);
        } else {
            System.out.println("Medication not found.");
        }
    }

    private static void deletePatient(Scanner scanner, MedicationTracking system) {
        System.out.print("Enter patient's name to delete: ");
        String patientName = scanner.nextLine();

        Patient patient = system.getPatientByNameNoPrint(patientName);
        if (patient != null) {
            system.deletePatientNoPrint(patient.getId());
            System.out.println("Patient deleted successfully!");
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void deleteDoctor(Scanner scanner, MedicationTracking system) {
        System.out.print("Enter doctor's name to delete: ");
        String doctorName = scanner.nextLine();

        Doctor doctor = system.getDoctorByNameNoPrint(doctorName);
        if (doctor != null) {
            system.deleteDoctorNoPrint(doctor.getId());
            System.out.println("Doctor deleted successfully!");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    private static void deleteMedication(Scanner scanner, MedicationTracking system) {
        System.out.print("Enter medication's name to delete: ");
        String medicationName = scanner.nextLine();

        Medication medication = system.getMedicationByNameNoPrint(medicationName);
        if (medication != null) {
            system.deleteMedicationNoPrint(medication.getId());
            System.out.println("Medication deleted successfully!");
        } else {
            System.out.println("Medication not found.");
        }
    }
}