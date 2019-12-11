package br.com.project.rest.cashback.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Disco {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private UUID uniqueId;
    private String nome;
    private Date dataLancamento;
    private Long totalFaixas;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    public static class Builder {

        private Long id;
        private UUID uniqueId;
        private String nome;
        private Date dataLancamento;
        private Genero genero;

        public Builder setId(Long id){
            this.id = id;
            return this;
        }

        public Builder withUniqueId(UUID uniqueId){
            this.uniqueId = uniqueId;
            return this;
        }

        public Builder withNome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder withDataLancamento(Date dataLancamento){
            this.dataLancamento = dataLancamento;
            return this;
        }

        public Builder withGenero(Genero genero){
            this.genero = genero;
            return this;
        }

        public Disco build() {
            return new Disco(this);
        }

    }

    private Disco(Builder builder) {
        id = builder.id;
        uniqueId = builder.uniqueId;
        nome = builder.nome;
        dataLancamento = builder.dataLancamento;
        genero = builder.genero;
    }

}
