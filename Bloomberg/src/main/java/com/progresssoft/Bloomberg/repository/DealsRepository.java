package com.progresssoft.Bloomberg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.progresssoft.Bloomberg.model.DealsTransactions;

public interface DealsRepository extends CrudRepository<DealsTransactions, Long> {

	@Query("select c from DealsTransactions c where c.fCurrencyISOCode = :_fCurrencyISOCode and c.tCurrencyISOCode = :_tCurrencyISOCode and c.amount= :_amount")
	List<DealsTransactions> findByfCurrencyISOCodeAndtCurrencyISOCodeAndAmount(
			@Param("_fCurrencyISOCode") String fCurrencyISOCode, @Param("_tCurrencyISOCode") String tCurrencyISOCode,
			@Param("_amount") Double amount);

}
