package com.dxc.understandingSingleton;

public class MainApp {
	public static void main(String[] args) {
		MobilePhone myphone = MobilePhone.getCar();
		System.out.println(myphone.getBrand());
		
		myphone.setBrand("Samsung");
		System.out.println(myphone.getBrand());
		
		MobilePhone Tomsphone = MobilePhone.getCar();
		System.out.println(Tomsphone.getBrand());
		System.out.println(myphone.getBrand());
	}
}
