package br.com.project.rest.cashback.service;

import br.com.project.rest.cashback.model.ItemDiscoVenda;
import br.com.project.rest.cashback.model.Venda;
import br.com.project.rest.cashback.repository.VendaRepository;
import br.com.project.rest.cashback.service.impl.VendaService;
import br.com.project.rest.cashback.utils.UtilMethods;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VendaServiceImplTest {

    private VendaRepository vendaRepository;

    private Venda venda;
    private List<ItemDiscoVenda> itemDiscoVenda;

    private LocalDate dateInicio;
    private LocalDate dateFim;

    @Before
    public void setup() {

        this.vendaRepository = Mockito.mock(VendaRepository.class);

        this.itemDiscoVenda = new ArrayList<>();

        this.venda = new Venda();
        this.venda.setId(1L);
        this.venda.setValorCashback(UtilMethods.randomPriceGenerator());
        this.venda.setValorVenda(UtilMethods.randomPriceGenerator());
        this.venda.setDataVenda(LocalDate.now());
        this.venda.setUniqueId(UUID.randomUUID());
        this.venda.setItemDiscoVendas(itemDiscoVenda);

        this.dateInicio = LocalDate.now();
        this.dateFim = LocalDate.now();

    }

    @Test
    public void testFindVendas(){

        Integer page = 0;
        Integer linesPerPage = 10;
        String orderBy = "dataVenda";
        String direction = "DESC";

        List<Venda> vendas = new ArrayList<>();
        vendas.add(venda);

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<Venda> vendasPage = new PageImpl<>(vendas, pageRequest, vendas.size());

        Mockito.when(vendaRepository.findByDataVendaBetween(dateInicio, dateFim, pageRequest)).thenReturn(vendasPage);

        VendaService vendaService = new VendaService(vendaRepository);
        Page<Venda> vendasPageTested = vendaService.findVendas(dateInicio, dateFim, page, linesPerPage, orderBy, direction);

        Assert.assertEquals(vendasPage, vendasPageTested);
    }

    @Test
    public void testFindPage(){

        Long idVenda = 1L;
        Venda venda = new Venda();
        venda.setId(idVenda);

        Mockito.when(vendaRepository.findVendaById(idVenda)).thenReturn(venda);

        VendaService vendaService = new VendaService(vendaRepository);
        Venda vendaTested = vendaService.findVenda(idVenda);

        Assert.assertEquals(venda, vendaTested);
    }

}
