package payroll;

class PaydocNotFoundException extends RuntimeException {

	PaydocNotFoundException(Long id) {
		super("Could not find paydoc " + id);
	}
}
