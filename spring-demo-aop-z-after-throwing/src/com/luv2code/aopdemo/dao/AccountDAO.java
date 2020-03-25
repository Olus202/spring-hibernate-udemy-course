package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK");
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": DOING MY DB WORK - goToSleep()");
	}

	public String getName() {
		System.out.println(getClass() + ": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccounts(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("Exception... xd");
		}
		
		List<Account> accountList = new ArrayList<>();
		
		Account account1 = new Account("John", "1");
		Account account2 = new Account("Leo", "2");
		Account account3 = new Account("Chad", "3");
		
		accountList.add(account1);
		accountList.add(account2);
		accountList.add(account3);
		
		return accountList;
	}
	
}
