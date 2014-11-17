package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteCustomer {
    public static void main(String[] args) {
        // check for the required command-line arguments
        if (args.length < 2) {
            System.err.println("Usage: DeleteCustomer <url> <customer-id>");
            System.exit(1);
        }
        String url = args[0];
        String customerID = args[1];
        try {
            // Connect to the database
            Connection con = DriverManager.getConnection(url);
            try {
                // define the SQL DELETE statement
                String sql = "DELETE FROM Customers WHERE CustomerID=?";
                // prepare the statement ('?' denotes a parameter)
                PreparedStatement stmt = con.prepareStatement(sql);
                try {
                    // add the customerID parameter (marked with '?')
                    stmt.setString(1, customerID);
                    // run the SQL statement
                    int result = stmt.executeUpdate();
                    System.out.println(result + " customer(s) deleted.");
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
