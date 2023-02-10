package Customer.Rewards.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Customer.Rewards.Model.RewardPoints;
import Customer.Rewards.Service.CustomerRewardPointsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/customerRewardPoints")
public class CustomerRewardController {
	@Autowired
	private CustomerRewardPointsService customerRewardPointsService;

	@GetMapping(value = "/customerId/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RewardPoints> getRewardPointsByCustomer(@PathVariable("customer_id") int customer_id) {
		RewardPoints points = customerRewardPointsService.getRewardsByCustomer(customer_id);
		return new ResponseEntity<RewardPoints>(points, HttpStatus.OK);
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RewardPoints>> getRewardPointsByCustomer() {
		List<RewardPoints> list = customerRewardPointsService.getRewardsForAllCustomers();
		return new ResponseEntity<List<RewardPoints>>(list, HttpStatus.OK);
	}
}