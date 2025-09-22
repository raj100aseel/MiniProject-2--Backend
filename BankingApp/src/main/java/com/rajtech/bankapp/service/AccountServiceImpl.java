package com.rajtech.bankapp.service;

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

}
