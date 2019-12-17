package br.com.project.rest.cashback.resources;

import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.Genero;
import br.com.project.rest.cashback.service.IDiscoService;
import br.com.project.rest.cashback.service.impl.DiscoService;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DiscoResourceTest {

    private IDiscoService discoService;

    private Disco discoA;
    private Disco discoB;
    private Disco discoC;

    private Genero genero;

    @Before
    public void setup() {

        this.discoService = Mockito.mock(IDiscoService.class);

        this.genero = new Genero();
        this.genero.setId(1L);
        this.genero.setDescricao("Genero for Test");

        this.discoA = new Disco();
        this.discoA.setId(1L);
        this.discoA.setNome("Disco for Test A");
        this.discoA.setUniqueId(UUID.randomUUID());
        this.discoA.setValor(UtilMethods.randomPriceGenerator());
        this.discoA.setGenero(this.genero);

        this.discoB = new Disco();
        this.discoB.setId(2L);
        this.discoB.setNome("Disco for Test B");
        this.discoB.setUniqueId(UUID.randomUUID());
        this.discoB.setValor(UtilMethods.randomPriceGenerator());
        this.discoB.setGenero(this.genero);

        this.discoC = new Disco();
        this.discoC.setId(2L);
        this.discoC.setNome("Disco for Test C");
        this.discoC.setUniqueId(UUID.randomUUID());
        this.discoC.setValor(UtilMethods.randomPriceGenerator());
        this.discoC.setGenero(this.genero);
    }

    @Test
    public void testFindDiscos(){

        Long idForTest = 1L;

        Integer page = 0;
        Integer linesPerPage = 10;
        String orderBy = "nome";
        String direction = "ASC";

        List<Disco> discos = new ArrayList<>();
        discos.add(discoA);
        discos.add(discoB);
        discos.add(discoC);

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<Disco> discosPage = new PageImpl<>(discos, pageRequest, discos.size());

        Mockito.when(discoService.findDiscos(idForTest, page, linesPerPage, orderBy, direction)).thenReturn(discosPage);

        DiscoResource discoResource = new DiscoResource(discoService);
        ResponseEntity<Page<Disco>> discoPageTested = discoResource.findDiscos(idForTest, page, linesPerPage,  orderBy,  direction);

        Assert.assertEquals(discosPage, discoPageTested.getBody());
    }

    @Test
    public void testFindDisco(){

        Long idDisco = 1L;
        Disco disco = new Disco();
        disco.setId(idDisco);

        Mockito.when(discoService.findDisco(idDisco)).thenReturn(disco);

        DiscoResource discoResource = new DiscoResource(discoService);
        ResponseEntity<Disco> discoTested = discoResource.findDisco(idDisco);

        Assert.assertEquals(disco, discoTested.getBody());

    }
}
