
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CustomerRepository {


    void createCustomer(Customer customer) {
        // INSERT INTO Customers (name, phone_number, email) VALUES (?,?,?)
    }

    Customer getCustomer(int id) throws SQLException {

        Customer client = null;


        Connection connection = Utilities.getConnection();
        // CREATING A STATEMENT
        Statement statement = connection.createStatement();
        // CREATIING A QUERY
        String query = "SELECT * FROM clients WHERE client_id = " + id;

        // EXECUTING THE QUERY
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int client_id = resultSet.getInt("client_id");
            String firstName = resultSet.getString("name");
            String phone_number = resultSet.getString("phone_number");
            String email = resultSet.getString("email");

            client = new Customer(client_id, firstName, phone_number, email);

        }
        return client;
    }

    Customer  updateCustomer(Customer customer) {
        // UPDATE Customers SET name = ?, phone_number = ?, email = ? WHERE id = ?
        return null;
    }

    void   deleteCustomer(int id) {
        // DELETE FROM Customers WHERE id = ?
    }

    List<Customer> getCustomers() {
        // SELECT * FROM Customers
        return null;
    }
}