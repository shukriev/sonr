package com.sonr.crawler.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sonr.crawler.model.Account;
import com.sonr.crawler.model.Block;
import com.sonr.crawler.model.BlocksResult;
import com.sonr.crawler.model.RelationBlock;
import com.sonr.crawler.model.TestBlock;
import com.sonr.crawler.repository.RelationBlockRepository;
import com.sonr.crawler.services.AccountService;
import com.sonr.crawler.services.BlockService;

@Component
public class AnalyticsScheduler {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AccountService accountService;

	@Autowired
	private BlockService blockService;

	@Autowired
	private RelationBlockRepository repo;

	private static String mainBlockUrl = "http://api.etherscan.io/api?module=account&action=txlist&address=%s&startblock=0&endblock=99999999&sort=asc&apikey=YourApiKeyToken";

	public static final String[] ETHER_ACCOUNTS = { "0x281055afc982d96fab65b3a49cac8b878184cb16",
			"0x6f46cf5569aefa1acc1009290c8e043747172d89"};
	
//	, "0x90e63c3d53e0ea496845b7a03ec7548b70014a91",
//	"0xab7c74abc0c4d48d1bdad5dcb26153fc8780f83e", "0x53d284357ec70ce289d6d64134dfac8e511c8a3d",
//	"0xfe9e8709d3215310075d67e3ed32a380ccf451c8", "0xe853c56864a2ebe4576a807d26fdc4a0ada51919",
//	"0xfbb1b73c4f0bda4f67dca266ce6ef42f520fbb98", "0x61edcdf5bb737adffe5043706e7c5bb1f1a56eea",
//	"0xf27daff52c38b2c373ad2b9392652ddf433303c4", "0x3d2e397f94e415d7773e72e44d5b5338a99e77d9",
//	"0xb8487eed31cf5c559bf3f4edd166b949553d0d11", "0xde0b295669a9fd93d5f28d9ec85e40f4cb697bae",
//	"0xf4b51b14b9ee30dc37ec970b50a486f37686e2a8", "0x74660414dfae86b196452497a4332bd0e6611e82",
//	"0xfca70e67b3f93f679992cd36323eeb5a5370c8e4", "0x1b3cb81e51011b549d78bf720b0d924ac763a7c2",
//	"0x6f52730dba7b02beefcaf0d6998c9ae901ea04f9", "0x5ffc99b5b23c5ab8f463f6090342879c286a29be",
//	"0x847ed5f2e5dde85ea2b685edab5f1f348fb140ed"

	@Scheduled(fixedRate = 60000)
	public void blockScheduler() {

		for (String accountAddress : ETHER_ACCOUNTS) {
			Account account = new Account(accountAddress);

			BlocksResult incomingBlocks = restTemplate.getForObject(String.format(mainBlockUrl, accountAddress),
					BlocksResult.class);

			incomingBlocks.getResult().parallelStream().forEach(block -> {
//				blockService.saveBlock(block);
				System.out.println("Block: " + block.getBlockHash() + " was created!");

				account.setReceiveBlock(block);
			});

			accountService.saveAccount(account);
			System.out.println("Account: " + account.getAddress_hash() + " was created!");

		}
		
		System.out.println("=================================== Block Schedular ===================================");
	}
}
