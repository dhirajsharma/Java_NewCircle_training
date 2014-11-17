package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ShowCustomer {
    public static void main(String[] args) {
        // check for the required command-line arguments
        if (args.length < 2) {
            System.err.println("Usage: ShowCustomers <url> <customer-id>");
            System.exit(1);
        }
        String url = args[0];
        String customerID = args[1];
        try {
            // Connect to the database
            Connection con = DriverManager.getConnection(url);
            try {
                // define the SQL query statement
                String sql = "SELECT * FROM Customers WHERE CustomerID=?";
                // prepare the statement
                PreparedStatement stmt = con.prepareStatement(sql);
                try {
                    // add the customerID parameter (marked with '?')
                    stmt.setString(1, customerID);
                    // execute the SQL statement
                    ResultSet resultSet = stmt.executeQuery();
                    try {
                        // if there was a result
                        if (resultSet.next()) {
                            // get the meta data describing this result
                            ResultSetMetaData metaData = resultSet.getMetaData();
                            // for each column in the result
                            for (int column = 1; column <= metaData.getColumnCount(); column++) {
                                // print the column name and value (by index)
                                System.out.print(metaData.getColumnName(column));
                                System.out.print(": ");
                                System.out.println(resultSet.getObject(column));
                            }
                        } else {
                            // customer not found
                            System.err.println(customerID + " not found");
                        }
                    } finally {
                        resultSet.close();
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
