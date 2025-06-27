import java.io.*;
import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class ContactManager {
    static final String FILE_NAME = "contacts.txt";
    static List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        loadContactsFromFile();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n📞 Contact Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid option: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addContact(scanner);
                case 2 -> viewContacts();
                case 3 -> editContact(scanner);
                case 4 -> deleteContact(scanner);
                case 5 -> saveContactsToFile();
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        scanner.close();
        System.out.println("Exiting Contact Manager.");
    }

    static void addContact(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully.");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\n--- Contact List ---");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    static void editContact(Scanner scanner) {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter the number of the contact to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        Contact contact = contacts.get(index);

        System.out.print("Enter new name (leave blank to keep '" + contact.name + "'): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) contact.name = name;

        System.out.print("Enter new phone (leave blank to keep '" + contact.phone + "'): ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) contact.phone = phone;

        System.out.print("Enter new email (leave blank to keep '" + contact.email + "'): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) contact.email = email;

        System.out.println("Contact updated.");
    }

    static void deleteContact(Scanner scanner) {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter the number of the contact to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        contacts.remove(index);
        System.out.println("Contact deleted.");
    }

    static void saveContactsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Contact contact : contacts) {
                writer.write(contact.name + "," + contact.phone + "," + contact.email);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    static void loadContactsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            contacts.clear();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    contacts.add(new Contact(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }
}