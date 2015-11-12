package io.myspider.ireader.web.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/index")
public class LoginController {

	@RequestMapping()
	public String index() {
		return "index";
	}

}
