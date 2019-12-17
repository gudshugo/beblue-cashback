package br.com.project.rest.cashback.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "disco_venda")
@Getter
@NoArgsConstructor
@Setter
public class ItemDiscoVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "disco_id")
    private Disco disco;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    private Double valorVenda;

    private Double valorCashback;

    public static class Builder {

        private Long id;
        private Disco disco;
        private Venda venda;
        private Double valorVenda;
        private Double valorCashback;

        public Builder setId(Long id){
            this.id = id;
            return this;
        }

        public Builder withDisco(Disco disco){
            this.disco = disco;
            return this;
        }

        public Builder withVenda(Venda venda){
            this.venda = venda;
            return this;
        }

        public Builder withValorVenda(Double valorVenda){
            this.valorVenda = valorVenda;
            return this;
        }

        public Builder withValorCashback(Double valorCashback){
            this.valorCashback = valorCashback;
            return this;
        }

        public ItemDiscoVenda build(){
            return new ItemDiscoVenda(this);
        }
    }

    private ItemDiscoVenda(Builder builder){
        id = builder.id;
        disco = builder.disco;
        venda = builder.venda;
        valorVenda = builder.valorVenda;
        valorCashback = builder.valorCashback;
    }
}
