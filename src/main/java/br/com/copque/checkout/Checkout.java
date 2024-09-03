package br.com.copque.checkout;

import br.com.copque.customer.Customer;
import br.com.copque.stock.ProductItem;
import br.com.copque.vo.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToMany
    private List<ProductItem> items;

    private BigDecimal totalAmount;

    private String address;

    public void setAddress(Address address) {
        this.address = address.toString();
    }

}
