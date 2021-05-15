package com.springreact.vendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springreact.vendas.dto.SaleSuccessDTO;
import com.springreact.vendas.dto.SaleSumDTO;
import com.springreact.vendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	//JPQL:
	//seleciona um novo construtor SaleSumDTO, chamando cada um de 'obj.seller', e usando o SUM(soma das vendas desse vendedor 'obj')
	@Query("SELECT new com.springreact.vendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> totalAgrupadoPorSeller();
	
	@Query("SELECT new com.springreact.vendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals  ))"
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> sucessoAgrupadoPorSeller();

}
 