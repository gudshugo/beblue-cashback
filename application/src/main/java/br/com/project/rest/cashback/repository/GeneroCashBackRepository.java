package br.com.project.rest.cashback.repository;

import br.com.project.rest.cashback.enumeration.DiaEnum;
import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.GeneroCashBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GeneroCashBackRepository extends JpaRepository<GeneroCashBack, Integer> {

    @Query(value = "select gc.cashback from GeneroCashBack gc " +
            " inner join Disco d on d.genero = gc.genero " +
            " where d.id in (:discos) and gc.dia = :dia")
    List<Double> findGeneroCashBackByGeneroInAndDia(List<Long> discos, DiaEnum dia);

}
