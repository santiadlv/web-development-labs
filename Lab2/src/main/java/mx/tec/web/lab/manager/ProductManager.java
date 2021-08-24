package mx.tec.web.lab.manager;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.tec.web.lab.entity.Product;
import mx.tec.web.lab.entity.Sku;
import mx.tec.web.lab.repository.ProductRepository;

/**
 * This class depicts a manager in an MVC model, where all business logic is handled. Upon invoking the class,
 * the constructor creates a list of pre-made products. It features a list of methods that follow the CRUD
 * methodology, where you can create, read, update and delete products from the list. Additionally, you can
 * either get all products, or just a single product with a specified ID.
 * 
 * @author Santiago Alcerreca
 * @version 2.0
 */

@Service
public class ProductManager {
	
	/**
	 * Database static instance to store products
	 */
	@Resource
	ProductRepository productRespository;
	
	/**
	 * Retrieve all the products
	 * @return List of products in a JSON format
	 */
	public List<Product> getProducts() {
		return productRespository.findAll();
	}
	
	/**
	 * Retrieve an specific product based on a given product id
	 * @param id product id
	 * @return Optional containing a product if the product was found or empty otherwise
	 */
	public Optional<Product> getProduct(final long id) {
		return productRespository.findById(id);
	}
	
	/**
	 * Add a new Product to the productRepository based on a given product
	 * @param newProduct Product to add
	 * @return the Product saved to the database
	 */
	public Product addProduct(final Product newProduct) {
		for (final Sku newSku : newProduct.getChildSkus()) {
			newSku.setParentProduct(newProduct);
		}
		
		return productRespository.save(newProduct);
	}
	
	/**
	 * Update an existing product based on a given modified product and a product id
	 * @param id The product id for the original product
	 * @param modifiedProduct The product in its new version
	 */
	public void updateProduct(final long id, final Product modifiedProduct) {
		if (modifiedProduct.getId() == id) {
			for (final Sku modifiedSku : modifiedProduct.getChildSkus()) {
				modifiedSku.setParentProduct(modifiedProduct);
			}			
			
			productRespository.save(modifiedProduct);
		}
	}

	/**
	 * Delete the product based on a given product
	 * @param existingProduct the product to delete
	 */
	public void deleteProduct(final Product existingProduct) {
		productRespository.delete(existingProduct);
	}
	
	/**
	 * Retrieve an specific product based on a given product id
	 * @param pattern Pattern to search
	 * @return Optional containing a product if the product was found or empty otherwise
	 */
	public List<mx.tec.web.lab.entity.Product> getProducts(final String pattern) {
		return productRespository.findByNameLike(pattern);
	}
}
