# Contact_Manager-
:

📞 Contact Manager (Java Console Application)
A simple Java console-based application to manage contacts. It allows users to add, view, edit, and delete contacts. The data is saved to a file named contacts.txt so it persists across sessions.

✅ Features
➕ Add Contact

📋 View All Contacts

📝 Edit Existing Contact

❌ Delete Contact

💾 Save Contacts to File

📂 Load Contacts from File (on startup)

🧾 File Structure
bash
Copy
Edit
📁 ContactManager/
 ┣ 📄 ContactManager.java   ← Main Java source file
 ┣ 📄 contacts.txt           ← Saved contacts (auto-created)
 ┗ 📄 README.md              ← Project description
💻 How to Run
Ensure Java is installed on your system.

1. Compile
javac ContactManager.java
2. Run
java ContactManager
🧠 Technologies Used
Java

File I/O (BufferedReader, BufferedWriter)

ArrayList for contact storage

Basic Console UI (Scanner)

📂 Data Storage
All contacts are saved in a plain text file named contacts.txt in the following format:


Name,Phone,Email
John Doe,1234567890,john@example.com
🔒 Note
This is a basic version. No validations or advanced search features are included yet. Suitable for beginners learning Java, file handling, and simple CRUD logic.

👨‍💻 Author
Akash Singh


