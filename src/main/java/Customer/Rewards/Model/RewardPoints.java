package Customer.Rewards.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RewardPoints {
	private int customer_id;
	private String customer_name;
	private int pointsThisMonth;
	private int points1MonththBefore;
	private int points2MonththBefore;
	private int total3MonthPoints;

	public RewardPoints() {

	}

	public RewardPoints(int customer_id) {
		this.setCustomer_id(customer_id);
	}
}