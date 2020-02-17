package ar.com.veterinaria.app.helper.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.AnimalBreed;
import ar.com.veterinaria.app.exception.invalidData.AnimalBreedInvalidDataException;
import ar.com.veterinaria.app.exception.validationLength.AnimalBreedValidationLengthDataException;

@Service
@Transactional
public class AnimalBreedManagerServiceHelper {

	@Autowired
	private static AnimalBreedServiceHelper animalBreedServiceHelper;

	@Autowired
	public AnimalBreedManagerServiceHelper(AnimalBreedServiceHelper animalBreedServiceHelper) {
		this.animalBreedServiceHelper = animalBreedServiceHelper;
	}

	public static boolean validate(AnimalBreed animalBreed) {
		if (!animalBreedServiceHelper.isValidName(animalBreed)) {
			throw new AnimalBreedInvalidDataException(animalBreed);

		} else if (!animalBreedServiceHelper.isValidLengthname(animalBreed)) {
			throw new AnimalBreedValidationLengthDataException(animalBreed);
		}
		return true;
	}

}