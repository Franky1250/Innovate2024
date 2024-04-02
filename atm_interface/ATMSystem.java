package atm_interface;

import java.util.HashMap;
import java.util.Map;

public class ATMSystem 
{
	public static void main(String[] args) 
	{
        Map<String, User> users = new HashMap<>();
        users.put("123456", new User("123456", "1234", 1000.0));
        users.put("789012", new User("789012", "5678", 2000.0));
        
        ATM atm = new ATM(users);
        Menu.displayMainMenu(atm);
    }
}
