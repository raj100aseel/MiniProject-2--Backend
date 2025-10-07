package com.rajtech.bankapp.service;

import java.util.List;

import com.rajtech.bankapp.dto.AccountDto;

public interface AccountService {
	AccountDto openAccount(AccountDto accountDto);
	AccountDto getAccountByAccountNumber(int accountNumber);
	AccountDto deposit(int accountNumber, double depositAmount);
	AccountDto withdraw(int accountNumber, double withdrawAmount);
	List<AccountDto> getAllAccounts();
	void deleteAccount(int accountNumber);
}
