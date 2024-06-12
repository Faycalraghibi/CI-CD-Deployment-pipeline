package Spring.example;
import Spring.example.customer.Customer;
import Spring.example.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot. SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        /*
        never do this
        customerService customer    Service =new customerService(new CustomerDataAccessService());
        CustomerController customerController=new CustomerController(customerService);*/
                SpringApplication.run(Main.class, args);
        }
        @Bean
        CommandLineRunner runner(CustomerRepository customerRepository){
        return args -> {
            Customer alex = new Customer( 21, "alex",
                    "alex@gmail.com");
            Customer jamila = new Customer(19, "jamila",
                    "jamila@gmail.com");
            List<Customer> customers = List.of(alex, jamila);
            customerRepository.saveAll(customers);
        };
        }
}









