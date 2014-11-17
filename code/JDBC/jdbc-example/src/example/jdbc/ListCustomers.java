package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListCustomers {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: ListCustomers <url>");
            System.exit(1);
        }
        String url = args[0];
        try {
            // Connect to the database
            Connection con = DriverManager.getConnection(url);
            try {
                String sql = "SELECT CustomerID, CompanyName, ContactName FROM Customers";
                // Create a statement
                Statement stmt = con.createStatement();
                try {
                    // execute the query
                    ResultSet resultSet = stmt.executeQuery(sql);
                    try {
                        // for all results
                        while (resultSet.next()) {
                            // print the columns of the current row (indexed by
                            // name)
                            System.out.print(resultSet.getString("CustomerID"));
                            System.out.print(", ");
                            System.out.print(resultSet.getString("CompanyName"));
                            System.out.print(", ");
                            System.out.print(resultSet.getString("ContactName"));
                            System.out.println();
                        }
                    } finally {
                        resultSet.close();
                    }
                } finally {
                    stmt.close();
                }
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
