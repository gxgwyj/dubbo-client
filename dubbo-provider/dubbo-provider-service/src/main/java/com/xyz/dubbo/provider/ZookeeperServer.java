package com.xyz.dubbo.provider;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZookeeperServer {
	private static String URL = "192.168.202.129:2181";
	private static ZooKeeper  zooKeeper = null;
	private ZookeeperServer(){}
	
	static {
		try {
			zooKeeper = new ZooKeeper(URL, 6000, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void createZNode() throws Exception{
		zooKeeper.create("/gaoxugang", "gaoxugang data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}
	
	public static void deleteZNode() throws Exception, KeeperException{
		zooKeeper.delete("/gaoxugang", -1);
	}
	
	public static String getNodeData(String nodeName) throws Exception, Exception{
		Stat  stat = new Stat();
		byte[] bt = zooKeeper.getData(nodeName, false, stat);
		String s = new String(bt, "utf-8");
		return s;
	}

	
	
	public static void main(String[] args) throws Exception{
		System.out.println(getNodeData("/"));
	}
}
