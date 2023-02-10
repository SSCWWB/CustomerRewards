package Customer.Rewards.Service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import Customer.Rewards.Repository.CustomerRespository;
import Customer.Rewards.Repository.TransactionRespository;
import Customer.Rewards.Entity.Customer;
import Customer.Rewards.Entity.Transaction;
import Customer.Rewards.Model.RewardPoints;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class CustomerRewardPointsServiceImplTest {

	@Mock
	CustomerRespository mockCustomerRespository;

	@Mock
	TransactionRespository mockTransactionRespository;

	List<Transaction> testTransactionList = new ArrayList<Transaction>();

	List<Customer> testCustomerList = new ArrayList<Customer>();

	Customer testCustomer = new Customer();
	CustomerRewardPointsServiceImpl service = new CustomerRewardPointsServiceImpl();

	@Before
	public void setUp() {
		testCustomer.setName("Yushi");
		testCustomer.setId(1);
		testCustomerList.add(testCustomer);

		Transaction t = new Transaction();
		t.setCustomerId(1);
		t.setAmount(120);
		t.setDate(new Date());
		testTransactionList.add(t);

		lenient().when(mockTransactionRespository.findByCustomerId(1)).thenReturn(testTransactionList);
		lenient().when(mockCustomerRespository.findAll()).thenReturn(testCustomerList);
		lenient().when(mockCustomerRespository.findById(1)).thenReturn(testCustomer);

		service.setCustomerRespository(this.mockCustomerRespository);
		service.setTransactionRespository(this.mockTransactionRespository);
	}

	@Test
	public void testGetRewardsByCustomer() {
		RewardPoints returnObj = service.getRewardsByCustomer(1);
		assertEquals(returnObj.getTotal3MonthPoints(), 90);
		assertEquals(returnObj.getPointsThisMonth(), 90);
	}

	@Test
	public void testGetRewardsForAllCustomers() {
		List<RewardPoints> list = service.getRewardsForAllCustomers();
		RewardPoints returnObj = list.get(0);
		assertEquals(returnObj.getTotal3MonthPoints(), 90);
		assertEquals(returnObj.getPointsThisMonth(), 90);
	}

	@Test(expected = Exception.class)
	public void testinvalidCustomerId() {
		lenient().when(mockCustomerRespository.findById(-1)).thenThrow(new Exception());
		RewardPoints returnObj = service.getRewardsByCustomer(-1);
	}

}
