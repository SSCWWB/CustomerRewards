package Customer.Rewards.Service;

import java.util.List;

import Customer.Rewards.Model.RewardPoints;


public interface CustomerRewardPointsService {
	public RewardPoints getRewardsByCustomer(int customer_id);

	public List<RewardPoints> getRewardsForAllCustomers();
}