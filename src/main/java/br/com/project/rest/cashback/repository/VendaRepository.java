package br.com.project.rest.cashback.repository;

import br.com.project.rest.cashback.model.Disco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VendaRepository extends JpaRepository<Disco, Integer> {

    @Query("select count(e.id) from Disco e")
    Long checkIfExistsAnyEntry();

    Page<Disco> findDiscoByGeneroId(Long generoId, Pageable pageRequest);

    Disco findDiscoById(Long id);
}
