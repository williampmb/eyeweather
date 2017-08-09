package com.pmb.eyeweather.users;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	String property = "java.io.tmpdir";

	String tempDir = System.getProperty(property);
	private List<User> users = null;

	public User getUser(String username, String password) {
		if (users == null) {
			loadUserFile();
		}

		for (User u : users) {
			if (u.getUsername().equals(username)
					&& u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}

	public List<User> findAllEnabledUsers() {
		List<User> result = new ArrayList<User>();
		if (users == null) {
			loadUserFile();

		} else {
			for (User u : users) {
				if (u.isEnable()) {
					result.add(u);
				}
			}
		}
		return result;
	}

	private void loadUserFile() {
		users = new ArrayList<User>();
		try {
			File relativeFile;

			relativeFile = new File(tempDir + "usersdb.txt");
			Scanner s = new Scanner(relativeFile);
			while (s.hasNext()) {

				String line = s.nextLine();
				String[] tok = line.split(", ");
				String id = tok[0];
				String email = tok[1];
				String first = tok[2];
				String last = tok[3];
				String uname = tok[4];
				String pword = tok[5];
				String role = tok[6];
				String enable = tok[7];			

				User u = new User.Builder().id(id).email(email)
						.first(first).last(last).username(uname)
						.password(pword).role(role)
						.enable(Boolean.valueOf(enable)).build();

				users.add(u);
				
			}
			s.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
