package br.com.project.rest.cashback.service.impl;

import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.Genero;
import br.com.project.rest.cashback.repository.DiscoRepository;
import br.com.project.rest.cashback.repository.GeneroRepository;
import br.com.project.rest.cashback.service.IDiscoService;
import br.com.project.rest.cashback.service.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscoService implements IDiscoService {

    private final DiscoRepository discoRepository;

    @Autowired
    public DiscoService(DiscoRepository discoRepository){
        this.discoRepository = discoRepository;
    }

    @Override
    public void saveDiscos(List<Disco> discos){
        discoRepository.saveAll(discos);
    }
}
