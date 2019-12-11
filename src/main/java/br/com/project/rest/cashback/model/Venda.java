package br.com.project.rest.cashback.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorVenda;

    private Double valorCashback;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_id")
    private List<ItemDiscoVenda> itemDiscoVendas;

    private LocalDateTime dataVenda;

    private Venda (VendaBuilder builder){
        id = builder.id;
        valorVenda = builder.valorVenda;
        valorCashback = builder.valorCashback;
        itemDiscoVendas = builder.itemDiscoVendas;
        dataVenda  = builder.dataVenda;
    }

    private static class VendaBuilder {

        private Long id;
        private Double valorVenda;
        private Double valorCashback;
        private LocalDateTime dataVenda;
        private List<ItemDiscoVenda> itemDiscoVendas;

        public VendaBuilder setId(){
            this.id = id;
            return this;
        }

        public VendaBuilder withValorVenda(){
            this.valorVenda = valorVenda;
            return this;
        }

        public VendaBuilder withValorCashback(){
            this.valorCashback = valorCashback;
            return this;
        }

        public VendaBuilder withDataVenda(){
            this.dataVenda = dataVenda;
            return this;
        }

        public VendaBuilder withItemDiscoVendas(){
            this.itemDiscoVendas = itemDiscoVendas;
            return this;
        }

        public Venda build(){
            return new Venda(this);
        }
    }

}
