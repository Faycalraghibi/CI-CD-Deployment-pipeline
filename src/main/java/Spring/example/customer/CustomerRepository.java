package Spring.example.customer;

import org.apache.el.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

 boolean existsCustomerByEmail(String email);
}
