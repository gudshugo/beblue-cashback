package br.com.project.rest.cashback.service.impl;

import br.com.project.rest.cashback.model.Genero;
import br.com.project.rest.cashback.repository.GeneroRepository;
import br.com.project.rest.cashback.service.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService implements IGeneroService {

    private final GeneroRepository generoRepository;

    @Autowired
    public GeneroService(GeneroRepository generoRepository){
        this.generoRepository = generoRepository;
    }

    @Override
    public List<Genero> findGeneros(){return generoRepository.findAll();}
}
