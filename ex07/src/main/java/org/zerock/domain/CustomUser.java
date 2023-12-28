package org.zerock.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User{
	
	private static final long serialVersionUID = 1L;
	
	private MemberVO member;

	public CustomUser(String username, String password, 
			Collection<? extends GrantedAuthority> authorities) {		
		super(username, password, authorities);		
	}
	
	public CustomUser(MemberVO vo) {
		super(vo.getUserid(), vo.getUserpw(), 
				vo.getAuthList().stream().map(auth->new SimpleGrantedAuthority(auth.getAuth()))	//authlist에는 2개의 정보가 있음. auth만 SimpleGrantedAuthority에 넘김
				.collect(Collectors.toList()));
		this.member = vo;
	}

}