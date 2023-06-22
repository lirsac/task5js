package com.mindhub.homebanking;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanRepository, ClientLoanRepository clientLoanRepository, CardRepository cardRepository) {
		return (args) -> {

			Client client1 = new Client("Melba", "Morel", "melba@gmail.com");
			Client client2 = new Client("Lucas", "Romo", "lucas@gmail.com");

			clientRepository.save(client1);
			clientRepository.save(client2);

			Account account1 = new Account("VIN001", LocalDate.now(), 7000);
			Account account2 = new Account("VIN002", LocalDate.now(), 1500);
			Account account3 = new Account("VIN003", LocalDate.now(), 897);

			client1.addAccount(account1);
			client1.addAccount(account2);
			client2.addAccount(account3);

			Card debitCard = new Card(CardType.DEBIT, "1234567890123456", "123", LocalDateTime.now(),
					LocalDateTime.now().plusYears(5), "Melba Morel", CardColor.GOLD);
			debitCard.setClient(client1);

			Card creditCard = new Card(CardType.CREDIT, "9876543210987654", "456", LocalDateTime.now(),
					LocalDateTime.now().plusYears(5), "Melba Morel", CardColor.TITANIUM);
			creditCard.setClient(client1);

			Card silverCard = new Card(CardType.CREDIT, "5678901234567890", "789", LocalDateTime.now(),
					LocalDateTime.now().plusYears(5), "Lucas Romo", CardColor.SILVER);
			silverCard.setClient(client2);

			cardRepository.save(silverCard);
			cardRepository.save(debitCard);
			cardRepository.save(creditCard);

			client1.addCard(debitCard);

			accountRepository.save(account1);
			accountRepository.save(account2);
			accountRepository.save(account3);

			Transaction transaction1 = new Transaction(TransactionType.CREDIT, LocalDateTime.of(2023, 6, 12, 9, 30), 1000, "loren");
			Transaction transaction2 = new Transaction(TransactionType.DEBIT, LocalDateTime.of(2023, 6, 11, 14, 15), -500, "loren");
			Transaction transaction8 = new Transaction(TransactionType.CREDIT, LocalDateTime.of(2023, 6, 10, 17, 45), 1000, "loren");

			account1.addTransaction(transaction1);
			account1.addTransaction(transaction2);
			account1.addTransaction(transaction8);

			transactionRepository.save(transaction1);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction8);

			Transaction transaction3 = new Transaction(TransactionType.CREDIT, LocalDateTime.of(2023, 6, 9, 11, 0), 200, "shopping");
			Transaction transaction4 = new Transaction(TransactionType.DEBIT, LocalDateTime.of(2023, 6, 8, 16, 30), -100, "pet shop");

			account2.addTransaction(transaction3);
			account2.addTransaction(transaction4);

			transactionRepository.save(transaction3);
			transactionRepository.save(transaction4);

			Transaction transaction5 = new Transaction(TransactionType.CREDIT, LocalDateTime.of(2023, 6, 7, 13, 45), 50, "deposit");
			Transaction transaction6 = new Transaction(TransactionType.DEBIT, LocalDateTime.of(2023, 6, 6, 10, 15), -20, "onlyfans");

			account3.addTransaction(transaction5);
			account3.addTransaction(transaction6);

			transactionRepository.save(transaction5);
			transactionRepository.save(transaction6);

			Loan loan1 = new Loan("Hipotecario", 500000, Arrays.asList(12, 24, 36, 48, 60));
			Loan loan2 = new Loan("Personal", 100000, Arrays.asList(6, 12, 24));
			Loan loan3 = new Loan("Automotriz", 300000, Arrays.asList(6, 12, 24, 36));

			loanRepository.save(loan1);
			loanRepository.save(loan2);
			loanRepository.save(loan3);

			ClientLoan clientLoan1 = new ClientLoan(client1, loan1, 400000, 60);
			ClientLoan clientLoan2 = new ClientLoan(client1, loan2, 50000, 12);
			ClientLoan clientLoan3 = new ClientLoan(client2, loan2, 100000, 24);
			ClientLoan clientLoan4 = new ClientLoan(client2, loan3, 200000, 36);

			client1.addClientLoan(clientLoan1);
			client1.addClientLoan(clientLoan2);
			client2.addClientLoan(clientLoan3);
			client2.addClientLoan(clientLoan4);

			clientLoanRepository.save(clientLoan1);
			clientLoanRepository.save(clientLoan2);
			clientLoanRepository.save(clientLoan3);
			clientLoanRepository.save(clientLoan4);
		};
	}
}
