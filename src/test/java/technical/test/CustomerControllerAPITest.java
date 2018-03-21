package technical.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import technical.test.customer.Customer;
import technical.test.customer.CustomerController;
import technical.test.customer.CustomerRepository;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerController.class)
public class CustomerControllerAPITest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void shouldReturnHelloWorld() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(content().string("Hello World!"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void shouldReturnFullName() throws Exception {
        Customer peter = new Customer("Peter", "Pan");
        given(customerRepository.findByEmail("Pan")).willReturn(peter);

        mockMvc.perform(post("/customers/add/"))
                .andExpect(content().string("Hello Peter Pan!"))
                .andExpect(status().is2xxSuccessful());
    }
}
