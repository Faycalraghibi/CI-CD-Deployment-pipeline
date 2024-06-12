package Spring.example.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(path ="api/v1/customer",
            method = RequestMethod.GET
     )
    @GetMapping("api/v1/customers")
    public List<Customer> getCustomers(){
        return customerService.getAllCustumers();
    }
    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable("id")Integer id){
        return customerService.getCustumers(id);
    }
    @PostMapping
    public void registerCustomer(
            @RequestBody CustomerRegistrationRequest request){
        customerService.addCustomer(request);
    }
}
