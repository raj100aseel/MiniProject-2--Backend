package com.rajtech.bankapp.dto;

import com.rajtech.bankapp.entity.Account;

public class AccountMapper {
	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
					accountDto.getAccountNumber(),
					accountDto.getCustomerName(),
					accountDto.getAccountBalance()
				);
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
					account.getAccountNumber(),
					account.getCustomerName(),
					account.getAccountBalance()
				);
		return accountDto;
	}
}
