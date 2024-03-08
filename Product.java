package model;


// 商品クラス
public class Product {
	
	private String id;
	
	private String name;
	
	private int price;
	
	private String imagePath;

	public Product(String id, String name, int price, String imagePath) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.imagePath = imagePath;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getPriceString() {
		return String.format("%,d", price) + "円";
	}


public String getImagePath() {
    return this.imagePath;
	}
}