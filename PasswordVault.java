// PasswordVault.java
import java.io.*;
import java.util.*;

public class PasswordVault {
    private static final String FILE_NAME = "vault.txt";
    private String masterKey;

    public PasswordVault(String masterKey) {
        this.masterKey = masterKey;
    }

    public void addEntry(String site, String password) throws Exception {
        String encrypted = CryptoUtil.encrypt(password, masterKey);
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(site + ":" + encrypted + "\n");
        }
    }

    public void viewEntries() throws Exception {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Vault is empty.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String decrypted = CryptoUtil.decrypt(parts[1], masterKey);
                    System.out.println(parts[0] + " -> " + decrypted);
                }
            }
        }
    }

// Edit an existing entry
public void editEntry(String site, String newPassword) throws Exception {
    List<String> lines = new ArrayList<>();
    boolean found = false;

    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(":");
            if (parts[0].equalsIgnoreCase(site)) {
                String encrypted = CryptoUtil.encrypt(newPassword, masterKey);
                lines.add(site + ":" + encrypted);
                found = true;
            } else {
                lines.add(line);
            }
        }
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
        for (String l : lines) {
            bw.write(l);
            bw.newLine();
        }
    }

    if (found) {
        System.out.println("Password updated successfully.");
    } else {
        System.out.println("Site not found.");
    }
}

// Delete an entry
public void deleteEntry(String site) throws Exception {
    List<String> lines = new ArrayList<>();
    boolean found = false;

    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(":");
            if (!parts[0].equalsIgnoreCase(site)) {
                lines.add(line);
            } else {
                found = true;
            }
        }
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
        for (String l : lines) {
            bw.write(l);
            bw.newLine();
        }
    }

    if (found) {
        System.out.println("Password deleted successfully.");
    } else {
        System.out.println("Site not found.");
    }
}
}