package mx.tec.web.lab.vo;

import java.net.URL;

public class Sku {
	private String id;
	private String color;
	private String size;
	private double listPrice;
	private double salePrice;
	private long quantityOnHand;
	private URL smallImage;
	private URL mediumImage;
	private URL largeImage;
	
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
	public Sku(String id, String color, String size, double listPrice, double salePrice, long quantityOnHand,
			URL smallImage, URL mediumImage, URL largeImage) {
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
	 * @return the id of the SKU
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set of the SKU
	 */
	public void setId(String id) {
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
	public URL getSmallImage() {
		return smallImage;
	}

	/**
	 * @param smallImage the smallImage to set
	 */
	public void setSmallImage(URL smallImage) {
		this.smallImage = smallImage;
	}

	/**
	 * @return the mediumImage
	 */
	public URL getMediumImage() {
		return mediumImage;
	}

	/**
	 * @param mediumImage the mediumImage to set
	 */
	public void setMediumImage(URL mediumImage) {
		this.mediumImage = mediumImage;
	}

	/**
	 * @return the largeImage
	 */
	public URL getLargeImage() {
		return largeImage;
	}

	/**
	 * @param largeImage the largeImage to set
	 */
	public void setLargeImage(URL largeImage) {
		this.largeImage = largeImage;
	}

}
