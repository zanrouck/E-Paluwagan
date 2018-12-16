package mypackage;
import java.sql.*;
import java.util.Scanner;

/**
 * @(#)REGISTRATION.java
 *
 *
 * @author GUZMAN, Franz Vittoria
 * @version 1.00 2018/12/15
 *
 *
 * This program serves as E- Paluwagan's Registry
 */

public class REGISTRATION {

    private static Connection con;
    private static Statement state;
    private static ResultSet rs;
    private static PreparedStatement pstm;

    private static String patientid = "";
    private static String idNum = "";
    private static String firstName = "";
    private static String lastName = "";
    private static String addr = "";
    private static String uname = "";
    private static String email = "";
    private static String gCashAcct = "";

    private static String birthdate = "";

    private static String contactNum = "";
    private static String passwd = "";

    private static String query = "";

    public static void main ( String[] args ) throws Exception {
        Scanner kbd = new Scanner ( System.in );
        Class.forName("com.mysql.jdbc.Driver");
        Connect("e_paluwagan", "root", "");

        while ( true ) {

            menu1();

            try {
                int choice = Integer.parseInt(kbd.nextLine());

                if ( choice < 1 || choice > 8 ) {
                    System.out.println("Invalid input!");

                } else {
                    switch ( choice ) {
                        case 1 : administrator(); break;
                        case 2 : userLogin(); break;
                        case 3 : registerAccount(); break;
                        case 4 : home(); break;
                        case 5 : group(); break;
                        case 6 : createGroup(); break;
                        case 7 : removeStudent(); break;
                        case 8 : groupManagement(); break;
                        case 10 : return;
                        default : break;
                    }
                }
            } catch ( Exception e ) {
                System.out.println(e.getMessage());
            }
        }
    }

        // Establishes a connection
        private static void Connect ( String database, String user, String passwd ) throws Exception {
            String connect = "jdbc:mysql://localhost:3306/" + database + "?user=" + user + "&password=" + passwd;
            con = DriverManager.getConnection( connect );
            state = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
        }

        private static void menu1() {
            System.out.println("-------------------------");
            System.out.printf("%21s \n", "PERA MO! PERA KO!");
            System.out.printf("%23s \n", "E- PALUWAGAN MAIN MENU");
            System.out.println("-------------------------");

            System.out.println("  [1] ADMIN");
            System.out.println("  [2] USER LOGIN");
            System.out.println("  [3] Register an Account");
            System.out.println("  [4] Home");
            System.out.println("  [5] Groups");
            System.out.println("  [6] Create Group");
            System.out.println("  [7] Contact Us"); // NA
            System.out.println("  [8] Group Management");
            System.out.println("  [9] Exit");

            System.out.print("\nEnter your choice: ");
        } // end of menu1()

// =====================================================================================================================================

        // administrator()
        public static void administrator() throws Exception {
            Scanner kbd = new Scanner(System.in);

            System.out.print("Admin ID or Email: ");
            String admin = kbd.nextLine();

            query = "select adminId,adminEmail, adminName, adminContactNumber from epgadmin where adminId = ? or adminEmail = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, admin);
            pstm.executeQuery();
            rs = pstm.executeQuery();

            if ( rs.next() == true ) {
                System.out.println("  [1] View the login status of the users");
                System.out.println("  [2] View NEWLY Registered Students");
                System.out.print("  > ");
                String option = kbd.nextLine();

                switch ( option ) {
                    case "1" :
                        query = "select logId,date,studId,groupId,gmpId from paymentdetails";
                        pstm = con.prepareStatement(query);
                        rs = pstm.executeQuery();

                        System.out.printf("%-25s %-25s %-25s %-25s %-25s \n", "Login_ID", "Date", "Student_ID", "Group_ID", "GM_ID");
                        System.out.println("-------------------------------------------------------------");
                        rs.beforeFirst();

                        while ( rs.next() ) {
                            String login = rs.getString("logId");
                            String date = rs.getString("date");
                            int studID = rs.getInt("studId");
                            int grpID = rs.getInt("groupId");
                            int gmpID = rs.getInt("gmpId");
                            System.out.printf("%-25s %-25s %-25s %-25s %-25s \n", login, date, studID, grpID, gmpID);
                        }

                    case "2" :
                        query = "select StudId,StudName,StudAddress,StudContactNumber,StudEmail,StudBirthday,GCashAccount from student";
                        pstm = con.prepareStatement(query);
                        rs = pstm.executeQuery();

                        System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s %-25s %-25s \n", "Login_ID", "Student_ID#", "StudentName", "Address", "Contact#", "Email", "Birthdate", "GCashAccount");
                        System.out.println("----------------------------------------------------------------------");
                        rs.beforeFirst();

                        while ( rs.next() ) {
                            int studID = rs.getInt("StudId");
                            String name = rs.getString("StudName");
                            String addr = rs.getString("StudAddress");
                            String contactNum = rs.getString("StudContactNumber");
                            String email = rs.getString("StudEmail");
                            String birthdate = rs.getString("StudBirthday");
                            String gCashAcct = rs.getString("GCashAccount");
                            System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s %-25s \n", studID, name, addr, contactNum, email, birthdate, gCashAcct);
                        }
                }
                return;

            }
        } // end of administrator()

// =====================================================================================================================================

