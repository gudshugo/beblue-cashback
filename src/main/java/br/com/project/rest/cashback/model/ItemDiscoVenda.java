package br.com.project.rest.cashback.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    private ItemDiscoVenda(ItemDiscoVendaBuilder builder){
        id = builder.id;
        disco = builder.disco;
        venda = builder.venda;
        valorVenda = builder.valorVenda;
        valorCashback = builder.valorCashback;
    }

    private static class ItemDiscoVendaBuilder {

        private Long id;
        private Disco disco;
        private Venda venda;
        private Double valorVenda;
        private Double valorCashback;

        public ItemDiscoVendaBuilder setId(){
            this.id = id;
            return this;
        }

        public ItemDiscoVendaBuilder withDisco(){
            this.disco = disco;
            return this;
        }

        public ItemDiscoVendaBuilder withVenda(){
            this.venda = venda;
            return this;
        }

        public ItemDiscoVendaBuilder withValorVenda(){
            this.valorVenda = valorVenda;
            return this;
        }

        public ItemDiscoVendaBuilder withValorCashback(){
            this.valorCashback = valorCashback;
            return this;
        }

        public ItemDiscoVenda build(){
            return new ItemDiscoVenda(this);
        }
    }
}
