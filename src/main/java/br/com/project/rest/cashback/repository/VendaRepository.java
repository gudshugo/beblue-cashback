package br.com.project.rest.cashback.repository;

import br.com.project.rest.cashback.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Integer> {

}
