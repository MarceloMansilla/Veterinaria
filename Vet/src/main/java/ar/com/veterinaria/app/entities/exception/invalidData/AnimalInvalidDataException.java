package ar.com.veterinaria.app.entities.exception.invalidData;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import ar.com.veterinaria.app.entities.Animal;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AnimalInvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 4634979775139669877L;

	public AnimalInvalidDataException(Animal animal) {
		super("Invalid Name: " + animal.getName() + ". It must be capital or lower letters and whitespace");
	}

}
