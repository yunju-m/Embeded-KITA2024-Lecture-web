package springmvc4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/exception")
public class CommonExceptionController {

	@RequestMapping(value = "/arithmeticException.do")
	public void handleArithmeticException(Exception ex) {
		int i = 100 / 0;
	}

}
