package mx.tec.web.lab.entity;

import java.io.Serializable;
import java.net.URI;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *	Sku Entity to store the SKU's attributes
 *	
 *	@author Santiago Alcerreca
 *	@version 2.0
 */

@Entity
public class Sku implements Serializable {
	
	/**
	 * Unique Identifier for the Sku class based on its attributes and methods
	 */
	private static final long serialVersionUID = -3108252160774144465L;
	
	/**
	 * id: long variable identifier for each specific Sku
	 * color: string variable that states the color of a Sku
	 * size: string variable that defines the size of a Sku
	 * listPrice: double variable that sets the list price of a Sku
	 * salePrice: double variable that sets the sale price of a Sku
	 * quantityOnHand: long variable that defines the inventory quantity of a Sku
	 * smallImage: URL variable pointing to a small image file of a Sku
	 * mediumImage: URL variable pointing to a medium image file of a Sku 
	 * largeImage: URL variable pointing to a large image file of a Sku
	 * parentProduct: Product variable defined as the parent or generic product of many Sku's
	 */
	@Id
	@GeneratedValue
	private long id;
	private String color;
	private String size;
	private double listPrice;
	private double salePrice;
	private long quantityOnHand;
	private URI smallImage;
	private URI mediumImage;
	private URI largeImage;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Product parentProduct;
	
	/**
	 * Each SKU is a slight variation of a product, and is comprised of an ID, 
	 * a color, its size, list price, sale price, quantity on hand, and finally
	 * three different URLs to many display images.
	 */
	public Sku() {
	}
	
	/**
	 * @param id
	 * @param color
	 * @param size
	 * @param listPrice
	 * @param salePrice
	 * @param quantityOnHand
	 * @param smallImage
	 * @param mediumImage
	 * @param largeImage
	 */
	public Sku(long id, String color, String size, double listPrice, double salePrice, long quantityOnHand,
			URI smallImage, URI mediumImage, URI largeImage) {
		this.id = id;
		this.color = color;
		this.size = size;
		this.listPrice = listPrice;
		this.salePrice = salePrice;
		this.quantityOnHand = quantityOnHand;
		this.smallImage = smallImage;
		this.mediumImage = mediumImage;
		this.largeImage = largeImage;
	}

	/**
	 * @return a string that converts all attributes of a Sku to string format and concatenates them into a single variable
	 */
	@Override
	public String toString() {
		return "Sku [id=" + id + ", color=" + color + ", size=" + size + ", listPrice=" + listPrice + ", salePrice="
				+ salePrice + ", quantityOnHand=" + quantityOnHand + ", smallImage=" + smallImage + ", mediumImage="
				+ mediumImage + ", largeImage=" + largeImage + ", parentProduct=" + parentProduct + "]";
	}

	/**
	 * Hash the object to create a fingerprint of the Sku
	 * @return a calculated hash of a Sku based on operations done on each attribute
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((largeImage == null) ? 0 : largeImage.hashCode());
		long temp;
		temp = Double.doubleToLongBits(listPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((mediumImage == null) ? 0 : mediumImage.hashCode());
		result = prime * result + ((parentProduct == null) ? 0 : parentProduct.hashCode());
		result = prime * result + (int) (quantityOnHand ^ (quantityOnHand >>> 32));
		temp = Double.doubleToLongBits(salePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((smallImage == null) ? 0 : smallImage.hashCode());
		return result;
	}

	/**
	 * Check whether two given objects are equal or not
	 * @param an object to compare against the Sku
	 * @return a boolean stating if an object is equal to the specified Sku
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Sku)) {
			return false;
		}
		
		Sku differentSku = (Sku) obj;
		return this.getId() == differentSku.getId();
	}

	/**
	 * @return the id of the SKU
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set of the SKU
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the color of the SKU
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * @param color the color to set of the SKU
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * @return the size of the SKU
	 */
	public String getSize() {
		return size;
	}
	
	/**
	 * @param size the size to set of the SKU
	 */
	public void setSize(String size) {
		this.size = size;
	}
	
	/**
	 * @return the listPrice of the SKU
	 */
	public double getListPrice() {
		return listPrice;
	}
	
	/**
	 * @param listPrice the listPrice to set of the SKU
	 */
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}
	
	/**
	 * @return the salePrice of the SKU
	 */
	public double getSalePrice() {
		return salePrice;
	}
	
	/**
	 * @param salePrice the salePrice to set of the SKU
	 */
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	/**
	 * @return the quantityOnHand of the SKU
	 */
	public long getQuantityOnHand() {
		return quantityOnHand;
	}
	
	/**
	 * @param quantityOnHand the quantityOnHand to set of the SKU
	 */
	public void setQuantityOnHand(long quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	/**
	 * @return the smallImage
	 */
	public URI getSmallImage() {
		return smallImage;
	}

	/**
	 * @param smallImage the smallImage to set
	 */
	public void setSmallImage(URI smallImage) {
		this.smallImage = smallImage;
	}

	/**
	 * @return the mediumImage
	 */
	public URI getMediumImage() {
		return mediumImage;
	}

	/**
	 * @param mediumImage the mediumImage to set
	 */
	public void setMediumImage(URI mediumImage) {
		this.mediumImage = mediumImage;
	}

	/**
	 * @return the largeImage
	 */
	public URI getLargeImage() {
		return largeImage;
	}

	/**
	 * @param largeImage the largeImage to set
	 */
	public void setLargeImage(URI largeImage) {
		this.largeImage = largeImage;
	}

	/**
	 * @return the parentProduct
	 */
	public Product getParentProduct() {
		return parentProduct;
	}

	/**
	 * @param parentProduct the parentProduct to set
	 */
	public void setParentProduct(Product parentProduct) {
		this.parentProduct = parentProduct;
	}
}
