package ar.com.veterinaria.app.entities.exception.duplicate;

import ar.com.veterinaria.app.entities.Breed;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BreedDuplicatedException extends RuntimeException {

	private static final long serialVersionUID = 6741240461414789821L;

	public BreedDuplicatedException(String breed) {
		super("The Breed '" + breed + "' already exists.");
	}

	public BreedDuplicatedException(int id) {
		super("The Breed with id '" + id + "' already exists.");
	}

	public BreedDuplicatedException(Breed breed) {
		super("The Breed '" + breed + "' already exists.");
	}
}
