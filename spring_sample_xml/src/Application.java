import service.CustomerService;
import service.CustomerServiceImpl;

public class Application {

	public static void main(String[] args) {

		CustomerService customerService = new CustomerServiceImpl();
		customerService.findAll().forEach(customer -> System.out.println(customer));
	}

}
