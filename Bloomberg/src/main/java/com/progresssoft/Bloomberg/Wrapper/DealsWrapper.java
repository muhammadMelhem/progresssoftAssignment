package com.progresssoft.Bloomberg.Wrapper;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.progresssoft.Bloomberg.validation.CheckAmount;

import lombok.Data;

@Data
public class DealsWrapper {

	@NotBlank(message = "fCurrencyISOCode is mandatory")
	@JsonProperty("fCurrencyISOCode")
	private String fCurrencyISOCode;

	@NotBlank(message = "tCurrencyISOCode is mandatory")
	@JsonProperty("tCurrencyISOCode")
	private String tCurrencyISOCode;

	@CheckAmount
	private Double amount;

}
