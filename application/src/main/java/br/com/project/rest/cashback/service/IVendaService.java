package br.com.project.rest.cashback.service;

import br.com.project.rest.cashback.model.ItemDiscoVenda;

import java.util.List;

public interface IVendaService {

    void saveVenda(List<ItemDiscoVenda> itens);
}
