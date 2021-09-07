package com.progresssoft.Bloomberg;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.progresssoft.Bloomberg.Controller.DealsController;
import com.progresssoft.Bloomberg.Wrapper.DealsWrapper;
import com.progresssoft.Bloomberg.model.DealsTransactions;
import com.progresssoft.Bloomberg.repository.DealsRepository;

@ExtendWith(MockitoExtension.class)
public class DealsControllerIntegrationTests {

	@InjectMocks
	DealsController dealsController;

	@Mock
	DealsRepository dealsRepository;

	@Test
	public void testAddDeal() throws Exception {

		DealsWrapper dealToAdd = new DealsWrapper();
		dealToAdd.setAmount(20.210055);
		dealToAdd.setFCurrencyISOCode("JOD");
		dealToAdd.setTCurrencyISOCode("USD");
		ResponseEntity<?> responseEntity = dealsController.saveNew(dealToAdd);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}

}
