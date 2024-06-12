package Spring.example.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository("list")
public class CustomerListDataAccessService implements  CustomerDao {
    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(1, 21, "alex",
                "alex@gmail.com");
        Customer jamila = new Customer(2, 19, "jamila",
                "jamila@gmail.com");
        customers.add(alex);
        customers.add(jamila);
    }

    @Override
    public List<Customer> selectAllCustomers() {

        return customers;
    }

    @Override
    public Optional<Customer> selectAllCustomersById(Integer id) {
       return   customers.stream().filter(custmor ->custmor.getId().equals(id))
                .findFirst();
    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return customers.stream().anyMatch(c->c.getEmail().equals(email));
    }

}
