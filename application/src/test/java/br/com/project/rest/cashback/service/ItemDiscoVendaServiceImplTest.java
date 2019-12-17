package br.com.project.rest.cashback.service;

import br.com.project.rest.cashback.enumeration.DiaEnum;
import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.Genero;
import br.com.project.rest.cashback.model.dto.DiscosListaDTO;
import br.com.project.rest.cashback.repository.DiscoRepository;
import br.com.project.rest.cashback.repository.GeneroCashBackRepository;
import br.com.project.rest.cashback.service.impl.DiscoService;
import br.com.project.rest.cashback.service.impl.GeneroCashBackService;
import br.com.project.rest.cashback.service.impl.ItemDiscoVendaService;
import br.com.project.rest.cashback.service.impl.VendaService;
import br.com.project.rest.cashback.utils.UtilMethods;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.*;

public class ItemDiscoVendaServiceImplTest {

    private ItemDiscoVendaService itemDiscoVendaService;
    private IDiscoService discoService;
    private IGeneroCashBackService generoCashBackService;
    private IVendaService vendaService;

    private Disco discoA;
    
    @Before
    public void setup() {
        this.itemDiscoVendaService = Mockito.mock(ItemDiscoVendaService.class);
        this.discoService = Mockito.mock(DiscoService.class);
        this.generoCashBackService = Mockito.mock(GeneroCashBackService.class);
        this.vendaService = Mockito.mock(VendaService.class);

        this.discoA = new Disco();
        this.discoA.setId(1L);
        this.discoA.setNome("Disco for Test A");
        this.discoA.setUniqueId(UUID.randomUUID());
        this.discoA.setValor(UtilMethods.randomPriceGenerator());
        this.discoA.setGenero(this.genero);

    }

    @Test
    public void testSaveItemVendaDisco(){

        DiscosListaDTO discosListaDTO = new DiscosListaDTO();

        List<Disco> discosList = new ArrayList<>();
        discosList.add(discoA);

        List<Double> cashbacks = new ArrayList<>();
        cashbacks.add(0.2);

        List<Long> discos = new ArrayList<>();
        discos.add(1L);
        discos.add(2L);
        discos.add(3L);

        discosListaDTO.setDiscoIds(discos);

        Double cashback = 0.5;

        Map<Disco, Double> map = new HashMap<>();
        map.put(discoA, cashback);

        Mockito.when(itemDiscoVendaService.recuperarCashbackPorDiscos(discos)).thenReturn(map);
        Mockito.when(discoService.findListaDiscosPorIds(discos)).thenReturn(discosList);
        Mockito.when(generoCashBackService.findGeneroCashBackPorGeneroHoje(discos, DiaEnum.toEnum(new Date()))).thenReturn(cashbacks);

        ItemDiscoVendaService itemDiscoVendaService = new ItemDiscoVendaService(discoService, generoCashBackService, vendaService);
        Boolean insertedTested = itemDiscoVendaService.saveItemVendaDisco(discosListaDTO);

        Assert.assertTrue(insertedTested);
    }

    @Test
    public void testRecuperarCashbackPorDiscos(){

        List<Disco> discosList = new ArrayList<>();
        discosList.add(discoA);

        List<Double> cashbacks = new ArrayList<>();
        cashbacks.add(0.2);

        List<Long> discos = new ArrayList<>();
        discos.add(1L);

        Double cashback = 0.2;

        Map<Disco, Double> map = new HashMap<>();
        map.put(discoA, cashback);

        Mockito.when(discoService.findListaDiscosPorIds(discos)).thenReturn(discosList);
        Mockito.when(generoCashBackService.findGeneroCashBackPorGeneroHoje(discos, DiaEnum.toEnum(new Date()))).thenReturn(cashbacks);

        ItemDiscoVendaService itemDiscoVendaService = new ItemDiscoVendaService(discoService, generoCashBackService, vendaService);
        Map<Disco, Double> mapTested = itemDiscoVendaService.recuperarCashbackPorDiscos(discos);

        Assert.assertEquals(map, mapTested);
    }

    @Test
    public void testEmptyListForSaveItemVendaDisco(){

        DiscosListaDTO discosListaDTO = new DiscosListaDTO();

        List<Long> discosList = new ArrayList<>();

        discosListaDTO.setDiscoIds(discosList);

        ItemDiscoVendaService itemDiscoVendaService = new ItemDiscoVendaService(discoService, generoCashBackService, vendaService);
        Boolean inserted = itemDiscoVendaService.saveItemVendaDisco(discosListaDTO);

        Assert.assertFalse(inserted);
    }

}
