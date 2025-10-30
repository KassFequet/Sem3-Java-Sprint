/**
 * The Person class is an abstract base class representing a person in the pharmacy system.
 * It provides common fields and methods for subclasses such as Doctor and Patient.
 */

public abstract class Person {
    /**
     * The unique ID of the person.
     */
    protected String id;

    /**
     * The name of the person.
     */
    protected String name;

    /**
     * The age of the person.
     */
    protected int age;

    /**
     * The phone number of the person.
     */
    protected String phoneNumber;

    /**
     * Constructs a new Person with the specified details.
     *
     * @param id          The unique ID of the person.
     * @param name        The name of the person.
     * @param age         The age of the person.
     * @param phoneNumber The phone number of the person.
     */
    public Person(String id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the unique ID of the person.
     *
     * @return The person's ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique ID of the person.
     *
     * @param id The new ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name of the person.
     *
     * @return The person's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of the person.
     *
     * @return The person's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age The new age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the phone number of the person.
     *
     * @return The person's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the person.
     *
     * @param phoneNumber The new phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns a string representation of the person, including ID, name, age, and phone number.
     *
     * @return A string with person details.
     */
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Phone Number: " + phoneNumber;
    }
}
