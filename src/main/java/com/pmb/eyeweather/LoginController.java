package com.pmb.eyeweather;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pmb.eyeweather.geocoding.Climate;
import com.pmb.eyeweather.geocoding.GeocondingService;
import com.pmb.eyeweather.users.User;
import com.pmb.eyeweather.users.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private GeocondingService gService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(
			@RequestParam(value = "error", required = false, defaultValue = "false") Boolean error,
			Model model) {
		model.addAttribute("error", error);

		return "login";
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.POST)
	public String validatingLogin(
			@RequestParam(value = "login", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			HttpSession session,
			Model model
			
			) throws ClientProtocolException, URISyntaxException, IOException {
		String property = "java.io.tmpdir";

		String tempDir = System.getProperty(property);
	   // Climate c = gService.getWeatherOfLocation(43.81, -92.22);
	
	    System.out.println(tempDir);
		
		User user = userService.getUser(username, password);
		if (user != null) {
			model.addAttribute("user",user);
			
			return "eyeweather";
		} else {
			return "redirect:/login?error=true";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:/login";
	}

}
