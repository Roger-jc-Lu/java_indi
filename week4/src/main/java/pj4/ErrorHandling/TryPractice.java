package pj4.ErrorHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryPractice {

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);

		System.out.println("=====start=====");
		try{
			System.out.print("first int：");
			int firstInt=input.nextInt();
			System.out.print("second int：");
			int secondInt=input.nextInt();
			System.out.println("result："+ (firstInt/secondInt));
		}catch(ArithmeticException e){
			System.out.println("0 as divisor");
			e.printStackTrace();
		}catch(InputMismatchException e){
			System.out.println("input has to be integer");
			e.printStackTrace();
		}catch(Exception e){
			System.out.println("unknown error");
			e.printStackTrace();
		}finally{
			System.out.println("=====end=====");
			input.close();
		}
	}

}






