package com.sonr.crawler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonr.crawler.model.Account;
import com.sonr.crawler.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accoutnRepository; 
	
	@Override
	public void saveAccount(Account account) {
		accoutnRepository.save(account);
}

}
