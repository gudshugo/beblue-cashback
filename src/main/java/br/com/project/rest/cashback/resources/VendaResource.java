package br.com.project.rest.cashback.resources;

import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.service.IDiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendaResource {

    private final IDiscoService discoService;

    @Autowired
    public VendaResource(IDiscoService discoService){
        this.discoService = discoService;
    }



}
