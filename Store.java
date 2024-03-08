package model;

import java.util.List;


 //店舗情報を表すクラス
public class Store {
	
	private String name;

	private List<Product> listProd;

	public Store(String name, List<Product> listProd) {
		this.name = name;
		this.listProd = listProd;
	}

	public List<Product> getListProd() {
		return listProd;
	}

	public String getName() {
		return name;
	}

	public void add(Product prod) {
		listProd.add(prod);
	}

	public void remove(int index) {
		listProd.remove(index);
	}
	
	public void clear() {
		listProd.clear();
	}

}
