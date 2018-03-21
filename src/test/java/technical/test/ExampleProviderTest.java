package technical.test;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import technical.test.customer.CustomerController;
import technical.test.customer.CustomerRepository;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 *  A provider test for the contract between this service (as a provider) and
 *  a primitive consumer. The implementation of the consumer can be
 *  found under https://github.com/hamvocke/spring-testing-consumer
 */

@RunWith(RestPactRunner.class)
@Provider("person_provider")// same as in the "provider_name" part in our pact file
@PactFolder("target/pacts") // tells pact where to load the pact files from
public class ExampleProviderTest {

    @Mock
    private CustomerRepository customerService;

    private CustomerController customerController;

    @TestTarget
    public final MockMvcTarget target = new MockMvcTarget();

    @Before
    public void before() {
        initMocks(this);
        customerController = new CustomerController(customerService);
        target.setControllers(customerController);
    }

    /*@State("person data") // same as the "given()" part in our consumer test
    public void personData() {
        Customer peterPan = new Customer("Peter", "Pan");
        when(customerService.findByEmail("Pan")).thenReturn(Optional.of
                (peterPan));
    }*/
}