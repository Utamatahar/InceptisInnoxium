package app.repository;

import java.util.List;

import app.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}