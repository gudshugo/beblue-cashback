package br.com.project.rest.cashback.service.impl;

import br.com.project.rest.cashback.exceptions.DiscoNotFoundException;
import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.repository.DiscoRepository;
import br.com.project.rest.cashback.service.IDiscoService;
import br.com.project.rest.cashback.service.IVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService implements IVendaService {

    @Autowired
    public VendaService(){

    }


}
