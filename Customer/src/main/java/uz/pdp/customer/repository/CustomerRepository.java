package uz.pdp.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
