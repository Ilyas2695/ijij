package repositories;

import models.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAll();
    Optional<Customer> findByName(String name);
    List<Customer> findByCity(String city);
    List<Customer> findByZipCode(String zipcode);
    List<Customer> findByHasBought(Boolean hasBought);
    List<Customer> findByIsVip(boolean isVip);
    List<Customer> findByCityAndIsVip(String city, boolean isVip);

    List<Customer> findAll(Sort name);
}

