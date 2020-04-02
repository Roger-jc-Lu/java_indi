/**
A one element queue demo to show deadlock prevention from threads communication
*/

package Cocurrency.DeadLockPrevention;

public class Queue {
	private int n;
	boolean indicator = false;
	
	public synchronized int get() {
		if(!indicator){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("dequeue: " + n);
		indicator = false;
		notifyAll();
		return n;
	}

	public synchronized void set(int n) {
		if(indicator){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("enqueue：" + n);
		this.n = n;
		indicator = true;
		notifyAll();
	}
	
}
