package br.com.project.rest.cashback.model;

import br.com.project.rest.cashback.enumeration.Dia;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "genero_cashback")
public class GeneroCashBack {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @Enumerated(EnumType.ORDINAL)
    private Dia dia;

    private Double cashback;

    private GeneroCashBack(GeneroCashBackBuilder builder){
        id = builder.id;
        genero = builder.genero;
        dia = builder.dia;
        cashback = builder.cashback;
    }

    private static class GeneroCashBackBuilder {

        private Long id;
        private Genero genero;
        private Dia dia;
        private Double cashback;

        public GeneroCashBackBuilder setId(){
            this.id = id;
            return this;
        }

        public GeneroCashBackBuilder withGenero(){
            this.genero = genero;
            return this;
        }

        public GeneroCashBackBuilder withDia(){
            this.dia = dia;
            return this;
        }

        public GeneroCashBackBuilder withCashback(){
            this.cashback = cashback;
            return this;
        }

        public GeneroCashBack build(){
            return new GeneroCashBack(this);
        }
    }

}
