package br.com.project.rest.cashback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Genero {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String descricao;

    public static class Builder {

        private Integer id;
        private String descricao;

        public Builder setId(Integer id){
            this.id = id;
            return this;
        }

        public Builder withDescricao(String descricao){
            this.descricao = descricao;
            return this;
        }

        public Genero build(){
            return new Genero(this);
        }

    }

    private Genero(Builder builder){
        id = builder.id;
        descricao = builder.descricao;
    }
}
