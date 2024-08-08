package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public String sayHello(Model model) {
		String msg = "hello";
		model.addAttribute("hello", msg);
		return "/jsp/hello.jsp";
	}
	
}
