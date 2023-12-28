package kr.co.dongwoo.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class MemberVO {
	private String memId;
	private String memPassword;
	private String memName;
	private String email;
	private String postCode;
	private String detailAddress;
	private String regiDate;
	
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

	public MemberVO(String memId, String memPassword, String memName, String email, String postCode,
			String detailAddress) {
		super();
		this.memId = memId;
		this.memPassword = memPassword;
		this.memName = memName;
		this.email = email;
		this.postCode = postCode;
		this.detailAddress = detailAddress;
	}


	
	
}
