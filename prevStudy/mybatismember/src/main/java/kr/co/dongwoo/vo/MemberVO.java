package kr.co.dongwoo.vo;


public class MemberVO {
	private String memId;
	private String memPassword;
	private String memName;
	private String email;
	private String postCode;
	private String detailAddress;
	private String regiDate;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemberVO(String memId, String memPassword, String memName) {
		super();
		this.memId = memId;
		this.memPassword = memPassword;
		this.memName = memName;
	}
	
	
	public MemberVO(String memId, String memPassword, String memName, String email, String postCode,
			String detailAddress, String regiDate) {
		super();
		this.memId = memId;
		this.memPassword = memPassword;
		this.memName = memName;
		this.email = email;
		this.postCode = postCode;
		this.detailAddress = detailAddress;
		this.regiDate = regiDate;
	}

	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(String regiDate) {
		this.regiDate = regiDate;
	}
	
	
	
}
