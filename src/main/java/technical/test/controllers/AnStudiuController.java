package technical.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technical.test.Utils;
import technical.test.customer.Customer;
import technical.test.customer.CustomerRepository;
import technical.test.enitities.AnStudiu;
import technical.test.repositories.AnStudiuRepository;

import java.util.Set;

@RequestMapping(value = "/api/anStudiu")
@RestController
public class AnStudiuController {

    private final AnStudiuRepository anStudiuRepository;

    @Autowired
    public AnStudiuController(final AnStudiuRepository anStudiuRepository) {
        this.anStudiuRepository = anStudiuRepository;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Set<AnStudiu>> getCustomers() {
        return new ResponseEntity<>(anStudiuRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestParam final String an) {
        Customer customer = new Customer(name, email.toLowerCase());
        if (Utils.isAValidEmail(customer.getEmail())) {
            try {
                customer = anStudiuRepository.save(customer);
                return new ResponseEntity<>(customer, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam String id) {
        try {
            anStudiuRepository.delete(anStudiuRepository.findOne(id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
