package br.com.project.rest.cashback.model;

import br.com.project.rest.cashback.model.dto.GeneroCashBackDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@Entity
public class Genero {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String descricao;
    
}
