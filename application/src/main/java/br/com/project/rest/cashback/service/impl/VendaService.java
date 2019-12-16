package br.com.project.rest.cashback.service.impl;

import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.ItemDiscoVenda;
import br.com.project.rest.cashback.model.Venda;
import br.com.project.rest.cashback.repository.VendaRepository;
import br.com.project.rest.cashback.service.IVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VendaService implements IVendaService {

    private final VendaRepository vendaRepository;

    @Autowired
    public VendaService(VendaRepository vendaRepository){
        this.vendaRepository = vendaRepository;
    }


    public void saveVenda(List<ItemDiscoVenda> itens){

        Double totalVenda = itens.stream().mapToDouble(ItemDiscoVenda::getValorVenda).reduce(0, Double::sum);
        Double totalCashback = itens.stream().mapToDouble(ItemDiscoVenda::getValorCashback).reduce(0, Double::sum);

        Venda venda = new Venda.Builder()
                .withDataVenda(new Date())
                .withValorVenda(totalVenda)
                .withUniqueId(UUID.randomUUID())
                .withValorCashback(totalCashback)
                .withItemDiscoVendas(itens)
                .build();

        vendaRepository.save(venda);
    }

}
