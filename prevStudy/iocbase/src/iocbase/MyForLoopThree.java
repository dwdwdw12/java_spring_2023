package iocbase;

public class MyForLoopThree {
	int start; public void setStart(int start) {this.start = start;}
	int end; public void setEnd(int end) {this.end = end;}
	int incre; public void setIncre(int incre) {this.incre = incre;}
	
	public int forLoop() {
		int sum=0;
		//end=end+1;	//반복 실행시 결과값이 달라질 수 있음
						//설정정보에 의해 생성된 객체의 필드값이 변경된다. 이후에는 변경된 값들이 계속 사용된다.
		for(int i=start;i<=end;i=i+incre) {
			sum=sum+i;
		}
		return sum;
	}
	
}
