import java.util.Random;
import java.time.LocalDate;

public class Medication {
    private String id;
    private String name;
    private String dosage;
    private int quantityInStock;
    private LocalDate expiryDate;

    // Constructor
    public Medication(String id, String name, String dosage, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomDate();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDosage() {
        return dosage;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    private LocalDate generateRandomDate() {
        Random random = new Random();
        int daysOffset = random.nextInt(4 * 365) - (2 * 365);
        return LocalDate.now().plusDays(daysOffset);
    }

    // to String method
    public String toString() {
        return ("ID: " + id +
        " | Name: " + name +
        " | Dosage: " + dosage +
        " | Quantity in Stock: " + quantityInStock +
        " | Expiry Date: " + expiryDate);
    }

}
