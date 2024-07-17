package jspbasic.product;

import java.sql.Date;
import java.util.List;

public class ProductTest {
	
	public static void main(String[] args) throws Exception {
	
		ProductProc productProc = new ProductProc();
		Product product 
			= new Product(0, "제조사", "상품명", "색상", 10, 1000,
					new Date(System.currentTimeMillis()));
		productProc.insertProduct(product);
		
		List<Product> productList = productProc.listProduct();
		for (Product p : productList) {
			System.out.println(p);
		}
		
		Product product2
		= new Product(1, "신제조사", "신상품", "새로운색상", 30, 3000,
				new Date(System.currentTimeMillis()));
		productProc.updateProduct(product2);
		
		productList = productProc.listProduct();
		for (Product p : productList) {
			System.out.println(p);
		}
		
		productProc.deleteProduct(4);
		productList = productProc.listProduct();
		for (Product p : productList) {
			System.out.println(p);
		}
	}
	
}
