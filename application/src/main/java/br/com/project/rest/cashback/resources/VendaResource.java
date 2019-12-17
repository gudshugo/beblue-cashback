package br.com.project.rest.cashback.resources;

import br.com.project.rest.cashback.model.Venda;
import br.com.project.rest.cashback.model.dto.DiscosListaDTO;
import br.com.project.rest.cashback.service.IItemDiscoVendaService;
import br.com.project.rest.cashback.service.IVendaService;
import br.com.project.rest.cashback.utils.UtilMethods;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@Api("Resource para realizar operações com a entidade Venda e relacionados a ela.")
public class VendaResource {

    private final IItemDiscoVendaService itemDiscoVendaService;

    private final IVendaService vendaService;

    @Autowired
    public VendaResource(IItemDiscoVendaService itemDiscoVendaService, IVendaService vendaService){
        this.itemDiscoVendaService = itemDiscoVendaService;
        this.vendaService = vendaService;
    }


    @ApiOperation("Endpoint para registrar uma nova venda de discos calculando o valor total de cashback considerando a tabela.")
    @PostMapping(value = "/v1/venda", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> vendaDiscos(@RequestBody DiscosListaDTO discoLista){
        Boolean inserted = itemDiscoVendaService.saveItemVendaDisco(discoLista);
        return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    }

    @ApiOperation("Endpoint para consultar venda por identificador.")
    @GetMapping(value = "/v1/venda/{vendaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venda> findVenda(@PathVariable Long vendaId){
        Venda venda = vendaService.findVenda(vendaId);
        return new ResponseEntity<>(venda, HttpStatus.OK);
    }

    @ApiOperation("Endpoint para consultar todas as vendas efetuadas de forma paginada, filtrando pelo range de datas (inicial e final) da venda " +
            "e ordenando de forma decrescente pela data da venda.")
    @GetMapping(value = "/v1/vendas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Venda>> findVendas(
            @RequestParam(value="dataInicio", required = true) Date dataInicio,
            @RequestParam(value="dataFim", required = true) Date dataFim,
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="10") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="dataVenda") String orderBy,
            @RequestParam(value="direction", defaultValue="DESC") String direction){

        Page<Venda> venda = vendaService.findVendas(UtilMethods.toLocalDate(dataInicio), UtilMethods.toLocalDate(dataFim), page, linesPerPage, orderBy, direction);
        return new ResponseEntity<>(venda, HttpStatus.OK);
    }

}
