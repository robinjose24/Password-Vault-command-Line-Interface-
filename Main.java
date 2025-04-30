// Main.java
import java.util.*;

public class Main {
    private static final String MASTER_PASSWORD = "MySecretKey12345"; // Must be 16 chars

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Master Password: ");
        String inputKey = sc.nextLine();

        if (!inputKey.equals(MASTER_PASSWORD)) {
            System.out.println("Incorrect Master Password. Access Denied.");
            return;
        }

        PasswordVault vault = new PasswordVault(MASTER_PASSWORD);

        while (true) {
    System.out.println("\n1. Add Password");
    System.out.println("2. View Passwords");
    System.out.println("3. Edit Password");
    System.out.println("4. Delete Password");
    System.out.println("5. Exit");
    System.out.print("Enter your choice: ");
    
    int choice = sc.nextInt();
    sc.nextLine(); // consume newline

    if (choice == 1) {
        System.out.print("Enter site name: ");
        String site = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        vault.addEntry(site, password);
        System.out.println("Password saved successfully.");
    } else if (choice == 2) {
        vault.viewEntries();
    } else if (choice == 3) {
        System.out.print("Enter site name to edit: ");
        String site = sc.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = sc.nextLine();
        vault.editEntry(site, newPassword);
    } else if (choice == 4) {
        System.out.print("Enter site name to delete: ");
        String site = sc.nextLine();
        vault.deleteEntry(site);
    } else if (choice == 5) {
        System.out.println("Exiting Password Vault. Goodbye!");
        break;
    } else {
        System.out.println("Invalid choice. Try again.");
    }
}


        sc.close();
    }
}
