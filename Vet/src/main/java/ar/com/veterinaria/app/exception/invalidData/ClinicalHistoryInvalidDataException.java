package ar.com.veterinaria.app.exception.invalidData;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ar.com.veterinaria.app.entities.ClinicalHistory;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ClinicalHistoryInvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public ClinicalHistoryInvalidDataException(ClinicalHistory clinicalHistory) {
		super("Invalid Clinical History Name: " + clinicalHistory.getClinicalHistory()
				+ ", it must be capital or lower letters");
	}

}
