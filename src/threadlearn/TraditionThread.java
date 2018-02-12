package threadlearn;

public class TraditionThread {

	public static void main(String[] args){
		final String a="-ABCD123456789ABCD123456789ABCD123456789";
		
		Thread thread = new Thread(){
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName());
				}
			}
			
		};
		thread.start();
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName());
				}
				
			}
		});
		thread2.start();
		
		new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Runnable-"+Thread.currentThread().getName());
				}
				
			}
		}){
			public void run() {
			while(true){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread-"+Thread.currentThread().getName());
			}
			
		}
			}.start();
	}
	
	
}
