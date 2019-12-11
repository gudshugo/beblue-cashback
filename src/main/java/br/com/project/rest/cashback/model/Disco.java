package br.com.project.rest.cashback.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Disco {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private UUID uniqueId;
    private String nome;
    private LocalDateTime dataLancamento;
    private Long totalFaixas;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    private Disco(DiscoBuilder builder){
        id = builder.id;
        uniqueId = builder.uniqueId;
        nome = builder.nome;
        dataLancamento = builder.dataLancamento;
        totalFaixas = builder.totalFaixas;
        genero = builder.genero;
    }

    private static class DiscoBuilder {

        private Long id;
        private UUID uniqueId;
        private String nome;
        private LocalDateTime dataLancamento;
        private Long totalFaixas;
        private Genero genero;

        public DiscoBuilder setId(){
            this.id = id;
            return this;
        }

        public DiscoBuilder withUniqueId(){
            this.uniqueId = UUID.randomUUID();
            return this;
        }

        public DiscoBuilder withNome(){
            this.nome = nome;
            return this;
        }

        public DiscoBuilder withDataLancamento(){
            this.dataLancamento = dataLancamento;
            return this;
        }

        public DiscoBuilder withTotalFaixas(){
            this.totalFaixas = totalFaixas;
            return this;
        }

        public DiscoBuilder withGenero(){
            this.genero = genero;
            return this;
        }

        public Disco build(){
            return new Disco(this);
        }

    }

}
