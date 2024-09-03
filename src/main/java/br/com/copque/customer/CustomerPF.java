package br.com.copque.customer;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class CustomerPF extends Customer {

    @Builder
    public CustomerPF(String name) {
        super(name, CustomerType.PF);
    }

}
