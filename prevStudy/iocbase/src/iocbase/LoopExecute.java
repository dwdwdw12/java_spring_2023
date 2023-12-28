package iocbase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoopExecute {
	public static void main(String[] args) throws Exception {
		MyForLoopOne one = new MyForLoopOne();
		int result = one.forLoop();
		System.out.println("MyForLoopOne 실행결과1 : "+result);
	
		MyForLoopTwo two = new MyForLoopTwo();
		int resultTwo = two.forLoop(1,9,1);
		System.out.println("MyForLoopTwo 실행결과1 : "+resultTwo);
		resultTwo = two.forLoop(1,9,2);
		System.out.println("MyForLoopTwo 실행결과2 : "+resultTwo);
		resultTwo = two.forLoop(2,9,2);
		System.out.println("MyForLoopTwo 실행결과3 : "+resultTwo);
		
		System.out.println("===================================");
		
		Scanner scan = new Scanner(new File("loopData.txt"));
		String readData = scan.nextLine();
		System.out.println("readData : " + readData);
		String[] dataArr = readData.split(",");
		int twoResult = two.forLoop(Integer.parseInt(dataArr[0]),
				Integer.parseInt(dataArr[1]), Integer.parseInt(dataArr[2]));
		System.out.println("twoResult : " + twoResult);
		
		System.out.println("===================================");
		
		
		
		
		
	}
}
