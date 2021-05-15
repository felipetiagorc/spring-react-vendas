package com.springreact.vendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springreact.vendas.dto.SaleDTO;
import com.springreact.vendas.dto.SaleSuccessDTO;
import com.springreact.vendas.dto.SaleSumDTO;
import com.springreact.vendas.entities.Sale;
import com.springreact.vendas.repositories.SaleRepository;
import com.springreact.vendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repo;
	
	@Autowired
	private SellerRepository sellerRepo;
	
	@Transactional(readOnly = true)   // pra dizer q não precisa fazer lock de escrita no banco 
	public Page<SaleDTO> findAll(Pageable page){
		// pra não ficar fazendo varios selects desnecessários
		// buscando todos aqui, a JPA armazena em cache
		sellerRepo.findAll(); 
		Page<Sale> result = repo.findAll(page);   
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> totalAgrupadoPorSeller() {
		return repo.totalAgrupadoPorSeller();
	}

	public List<SaleSuccessDTO> sucessoAgrupadoPorSeller() {
		return repo.sucessoAgrupadoPorSeller();
	} 
	
	
}
