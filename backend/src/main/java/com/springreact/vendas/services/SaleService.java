package com.springreact.vendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springreact.vendas.dto.SaleDTO;
import com.springreact.vendas.entities.Sale;
import com.springreact.vendas.repositories.SaleRepository;
import com.springreact.vendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repo;
	
	@Autowired
	private SellerRepository sellerRepo;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable page){
		sellerRepo.findAll();
		Page<Sale> result = repo.findAll(page);   
		return result.map(x -> new SaleDTO(x));
		
	}

}
