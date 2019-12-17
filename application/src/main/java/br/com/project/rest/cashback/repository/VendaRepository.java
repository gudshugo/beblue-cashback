package br.com.project.rest.cashback.repository;

import br.com.project.rest.cashback.model.Venda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface VendaRepository extends JpaRepository<Venda, Integer> {

    Venda findVendaById(Long vendaId);

    Page<Venda> findByDataVendaBetween(LocalDate dataInicio, LocalDate dataFim, Pageable pageRequest);

}
