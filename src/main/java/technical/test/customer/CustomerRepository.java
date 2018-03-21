package technical.test.customer;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface CustomerRepository extends CrudRepository<Customer, String> {
    Customer findByEmail(String email);

    @Override
    Set<Customer> findAll();
}
