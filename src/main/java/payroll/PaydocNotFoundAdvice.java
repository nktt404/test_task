package payroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class PaydocNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(PaydocNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String PaydocNotFoundHandler(PaydocNotFoundException ex) {
		return ex.getMessage();
	}
}
