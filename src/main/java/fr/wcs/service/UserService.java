package fr.wcs.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.wcs.servlet.User;

public class UserService {

	public static List<User> USERS = new ArrayList<>(Arrays.asList(
		new User("Loki", 5, "loki@leschats.com"),
		new User("Ivy", 4, "ivy@leschats.com"),
		new User("Athena", 7, "athena@leschats.com"),
		new User("Bandit", 6, "bandit@leschiens.com")
	));
	
	public static void addUser(User user) {
		UserService.USERS.add(user);
	}
}
