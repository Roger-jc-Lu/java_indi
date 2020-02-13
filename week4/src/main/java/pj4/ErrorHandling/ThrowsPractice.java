package pj4.ErrorHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsPractice {

	public static void main(String[] args) {

		try{
			int result = test();
			System.out.println("result：" + result);
		}catch(ArithmeticException e){
			System.out.println("0 as divisor");
			e.printStackTrace();
		}catch(InputMismatchException e){
			System.out.println("input has to be integer");
			e.printStackTrace();
		}catch(Exception e){
			System.out.println("unknown error");
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws ArithmeticException
	 * @throws InputMismatchException
	 */
	public static int test() throws ArithmeticException,InputMismatchException{
		Scanner input = new Scanner(System.in);
		System.out.println("=====start=====");
		System.out.print("first int：");
		int firstInt=input.nextInt();
		System.out.print("second int：");
		int secondInt=input.nextInt();
		input.close();
		return firstInt/secondInt;
	}

}
