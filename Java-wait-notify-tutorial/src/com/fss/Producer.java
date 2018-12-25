package com.fss;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable{

	private List<Integer> queue=new ArrayList<Integer>();
	private int MAX_SIZE;
	
	public Producer() {}
	
	public Producer(List<Integer> queuelist, int size) {
		queue=queuelist;
		MAX_SIZE=size;
	}
	
	@Override
	public  void run() {
		int i=0;
		
		while(true) {
			try {
				produce(i++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void produce(int i) throws InterruptedException{
		
		synchronized(queue) {
			if(queue.size()==MAX_SIZE) {
				try {
					System.out.println(Thread.currentThread().getName()+" is waiting ");
					System.out.println("Current queue size is:"+queue.size());
					queue.wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			Thread.sleep(2000);
			queue.add(i);
			System.out.println("Produced "+i);
			queue.notifyAll();
			
		}
	}

}
