package br.com.project.rest.cashback.service;

import br.com.project.rest.cashback.model.Genero;
import br.com.project.rest.cashback.repository.GeneroRepository;
import br.com.project.rest.cashback.service.impl.GeneroService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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
