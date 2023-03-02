public class Customer {


private int client_id;
private String name;
private String phone_number;
private String email;


    public Customer(int client_id,String name, String phone_number, String email) {
        this.client_id = client_id;
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Client ID='" + client_id + '\'' +
                "name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void add(Customer customer) {
    }
}
