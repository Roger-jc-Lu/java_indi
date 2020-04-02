package Cocurrency.DeadLockPrevention;

public class Dequeue implements Runnable{
	Queue queue;
	Dequeue(Queue queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true){
			queue.get();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
