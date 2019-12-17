package br.com.project.rest.cashback.model;

import br.com.project.rest.cashback.enumeration.DiaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "genero_cashback")
public class GeneroCashBack {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @Column(name = "dia")
    private DiaEnum dia;

    private Double cashback;

    public static class Builder {

        private Integer id;
        private Genero genero;
        private DiaEnum dia;
        private Double cashback;

        public Builder setId(Integer id){
            this.id = id;
            return this;
        }

        public Builder withGenero(Genero genero){
            this.genero = genero;
            return this;
        }

        public Builder withDia(DiaEnum dia){
            this.dia = dia;
            return this;
        }

        public Builder withCashback(Double cashback){
            this.cashback = cashback;
            return this;
        }

        public GeneroCashBack build(){
            return new GeneroCashBack(this);
        }
    }

    private GeneroCashBack(Builder builder){
        id = builder.id;
        genero = builder.genero;
        dia = builder.dia;
        cashback = builder.cashback;
    }

}
