package com.aop.AOPDemo;

import com.aop.AOPDemo.dao.AccountDAO;
import com.aop.AOPDemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			System.out.println("Hello World!");

			demoBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call business method
		Account account = new Account();
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
}
