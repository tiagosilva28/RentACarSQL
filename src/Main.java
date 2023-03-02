
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static CustomerRepository cr = new CustomerRepository();
    public static void main(String[] args) {

        try {
            //getCustomers().forEach(System.out::println);
            System.out.println(cr.getCustomer(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Customer> getCustomers() throws SQLException {

        List<Customer> customers = new LinkedList<>();

        Connection connection = Utilities.getConnection();
        // CREATING A STATEMENT
        Statement statement = connection.createStatement();

        // CREATIING A QUERY
        String query = "SELECT * FROM clients";

        // EXECUTING THE QUERY
        ResultSet resultSet = statement.executeQuery(query);

        // DEALING WITH THE RESULTS
        while (resultSet.next()) {
            int client_id = resultSet.getInt("client_id");
            String firstName = resultSet.getString("name");
            String phone_number = resultSet.getString("phone_number");
            String email = resultSet.getString("email");

            customers.add(new Customer(client_id, firstName, phone_number, email));



        }
        return customers;
    }




}