package br.com.project.rest.cashback.service.impl;

import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.Venda;
import br.com.project.rest.cashback.service.IDiscoService;
import br.com.project.rest.cashback.service.IVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VendaService implements IVendaService {

    private final IDiscoService discoService;

    @Autowired
    public VendaService(IDiscoService discoService){
        this.discoService = discoService;
    }

    public void realizarVendaDisco(List<Long> discoIds){

        List<Disco> discos = discoService.findListaDiscosPorIds(discoIds);

        if(!discos.isEmpty()){


        }
    }

}
