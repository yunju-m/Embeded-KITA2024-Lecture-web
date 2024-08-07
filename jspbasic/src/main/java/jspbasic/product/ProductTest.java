package jspbasic.product;

import java.util.List;

public class ProductTest {
	
	public static void main(String[] args) throws Exception {
	
		ProductProc productProc = new ProductProc();
		Product product 
			= new Product(0, "제조사", "상품명", "색상", "10", "1000", "2024-07-18");
		int result = productProc.insertProduct(product);
		if (result > 0) {
			System.out.println("등록 성공!");
		}
		
		Product product2
		= new Product(0, "신제조사", "신상품", "새로운색상", "30", "3000", "2024-07-18");
		productProc.updateProduct(product2);
		if (result > 0) {
			System.out.println("업데이트 성공!");
		}
		
		productProc.deleteProduct(4);
		if (result > 0) {
			System.out.println("삭제 성공!");
		}
		
		List<Product> productList = productProc.listProduct();
		for (Product p : productList) {
			System.out.println(p);
		}
		
		productProc.getProduct(1);
	}
	
}
