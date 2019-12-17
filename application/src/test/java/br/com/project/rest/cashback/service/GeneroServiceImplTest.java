package br.com.project.rest.cashback.service;

import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.Genero;
import br.com.project.rest.cashback.repository.DiscoRepository;
import br.com.project.rest.cashback.repository.GeneroRepository;
import br.com.project.rest.cashback.service.impl.DiscoService;
import br.com.project.rest.cashback.service.impl.GeneroService;
import br.com.project.rest.cashback.utils.UtilMethods;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GeneroServiceImplTest {

    private GeneroRepository generoRepository;

    @Before
    public void setup() {

        this.generoRepository = Mockito.mock(GeneroRepository.class);
    }

    @Test
    public void testFindGeneros(){

        List<Genero> generos = new ArrayList<>();

        Mockito.when(generoRepository.findAll()).thenReturn(generos);

        GeneroService generoService = new GeneroService(generoRepository);
        List<Genero> generoTested = generoService.findGeneros();

        Assert.assertEquals(generos, generoTested);

    }

}
