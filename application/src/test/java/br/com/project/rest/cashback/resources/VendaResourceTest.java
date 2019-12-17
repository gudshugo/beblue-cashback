package br.com.project.rest.cashback.resources;

import br.com.project.rest.cashback.model.ItemDiscoVenda;
import br.com.project.rest.cashback.model.Venda;
import br.com.project.rest.cashback.model.dto.DiscosListaDTO;
import br.com.project.rest.cashback.service.IItemDiscoVendaService;
import br.com.project.rest.cashback.service.IVendaService;
import br.com.project.rest.cashback.utils.UtilMethods;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class VendaResourceTest {

    private IVendaService vendaService;
    private IItemDiscoVendaService itemDiscoVendaService;

    private Venda venda;
    private List<ItemDiscoVenda> itemDiscoVenda;
    private DiscosListaDTO discosListaDTO;

    @Before
    public void setup() {

        this.vendaService = Mockito.mock(IVendaService.class);
        this.itemDiscoVendaService = Mockito.mock(IItemDiscoVendaService.class);

        this.discosListaDTO = new DiscosListaDTO();

        this.itemDiscoVenda = new ArrayList<>();

        this.venda = new Venda();
        this.venda.setId(1L);
        this.venda.setValorCashback(UtilMethods.randomPriceGenerator());
        this.venda.setValorVenda(UtilMethods.randomPriceGenerator());
        this.venda.setDataVenda(LocalDate.now());
        this.venda.setUniqueId(UUID.randomUUID());
        this.venda.setItemDiscoVendas(itemDiscoVenda);

    }

    @Test
    public void testVendaDiscos(){

        List<Long> discos = new ArrayList<>();
        discos.add(1L);
        discos.add(2L);
        discos.add(3L);

        discosListaDTO.setDiscoIds(discos);

        Mockito.when(itemDiscoVendaService.saveItemVendaDisco(discosListaDTO)).thenReturn(true);

        VendaResource vendaResource = new VendaResource(itemDiscoVendaService, vendaService);
        ResponseEntity<Boolean> vendasPageTested = vendaResource.vendaDiscos(discosListaDTO);

        Assert.assertTrue(vendasPageTested.getBody());
    }

    @Test
    public void findVenda(){

        Long idVenda = 1L;
        Venda venda = new Venda();
        venda.setId(idVenda);

        Mockito.when(vendaService.findVenda(idVenda)).thenReturn(venda);

        VendaResource vendaResource = new VendaResource(itemDiscoVendaService, vendaService);
        ResponseEntity<Venda> vendaTested = vendaResource.findVenda(idVenda);

        Assert.assertEquals(venda, vendaTested.getBody());
    }

    @Test
    public void findVendas(){

        Integer page = 0;
        Integer linesPerPage = 10;
        String orderBy = "nome";
        String direction = "ASC";

        List<Venda> vendas = new ArrayList<>();
        vendas.add(venda);

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<Venda> vendasPage = new PageImpl<>(vendas, pageRequest, vendas.size());

        Mockito.when(vendaService.findVendas(UtilMethods.toLocalDate(new Date()), UtilMethods.toLocalDate(new Date()), page, linesPerPage, orderBy, direction)).thenReturn(vendasPage);

        VendaResource vendaResource = new VendaResource(itemDiscoVendaService, vendaService);
        ResponseEntity<Page<Venda>> vendasPageTested = vendaResource.findVendas(new Date(), new Date(), page, linesPerPage,  orderBy,  direction);

        Assert.assertEquals(vendasPage, vendasPageTested.getBody());

    }



}
