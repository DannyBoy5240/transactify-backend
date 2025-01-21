package com.example.transactify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransactifyApplicationTests {

	@Autowired
	private TransactionService transactionService;

	@MockBean
	private TransactionRepository transactionRepository;

	@Test
	public void testCalculateBalance() {
		List<Transaction> transactions = Arrays.asList(
				new Transaction("123456", BigDecimal.valueOf(100), "CREDIT"),
				new Transaction("123456", BigDecimal.valueOf(50), "DEBIT")
		);
		when(transactionRepository.findByAccountNumber("123456")).thenReturn(transactions);

		BigDecimal balance = transactionService.calculateBalance("123456");
		assertEquals(BigDecimal.valueOf(50), balance);
	}

}
