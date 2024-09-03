package br.com.copque.customer;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class CustomerPJ extends Customer {

    @Builder
    public CustomerPJ(String name) {
        super(name, CustomerType.PJ);
    }

}
