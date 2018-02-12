package rpc;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface MyBizable extends VersionedProtocol{
	public static final long VERSION =234256265522L;

	public abstract String hello(String name);

}