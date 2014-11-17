package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddCustomer {
    public static void main(String[] args) {
        // check for the required command-line arguments
        if (args.length < 3) {
            System.err.println("Usage: AddCustomer <url> <customer-id> "
                    + "<company-name> <contact-name> <contact-title> "
                    + "<address> <city> <region> <postal-code> "
                    + "<country> <phone> <fax>");
            System.exit(1);
        }
        // the the a values
        String url = args[0];
        try {
            // Connect to the database
            Connection con = DriverManager.getConnection(url);
            try {
                // define the SQL INSERT statement
                String sql = "INSERT INTO Customers VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                // prepare the statement
                PreparedStatement stmt = con.prepareStatement(sql.toString());
                try {
                    // add the customer parameters (marked with '?')
                    for (int i = 1; i < args.length; i++) {
                        stmt.setString(i, args[i]);
                    }
                    // run the SQL statement
                    int result = stmt.executeUpdate();
                    if (result == 0) {
                        System.out.println("Customer not added.");
                    } else {
                        System.out.println("Customer added.");
                    }
                } finally {
                    stmt.close(); // release the statement
                }
            } finally {
                con.close(); // release the connection
            }
        } catch (Exception e) {
            e.printStackTrace(); // "handle" errors
        }
    }
}
