import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.CustomerService;

public class Application {

	public static void main(String[] args) {

		// CustomerService customerService = new CustomerServiceImpl();

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService service = applicationContext.getBean("customerService", CustomerService.class);

		service.findAll().forEach(customer -> System.out.println(customer));
	}

}
