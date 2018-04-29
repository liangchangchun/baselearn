package threadlearn;

public class JoinDemo {
	
	public static void main(String[] args) {
		
		Thread sub2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("#########执行sub2子任务,当前线程数量"+Thread.activeCount());
				
			}
		});
		Thread sub = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					sub2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("-----------执行sub子任务,当前线程数量"+Thread.activeCount());
			}
		});
		
		sub.start();
		sub2.start();
		try {
			sub.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("执行main方法任务,当前线程数"+Thread.activeCount());
	}

}
