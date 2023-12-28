package iocbase;

public class FrontService {
	MyForLoopThree three;
	
	public FrontService(MyForLoopThree three) {
		this.three = three;
	}
	
	public void work() {
		System.out.println( this.getClass().getName() +"=>Service Class");
		int result = three.forLoop();
		
		System.out.println("result : "+result);
		
	}
	
}
