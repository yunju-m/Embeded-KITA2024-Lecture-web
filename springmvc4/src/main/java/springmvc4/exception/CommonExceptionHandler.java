package springmvc4.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleArithmeticException(Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.setViewName("/arithmeticException");
		return mav;
	}

}
