package Spring.example.customer;

import Spring.example.customer.ResourceNotFound.DuplicateResourceExeption;
import Spring.example.customer.ResourceNotFound.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustumers(){
        return customerDao.selectAllCustomers();
    }
    public Customer getCustumers(Integer id){
        return customerDao.selectAllCustomersById(id)
                .orElseThrow(() -> new ResourceNotFound("customer with id [%s] not found".formatted(id)));
    }
    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        String email = customerRegistrationRequest.email();
        if (customerDao.existsPersonWithEmail(email)){
    throw new DuplicateResourceExeption("email already taken");
}
        customerDao.insertCustomer(new Customer(customerRegistrationRequest.age(),customerRegistrationRequest.email(),customerRegistrationRequest.name()));
    }
}
