package com.xinguoren.coolpen.cloud.web.app;
/**
 * 懒汉式单例
 * @author Lenovo
 *
 */
public class Singleton1 {
	private static Singleton1 singleton1 = null;

	private Singleton1() {
		
	}
	
	public static Singleton1 getInstance(){
		if(singleton1 == null)
			singleton1 = new Singleton1();
		return singleton1;
	}
}
