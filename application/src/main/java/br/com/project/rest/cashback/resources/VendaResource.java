package br.com.project.rest.cashback.resources;

import br.com.project.rest.cashback.model.dto.DiscosListaDTO;
import br.com.project.rest.cashback.service.impl.ItemDiscoVendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Resource para realizar operações com a entidade Venda e relacionados a ela.")
public class VendaResource {

    private final ItemDiscoVendaService itemDiscoVendaService;

    @Autowired
    public VendaResource(ItemDiscoVendaService itemDiscoVendaService){
        this.itemDiscoVendaService = itemDiscoVendaService;
    }


    @ApiOperation("Endpoint para registrar uma nova venda de discos calculando o valor total de cashback considerando a tabela.")
    @PostMapping(value = "/v1/venda", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> vendaDiscos(@RequestBody DiscosListaDTO discoLista){
        Boolean inserted = itemDiscoVendaService.saveItemVendaDisco(discoLista);
        return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    }


}
