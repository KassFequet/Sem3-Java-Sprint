import java.util.Random;
import java.time.LocalDate;

/**
 * Represents a medication in the pharmacy system.
 * Stores information such as ID, name, dosage, quantity in stock, and expiry date.
 */
public class Medication {
    /**
     * The unique ID of the medication.
     */
    private String id;
    /**
     * The name of the medication.
     */
    private String name;
    /**
     * The dosage information for the medication.
     */
    private String dosage;
    /**
     * The quantity of this medication currently in stock.
     */
    private int quantityInStock;
    /**
     * The expiry date of the medication.
     */
    private LocalDate expiryDate;

    /**
     * Constructs a new Medication with the specified details.
     * The expiry date is randomly generated within a range of +/- 2 years from today.
     *
     * @param id              The unique ID of the medication.
     * @param name            The name of the medication.
     * @param dosage          The dosage information.
     * @param quantityInStock The quantity in stock.
     */
    public Medication(String id, String name, String dosage, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomDate();
    }

    /**
     * Gets the unique ID of the medication.
     *
     * @return The medication ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the name of the medication.
     *
     * @return The medication name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the dosage information for the medication.
     *
     * @return The medication dosage.
     */
    public String getDosage() {
        return dosage;
    }

    /**
     * Gets the quantity of this medication currently in stock.
     *
     * @return The quantity in stock.
     */
    public int getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * Gets the expiry date of the medication.
     *
     * @return The expiry date.
     */
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the unique ID of the medication.
     *
     * @param id The medication ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the name of the medication.
     *
     * @param name The medication name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the dosage information for the medication.
     *
     * @param dosage The medication dosage.
     */
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    /**
     * Sets the quantity of this medication currently in stock.
     *
     * @param quantityInStock The quantity in stock.
     */
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    /**
     * Sets the expiry date of the medication.
     *
     * @param expiryDate The expiry date.
     */
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Generates a random expiry date within +/- 2 years from today.
     *
     * @return A randomly generated expiry date.
     */
    private LocalDate generateRandomDate() {
        Random random = new Random();
        int daysOffset = random.nextInt(4 * 365) - (2 * 365);
        return LocalDate.now().plusDays(daysOffset);
    }

    /**
     * Returns a string representation of the medication, including all details.
     *
     * @return A string with medication details.
     */
    public String toString() {
        return ("ID: " + id +
        " | Name: " + name +
        " | Dosage: " + dosage +
        " | Quantity in Stock: " + quantityInStock +
        " | Expiry Date: " + expiryDate);
    }

}
