package threadlearn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import design.TimeTemplate;

public class CountDown extends TimeTemplate {

	@Override
	public void task() {
		 ExecutorService executorService= Executors.newCachedThreadPool();
			//ExecutorService executorService= Executors.newFixedThreadPool(3);
			  
			  for (int i=0;i<10;i++) {
				  executorService.execute(new ResultTask(String.valueOf(i)));
			  }
			  executorService.shutdown();
			 while(true) {
				 if (executorService.isTerminated()) {  
					  System.out.println("结束了！");  
					 break;  
				}  
	            try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  
			} 
	}

}

class ResultTask implements Runnable {  
	
	private String name;
	
	public ResultTask(String name) {
		this.name = name;
	}
	  
    @Override  
    public void run() {  
         System.out.println("任务"+this.name+",抓取链接");
         System.out.println("-------------------当前线程数量:"+Thread.activeCount());  
    }  
  
}  