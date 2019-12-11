package br.com.project.rest.cashback.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Genero {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String descricao;

    private Genero(GeneroBuilder builder){
        id = builder.id;
        descricao = builder.descricao;
    }

    private static class GeneroBuilder {

        private Long id;
        private String descricao;

        private GeneroBuilder setId(){
            this.id = id;
            return this;
        }

        private GeneroBuilder withDescricao(){
            this.descricao = descricao;
            return this;
        }

        private Genero build(){
            return new Genero(this);
        }

    }
}
