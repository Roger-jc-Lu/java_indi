package Cocurrency;

class MyThread extends Thread{
	public void run(){
		for(int i=1;i<=500;i++)
		System.out.println(getName() + i);
	}
}
public class Join{

	public static void main(String[] args) {
		MyThread mt=new MyThread();
		mt.start();
		try {
			mt.join(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=1;i<=20;i++){
			System.out.println(i);
		}
		System.out.println("end");
	}

}
