package br.com.project.rest.cashback.service.impl;

import br.com.project.rest.cashback.enumeration.DiaEnum;
import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.ItemDiscoVenda;
import br.com.project.rest.cashback.model.dto.DiscosListaDTO;
import br.com.project.rest.cashback.repository.ItemDiscoVendaRepository;
import br.com.project.rest.cashback.service.IDiscoService;
import br.com.project.rest.cashback.service.IGeneroCashBackService;
import br.com.project.rest.cashback.service.IItemDiscoVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemDiscoVendaService implements IItemDiscoVendaService {

    private final ItemDiscoVendaRepository itemDiscoVendaRepository;

    private final IDiscoService discoService;

    private final IGeneroCashBackService generoCashBackService;

    @Autowired
    public ItemDiscoVendaService(ItemDiscoVendaRepository itemDiscoVendaRepository, IDiscoService discoService,
                                 IGeneroCashBackService generoCashBackService){
        this.itemDiscoVendaRepository = itemDiscoVendaRepository;
        this.discoService = discoService;
        this.generoCashBackService = generoCashBackService;
    }

    @Override
    public Boolean vendaDiscos(DiscosListaDTO discosLista){

        List<Disco> findCashbackPorDisco = this.recuperarCashbackPorDiscos(discosLista.getDiscoIds());

        if(!findCashbackPorDisco.isEmpty()){

        }

        return true;
    }

    private List<Disco> recuperarCashbackPorDiscos(List<Long> listaDiscos){
        return null;
    }

}
