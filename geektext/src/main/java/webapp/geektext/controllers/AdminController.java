package webapp.geektext.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@GetMapping("/admin")
	public String getAdmin() {
		return "Welcome to the admin page. You can create a book using /addbook or an author using /addauthor";
	}
	
}
