package ar.com.veterinaria.app.entities.exception.validationLength;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ar.com.veterinaria.app.entities.Address;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AddressValidationLengthDataException extends RuntimeException {

	private static final long serialVersionUID = -373914835914990495L;

	public AddressValidationLengthDataException(Address address) {
		super("Length name is over 70 character: " + address.getName().length() + " for name: " + address.getName());
	}

}
