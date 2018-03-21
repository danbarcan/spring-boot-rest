package technical.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import technical.test.customer.Customer;
import technical.test.customer.CustomerController;
import technical.test.customer.CustomerRepository;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class CustomerControllerTest {

    private CustomerController subject;


    Customer peter = new Customer("Peter Pan", "ppan@fantasy.com");
    Customer batman = new Customer("Bruce Wayne", "bwayne@batman.com");

    @Mock
    private CustomerRepository customerRepository;


    @Before
    public void setUp() throws Exception {
        initMocks(this);
        subject = new CustomerController(customerRepository);
    }

    @Test
    public void shouldSaveAndReturnCustomer() throws Exception {
        Customer maybePeter = subject.addCustomer(peter.getName(), peter.getEmail()).getBody();
        assertThat(maybePeter, is(peter));
    }

    @Test
    public void shouldReturnFullNameOfAPerson() throws Exception {
        assertThat(subject.addCustomer(batman.getName(), batman.getEmail()).getBody(), is(batman));
        Set<Customer> customers = new HashSet<>();
        customers.add(peter);
        customers.add(batman);

        Set<Customer> returnedCustomers = subject.getCustomers().getBody();
        assertThat(returnedCustomers, is(customers));
    }

    /*@Test
    public void shouldTellIfPersonIsUnknown() throws Exception {
        given(customerRepository.findByEmail(anyString())).willReturn("");

        String greeting = subject.hello("Pan");

        assertThat(greeting, is("Who is this 'Pan' you're talking about?"));
    }

    @Test
    public void shouldReturnWeatherClientResult() throws Exception {
        WeatherResponse weatherResponse = new WeatherResponse("Hamburg, 8°C raining");
        given(weatherClient.fetchWeather()).willReturn(Optional.of(weatherResponse));

        String weather = subject.weather();

        assertThat(weather, is("Hamburg, 8°C raining"));
    }*/

}