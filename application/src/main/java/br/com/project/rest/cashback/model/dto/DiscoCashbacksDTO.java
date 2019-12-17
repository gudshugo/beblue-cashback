package br.com.project.rest.cashback.model.dto;

import br.com.project.rest.cashback.model.Disco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscoCashbacksDTO {

    private Disco disco;
    private Double cashbackValue;

    public static class Builder {

        private Disco disco;
        private Double cashbackValue;

        public Builder withDisco(Disco disco){
            this.disco = disco;
            return this;
        }

        public Builder withCashbackValue(Double cashbackValue){
            this.cashbackValue = cashbackValue;
            return this;
        }

        public DiscoCashbacksDTO build(){
            return new DiscoCashbacksDTO(this);
        }
    }

    private DiscoCashbacksDTO(Builder builder) {
        disco = builder.disco;
        cashbackValue = builder.cashbackValue;
    }

}


