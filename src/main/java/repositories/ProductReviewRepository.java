package repositories;

import models.ProductReview;
import models.ReviewStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductReviewRepository extends CrudRepository<ProductReview, Long> {
    List<ProductReview> findAll();
    List<ProductReview> findByStatus(ReviewStatus status);
    List<ProductReview> findByCustomerId(Long customerId);
    List<ProductReview> findByTechProductId(Long techProductId);
    List<ProductReview> findByScoreGreaterThan(int score);
    List<ProductReview> findByCustomerIdAndStatus(Long customerId, ReviewStatus status);
    List<ProductReview> findByTechProductIdAndScore(Long techProductId, int score);
}
