import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.service.CustomerService;

public class Application {

	public static void main(String[] args) {

		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		CustomerService customerService = appContext.getBean("customerService", CustomerService.class);
		customerService.findAll().forEach(customer -> System.out.println(customer));
	}

}
