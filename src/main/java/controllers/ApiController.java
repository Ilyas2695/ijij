package controllers;

import models.Customer;
import models.ProductReview;
import models.ReviewStatus;
import models.TechProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;
import repositories.CustomerRepository;
import repositories.ProductRepository;
import repositories.ProductReviewRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ApiController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductReviewRepository productReviewRepository;

    // Endpoint to create a customer
    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    // Endpoint to create a tech product
    @PostMapping("/tech-products")
    public ResponseEntity<TechProduct> createTechProduct(@RequestBody TechProduct techProduct) {
        TechProduct createdTechProduct = productRepository.save(techProduct);
        return new ResponseEntity<>(createdTechProduct, HttpStatus.CREATED);
    }

    // Endpoint to create a product review
    @PostMapping("/product-reviews")
    public ResponseEntity<ProductReview> createProductReview(@RequestBody ProductReview productReview) {
        ProductReview createdProductReview = productReviewRepository.save(productReview);
        return new ResponseEntity<>(createdProductReview, HttpStatus.CREATED);
    }

    // Endpoint to get all customers
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Endpoint to get all tech products
    @GetMapping("/tech-products")
    public ResponseEntity<List<TechProduct>> getAllTechProducts() {
        List<TechProduct> techProducts = productRepository.findAll();
        return new ResponseEntity<>(techProducts, HttpStatus.OK);
    }

    // Endpoint to get all product reviews
    @GetMapping("/product-reviews")
    public ResponseEntity<List<ProductReview>> getAllProductReviews() {
        List<ProductReview> productReviews = productReviewRepository.findAll();
        return new ResponseEntity<>(productReviews, HttpStatus.OK);
    }

    // Endpoint to get all customers sorted by name in ascending order
    @GetMapping("/sort-by-name-asc")
    public ResponseEntity<List<Customer>> getAllCustomersSortedByNameAsc() {
        List<Customer> customers = customerRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Endpoint to get all customers sorted by name in descending order
    @GetMapping("/sort-by-name-desc")
    public ResponseEntity<List<Customer>> getAllCustomersSortedByNameDesc() {
        List<Customer> customers = customerRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Endpoint to get all customers sorted by city in ascending order
    @GetMapping("/sort-by-city-asc")
    public ResponseEntity<List<Customer>> getAllCustomersSortedByCityAsc() {
        List<Customer> customers = customerRepository.findAll(Sort.by(Sort.Direction.ASC, "city"));
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Endpoint to get all customers sorted by city in descending order
    @GetMapping("/sort-by-city-desc")
    public ResponseEntity<List<Customer>> getAllCustomersSortedByCityDesc() {
        List<Customer> customers = customerRepository.findAll(Sort.by(Sort.Direction.DESC, "city"));
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ProductReview>> getProductReviewsByStatus(@PathVariable ReviewStatus status) {
        List<ProductReview> productReviews = productReviewRepository.findByStatus(status);
        return new ResponseEntity<>(productReviews, HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ProductReview>> getProductReviewsByCustomerId(@PathVariable Long customerId) {
        List<ProductReview> productReviews = productReviewRepository.findByCustomerId(customerId);
        return new ResponseEntity<>(productReviews, HttpStatus.OK);
    }

    @GetMapping("/tech-product/{techProductId}")
    public ResponseEntity<List<ProductReview>> getProductReviewsByTechProductId(@PathVariable Long techProductId) {
        List<ProductReview> productReviews = productReviewRepository.findByTechProductId(techProductId);
        return new ResponseEntity<>(productReviews, HttpStatus.OK);
    }

    @GetMapping("/score-greater-than/{score}")
    public ResponseEntity<List<ProductReview>> getProductReviewsByScoreGreaterThan(@PathVariable int score) {
        List<ProductReview> productReviews = productReviewRepository.findByScoreGreaterThan(score);
        return new ResponseEntity<>(productReviews, HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}/status/{status}")
    public ResponseEntity<List<ProductReview>> getProductReviewsByCustomerIdAndStatus(
            @PathVariable Long customerId, @PathVariable ReviewStatus status) {
        List<ProductReview> productReviews = productReviewRepository.findByCustomerIdAndStatus(customerId, status);
        return new ResponseEntity<>(productReviews, HttpStatus.OK);
    }

    @GetMapping("/tech-product/{techProductId}/score-greater-than/{score}")
    public ResponseEntity<List<ProductReview>> getProductReviewsByTechProductIdAndScoreGreaterThan(
            @PathVariable Long techProductId, @PathVariable int score) {
        List<ProductReview> productReviews = productReviewRepository.findByTechProductIdAndScore(techProductId, score);
        return new ResponseEntity<>(productReviews, HttpStatus.OK);
    }

    @GetMapping("/name/{name}/zip-code/{zipCode}")
    public ResponseEntity<TechProduct> getTechProductByNameAndZipCode(@PathVariable String name, @PathVariable String zipCode) {
        TechProduct techProduct = productRepository.findByNameAndZipCode(name, zipCode);
        return new ResponseEntity<>(techProduct, HttpStatus.OK);
    }

    @GetMapping("/zip-code/{zipCode}/approved-scores/score-greater-than/{score}")
    public ResponseEntity<List<TechProduct>> getTechProductsByZipCodeAndApprovedScoresOrderByScoreDesc(
            @PathVariable String zipCode, @PathVariable Integer score) {
        List<TechProduct> techProducts = productRepository.findByZipCodeAndApprovedScoresOrderByScoreDesc(zipCode, score);
        return new ResponseEntity<>(techProducts, HttpStatus.OK);
    }

    @GetMapping("/score-greater-than/{score}")
    public ResponseEntity<List<TechProduct>> getTechProductsByScoreGreaterThan(@PathVariable Integer score) {
        List<TechProduct> techProducts = productRepository.findByScoreGreaterThan(score);
        return new ResponseEntity<>(techProducts, HttpStatus.OK);
    }

    @GetMapping("/price-less-than/{price}")
    public ResponseEntity<List<TechProduct>> getTechProductsByPriceLessThan(@PathVariable Float price) {
        List<TechProduct> techProducts = productRepository.findByPriceLessThan(price);
        return new ResponseEntity<>(techProducts, HttpStatus.OK);
    }

    @GetMapping("/weight-between/{minWeight}/{maxWeight}")
    public ResponseEntity<List<TechProduct>> getTechProductsByWeightBetween(
            @PathVariable Float minWeight, @PathVariable Float maxWeight) {
        List<TechProduct> techProducts = productRepository.findByWeightBetween(minWeight, maxWeight);
        return new ResponseEntity<>(techProducts, HttpStatus.OK);
    }

    @GetMapping("/description-contains/{keyword}")
    public ResponseEntity<List<TechProduct>> getTechProductsByDescriptionContains(@PathVariable String keyword) {
        List<TechProduct> techProducts = productRepository.findByDescriptionContains(keyword);
        return new ResponseEntity<>(techProducts, HttpStatus.OK);
    }

    @GetMapping("/amount-greater-than/{amount}/price-less-than/{price}")
    public ResponseEntity<List<TechProduct>> getTechProductsByAmountGreaterThanAndPriceLessThan(
            @PathVariable Integer amount, @PathVariable Float price) {
        List<TechProduct> techProducts = productRepository.findByAmountGreaterThanAndPriceLessThan(amount, price);
        return new ResponseEntity<>(techProducts, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Customer> getCustomerByName(@PathVariable String name) {
        Optional<Customer> customer = customerRepository.findByName(name);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Customer>> getCustomersByCity(@PathVariable String city) {
        List<Customer> customers = customerRepository.findByCity(city);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/zip-code/{zipcode}")
    public ResponseEntity<List<Customer>> getCustomersByZipCode(@PathVariable String zipcode) {
        List<Customer> customers = customerRepository.findByZipCode(zipcode);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/has-bought/{hasBought}")
    public ResponseEntity<List<Customer>> getCustomersByHasBought(@PathVariable Boolean hasBought) {
        List<Customer> customers = customerRepository.findByHasBought(hasBought);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/is-vip/{isVip}")
    public ResponseEntity<List<Customer>> getCustomersByIsVip(@PathVariable boolean isVip) {
        List<Customer> customers = customerRepository.findByIsVip(isVip);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/city-and-vip/{city}/{isVip}")
    public ResponseEntity<List<Customer>> getCustomersByCityAndIsVip(@PathVariable String city, @PathVariable boolean isVip) {
        List<Customer> customers = customerRepository.findByCityAndIsVip(city, isVip);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


}
