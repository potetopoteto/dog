package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import model.dao.ProductDAO;


 //店内オペレーションクラス
 public class Operation {
	
	public boolean loginProc(String userId, String password, HttpSession session) throws Exception {

		boolean result = authenticate(userId, password);

		if (result) {
			Store store = makeStore();
			session.setAttribute("store", store);
			
			Cart cart = new Cart(userId, new ArrayList<Product>());
			session.setAttribute("cart", cart);
		}

		return result;
	}

	private boolean authenticate(String userId, String password) {

		boolean result = password.equals("pass");

		return result;
	}
	
	private Store makeStore() throws Exception {

		ProductDAO productDao = new ProductDAO();
		List<Product> list = productDao.selectAll();
			
		Store store = new Store("Dogshop", list);
		
		return store;
	}
	
	public void logoutProc(HttpSession session) {

		session.invalidate();
		
	}

	public void addProd(String productId, HttpSession session) {
	    
	    Store store = (Store) session.getAttribute("store");
	    Cart cart = (Cart) session.getAttribute("cart");

	    if ((store != null) && (cart != null)) {
	        Product productToAdd = store.getListProd().stream()
	            .filter(product -> product.getId().equals(productId))
	            .findFirst()
	            .orElse(null);
	        if (productToAdd != null) {
	            cart.add(productToAdd);
	        }

	        session.setAttribute("cart", cart);
	    }
	}

	public void removeProd(int idx, HttpSession session) {
	
		Cart cart = (Cart) session.getAttribute("cart");
	
		if (cart != null) {
			
			cart.remove(idx);

			session.setAttribute("cart", cart);
		}
			
	}
	
	public void pay(HttpSession session) {

		Cart cart = (Cart) session.getAttribute("cart");

		if (cart != null) {
			
			session.setAttribute("pay", cart);

			Cart newCart = new Cart(cart.getUserId(), new ArrayList<Product>());
			session.setAttribute("cart", newCart);
		}

	}

}
