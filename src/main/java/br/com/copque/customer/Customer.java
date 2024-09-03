package br.com.copque.customer;

import br.com.copque.vo.Document;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public abstract class Customer implements DocumentValidator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CustomerType type;

    private String name;

    private String document;

    protected Customer(String name, CustomerType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public void applyDocument(Document document) {
        this.document = document.getValue();
    }

}
