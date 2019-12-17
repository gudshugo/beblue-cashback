package br.com.project.rest.cashback.service.impl;

import br.com.project.rest.cashback.exceptions.VendaNotFoundException;
import br.com.project.rest.cashback.model.ItemDiscoVenda;
import br.com.project.rest.cashback.model.Venda;
import br.com.project.rest.cashback.repository.VendaRepository;
import br.com.project.rest.cashback.service.IVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        venda.setDataVenda(LocalDate.now());
        venda.setValorVenda(totalVenda);
        venda.setValorCashback(totalCashback);
        venda.setItemDiscoVendas(itens);

        vendaRepository.save(venda);
    }

    @Override
    public Venda findVenda(Long vendaId){

        Optional<Venda> venda = Optional.ofNullable(vendaRepository.findVendaById(vendaId));

        if(venda.isPresent())
            return venda.get();

        throw new VendaNotFoundException(String.format("Venda com id: %d não encontrado", vendaId));
    }

    @Override
    public Page<Venda> findVendas(LocalDate dataInicio, LocalDate dataFim, Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return vendaRepository.findByDataVendaBetween(dataInicio, dataFim, pageRequest);
    }

}
