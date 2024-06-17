package filenest;

import java.util.HashMap;
import java.util.Map;

import filenest.domain.Customer;

public class Session {
	private static Map<String, Customer> session = new HashMap<String,Customer>();
	
	private Session() {}
	
	private static void setNewSession(String userId, Customer customer) {
		session.put(userId, customer);
	}
	private static Customer getSession(String userId) {
		return session.get(userId);
	}
	
}
