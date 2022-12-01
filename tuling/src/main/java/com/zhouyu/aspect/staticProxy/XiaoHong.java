package com.zhouyu.aspect.staticProxy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName User.java
 * @Description 客户
 * @createTime 2022年11月28日 17:26:00
 */
public class XiaoHong implements Room{

	@Override
	public void seekRoom() {
		System.out.println("找房");
	}

	@Override
	public void watchRoom() {
		System.out.println("看房");
	}

	@Override
	public void room() {
		System.out.println("给钱租房");
	}

	@Override
	public void finish() {
		System.out.println("完成租房");
	}
}
