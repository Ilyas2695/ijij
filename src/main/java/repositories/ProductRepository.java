package repositories;

import models.TechProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<TechProduct, Long> {
    List<TechProduct> findAll();
    TechProduct findByNameAndZipCode(String name, String zipCode);
    List<TechProduct> findByZipCodeAndApprovedScoresOrderByScoreDesc(String zipcode, Integer score);
    List<TechProduct> findByScoreGreaterThan(Integer score);
    List<TechProduct> findByPriceLessThan(Float price);
    List<TechProduct> findByWeightBetween(Float minWeight, Float maxWeight);
    List<TechProduct> findByDescriptionContains(String keyword);
    List<TechProduct> findByAmountGreaterThanAndPriceLessThan(Integer amount, Float price);

}
