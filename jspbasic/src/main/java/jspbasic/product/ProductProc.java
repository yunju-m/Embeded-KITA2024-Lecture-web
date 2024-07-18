package jspbasic.product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

public class ProductProc {
	
	private Connection conn;
	private CallableStatement cstmt;
	private ResultSet rs;
	
	
	public ProductProc() {
		conn = ConnectionUtil.getConnection();
	}
	
	// 상품 목록 출력
	public List<Product> listProduct() throws SQLException {
		String sql = "{ call PROC_SELECT_PRODUCTLIST(?) }";
		cstmt = conn.prepareCall(sql);
		cstmt.registerOutParameter(1, OracleTypes.CURSOR);
		cstmt.execute();
		
		List<Product> productList = new ArrayList<Product>();
		rs = (ResultSet)cstmt.getObject(1);
		while(rs.next()) {
			Product product = new Product(
					rs.getInt("PNO"),
					rs.getString("PCOMP"),
					rs.getString("PNAME"),
					rs.getString("PCOLOR"),
					rs.getString("PAMT"),
					rs.getString("PPRICE"),
					rs.getString("PMDATE")
			);
			productList.add(product);
		}
		cstmt.close();
		return productList;
	}
	
	// 하나의 상품 출력
	public Product getProduct(int pno) throws SQLException {
		String sql = "{ call PROC_SELECT_PRODUCT(?, ?, ?, ?, ?, ?, ?) }";
		cstmt = conn.prepareCall(sql);
		cstmt.setInt(1, pno);
		cstmt.registerOutParameter(1, Types.INTEGER); // 품번
		cstmt.registerOutParameter(2, Types.VARCHAR); // 제조사
		cstmt.registerOutParameter(3, Types.VARCHAR); // 상품명
		cstmt.registerOutParameter(4, Types.VARCHAR); // 색상
		cstmt.registerOutParameter(5, Types.VARCHAR); // 수량
		cstmt.registerOutParameter(6, Types.VARCHAR); // 가격
		cstmt.registerOutParameter(7, Types.VARCHAR); // 제조일시
		cstmt.execute();

		Product product = new Product(
				cstmt.getInt(1),
				cstmt.getString(2),
				cstmt.getString(3),
				cstmt.getString(4),
				cstmt.getString(5),
				cstmt.getString(6),
				cstmt.getString(7)
		);		
		cstmt.close();
		return product;
	}
	
	// 상품 등록
	public int insertProduct(Product product) throws SQLException {
		String sql = " { call PROC_INSERT_PRODUCT(?, ?, ?, ?, ?, ?) } ";
		cstmt = conn.prepareCall(sql);
		cstmt.setString(1, product.getPcomp());
		cstmt.setString(2, product.getPname());
		cstmt.setString(3, product.getPcolor());
		cstmt.setString(4, product.getPamt());
		cstmt.setString(5, product.getPprice());
		cstmt.setString(6, product.getPmdate());
		int result = cstmt.executeUpdate();
		cstmt.close();
		return result;
	}
	
	// 상품 수정
	public int updateProduct(Product product) throws SQLException {
		String sql = " { call PROC_UPDATE_PRODUCT(?, ?, ?, ?, ?, ?, ?) } ";
		cstmt = conn.prepareCall(sql);
		cstmt.setInt(1, product.getPno());
		cstmt.setString(2, product.getPcomp());
		cstmt.setString(3, product.getPname());
		cstmt.setString(4, product.getPcolor());
		cstmt.setString(5, product.getPamt());
		cstmt.setString(6, product.getPprice());
		cstmt.setString(7, product.getPmdate());
		int result = cstmt.executeUpdate();
		cstmt.close();
		return result;
	}
	
	// 상품 삭제
	public int deleteProduct(int pno) throws SQLException {
		String sql = " { call PROC_DELETE_PRODUCT(?) } ";
		cstmt = conn.prepareCall(sql);		
		cstmt.setInt(1, pno);
		int result = cstmt.executeUpdate();
		cstmt.close();
		return result;
	}
}
