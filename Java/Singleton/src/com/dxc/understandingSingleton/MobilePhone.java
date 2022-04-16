package com.dxc.understandingSingleton;

public class MobilePhone {
	static MobilePhone obj = new MobilePhone();
	private String brand = "Apple";
	private String color = "silver";
	private String model = "iPhone 12 pro max";
	private String capacity = "256GB";
	
	private MobilePhone() {
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public static MobilePhone getCar() {
		return obj;
	}
}
