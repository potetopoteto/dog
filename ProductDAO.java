package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;

 //商品情報DAO
public class ProductDAO {

	public List<Product> selectAll() throws Exception {

	    List<Product> productList = new ArrayList<Product>();

	    String sql = "SELECT *, image_path FROM m_product ORDER BY product_id ";

	    try (Connection con = MyConnection.getConnection();
	            Statement stmt = con.createStatement()) {

	        try (ResultSet res = stmt.executeQuery(sql)) {
	            while (res.next()) {
	                String productId = res.getString("product_id");
	                String productName = res.getString("product_name");
	                int price = res.getInt("price");
	               
	                String imagePath = res.getString("image_path");

	                Product product 
	                    = new Product(productId, productName, price, imagePath);
	                productList.add(product);
	            }
	        }
	    }

	    return productList;
	}
}	
