package jspbasic.product;

public class Product {
	private int pno; // 품번
	private String pcomp; // 제조사
	private String pname; // 상품명
	private String pcolor; // 색상
	private String pamt; // 수량
	private String pprice; // 가격
	private String pmdate; // 제조일시
	
	public Product() {
	}

	public Product(int pno, String pcomp, String pname, String pcolor, String pamt, String pprice, String pmdate) {
		super();
		this.pno = pno;
		this.pcomp = pcomp;
		this.pname = pname;
		this.pcolor = pcolor;
		this.pamt = pamt;
		this.pprice = pprice;
		this.pmdate = pmdate;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPcomp() {
		return pcomp;
	}

	public void setPcomp(String pcomp) {
		this.pcomp = pcomp;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcolor() {
		return pcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	public String getPamt() {
		return pamt;
	}

	public void setPamt(String pamt) {
		this.pamt = pamt;
	}

	public String getPprice() {
		return pprice;
	}

	public void setPprice(String pprice) {
		this.pprice = pprice;
	}

	public String getPmdate() {
		return pmdate;
	}

	public void setPmdate(String pmdate) {
		this.pmdate = pmdate;
	}

	@Override
	public String toString() {
		return "Product [pno=" + pno + ", pcomp=" + pcomp + ", pname=" + pname + ", pcolor=" + pcolor + ", pamt=" + pamt
				+ ", pprice=" + pprice + ", pmdate=" + pmdate + "]";
	}

}

