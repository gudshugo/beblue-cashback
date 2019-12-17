package br.com.project.rest.cashback.service;

import br.com.project.rest.cashback.enumeration.DiaEnum;
import br.com.project.rest.cashback.repository.GeneroCashBackRepository;
import br.com.project.rest.cashback.service.impl.GeneroCashBackService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class GeneroCashBackServiceImplTest {

    private GeneroCashBackRepository generoCashBackRepository;

    @Before
    public void setup() {

        this.generoCashBackRepository = Mockito.mock(GeneroCashBackRepository.class);

    }

    @Test
    public void testFindGeneroCashBackPorGeneroHoje(){

        List<Double> cashbacks = new ArrayList<>();

        List<Long> discos = new ArrayList<>();
        discos.add(1L);
        discos.add(2L);

        Mockito.when(generoCashBackRepository.findGeneroCashBackByGeneroInAndDia(discos, DiaEnum.DOM)).thenReturn(cashbacks);

        GeneroCashBackService generoCashBackService = new GeneroCashBackService(generoCashBackRepository);
        List<Double> cashbacksTested = generoCashBackService.findGeneroCashBackPorGeneroHoje(discos, DiaEnum.QUA);

        Assert.assertEquals(cashbacks, cashbacksTested);
    }

}
