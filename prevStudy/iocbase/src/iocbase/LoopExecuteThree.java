package iocbase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class LoopExecuteThree {
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("appbean.xml");
		MyForLoopThree three = (MyForLoopThree) context.getBean("myForLoopThree");	//@Autowired
		int threeResult = three.forLoop();
		System.out.println("threeResult : " + threeResult);
		
		System.out.println("한 단계 더 거치는 예제");
		FrontService ser = (FrontService) context.getBean("service");
		ser.work();	//Spring은 singleton을 참조. 호출될때마다 end=end+1이 반복됨. 결과값이 달라짐.		
		System.out.println(three==ser.three); //하나의 객체이기 때문에 주소가 같고, ==으로 비교해도 true값이 나온다.
	}
}
