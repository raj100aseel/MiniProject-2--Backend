package com.rajtech.bankapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajtech.bankapp.dto.AccountDto;
import com.rajtech.bankapp.dto.AccountMapper;
import com.rajtech.bankapp.entity.Account;
import com.rajtech.bankapp.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public AccountDto openAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountByAccountNumber(Long accountNumber) {
		Account account = accountRepository.findById(accountNumber).orElseThrow(() -> new RuntimeException("Account does not exist"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long accountNumber, double depositAmount) {
		Account account = accountRepository.findById(accountNumber).orElseThrow(() -> new RuntimeException("Account does not exist"));
		double currentBalance = account.getAccountBalance() + depositAmount;
		account.setAccountBalance(currentBalance);
		Account savedAccount  = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Long accountNumber, double withdrawAmount) {
		Account account = accountRepository.findById(accountNumber).orElseThrow(() -> new RuntimeException("Account does not exist"));
		if (account.getAccountBalance() < withdrawAmount) {
			throw new RuntimeException("Insufficient Balance");
		}
		double currentBalance = account.getAccountBalance() - withdrawAmount;
		account.setAccountBalance(currentBalance);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		return accountRepository.findAll().stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(Long accountNumber) {
		Account account = accountRepository.findById(accountNumber).orElseThrow(() -> new RuntimeException("Account does not exist"));
		accountRepository.delete(account);
	}

}













