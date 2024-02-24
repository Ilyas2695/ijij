package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long techProductId;
    private String review;
    private int score;
    private ReviewStatus status;

    public ProductReview(Long customerId, Long techProductId, String review, int score, ReviewStatus status) {
        this.customerId = customerId;
        this.techProductId = techProductId;
        this.review = review;
        this.score = score;
        this.status = status;
    }
}

