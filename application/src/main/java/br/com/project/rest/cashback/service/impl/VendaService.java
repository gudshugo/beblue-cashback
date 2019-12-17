package br.com.project.rest.cashback.service.impl;

import br.com.project.rest.cashback.exceptions.VendaNotFoundException;
import br.com.project.rest.cashback.model.ItemDiscoVenda;
import br.com.project.rest.cashback.model.Venda;
import br.com.project.rest.cashback.repository.VendaRepository;
import br.com.project.rest.cashback.service.IVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService implements IVendaService {

    private final VendaRepository vendaRepository;

    @Autowired
    public VendaService(VendaRepository vendaRepository){
        this.vendaRepository = vendaRepository;
    }

    public void saveVenda(List<ItemDiscoVenda> itens, Venda venda){

        Double totalVenda = itens.stream().mapToDouble(ItemDiscoVenda::getValorVenda).reduce(0, Double::sum);
        Double totalCashback = itens.stream().mapToDouble(ItemDiscoVenda::getValorCashback).reduce(0, Double::sum);

        venda.setDataVenda(new Date());
        venda.setValorVenda(totalVenda);
        venda.setValorCashback(totalCashback);
        venda.setItemDiscoVendas(itens);

        vendaRepository.save(venda);
    }

    @Override
    public Venda findVenda(Integer id){

        Optional<Venda> venda =vendaRepository.findById(id);

        if(venda.isPresent())
            return venda.get();

        throw new VendaNotFoundException(String.format("Disco com id: %d não encontrado", id));
    }

}
