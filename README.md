# Pharmacy Management System

This project is a pharmacy management system designed to handle patient medications and related information. Developed using using object-oriented programming (OOP) principles, the system features multiple classes to represent key entities such as doctors, patients, medications, prescriptions, and the core medication tracking functionality.

## Features

- Add, edit, search, and delete patients, doctors, and medications
- Assign patients to doctors
- Process and manage prescriptions
- Generate system and expired medication reports
- Restock medications
- View prescriptions by doctor or patient

## Project Structure

- `Person.java` - Abstract base class for `Doctor` and `Patient`
- `Doctor.java` - Represents a doctor, including specialization and assigned patients
- `Patient.java` - Represents a patient, including medications and prescriptions
- `Medication.java` - Represents a medication, including dosage, stock, and expiry
- `Prescription.java` - Represents a prescription, linking doctor, patient, medication, and dates
- `MedicationTracking.java` - Core logic for managing all entities and operations
- `Menu.java` - Main menu-driven interface for user interaction

## How to Run

1. **Open a JavaIDE( IntelliJ IDEA, VS Code or Eclipse)**

2. **Download the repository**
    ```sh
    git clone https://github.com/KassFequet/Sem3-Java-Sprint.git
    cd Sem3-Java-Sprint
    ```

3. **Navigate to project directory**
   ```sh
   cd Sem3-Java-Sprint
   cd PharmacySystem
    ```

3. **Run the main program**
    ```sh
    java Menu
    ```

4. **Follow the on-screen menu to interact with the system.**

## Tech Stack

| **Category**        | **Details**      |
| ------------------- | ---------------- |
| **Language**        | Java             |
| **JDK Version**     | 8 or higher      |
| **Build/Run Tool**  | Java CLI         |
| **Version Control** | Git & GitHub     |

## Documentation

This repository includes two key documents:

**User Documentation:**  
  Provides an overview of the application, detailed explanations of all classes and their functionality, instructions on how to start and use the system, and a class diagram showing the relationships between entities.

**Development Documentation:**  
  Contains Javadocs, a description of the source code directory structure, build and compilation instructions, compiler-time dependencies, development standards, a theoretical database design with entity relationships, and instructions for obtaining the source code from GitHub.

## Notes

- All data is stored in memory; data will reset when the program restarts.
- Input validation is performed for most fields.

## Project Information
**Course:** Java - Software Development Program – Keyin College

**Project:** Midterm Sprint – Team Project

**Date:** October 2025

**Authors:** Kassaundra Fequet & Cameron Boyer

**Instructor:** Dr. Qurrat-Ul-Ain Malik
