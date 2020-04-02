package Cocurrency;

class Thread1 extends Thread{
	private String name;
	public Thread1(String name){
		this.name = name;
	}
	public void run(){
		for(int i=1;i<=50;i++){
			System.out.println(i);
		}
	}
}
public class Priority {

	public static void main(String[] args) {

		int mainPriority=Thread.currentThread().getPriority();
		System.out.println("mainPriority："+mainPriority);
		MyThread mt1=new MyThread();
		MyThread mt2=new MyThread();

		mt1.setPriority(Thread.MAX_PRIORITY);
		mt2.setPriority(Thread.MIN_PRIORITY);
		mt2.start();
		mt1.start();
		System.out.println("mt1Priority："+mt1.getPriority());
	}

}
