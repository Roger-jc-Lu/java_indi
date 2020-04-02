package Cocurrency.DeadLockPrevention;;

public class Test {

	public static void main(String[] args) {
		Queue queue=new Queue();
		new Thread(new Enqueue(queue)).start();
		new Thread(new Dequeue(queue)).start();
	}

}
