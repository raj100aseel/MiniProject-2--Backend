package com.rajtech.bankapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name="accounts")
public class Account {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="account_number")
	private Long accountNumber;
	@Column (name="customer_name")
	private String customerName;
	@Column (name="account_balance")
	private double accountBalance;
}