        // userLogin() ###
        public static void userLogin() throws Exception {
            Scanner kbd = new Scanner(System.in);

            System.out.print("Username or Email: ");
            uname = kbd.nextLine();

            System.out.print("Password: ");
            passwd = kbd.nextLine();

            query = "select StudEmail from student where StudEmail = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, uname);
            pstm.setString(2, passwd);
            pstm.executeQuery();
            rs = pstm.executeQuery();

            if ( rs.next() == true ) {
                System.out.print("Would you like to view your status in the group?(y/n): ");
                String option = kbd.nextLine();

                switch ( option ) {
                    case "n" :
                        break;

                    case "y" :
                        query = "select status,studId,paymentId from paymentdetails";
                        pstm = con.prepareStatement(query);
                        rs = pstm.executeQuery();
                        System.out.printf("%-25s %-25s %-25s \n", "Status", "ID_#", "Payment_ID");
                        System.out.println("--------------------------------------------------");
                        rs.beforeFirst();

                        while ( rs.next() ) {
                            String status = rs.getString("status");
                            String idnum = rs.getString("studId");
                            int paymentId = rs.getInt("paymentId");
                            System.out.printf("%-25s %-25s %-25s \n",status, idnum, paymentId);
                        }
                }
                return;
            }
        } // end of userLogin()

// =====================================================================================================================================

        // registerAccount() ###
        private static void registerAccount() throws Exception {
            Scanner kbd = new Scanner(System.in);

            System.out.println("");
            System.out.print("Student ID Number: ");
            idNum = kbd.nextLine();

            System.out.print("First Name: ");
            firstName = kbd.nextLine();

            System.out.print("Last Name: ");
            lastName = kbd.nextLine();

            System.out.print("Address: ");
            addr = kbd.nextLine();

            System.out.print("Contact #: ");
            contactNum = kbd.nextLine();

            System.out.print("Username: ");
            uname = kbd.nextLine();

            System.out.print("Email: ");
            email = kbd.nextLine();

            System.out.println("Birthdate ( YYYY/MM/DD ): ");
            birthdate = kbd.nextLine();

            System.out.print("GCash Account: ");
            gCashAcct = kbd.nextLine();

            System.out.print("Password: ");
            passwd = kbd.nextLine();

            query = "insert into student (StudId,StudName,StudAddress,StudContactNumber,StudEmail,StudBirthday,GCashAccount) values (?, ?, ?, ?, ?, ?, ?)";
            pstm = con.prepareStatement(query);
            pstm.setString(1, idNum);
            pstm.setString(2, firstName);
            pstm.setString(3, lastName);
            pstm.setString(4, addr);
            pstm.setString(5, contactNum);
            pstm.setString(6, uname);
            pstm.setString(7, email);
            pstm.setString(8, birthdate);
            pstm.setString(9, gCashAcct);
            pstm.execute();

            System.out.println("Student Added!");
}

// =====================================================================================================================================

