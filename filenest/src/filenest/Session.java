package filenest;

import java.util.HashMap;
import java.util.Map;

import filenest.domain.Customer;

public class Session {
	private static Map<String, Customer> session = new HashMap<String,Customer>();
	private static String userIdSession;
	private Session() {}
	
	public static void setNewSession(String userId, Customer customer) {
		session.put(userId, customer);
		userIdSession = userId;
	}
	public static Customer getSession() {
		return session.get(userIdSession);
	}
	
}
