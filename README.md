Password Vault (COMMAND LINE INTERFACE) Using JAVA
----------------------------------------------------------
A simple yet secure Password Manager built using Java, AES Encryption, and File Storage.
It allows users to add, view, edit, and delete passwords securely from a command-line interface.

# Features
AES Encryption (javax.crypto) for all stored passwords

Master Password Authentication before accessing the vault

Secure File Storage: encrypted passwords saved in vault.txt

# CRUD Operations:

Add new password

View all stored passwords

Edit existing passwords

Delete passwords

Modular Code Structure (separate utility and service classes)

Extensible for Android app or GUI integration

 # Project Structure

src/
  ├── CryptoUtil.java   # Handles AES encryption and decryption
  ├── PasswordVault.java # Core vault operations (add, view, edit, delete)
  └── Main.java         # Main user interface and control flow
vault.txt               # Auto-generated encrypted vault file

# Technologies Used
Java 8+

AES Encryption (128-bit)

File I/O (FileReader, FileWriter, BufferedReader)

Basic Exception Handling

# How to Run
## Clone this repo:

git clone https://github.com/yourusername/password-vault.git
cd password-vault

## Compile Java files:

javac src/*.java

## Run the application:

java -cp src Main

Enter the Master Password (default is MySecretKey12345).

# Example Flow

Enter Master Password: MySecretKey12345

1. Add Password
2. View Passwords
3. Edit Password
4. Delete Password
5. Exit
Enter your choice: 1

Enter site name: Gmail
Enter password: gmail@123

Password saved successfully!

Enter your choice: 1
Enter site name: Instagram 
Enter password: instaPass!2024

Password saved successfully!

## View Stored Passwords
rust
Copy
Edit
Enter your choice: 2
Gmail -> myGmail@123
Instagram -> instaPass!2024

## Edit a Password
Enter your choice: 3
Enter site name to edit: Gmail
Enter new password: newGmailPass@321
Password updated successfully.

## View Again After Edit
Enter your choice: 2
Gmail -> newGmailPass@321
Instagram -> instaPass!2024

## Delete a Password
Enter your choice: 4
Enter site name to delete: Instagram
Password deleted successfully.

## View After Deletion
Enter your choice: 2
Gmail -> newGmailPass@321

Enter your choice: 5
Exiting Password Vault. Goodbye!

# vault.txt File after all operations
If you open the file manually, it contains something like:

Gmail:EncryptedDataHere
(Encrypted password, safe even if someone opens the file!)

