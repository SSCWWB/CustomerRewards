package Customer.Rewards.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.List;

import org.springframework.stereotype.Service;

import Customer.Rewards.Entity.Customer;
import Customer.Rewards.Entity.Transaction;

import Customer.Rewards.Model.RewardPoints;
import Customer.Rewards.Repository.CustomerRespository;
import Customer.Rewards.Repository.TransactionRespository;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Getter
@Setter
public class CustomerRewardPointsServiceImpl implements CustomerRewardPointsService {

	@Autowired
	private CustomerRespository customerRespository;

	@Autowired
	private TransactionRespository transactionRespository;

	public RewardPoints getRewardsByCustomer(int customer_id) {
		// TODO Auto-generated method stub

		RewardPoints reward = new RewardPoints(customer_id);
		try {
			Customer customer = customerRespository.findById(customer_id);
			reward.setCustomer_name(customer.getName());
		} catch (Exception e) {
			System.out.println("Can't find the customer , customer id is wrong " + e.getMessage());
			throw e;
		}

		Calendar calNow = Calendar.getInstance();

		Calendar cal1MonthAgo = Calendar.getInstance();
		cal1MonthAgo.add(Calendar.MONTH, -1);

		Calendar cal2MonthAgo = Calendar.getInstance();
		cal2MonthAgo.add(Calendar.MONTH, -2);

		List<Transaction> transactions = this.transactionRespository.findByCustomerId(customer_id);

		int thisMonthPoints = this.caculatePoints(transactions, calNow);
		int oneMonththBeforePoints = this.caculatePoints(transactions, cal1MonthAgo);
		int twoMonththBeforePoints = this.caculatePoints(transactions, cal2MonthAgo);

		reward.setPointsThisMonth(thisMonthPoints);
		reward.setPoints1MonththBefore(oneMonththBeforePoints);
		reward.setPoints2MonththBefore(twoMonththBeforePoints);
		reward.setTotal3MonthPoints(thisMonthPoints + oneMonththBeforePoints + twoMonththBeforePoints);
		return reward;
	}

	public List<RewardPoints> getRewardsForAllCustomers() {
		// TODO Auto-generated method stub
		List<RewardPoints> list = new ArrayList<RewardPoints>();
		List<Customer> allCustomer = this.customerRespository.findAll();
		for (Customer customer : allCustomer) {
			RewardPoints points = this.getRewardsByCustomer(customer.getId());
			list.add(points);
		}
		return list;
	}

	private int caculatePoints(List<Transaction> list, Calendar cal) {
		int points = 0;
		for (Transaction t : list) {
			Date tDate = t.getDate();
			Calendar tCal = Calendar.getInstance();
			tCal.setTime(tDate);
			if ((tCal.get(Calendar.YEAR) == cal.get(Calendar.YEAR))
					&& (tCal.get(Calendar.MONTH) == cal.get(Calendar.MONTH))) {
				if (t.getAmount() <= 100 && t.getAmount() > 50) {
					points += t.getAmount() - 50;
				} else if (t.getAmount() > 100) {
					points += (t.getAmount() - 100) * 2 + 50;
				}
			}
		}

		return points;
	}
}
