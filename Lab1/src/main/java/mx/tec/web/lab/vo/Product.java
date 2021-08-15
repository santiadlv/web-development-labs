package mx.tec.web.lab.vo;

import java.util.List;

public class Product {
	private String id;
	private String name;
	private String description;
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
	public Product(String id, String name, String description, List<Sku> childSkus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.childSkus = childSkus;
	}

	/**
	 * @return the id of the product
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set of the product
	 */
	public void setId(String id) {
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
