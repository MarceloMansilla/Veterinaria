package ar.com.veterinaria.app.entities.exception.duplicate;

import ar.com.veterinaria.app.entities.ClinicalHistory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ClinicalHistoryDuplicatedException extends RuntimeException {

	private static final long serialVersionUID = 5479891174244479722L;

	public ClinicalHistoryDuplicatedException(String clinicalHistory) {
		super("The Clinical History '" + clinicalHistory + "' already exists.");
	}

	public ClinicalHistoryDuplicatedException(int id) {
		super("The Clinical History with id '" + id + "' already exists.");
	}

	public ClinicalHistoryDuplicatedException(ClinicalHistory clinicalHistory) {
		super("The Clinical History '" + clinicalHistory + "' already exists.");
	}
}
