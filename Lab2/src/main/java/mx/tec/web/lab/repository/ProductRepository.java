package mx.tec.web.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.tec.web.lab.entity.Product;

/**
 * Product JPA Repository to serve as a database
 * 
 * @author Santiago Alcerreca
 * @version 2.0
  */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	/**
	 * Find a product based on a pattern in the product's name
	 * @param pattern pattern to find
	 * @return A list of products matching the pattern in the name
	 */
	@Query("FROM Product WHERE name LIKE %:pattern%")
    List<Product> findByNameLike(@Param("pattern") String pattern);
}
