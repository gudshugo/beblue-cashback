package br.com.project.rest.cashback.resources;

import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.service.IDiscoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Resource para realizar operações com a entidade Disco e relacionados a ela.")
public class DiscoResource {

    private final IDiscoService discoService;

    @Autowired
    public DiscoResource(IDiscoService discoService){
        this.discoService = discoService;
    }

    @ApiOperation("Endpoint para consultar o catálogo de discos de forma paginada, filtrando por gênero e ordenando de forma crescente pelo nome do disco.")
    @GetMapping(value = "/v1/discos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Disco>> findDiscos(
            @RequestParam(value="generoId", defaultValue="0", required = true) Long generoId,
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="10") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction){

        Page<Disco> discos = discoService.findDiscos(generoId, page, linesPerPage, orderBy, direction);
        return new ResponseEntity<>(discos, HttpStatus.OK);
    }

    @ApiOperation("Endpoint para consultar o disco pelo seu identificador")
    @GetMapping(value = "/v1/disco/{discoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disco> findDisco(@PathVariable Long discoId){
        Disco disco = discoService.findDisco(discoId);
        return new ResponseEntity<>(disco, HttpStatus.OK);
    }


}
