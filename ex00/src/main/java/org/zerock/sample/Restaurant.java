package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor	//선언된 모든 변수를 내포한 생성자 생성
@NoArgsConstructor	//매개변수 없는 생성자 생성
public class Restaurant {
	
	@Autowired
	private Chef chef;
	
}
