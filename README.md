# Online Banking System (ATM Project)

The **ATM Project** is a Java-based console application that uses **MySQL** as its backend database. It provides essential features of an online banking system such as creating and updating accounts, handling deposits and withdrawals, and checking balances. The project is fully menu-driven and uses JDBC for database connectivity.

---

## Features

- **Account Management**
  - Create a new account with details (Name, Age, Email, Mobile, City, Balance, Type)
  - Update account details (Name, Age, Email, Mobile, City, Type)
  - Delete an account

- **Transaction Management**
  - Withdraw money (validates insufficient funds)
  - Credit (deposit) money to account

- **Account Information**
  - Check account balance by ID
  - View all account holders list with full details

---

## Tech Stack

- **Programming Language**: Java  
- **Database**: MySQL  
- **Connector**: JDBC  

---

## Database Structure

### Data Table (`data`)
| Column   | Type        | Description                  |
|----------|-------------|------------------------------|
| Acc_ID   | INT (PK, AI)| Unique account ID (starts 101)|
| Name     | VARCHAR     | Account holder name          |
| Age      | INT         | Account holder age           |
| Email    | VARCHAR     | Account holder email         |
| Mobile   | VARCHAR     | Account holder mobile number |
| City     | VARCHAR     | Account holder city          |
| Balance  | DOUBLE      | Current balance in account   |
| Type     | VARCHAR     | Account type (Current/Savings)|

---

## How to Run

1. Clone the repository or copy the source code.  
2. Create a MySQL database named **ATM**.  
3. Create the required table (`data`) using the schema above.  
4. Update your MySQL credentials inside the code:  
   ```java
   Connection con = DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/ATM", "root", "your_password_here"
   );
   ```
5. Compile and run the project:  
   ```bash
   javac Project_ATM.java
   java Project_ATM
   ```

---

## Future Enhancements

- Add PIN-based login system for accounts  
- Provide transaction history (mini statement)  
- Support for interest calculation on savings accounts  
- GUI-based implementation for better user experience 


## 📞 Contact

For any questions or feedback regarding this project, feel free to reach out:  

- **Name:** Fahad Shamshad  
- **Email:** fahads19080@gmail.com  
- **GitHub:** [github.com/Fahad-sh06](https://github.com/Fahad-sh06)  
- **LinkedIn:** [linkedin.com/in/fahad-shamshad-8118ba312](https://www.linkedin.com/in/fahad-shamshad-8118ba312/)  

