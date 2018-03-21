package technical.test;

import technical.test.customer.Customer;
import technical.test.customer.CustomerRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloE2ERestTest {

    @Autowired
    private CustomerRepository customerRepository;

    @LocalServerPort
    private int port;

    @After
    public void tearDown() throws Exception {
        customerRepository.deleteAll();
    }

    @Test
    public void shouldReturnHelloWorld() throws Exception {
        when()
                .get(String.format("http://localhost:%s/hello", port))
                .then()
                .statusCode(is(200))
                .body(containsString("Hello World!"));
    }

    @Test
    public void shouldReturnGreeting() throws Exception {
        Customer peter = new Customer("Peter", "Pan");
        customerRepository.save(peter);

        when()
                .get(String.format("http://localhost:%s/hello/Pan", port))
                .then()
                .statusCode(is(200))
                .body(containsString("Hello Peter Pan!"));
    }
}
