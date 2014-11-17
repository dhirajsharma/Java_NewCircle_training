package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModifyCustomer {
    public static void main(String[] args) {
        // check for the required command-line arguments
        if (args.length < 3) {
            System.err.println("Usage: ModifyCustomer <url> <customer-id>"
                    + " <field>=<value>...");
            System.exit(1);
        }
        // the the argument values
        String url = args[0];
        String customerID = args[1];
        String[][] updateList = parseUpdateList(args, 2);
        try {
            // Connect to the database
            Connection con = DriverManager.getConnection(url);
            try {
                // define the SQL UPDATE statement in the format:
                // UPDATE Customers SET <name>=?... WHERE CustomerID=?
                StringBuffer sql = new StringBuffer();
                sql.append("UPDATE Customers SET ");
                for (int i = 0; i < updateList.length; i++) {
                    sql.append(updateList[i][0]).append("=?");
                    if (i < updateList.length - 1) {
                        sql.append(", ");
                    }
                }
                sql.append(" WHERE CustomerID=?");
                // prepare the statement
                System.out.println(sql);
                PreparedStatement stmt = con.prepareStatement(sql.toString());
                try {
                    // add the customer update parameters (marked with '?')
                    for (int i = 0; i < updateList.length; i++) {
                        stmt.setString(i + 1, updateList[i][1]);
                    }
                    // set the customer id parameter
                    stmt.setString(updateList.length + 1, customerID);
                    // run the SQL statement
                    int result = stmt.executeUpdate();
                    if (result == 0) {
                        System.out.println("Customer not updated.");
                    } else {
                        System.out.println("Customer updated.");
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

    private static final Pattern NAME_VALUE_PATTERN = Pattern.compile("(.+)=(.*)");

    /**
     * Parse name=value pairs from commmand line arguments.
     * 
     * @param args array of arguments to parse.
     * @param from index at which to start parsing.
     * @return two-dimensional array in the format [list-length][2] where [i][0]
     *         is the name of i'th parameter and [i][1] is the value of i'th
     *         parameter
     */
    private static String[][] parseUpdateList(String[] args, int from) {
        String[][] updateList = new String[args.length - from][2];
        for (int i = 0; i < args.length - from; i++) {
            Matcher m = NAME_VALUE_PATTERN.matcher(args[i + from]);
            if (m.matches()) {
                updateList[i][0] = m.group(1);
                updateList[i][1] = m.group(2);
            } else {
                throw new IllegalArgumentException("Command line parameter ["
                        + args[i + from]
                        + "] is not in the required <name>=<value> format.");
            }
        }
        return updateList;
    }
}
