package Spring.example.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> selectAllCustomers();
    Optional<Customer> selectAllCustomersById(Integer id);
    void insertCustomer(Customer customer);
    boolean  existsPersonWithEmail(String email);
}
