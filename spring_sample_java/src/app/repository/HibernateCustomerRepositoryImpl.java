package app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import app.model.Customer;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	@Value("${dbUsername}")
	private String dbUsername;

	@Override
	public List<Customer> findAll() {
		System.out.println(dbUsername);

		List<Customer> customers = new ArrayList<Customer>();

		Customer customer = new Customer();
		customer.setFirstName("pierre");
		customer.setLastName("Demoury");

		Customer customer2 = new Customer();
		customer2.setFirstName("Aurelien");
		customer2.setLastName("Demguillon");

		customers.add(customer);
		customers.add(customer2);
		return customers;
	}

}
