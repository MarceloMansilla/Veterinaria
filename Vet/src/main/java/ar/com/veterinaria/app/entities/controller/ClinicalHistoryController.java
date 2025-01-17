package ar.com.veterinaria.app.entities.controller;

import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ar.com.veterinaria.app.entities.ClinicalHistory;
import ar.com.veterinaria.app.entities.service.ClinicalHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping(value = "/clinicalhistory", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Api(tags = "ClinicalHistory", description = "Endpoint for ClinicalHistory management")
public class ClinicalHistoryController {

	private static final Logger logger = LoggerFactory.getLogger(ClinicalHistoryController.class);

	@Autowired
	ClinicalHistoryService clinicalHistoryService;

	@Autowired
	public ClinicalHistoryController(ClinicalHistoryService clinicalHistoryService) {
		this.clinicalHistoryService = clinicalHistoryService;
	}

	@GetMapping
	@RequestMapping(value = "/new-ClinicalHistory", method = RequestMethod.POST)
	@ApiOperation(value = "Create a new ClinicalHistory", notes = "Create a new ClinicalHistory.", response = ClinicalHistory.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful retrieval of ClinicalHistory List", response = ClinicalHistory.class),
			@ApiResponse(code = 500, message = "Internal server error") })
	public ResponseEntity<ClinicalHistory> create(@RequestBody ClinicalHistory clinicalHistory) {
		try {

			clinicalHistoryService.isValidInputData(clinicalHistory);
			clinicalHistoryService.exist(clinicalHistory);
			clinicalHistoryService.add(clinicalHistory);
			return new ResponseEntity<ClinicalHistory>(clinicalHistory, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping
	@RequestMapping(value = "/get-list-ClinicalHistory", method = RequestMethod.GET)
	@ApiOperation(value = "Returns List of ClinicalHistory", notes = "Returns a complete list of ClinicalHistory details.", response = ClinicalHistory.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful retrieval of Breed List", response = ClinicalHistory.class),
			@ApiResponse(code = 500, message = "Internal server error") })
	public ResponseEntity<List<Map<String, Object>>> getAll() {
		try {
			List<Map<String, Object>> result = clinicalHistoryService.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Search a ClinicalHistory by ID", response = ClinicalHistory.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 403, message = "Operation is forbidden"),
			@ApiResponse(code = 500, message = "Server error") })
	public ResponseEntity<ClinicalHistory> getById(@PathVariable("id") int id) {
		try {
			ClinicalHistory clinicalHistory = clinicalHistoryService.findById(id);
			if (clinicalHistory != null) {
				return ResponseEntity.status(HttpStatus.OK).body(clinicalHistory);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update a ClinicalHistory by ID", response = ClinicalHistory.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 403, message = "Operation is forbidden"),
			@ApiResponse(code = 500, message = "Server error") })
	public ResponseEntity<ClinicalHistory> update(@PathVariable("id") int id,
			@RequestBody ClinicalHistory clinicalHistory) {
		try {
			clinicalHistoryService.isValidInputData(clinicalHistory);
			clinicalHistoryService.update(id, clinicalHistory);
			return ResponseEntity.status(HttpStatus.OK).body(clinicalHistory);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a ClinicalHistory by ID", response = ClinicalHistory.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 403, message = "Operation is forbidden"),
			@ApiResponse(code = 500, message = "Server error") })
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		try {
			clinicalHistoryService.remove(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
