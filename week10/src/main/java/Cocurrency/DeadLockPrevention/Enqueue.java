package Cocurrency.DeadLockPrevention;

public class Enqueue implements Runnable{
	Queue queue;
	Enqueue(Queue queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		int i=0;
		while(true){
			queue.set(i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
