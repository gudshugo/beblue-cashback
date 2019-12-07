package br.com.project.rest.cashback.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Disco {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private UUID uniqueId;
    private Genero genero;


}
