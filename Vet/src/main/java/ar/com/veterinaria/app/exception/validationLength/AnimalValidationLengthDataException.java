package ar.com.veterinaria.app.exception.validationLength;

import ar.com.veterinaria.app.entities.Animal;

public class AnimalValidationLengthDataException extends RuntimeException {

	private static final long serialVersionUID = -8242517982836630219L;

	public AnimalValidationLengthDataException(Animal animal) {
		super("Length name is over 70 character: " + animal.getName().length() + " for name: " + animal.getName());
	}

}