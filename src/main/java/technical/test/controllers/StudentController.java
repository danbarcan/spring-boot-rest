package technical.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import technical.test.Utils;
import technical.test.customer.Customer;
import technical.test.customer.CustomerRepository;

import java.util.Set;

@RestController
public class StudentController {

    private final CustomerRepository customerRepository;

    @Autowired
    public StudentController(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public ResponseEntity<Set<Customer>> getCustomers() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/customers/customer")
    public ResponseEntity<Customer> getCustomer(@RequestParam final String email) {
        Customer customer = customerRepository.findByEmail(email.toLowerCase());
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/customers/add")
    public ResponseEntity<Customer> addCustomer(@RequestParam final String name, @RequestParam final String email) {
        Customer customer = new Customer(name, email.toLowerCase());
        if (Utils.isAValidEmail(customer.getEmail())) {
            try {
                customer = customerRepository.save(customer);
                return new ResponseEntity<>(customer, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @PostMapping("/customers/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam String email) {
        try {
            customerRepository.delete(customerRepository.findByEmail(email.toLowerCase()));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
