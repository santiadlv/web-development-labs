package mx.tec.web.lab.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.web.lab.entity.Product;
import mx.tec.web.lab.manager.ProductManager;

/**
 * This class depicts a controller in an MVC model, where all the endpoints are handled. Upon invoking the
 * class and depending on the specified route, the controller will handle input and pass it on to the manager,
 * who will then perform business logic, and return a satisfactory or failing result to the controller. This 
 * class returns many HTTP statuses: 200 for OK, 404 for no content, 201 for created and 400 for bad request.
 * 
 * @author Santiago Alcerreca
 * @version 2.0
 */

@RestController
public class ProductController {
	
	/**
	 * Static resource in charge of product business logic, empty if there are no products
	 */
	@Resource
	private ProductManager productManager;
	
	/**
	 * The endpoint for GET {url}/products
	 * @return a JSON containing all the products in the database
	 */
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productManager.getProducts();		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	/**
	 * The endpoint for GET {url}/products/{id}
	 * @param id Product id
	 * @return a JSON containing the product info and status 200 if the product is found or status 204 if the product is not found
	 */
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable(value = "id") long id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			responseEntity = new ResponseEntity<>(product.get(), HttpStatus.OK);
		}
		
		return responseEntity;
	}
	
	/**
	 * The endpoint for POST {url}/products/
	 * @param newProduct a json containing the info for the new product
	 * @return If the product is created successfully then status 201 and the product info is returned, otherwise it returns status 400 
	 */
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) {
		Product product = productManager.addProduct(newProduct);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}	
	
	/**
	 * The endpoint for PUT {url}/products/{id}
	 * @param id Product id
	 * @param modifiedProduct a JSON containing the info for the modified product
	 * @return status 200 if product is found and updated, otherwise status 204 if product is not found
	 */
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") long id, @RequestBody Product modifiedProduct) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			productManager.updateProduct(id, modifiedProduct);
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		
		return responseEntity;
	}

	/**
	 * The endpoint for DELETE {url}/products/{id}
	 * @param id Product id
	 * @return status 200 if the product is found and deleted, else 204 if product is not found
	 */
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") long id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			productManager.deleteProduct(product.get());
			responseEntity = new ResponseEntity<>(HttpStatus.OK);
		}
		
		return responseEntity;
	}
	
	/**
	 * The endpoint for GET {url}/products?search={pattern}
	 * @param search Pattern to search
	 * @return a json list of all the products matching the pattern
	 */
	@GetMapping(value="/products", params="search")
	public ResponseEntity<List<Product>> getProducts(@RequestParam String search) {
		List<Product> products = productManager.getProducts(search);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
}
