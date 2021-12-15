package qlvemaybay;

import java.io.Serializable;
import java.util.Scanner;

public class VeMayBay implements Serializable{
	private String id;
	private String name;
	private String date;
	private String bag;
	private int price;
	
	public VeMayBay() {
		// TODO Auto-generated constructor stub
	}
	
	public VeMayBay(String id, String name, String date, String bag, int price) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.bag = bag;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBag() {
		return bag;
	}

	public void setBag(String bag) {
		this.bag = bag;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "VeMayBay [id=" + id + ", name=" + name + ", date=" + date + ", bag=" + bag + ", price=" + price + "]";
	}
	
	public void input() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap ma ve: ");
		this.id = input.nextLine();
		System.out.println("Nhap ten chuyen bay: ");
		name = input.nextLine();
		System.out.println("Nhap ngay bay: ");
		date = input.nextLine();
		System.out.println("Nhap hanh ly: ");
		bag = input.nextLine();
		System.out.println("Nhap gia: ");
		price = Integer.parseInt(input.nextLine());
	}
	
	public void display() {
		System.out.println(toString());
	}
	
}
