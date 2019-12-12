package br.com.project.rest.cashback.resources;

import br.com.project.rest.cashback.service.IVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendaResource {

    private final IVendaService vendaService;

    @Autowired
    public VendaResource(IVendaService vendaService){
        this.vendaService = vendaService;
    }



}
