package rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.VersionedProtocol;

public class MyClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final VersionedProtocol proxy= RPC.waitForProxy(MyBizable.class, MyBizable.VERSION, new InetSocketAddress(MyServer.SERVER_ADDRESS, MyServer.PORT), new Configuration());
		final MyBizable mybiz=(MyBizable)proxy;
		String result = mybiz.hello("world");
		System.out.println("客户端调用结果:"+result);
		RPC.stopProxy(mybiz);
	}

}
