package board;

import java.io.Serializable;
import java.sql.Timestamp;

public class Board implements Serializable {

	public static final long serialVersionUID = 213123913819032L;

	private int bid; // 번호
	private String btitle; // 제목
	private String bcontent; // 내용
	private String bwriter; // 작성자
	private int bcount; // 조회수
	private Timestamp bregdate; // 작성일시
	private String bsort; // 분류
	private String cfn;	// 사용자가 입력한 파일 이름
	private int rcount; // 댓글수

	public Board() {		
	}

	public Board(int bid, String btitle, String bcontent, String bwriter, int bcount, Timestamp bregdate, String bsort,
			String cfn, int rcount) {
		super();
		this.bid = bid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bcount = bcount;
		this.bregdate = bregdate;
		this.bsort = bsort;
		this.cfn = cfn;
		this.rcount = rcount;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public Timestamp getBregdate() {
		return bregdate;
	}

	public void setBregdate(Timestamp bregdate) {
		this.bregdate = bregdate;
	}

	public String getBsort() {
		return bsort;
	}

	public void setBsort(String bsort) {
		this.bsort = bsort;
	}

	public String getCfn() {
		return cfn;
	}

	public void setCfn(String cfn) {
		this.cfn = cfn;
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Board [bid=" + bid + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter
				+ ", bcount=" + bcount + ", bregdate=" + bregdate + ", bsort=" + bsort + ", cfn=" + cfn + ", rcount="
				+ rcount + "]";
	}

}
