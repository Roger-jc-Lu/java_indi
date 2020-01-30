package pj1;

public class DoWhile {

	public static void main(String[] args) {
		int n=1;
		int sum=0;
		do{
			sum=sum+n;
			n++;
		}while(n<=5);
		System.out.println("sum="+sum);
	}

}
