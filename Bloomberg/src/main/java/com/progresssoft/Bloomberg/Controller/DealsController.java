package com.progresssoft.Bloomberg.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progresssoft.Bloomberg.Wrapper.ApiError;
import com.progresssoft.Bloomberg.Wrapper.DealsWrapper;
import com.progresssoft.Bloomberg.model.DealsTransactions;
import com.progresssoft.Bloomberg.repository.DealsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/deals/")
public class DealsController {

	final Logger logger = LoggerFactory.getLogger(DealsController.class);

	@Autowired
	private DealsRepository currencyRepository;

	@PostMapping("/save-new")
	public ResponseEntity<?> saveNew(@RequestBody @Valid DealsWrapper request) throws Exception {

		logger.info("start calling /save-new");
		logger.info(request.toString());

		List<DealsTransactions> currencyTransactionsList = currencyRepository
				.findByfCurrencyISOCodeAndtCurrencyISOCodeAndAmount(request.getFCurrencyISOCode(),
						request.getTCurrencyISOCode(), request.getAmount());

		if (!currencyTransactionsList.isEmpty()) {
			logger.info("Deals Already saved");
			return new ResponseEntity<ApiError>(new ApiError(HttpStatus.OK, "Deals Already saved", ""), HttpStatus.OK);

		}

		DealsTransactions dealsTransaction = new DealsTransactions();
		dealsTransaction.setAmount(request.getAmount());
		dealsTransaction.setFCurrencyISOCode(request.getFCurrencyISOCode());
		dealsTransaction.setTCurrencyISOCode(request.getTCurrencyISOCode());

		logger.info("end calling /save-new");

		return new ResponseEntity<>(currencyRepository.save(dealsTransaction), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public DealsTransactions getById(@PathVariable String id) throws Exception {

		logger.info("start calling getById");

		Optional<DealsTransactions> dealsTransaction = Optional
				.ofNullable(currencyRepository.findById(Long.valueOf(id)).orElse(null));

		if (!dealsTransaction.isPresent()) {
			logger.info("Deals Not Found");
//			return new ResponseEntity<ApiError>(new ApiError(HttpStatus.OK, "Deals Not Found", ""), HttpStatus.OK);
			return new DealsTransactions();

		}

		logger.info("end calling getById");

		return dealsTransaction.get();
	}

}
