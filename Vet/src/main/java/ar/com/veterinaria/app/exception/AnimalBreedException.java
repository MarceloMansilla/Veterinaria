package ar.com.veterinaria.app.exception;

import ar.com.veterinaria.app.entities.Animal;
import ar.com.veterinaria.app.entities.AnimalBreed;
import ar.com.veterinaria.app.entities.Breed;

public class AnimalBreedException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public AnimalBreedException(AnimalBreed animalBreed) {
		super("\nIt is neccesary an association: \nAnimal " + animalBreed.getAnimal().getName() + " & Breed "
				+ animalBreed.getBreed().getBreed());
	}

	public AnimalBreedException(Animal animal, Breed breed) {
		super("\nAssociation: \tAnimal " + animal.getName() + " & Breed " + breed.getBreed() + " already exists");
	}

}
