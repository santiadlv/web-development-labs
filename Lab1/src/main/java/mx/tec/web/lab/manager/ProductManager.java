package mx.tec.web.lab.manager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mx.tec.web.lab.vo.Product;
import mx.tec.web.lab.vo.Sku;

/**
 * @author Santiago Alcerreca
 * 
 * This class depicts a manager in an MVC model, where all business logic is handled. Upon invoking the class,
 * the constructor creates a list of pre-made products. It features a list of methods that follow the CRUD
 * methodology, where you can create, read, update and delete products from the list. Additionally, you can
 * either get all products, or just a single product with a specified ID.
 */

@Service
public class ProductManager {
	private List<Product> products;
	
	public ProductManager() throws MalformedURLException {
		products = new ArrayList<>();
		
		Product product1 = new Product("prod123", "Levi's 501 Original Fit Jeans Jeans para Hombre", "100% algodón, Cierre de Cremallera, Lavar a máquina, Jeans corte ajustado, Pierna ajustada, Stretch especial que te brinda mayor movilidad", Collections.emptyList());
		List<Sku> childSkus1 = new ArrayList<>();
		URL productImage = new URL("https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F79%2Fd9%2F79d94b8660a5ae7c57525f68855d482baa34158f.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bladies_jeans_loose%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main];");
		childSkus1.add(new Sku("sku1234", "Black", "29W X 32L", 1027.24, 1027.24, 500, productImage, productImage, productImage));
		childSkus1.add(new Sku("sku1235", "Dark Stonewash", "29W X 32L", 1027.24, 706.93, 200, productImage, productImage, productImage));
		
		product1.setChildSkus(childSkus1);products.add(product1);
		
		Product product2 = new Product("prod124", "Levi's Innovation Super Skinny Jeans para Mujer", "85% Algodón, 9% Elastomultiester, 6% Elastano, Lavar a máquina, Pantalón, Mezclilla, Cintura Media, Ajustado Desde la Cadera al Muslo, Pierna Súper Ajustada", Collections.emptyList());
		List<Sku> childSkus2 = new ArrayList<>();
		childSkus2.add(new Sku("sku1236", "Black Galaxy", "25W X 30L", 661.79, 661.79, 300, productImage, productImage, productImage));
		childSkus2.add(new Sku("sku1237", "Black Galaxy", "26W X 30L", 661.79, 661.79, 400, productImage, productImage, productImage));
		childSkus2.add(new Sku("sku1238", "Black Galaxy", "27W X 30L", 661.79, 661.79, 800, productImage, productImage, productImage));
		
		product2.setChildSkus(childSkus2);products.add(product2);
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public Optional<Product> getProduct(final String id) {
		Optional<Product> foundProduct = Optional.empty();
		
		for (final Product product : products) {
			if (product.getId().equals(id)) {
				foundProduct = Optional.of(product);
				break;
			}
		}
		return foundProduct;
	}
	
	public Optional<Product> addProduct(final Product newProduct) {
		products.add(newProduct);
		return Optional.of(newProduct);
	}
	
	public Optional<Product> updateProduct(final String id, final Product updatedProduct) {
		Optional<Product> finalProduct = Optional.empty()
				
;		for (final Product product : products) {
			if (product.getId().equals(id)) {
				product.setName(updatedProduct.getName());
				product.setDescription(updatedProduct.getDescription());
				product.setChildSkus(updatedProduct.getChildSkus());
				finalProduct = Optional.of(product);
				break;
			}
		}
		return finalProduct;
	}
	
	public Optional<Product> deleteProduct(final String id) {
		Optional<Product> deletedProduct = Optional.empty();
		
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			if (product.getId().equals(id)) {
				deletedProduct = Optional.of(product);
				iterator.remove();
				break;
			}
		}
		return deletedProduct;
	}
}
