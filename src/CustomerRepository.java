
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerRepository {


    void createCustomer(Customer customer) throws SQLException {

        Connection connection = Utilities.getConnection();
        // CREATING A STATEMENT
        Statement statement = connection.createStatement();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("New Name: ");
        String name = sc1.next();

        System.out.println("New phone number: ");
        String phone_number = sc1.next();


        System.out.println("New email: ");
        String email = sc1.next();

        String query = "INSERT INTO clients (name, phone_number, email) VALUES ('" + name + "','" + phone_number + "','" + email + "')";
        System.out.println(query);

        statement.executeUpdate(query);
        System.out.println("Sucess!!");


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

    Customer  updateCustomer(Customer customer) throws SQLException {
        Connection connection = Utilities.getConnection();
        // CREATING A STATEMENT
        Statement statement = connection.createStatement();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("New Name: ");
        String name = sc1.next();

        System.out.println("New phone number: ");
        String phone_number = sc1.next();


        System.out.println("New email: ");
        String email = sc1.next();

        String query = "UPDATE clients SET name = '" + name + "', phone_number = '" + phone_number + "', email = '" + email + "' WHERE client_id = " + customer.getClient_id();
        System.out.println(query);

        statement.executeUpdate(query);

        return customer;
    }

    void  deleteCustomer(int id) throws SQLException {
        Connection connection = Utilities.getConnection();
        // CREATING A STATEMENT
        Statement statement = connection.createStatement();

        String query = "DELETE FROM clients WHERE client_id = " + id;
        System.out.println(query);

        statement.executeUpdate(query);

        System.out.println("Client erased!");

    }

    List<Customer> getCustomers() throws SQLException {
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