package repository;

import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	/* (non-Javadoc)
	 * @see repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll() {

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
