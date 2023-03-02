import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RentalsRepository {

    List<Map<String, Object>> getRentals() throws SQLException {
        List<Map<String, Object>> rentals = new LinkedList<>();

        Connection connection = Utilities.getConnection();
        // CREATING A STATEMENT
        Statement statement = connection.createStatement();

        // CREATIING A QUERY
        String query = "SELECT rentals.rental_id, clients.name, cars.make, cars.model FROM rentals INNER JOIN clients ON rentals.client_id = clients.client_id INNER JOIN cars ON rentals.car_id = cars.car_id";


        // EXECUTING THE QUERY
        ResultSet resultSet = statement.executeQuery(query);

        // DEALING WITH THE RESULTS
        while (resultSet.next()) {
            int rental_id = resultSet.getInt("rental_id");
            String name = resultSet.getString("name");
            String car_make = resultSet.getString("make");
            String car_model = resultSet.getString("model");

            Map<String, Object> rental = new HashMap<>();
            rental.put("rental_id", rental_id);
            rental.put("name", name);
            rental.put("car_make", car_make);
            rental.put("car_model", car_model);

            rentals.add(rental);



        }

        return rentals;
    }


}