        public static void home() throws Exception {
            // INSERT NECESSARY CODES HERE ###
        } // end of home()

// =====================================================================================================================================

        // group() ###
        public static void group() throws Exception {
            Scanner kbd = new Scanner(System.in);

            while ( true ) {
                System.out.print("Search by student ID #: ");
                String choicelist = kbd.nextLine();

                System.out.println("");
                query = "select s.allocatedContrib,s.studId,s.groupId,p.paymentId,p.payDate,p.amount from payment p join studgrp s where studId = ?";
                pstm = con.prepareStatement(query);
                rs = pstm.executeQuery();
                System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s \n", "Allocated Contribution", "ID_#", "Group_ID", "Payment_ID", "Pay_Date", "Amount");
                System.out.println("----------------------------------------------------------------------");
                rs.beforeFirst();

                int contrib = rs.getInt("allocatedContrib");
                String idnum = rs.getString("studId");
                int grpId = rs.getInt("groupId");
                int paymentId = rs.getInt("paymentId");
                String payDate = rs.getString("payDate");
                int amount = rs.getInt("amount");
                System.out.printf("%-25s %-25s %-25s %-25s \n", contrib, idnum, grpId, paymentId, payDate, amount);

                if ( rs.next() == false ) {
                    System.out.println("Student ID # was not found!");
                    removeStudent();
                }
            }
        } // end of group()

// =====================================================================================================================================

        // createGroup() ###
        public static void createGroup() throws Exception {
            Scanner kbd = new Scanner(System.in);

            System.out.println("");
            System.out.print("Group ID: ");
            int grpID = kbd.nextInt();

            System.out.print("Group Name: ");
            String grpName = kbd.nextLine();

            System.out.print("Date Start (YYYY/MM/DD): ");
            String dateStart = kbd.nextLine();

            System.out.print("Date End (YYYY/MM/DD): ");
            String dateEnd = kbd.nextLine();

            query = "insert into epaluwagangroup (groupId,groupName,groupDateStart,groupDateEnd) values (?, ?, ?, ?)";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, grpID);
            pstm.setString(2, grpName);
            pstm.setString(3, dateStart);
            pstm.setString(4, dateEnd);
            pstm.execute();

            System.out.println("Group Added!");
        } // end of createGroup()

// =====================================================================================================================================

        // removeStudent() ###
        public static void removeStudent() throws Exception {
            Scanner kbd = new Scanner(System.in);

            System.out.println("");
            System.out.print("Enter the student's first name: ");
            String fname = kbd.nextLine();

            query = "select studId from student where StudName LIKE '?'";
            pstm = con.prepareStatement(query);
            pstm.setString(1, fname);
            pstm.executeQuery();
            rs = pstm.executeQuery();

            if ( rs.next() == false ) {
                System.out.println("Student's record was not found!");
                removeStudent();
            }

            String idnumber = rs.getString("studId");
            query = "DELETE FROM student WHERE studId = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, idnumber);

            System.out.print("Are you sure?(y/n): ");
            String option = kbd.nextLine();

            switch ( option ) {
                case "n" :
                    break;

                case "y" :
                    pstm.executeUpdate();
                    System.out.println("Student's record was successfully removed!");
                    break;

                default :
                    System.out.println("Invalid Input!");
                    break;
            }
        } // end of removeStudent()

// =====================================================================================================================================

    // groupManagement() ###
    public static void groupManagement() throws Exception {
        Scanner kbd = new Scanner(System.in);

        System.out.println("");
        System.out.print("Enter group manager's ID: ");
        String gmpId = kbd.nextLine();

        query = "select gmpId,grpReport,groupId,studId from groupmanager where gmpId = ?";
        pstm = con.prepareStatement(query);
        pstm.setString(1, gmpId);
        pstm.executeQuery();
        rs = pstm.executeQuery();

        if ( rs.next() == false ) {
            System.out.println("The Group's record was not found!");
            removeStudent();
        }
    } // end of groupManagement()

// =====================================================================================================================================



} // end of REGISTRATION class