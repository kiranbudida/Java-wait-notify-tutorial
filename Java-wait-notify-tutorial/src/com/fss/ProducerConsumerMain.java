package com.fss;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerMain {

	public static void main(String[] args) {
		
		List<Integer> queuelist=new ArrayList<Integer>();
		int MAX_CAPACITY=5;
		
Thread t1=new Thread(new Producer(queuelist,MAX_CAPACITY),"Producer");
Thread t2=new Thread(new Consumer(queuelist),"Consumer");

t1.start();
t2.start();

	}
}
