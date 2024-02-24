package models;

import jakarta.persistence.*;
import lombok.Data;

@Data // Generates getters, setters, toString(), equals(), and hashCode() methods
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String zipcode;
    private boolean hasBought;
    private boolean isVip;

    public Customer(String name, String city, String zipcode, boolean hasBought, boolean isVip) {
        this.name = name;
        this.city = city;
        this.zipcode = zipcode;
        this.hasBought = hasBought;
        this.isVip = isVip;
    }
}