import java.util.ArrayList;
import java.util.List;

/**
 * Represents a doctor in the pharmacy system.
 * Inherits from the Person class and includes a specialization and a list of assigned patients.
 */

public class Doctor extends Person {
    /**
     * The doctor's area of specialization.
     */
    private String specialization;

    /**
     * The list of patients assigned to this doctor.
     */
    private List<Patient> patients;

    /**
     * Constructs a new Doctor with the specified details.
     *
     * @param id             The unique ID of the doctor.
     * @param name           The name of the doctor.
     * @param age            The age of the doctor.
     * @param phoneNumber    The phone number of the doctor.
     * @param specialization The doctor's area of specialization.
     */
    public Doctor(String id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    /**
     * Gets the doctor's specialization.
     *
     * @return The specialization.
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Sets the doctor's specialization.
     *
     * @param specialization The new specialization.
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Gets the list of patients assigned to this doctor.
     *
     * @return The list of patients.
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Assigns a patient to this doctor if not already assigned.
     *
     * @param patient The patient to add.
     */
    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    /**
     * Removes a patient from this doctor's list.
     *
     * @param patient The patient to remove.
     */
    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    
    /**
     * Returns a string representation of the doctor, including specialization and patient count.
     *
     * @return A string with doctor details.
     */
    public String toString() {
        return super.toString() + " | Specialization: " + specialization + " | Patients: " + patients.size();
    }
}