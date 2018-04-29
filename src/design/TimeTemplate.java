package design;

public abstract class TimeTemplate {
	
	public void doSomeThing() {
		/*long startTime=System.currentTimeMillis();   //获取开始时间
		task();
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime - startTime)+"ms");
		 */
		long startTime=System.nanoTime();   //获取开始时间

		task(); //测试的代码段

		long endTime=System.nanoTime(); //获取结束时间

		System.out.println("程序运行时间： "+(endTime - startTime)+"ns");

	 };
	 
	 
	public abstract void task();
}
