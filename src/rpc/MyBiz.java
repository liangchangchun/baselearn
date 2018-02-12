package rpc;

import java.io.IOException;

import org.apache.hadoop.ipc.VersionedProtocol;

public class MyBiz implements  MyBizable {
	/* (non-Javadoc)
	 * @see rpc.MyBizable#hello(java.lang.String)
	 */
	public String hello(String name){
		System.out.println("我被调用");
		return "hello,"+name;	
	}

	public long getProtocolVersion(String arg0, long arg1) throws IOException {
		System.out.println("我是分支11");
		return MyBizable.VERSION;
	}

}
