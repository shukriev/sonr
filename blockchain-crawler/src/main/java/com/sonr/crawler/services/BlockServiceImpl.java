package com.sonr.crawler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonr.crawler.model.Block;
import com.sonr.crawler.repository.BlockRepository;

@Service
public class BlockServiceImpl implements BlockService {
	@Autowired
	private BlockRepository blockRepository;

	@Override
	public void saveBlock(Block block) {
		blockRepository.save(block);
	} 
}
