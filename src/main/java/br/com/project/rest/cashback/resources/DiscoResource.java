package br.com.project.rest.cashback.resources;

import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.service.IDiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoResource {

    private final IDiscoService discoService;

    @Autowired
    public DiscoResource(IDiscoService discoService){
        this.discoService = discoService;
    }

    @GetMapping(value = "/v1/albums")
    public ResponseEntity<Page<Disco>> findAlbums(
            @RequestParam(value="generoId", defaultValue="0", required = true) Long generoId,
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="10") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction){

        Page<Disco> discos = discoService.findAlbums(generoId, page, linesPerPage, orderBy, direction);
        return new ResponseEntity<>(discos, HttpStatus.OK);
    }

}
