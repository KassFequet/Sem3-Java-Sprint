import java.util.Random;
import java.util.UUID;
import java.time.LocalDate;

public class Medication {
    private final String id;
    private String name;
    private String dosage;
    private int quantityInStock;
    private LocalDate expiryDate;

    // Constructor
    public Medication(String name, String dosage, int quantityInStock){
        this.id = generateRandomID();
        this.name = name;
        this.dosage = dosage;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomDate();
    }

    // Helper methods
    public String generateRandomID(){
        return UUID.randomUUID().toString();
    }

    private LocalDate generateRandomDate() {
        Random random = new Random();
        int daysOffset = random.nextInt(4 * 365) - (2 * 365);
        return LocalDate.now().plusDays(daysOffset);
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

    public String toString() {
        return ("Medication ID: " + id +", Name: " + name + ", Dosage: " + dosage +", Quantity in Stock: " + quantityInStock + ", Expiry Date: " + expiryDate);
    }

}
