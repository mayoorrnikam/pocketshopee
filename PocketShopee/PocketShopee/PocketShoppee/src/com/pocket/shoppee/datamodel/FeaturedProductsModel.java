package com.pocket.shoppee.datamodel;

import java.util.ArrayList;

public class FeaturedProductsModel {

	private String entityId;
	private String typeId;
	private String sku;
	private String name;
	private String color;
	private String size;
	private String description;
	private String regularPriceWithTax;
	private String regularPriceWithoutTax;
	private String finalPriceWithTax;
	private String finalPriceWithoutTax;
	private boolean isSaleable;
	private String imageUrl;
	private ArrayList<String> categoryName;
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegularPriceWithTax() {
		return regularPriceWithTax;
	}
	public void setRegularPriceWithTax(String regularPriceWithTax) {
		this.regularPriceWithTax = regularPriceWithTax;
	}
	public String getRegularPriceWithoutTax() {
		return regularPriceWithoutTax;
	}
	public void setRegularPriceWithoutTax(String regularPriceWithoutTax) {
		this.regularPriceWithoutTax = regularPriceWithoutTax;
	}
	public String getFinalPriceWithTax() {
		return finalPriceWithTax;
	}
	public void setFinalPriceWithTax(String finalPriceWithTax) {
		this.finalPriceWithTax = finalPriceWithTax;
	}
	public String getFinalPriceWithoutTax() {
		return finalPriceWithoutTax;
	}
	public void setFinalPriceWithoutTax(String finalPriceWithoutTax) {
		this.finalPriceWithoutTax = finalPriceWithoutTax;
	}
	public boolean isSaleable() {
		return isSaleable;
	}
	public void setSaleable(boolean isSaleable) {
		this.isSaleable = isSaleable;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public ArrayList<String> getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(ArrayList<String> categoryName) {
		this.categoryName = categoryName;
	}
}
