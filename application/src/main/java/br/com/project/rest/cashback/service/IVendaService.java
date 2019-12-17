package br.com.project.rest.cashback.service;

import br.com.project.rest.cashback.model.ItemDiscoVenda;
import br.com.project.rest.cashback.model.Venda;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface IVendaService {

    void saveVenda(List<ItemDiscoVenda> itens, Venda venda);

    Venda findVenda(Long vendaId);

    Page<Venda> findVendas(LocalDate dataInicio, LocalDate dataFim, Integer page, Integer linesPerPage, String orderBy, String direction);
}
