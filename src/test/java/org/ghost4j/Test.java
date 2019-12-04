package org.ghost4j;

public class Test {
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(System.currentTimeMillis());
				}
			}).start();
		}
	}
}
