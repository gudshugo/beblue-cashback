package br.com.project.rest.cashback.service;

import br.com.project.rest.cashback.model.ItemDiscoVenda;
import br.com.project.rest.cashback.model.Venda;

import java.util.List;

public interface IVendaService {

    void saveVenda(List<ItemDiscoVenda> itens, Venda venda);

    Venda findVenda(Integer id);
}
