package br.com.project.rest.cashback.service.impl;

import br.com.project.rest.cashback.enumeration.DiaEnum;
import br.com.project.rest.cashback.exceptions.DiscoNotFoundException;
import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.ItemDiscoVenda;
import br.com.project.rest.cashback.model.Venda;
import br.com.project.rest.cashback.model.dto.DiscoCashbacksDTO;
import br.com.project.rest.cashback.model.dto.DiscosListaDTO;
import br.com.project.rest.cashback.repository.ItemDiscoVendaRepository;
import br.com.project.rest.cashback.service.IDiscoService;
import br.com.project.rest.cashback.service.IGeneroCashBackService;
import br.com.project.rest.cashback.service.IItemDiscoVendaService;
import br.com.project.rest.cashback.service.IVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ItemDiscoVendaService implements IItemDiscoVendaService {

    private final IDiscoService discoService;

    private final IGeneroCashBackService generoCashBackService;

    private final IVendaService vendaService;

    @Autowired
    public ItemDiscoVendaService(IDiscoService discoService, IGeneroCashBackService generoCashBackService, IVendaService vendaService){
        this.discoService = discoService;
        this.generoCashBackService = generoCashBackService;
        this.vendaService = vendaService;
    }

    @Override
    public Boolean saveItemVendaDisco(DiscosListaDTO discosLista){

        Map<Disco, Double> findCashbackPorDisco = this.recuperarCashbackPorDiscos(discosLista.getDiscoIds());

        if(!findCashbackPorDisco.isEmpty()){

            Venda venda = new Venda();
            venda.setUniqueId(UUID.randomUUID());

            List<ItemDiscoVenda> itens = findCashbackPorDisco.entrySet().stream()
                    .map(item -> new ItemDiscoVenda.Builder()
                    .withVenda(venda)
                    .withValorVenda(item.getKey().getValor())
                    .withDisco(item.getKey())
                    .withValorCashback(item.getKey().getValor() * item.getValue())
                    .build()).collect(Collectors.toList());

            vendaService.saveVenda(itens, venda);

            return true;
        }

       return false;
    }

    @Override
    public Map<Disco, Double> recuperarCashbackPorDiscos(List<Long> listaDiscosIds){

        List<Disco> discos = discoService.findListaDiscosPorIds(listaDiscosIds);

        List<Double> cashbackValues = generoCashBackService.findGeneroCashBackPorGeneroHoje(listaDiscosIds, DiaEnum.toEnum(new Date()));

        return IntStream.range(0, discos.size())
                        .boxed()
                        .collect(Collectors.toMap(discos::get,
                                cashbackValues::get));

    }

}
