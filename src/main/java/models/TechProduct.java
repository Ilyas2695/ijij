package models;

import jakarta.persistence.*;
import lombok.Data;

@Data // Generates getters, setters, toString(), equals(), and hashCode() methods
@Entity
public class TechProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer amount;
    private Float price;
    private Float weight;
    private String description;
    private String review;
    private Integer score;

    public TechProduct(String name,
                       Integer amount,
                       Float price,
                       Float weight,
                       String description,
                       String review,
                       Integer score) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.weight = weight;
        this.description = description;
        this.review = review;
        this.score = score;
    }
}