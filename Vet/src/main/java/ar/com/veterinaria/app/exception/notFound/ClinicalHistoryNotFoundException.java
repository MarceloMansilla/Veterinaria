package ar.com.veterinaria.app.exception.notFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ar.com.veterinaria.app.entities.ClinicalHistory;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ClinicalHistoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public ClinicalHistoryNotFoundException(Integer id) {
		super("Could not find Clinical History with id " + id);
	}

	public ClinicalHistoryNotFoundException(String breed) {
		super("Could not find Clinical History: " + breed);
	}

	public ClinicalHistoryNotFoundException(ClinicalHistory clinicalHistory) {
		super("Could not find Clinical History: " + clinicalHistory.toString());
	}

}
