package com.rajtech.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountDto {
	private int accountNumber;
	private String customerName;
	private double accountBalance;
}
