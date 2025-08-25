import java.sql.*;
import java.util.Scanner;
public class Project_ATM // database ATM is used for this project
{
    static Scanner SC = new Scanner(System.in);
    public static void main(String[]args) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con_in = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM","root","idkmypasssry01@");
        String  first_id = "alter table data auto_increment = 101;";
        Statement st = con_in.createStatement();
        st.executeUpdate(first_id);
        con_in.close();
        boolean res = true;
        while (res)
        {
            System.out.println("Online Banking System");
            System.out.println("----------------------");
            System.out.println("1. Create Account");
            System.out.println("2. Update Account");
            System.out.println("3. Delete Account");
            System.out.println("4. Check Account Balance");
            System.out.println("5. Check Account Holder List");
            System.out.println("6. Withdraw Amount");
            System.out.println("7. Credit Amount");
            System.out.println("8. Exit");
            System.out.print("Choice : ");
            int choice = SC.nextInt();
            SC.nextLine();
            switch(choice)
            {
                case 1:
                    createAccount();
                    break;
                case 2:
                    updateAccount();
                    break;
                case 3:
                    deleteAccount();
                    break;
                case 4:
                    checkAccountBalance();
                    break;
                case 5:
                    accHolderList();
                    break;
                case 6:
                    withdraw();
                    break;
                case 7:
                    credit();
                    break;
                case 8:
                    res = false;
                    break;
            }
        }
    }
    static void createAccount() throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM","root","idkmypasssry01@");
        String cr_acc = "insert into data(Name,Age,Email,Mobile,City,Balance,Type) values(?,?,?,?,?,?,?);";
        System.out.print("Enter your name : ");
        String name = SC.nextLine();
        System.out.print("Enter your age : ");
        int age = SC.nextInt();
        SC.nextLine();
        System.out.print("Enter your email : ");
        String email = SC.nextLine();
        System.out.print("Enter your mobile no : ");
        String number = SC.nextLine();
        System.out.print("Enter your city : ");
        String city = SC.nextLine();
        System.out.print("Intitial Deposit for account opening : ");
        double balance = SC.nextDouble();
        SC.nextLine();
        System.out.print("ATM type (Current/Savings) : ");
        String type = SC.nextLine();
        PreparedStatement pst = con.prepareStatement(cr_acc);
        try
        {
            pst.setString(1,name);
            pst.setInt(2,age);
            pst.setString(3,email);
            pst.setString(4,number);
            pst.setString(5,city);
            pst.setDouble(6,balance);
            pst.setString(7,type);
            int result = pst.executeUpdate();
            if(result > 0){System.out.println("\n------Account created sucessfully------\n");}
        }
        catch (Exception e)
        {
            e.printStackTrace(); 
        }
        con.close();
    }
    static void updateAccount() throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM","root","idkmypasssry01@");
        String change_qr;
        System.out.print("Enter your id : ");
        int id = SC.nextInt();
        System.out.println("Select option you want to change : ");
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. Email");
        System.out.println("4. Mobile");
        System.out.println("5. City");
        System.out.println("6. Type of account");
        int ch = SC.nextInt();
        SC.nextLine();
        switch(ch)
        {
            case 1: // Change Name
                System.out.print("Enter new name : ");
                String nam = SC.nextLine();
                change_qr = "update data set Name=? where Acc_ID=?";
                PreparedStatement pst = con.prepareStatement(change_qr);
                try
                {
                    pst.setString(1,nam);
                    pst.setInt(2,id);
                    int result = pst.executeUpdate();
                    if(result > 0){System.out.println("\n------Changes saved------\n");}
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case 2: // Change Age
                System.out.print("Enter new age : ");
                int ag = SC.nextInt();
                change_qr = "update data set Age=? where Acc_ID=?";
                PreparedStatement pst2 = con.prepareStatement(change_qr);
                try
                {
                    pst2.setInt(1,ag);
                    pst2.setInt(2,id);
                    int result = pst2.executeUpdate();
                    if(result > 0){System.out.println("\n------Changes saved------\n");}
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case 3: // Change Email
                System.out.print("Enter new email : ");
                String email = SC.nextLine();
                change_qr = "update data set Email=? where Acc_ID=?";
                PreparedStatement pst3 = con.prepareStatement(change_qr);
                try
                {
                    pst3.setString(1,email);
                    pst3.setInt(2,id);
                    int result = pst3.executeUpdate();
                    if(result > 0){System.out.println("\n------Changes saved------\n");}
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
                
            case 4: // change mobile
                System.out.print("Enter new mobile no. : ");
                String mob = SC.nextLine();
                change_qr = "update data set Mobile=? where Acc_ID=?";
                PreparedStatement pst4 = con.prepareStatement(change_qr);
                try
                {
                    pst4.setString(1,mob);
                    pst4.setInt(2,id);
                    int result = pst4.executeUpdate();
                    if(result > 0){System.out.println("\n------Changes saved------\n");}
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
            case 5: // change city
                System.out.print("Enter new city : ");
                String city = SC.nextLine();
                change_qr = "update data set City=? where Acc_ID=?";
                PreparedStatement pst5 = con.prepareStatement(change_qr);
                try
                {
                    pst5.setString(1,city);
                    pst5.setInt(2,id);
                    int result = pst5.executeUpdate();
                    if(result > 0){System.out.println("\n------Changes saved------\n");}
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break; 
            case 6: // change type
                System.out.print("Enter new type : ");
                String type = SC.nextLine();
                change_qr = "update data set Type=? where Acc_ID=?";
                PreparedStatement pst6 = con.prepareStatement(change_qr);
                try
                {
                    pst6.setString(1,type);
                    pst6.setInt(2,id);
                    int result = pst6.executeUpdate();
                    if(result > 0){System.out.println("\n------Changes saved------\n");}
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                break;
        }
    }
    static void checkAccountBalance() throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM","root","idkmypasssry01@");
        String change_qr;
        System.out.print("Enter your id : ");
        int id = SC.nextInt();
        String show_balance = "select Balance from data where Acc_ID=?;";
        PreparedStatement pst = con.prepareStatement(show_balance);
        pst.setInt(1,id);
        double balance = 0.0;
        try
        {
            ResultSet res = pst.executeQuery();
            if (res.next()) 
            {
                balance = res.getDouble("Balance");
                System.out.printf("Account Balance for Accounnt ID %d is: ₹%.2f\n", id, balance);
            } else 
            {
                System.out.println("No account found with that ID.\n");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    static void accHolderList() throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM","root","idkmypasssry01@");
        String getall = "select *from data;";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(getall);
        System.out.println("\n------ Account Holder List ------");
        System.out.printf("%-5s %-15s %-5s %-25s %-12s %-12s %-10s %-10s\n",
        "ID", "Name", "Age", "Email", "Mobile", "City", "Balance", "Type");
        System.out.println("---------------------------------------------------------------------------------------------");

        while (rs.next()) {
            int id = rs.getInt("Acc_ID");
            String name = rs.getString("Name");
            int age = rs.getInt("Age");
            String email = rs.getString("Email");
            String mobile = rs.getString("Mobile");
            String city = rs.getString("City");
            double balance = rs.getDouble("Balance");
            String type = rs.getString("Type");
    
            System.out.printf("%-5d %-15s %-5d %-25s %-12s %-12s ₹%-9.2f %-10s\n",
                id, name, age, email, mobile, city, balance, type);
        }
        System.out.println();
        con.close();
    }
    static void withdraw() throws Exception
    {
        double bal;
        System.out.print("Enter your ID : ");
        int ID = SC.nextInt();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM","root","idkmypasssry01@");
        String qr = "select Balance from data where Acc_ID = ?";
        PreparedStatement pst = con.prepareStatement(qr);
        pst.setInt(1,ID);
        ResultSet rs = pst.executeQuery();
        rs.next();
        bal = rs.getDouble("Balance"); 
        System.out.print("Enter amount to withdraw : ");
        double amt = SC.nextDouble();
        if(amt>bal)
        {
            System.out.println("-------Insuffient funds-------\n");
        }
        else
        {
            String update = "update data set Balance = ? where Acc_ID = ?;";
            PreparedStatement pst2 = con.prepareStatement(update);
            pst2.setDouble(1,(bal-amt));
            pst2.setInt(2,ID);
            int resu = pst2.executeUpdate();
            if(resu>0)
            {
                System.out.println(amt+" withdrawn sucessfully\n");
            }
            else
            {
                System.out.println("Some error occured\n");
            }
        }
        con.close();
    }
    static void credit() throws Exception
    {
        double bal;
        System.out.print("Enter your ID : ");
        int ID = SC.nextInt();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM","root","idkmypasssry01@");
        String qr = "select Balance from data where Acc_ID = ?";
        PreparedStatement pst = con.prepareStatement(qr);
        pst.setInt(1,ID);
        ResultSet rs = pst.executeQuery();
        rs.next();
        bal = rs.getDouble("Balance"); 
        System.out.print("Enter amount to deposit : ");
        double amt = SC.nextDouble();
        String qr2 = "update data set Balance=? where Acc_ID=?;";
        PreparedStatement pst2 = con.prepareStatement(qr2);
        pst2.setDouble(1,(bal+amt));
        pst2.setInt(2,ID);
        int resu = pst2.executeUpdate();
        if(resu>0)
        {
            System.out.println(amt+" credited sucessfully\n");
        }
        else
        {
            System.out.println("Some error occured\n");
        }
        con.close();
    }
    static void deleteAccount() throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.print("Enter your ID : ");
        int ID = SC.nextInt();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM","root","idkmypasssry01@");
        String qr = "delete from data where Acc_ID=?";
        PreparedStatement pst = con.prepareStatement(qr);
        pst.setInt(1,ID);
        int resu = pst.executeUpdate();
        if(resu>0)
        {
            System.out.println("------Account deleted sucessfully------\n");
        }
        else
        {
            System.out.println("------Some error occured------\n");
        }
        con.close();
    }
}