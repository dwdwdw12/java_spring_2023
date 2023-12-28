package kr.co.dongwoo.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {
	
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	
	//jsp에서 요청객체를 넘겨주면서 쿠키박스를 생성해야 한다. => 해당 클라이언트의 모든 쿠키를 맵에 담는다.
	public CookieBox(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
	
	//쿠키이름을 통해서 쿠키를 읽어오는 메서드(인스턴스 메서드)
	public Cookie getCookie(String cookieName) {
		return cookieMap.get(cookieName);
	}
	
	//쿠키이름을 통해서 단순하게 쿠키의 값만을 읽어오는 메서드(인스턴스 메서드)
	public String getValue(String cookieName){
		Cookie cookie = cookieMap.get(cookieName);
		if(cookie==null) {
			return null;
		}
		return cookie.getValue();
	}
	
	//쿠키이름에 해당하는 쿠키의 존재유무를 확인하는 메서드(인스턴스 메서드)
	public boolean exists(String cookieName) {
		return cookieMap.get(cookieName)!=null;	
	}
	
	//쿠키이름 목록을 반환하는 메서드
	public /*Set<String>*/List<String> getCookieNames() {	//set->기본적으로 set으로 반환
		//return cookieMap.keySet();	
		return new ArrayList<String>(cookieMap.keySet()); // <=List로 반환할 수도 있다.
	}

	//쿠키를 만드는 기능의 정적 메서드들
	public static Cookie createCookie(String cookieName, String cookieValue) {
		return new Cookie(cookieName, cookieValue);
	}
	
	public static Cookie createCookie(String cookieName, String cookieValue, int maxAge, String path) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(maxAge);
		cookie.setPath(path);
		return cookie;
	}
	
	public static Cookie createCookie(String cookieName, String cookieValue, int maxAge, String path, String domain) {
		Cookie cookie = createCookie(cookieName, cookieValue, maxAge, path);
		cookie.setDomain(domain);
		return cookie;
	}

}
