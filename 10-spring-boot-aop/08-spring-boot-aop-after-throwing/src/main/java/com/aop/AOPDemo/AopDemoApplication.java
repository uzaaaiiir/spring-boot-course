package com.aop.AOPDemo;

import com.aop.AOPDemo.dao.AccountDAO;
import com.aop.AOPDemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			System.out.println("Hello World!");

			// demoBeforeAdvice(accountDAO, membershipDAO);

			// demoAfterReturningAdvice(accountDAO);

			demoAfterThrowingAdvice(accountDAO);
		};
	}

	private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call business method
		Account account = new Account();
		account.setName("Madhu");
		account.setLevel("platinum");
		accountDAO.addAccount(account, true);
		accountDAO.doWork();

		// Call the AccountDAO Getter/Setters methods
		accountDAO.setName("FooBar");
		accountDAO.setServiceCode("Silver");
		accountDAO.getName();
		accountDAO.getServiceCode();

		// call membership business method
		membershipDAO.addAccount();
		membershipDAO.addMember();
		membershipDAO.goToSleep();
	}

	private void demoAfterReturningAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("\n\nMain Program: demoAfterReturningAdvice");
		accounts.forEach(System.out::println);
		System.out.println("\n");
	}


	private void demoAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try {
			boolean tripWire = true;

			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception exception) {
			System.out.println("\n\nMain Program: ... caught exception: " + exception);
		}

		System.out.println("\n\nMain Program: demoAfterReturningAdvice");
		System.out.println(accounts);
		System.out.println("\n");
	}

}
