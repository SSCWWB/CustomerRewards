package Customer.Rewards.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Customer.Rewards.Entity.Customer;

@Repository
public interface CustomerRespository extends JpaRepository<Customer, Integer> {
	Customer findById(int id);
}
