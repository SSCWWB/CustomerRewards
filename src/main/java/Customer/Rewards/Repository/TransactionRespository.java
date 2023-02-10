package Customer.Rewards.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Customer.Rewards.Entity.Transaction;


@Repository
public interface TransactionRespository extends JpaRepository<Transaction, Integer> {
	List<Transaction> findById(int id);
	List<Transaction> findByCustomerId(int id);
}