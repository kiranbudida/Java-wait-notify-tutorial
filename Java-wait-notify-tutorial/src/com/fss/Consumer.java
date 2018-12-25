package com.fss;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable{

	private List<Integer> queue=new ArrayList<Integer>();
	
	public Consumer() {}
	
	public Consumer(List<Integer> queuelist) {
		queue=queuelist;
	}
	
	@Override
	public  void run() {
		
		while(true) {
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}
	}

	private void consume() throws InterruptedException {
		
		synchronized(queue) {
			
			if(queue.size()==0) {
				try {
					System.out.println(Thread.currentThread().getName()+" is waiting ");
					System.out.println("Current queue size is:"+queue.size());
					queue.wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
			
			Thread.sleep(2000);
			System.out.println("Consumed :"+queue.remove(0));
			queue.notifyAll();
		}
		
	}
}
