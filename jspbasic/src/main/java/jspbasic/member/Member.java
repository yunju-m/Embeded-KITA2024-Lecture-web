package jspbasic.member;

public class Member {

	private String mid; // 사용자 ID
	private String mpass; // 사용자 PASSWORD
	
	public Member() {
	}

	public Member(String mid, String mpass) {
		super();
		this.mid = mid;
		this.mpass = mpass;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpass() {
		return mpass;
	}

	public void setMpass(String mpass) {
		this.mpass = mpass;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", mpass=" + mpass + "]";
	}

}
