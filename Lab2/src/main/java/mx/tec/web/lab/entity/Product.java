package mx.tec.web.lab.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *	Product Entity to store the product's attributes
 *	
 *	@author Santiago Alcerreca
 *	@version 2.0
 */

@Entity
public class Product implements Serializable {
	
	/**
	 * Unique Identifier for the Product class based on its attributes and methods
	 */
	private static final long serialVersionUID = 1940424686731950240L;
	
	/**
	 * id: long variable identifier for each Product
	 * name: string variable that states the name of any given Product
	 * description: string variable that stores a short description of a Product
	 * childSkus: a list of all different Sku's linked with certain Product
	 */
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "parentProduct", cascade = CascadeType.ALL)
	private List<Sku> childSkus;
	
	/**
	 * Each product can have one or more distinct SKUs, and is 
	 * comprised of an ID, name, description and a list of its SKUs.
	 */
	public Product() {
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param childSkus
	 */
	public Product(long id, String name, String description, List<Sku> childSkus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.childSkus = childSkus;
	}

	/**
	 * @return a string that converts all attributes of a Product to string format and concatenates them into a single variable
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", childSkus=" + childSkus
				+ "]";
	}

	/**
	 * Hash the object to create a fingerprint of the Product
	 * @return a calculated hash of a Product based on operations done on each attribute
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((childSkus == null) ? 0 : childSkus.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Check whether two given objects are equal or not
	 * @param an object to compare against the Product
	 * @return a boolean stating if an object is equal to the specified Product
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Product)) {
			return false;
		}
		Product differentProduct = (Product) obj;
		return this.getId() == differentProduct.getId();
	}

	/**
	 * @return the id of the product
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set of the product
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the name of the product
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set of the product
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the description of the product
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set of the product
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the childSkus of the product
	 */
	public List<Sku> getChildSkus() {
		return childSkus;
	}
	
	/**
	 * @param childSkus the childSkus to set of the product
	 */
	public void setChildSkus(List<Sku> childSkus) {
		this.childSkus = childSkus;
	}
}
