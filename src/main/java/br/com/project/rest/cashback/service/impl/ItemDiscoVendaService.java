package br.com.project.rest.cashback.service.impl;

import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.Venda;
import br.com.project.rest.cashback.repository.ItemDiscoVendaRepository;
import br.com.project.rest.cashback.service.IItemDiscoVendaService;

public class ItemDiscoVendaService implements IItemDiscoVendaService {

    private final ItemDiscoVendaRepository itemDiscoVendaRepository;

    public ItemDiscoVendaService(ItemDiscoVendaRepository itemDiscoVendaRepository){
        this.itemDiscoVendaRepository = itemDiscoVendaRepository;
    }

    public void salvarItemDiscoVenda(Disco disco, Venda venda){

    }

}

