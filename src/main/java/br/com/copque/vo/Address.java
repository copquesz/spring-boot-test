package br.com.copque.vo;


import lombok.Builder;

import java.util.Objects;

public class Address {
    private final String street;
    private final String number;
    private final String complement;
    private final String neighborhood;
    private final String city;
    private final String state;
    private final String postalCode;

    @Builder
    public Address(String street, String number, String complement, String neighborhood, String city, String state, String postalCode) {
        if (street == null || street.isEmpty()) {
            throw new IllegalArgumentException("Street cannot be null or empty");
        }
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Number cannot be null or empty");
        }
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        if (state == null || state.length() != 2) {
            throw new IllegalArgumentException("State must be a valid two-letter abbreviation");
        }
        if (postalCode == null || !postalCode.matches("\\d{5}-\\d{3}")) {
            throw new IllegalArgumentException("Postal code must be in the format 00000-000");
        }

        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state.toUpperCase();
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street.equals(address.street) &&
                number.equals(address.number) &&
                Objects.equals(complement, address.complement) &&
                Objects.equals(neighborhood, address.neighborhood) &&
                city.equals(address.city) &&
                state.equals(address.state) &&
                postalCode.equals(address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, complement, neighborhood, city, state, postalCode);
    }

    @Override
    public String toString() {
        StringBuilder addressBuilder = new StringBuilder();

        if (street != null && !street.isEmpty()) {
            addressBuilder.append(street);
        }

        if (number != null && !number.isEmpty()) {
            addressBuilder.append(" - ").append(number);
        }

        if (complement != null && !complement.isEmpty()) {
            addressBuilder.append(" (").append(complement).append(")");
        }

        if (neighborhood != null && !neighborhood.isEmpty()) {
            if (!addressBuilder.isEmpty()) {
                addressBuilder.append(", ");
            }
            addressBuilder.append(neighborhood);
        }

        if (city != null && !city.isEmpty()) {
            if (!addressBuilder.isEmpty()) {
                addressBuilder.append(", ");
            }
            addressBuilder.append(city);
        }

        if (state != null && !state.isEmpty()) {
            if (!addressBuilder.isEmpty()) {
                addressBuilder.append(" - ");
            }
            addressBuilder.append(state);
        }

        if (postalCode != null && !postalCode.isEmpty()) {
            if (!addressBuilder.isEmpty()) {
                addressBuilder.append(" - ");
            }
            addressBuilder.append(postalCode);
        }

        return addressBuilder.toString();
    }
}
