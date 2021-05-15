package com.springreact.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.vendas.dto.SaleDTO;
import com.springreact.vendas.dto.SaleSuccessDTO;
import com.springreact.vendas.dto.SaleSumDTO;
import com.springreact.vendas.services.SaleService;

@RestController
@RequestMapping(value="/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable page) {
		Page<SaleDTO> list = service.findAll(page);
		return ResponseEntity.ok(list);
		
	}
	
	
	@GetMapping(value="/totalPorSeller")
	public ResponseEntity<List<SaleSumDTO>> total(Pageable page) {
		List<SaleSumDTO> list = service.totalAgrupadoPorSeller();
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping(value="/sucessoPorSeller")
	public ResponseEntity<List<SaleSuccessDTO>> success(Pageable page) {
		List<SaleSuccessDTO> list = service.sucessoAgrupadoPorSeller();
		return ResponseEntity.ok(list);
		
	}
	
	

}
