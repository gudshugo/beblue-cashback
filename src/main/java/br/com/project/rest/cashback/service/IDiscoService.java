package br.com.project.rest.cashback.service;

import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.Genero;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IDiscoService {

    void saveDiscos(List<Disco> discos);

    Long checkIfExistsAnyEntry();

    Page<Disco> findAlbums(Long generoId, Integer page, Integer linesPerPage, String orderBy, String direction);

}
