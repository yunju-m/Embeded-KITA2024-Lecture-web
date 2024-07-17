package jspbasic;

public class Car {
	private int cno; // 연번
	private String company; // 제조사
	private String model; // 모델명
	private int cc; // 배기량
	private String color; // 색상
	private int price; // 가격
	
	public Car() {
	}

	public Car(int cno, String company, String model, int cc, String color, int price) {
		super();
		this.cno = cno;
		this.company = company;
		this.model = model;
		this.cc = cc;
		this.color = color;
		this.price = price;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [cno=" + cno + ", company=" + company + ", model=" + model + ", cc=" + cc + ", color=" + color
				+ ", price=" + price + "]";
	}
	
}
