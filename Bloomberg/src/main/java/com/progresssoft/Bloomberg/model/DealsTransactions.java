package com.progresssoft.Bloomberg.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "DEALS_TRANSACTIONS")
public class DealsTransactions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -47732246408746231L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreationTimestamp
	@Column(name = "CREATION_DATE")
	private LocalDateTime creationDate;

	@Column(name = "FROM_CURRENCY_ISO_CODE")
	private String fCurrencyISOCode;

	@Column(name = "TO_CURRENCY_ISO_CODE")
	private String tCurrencyISOCode;

	@Column(name = "AMOUNT")
	private Double amount;

}
