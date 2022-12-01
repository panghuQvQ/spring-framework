package com.zhouyu.aspect.staticProxy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName test.java
 * @Description TODO
 * @createTime 2022年11月29日 09:16:00
 */
public class test {
	public static void main(String[] args) {
		XiaoHong xiaoHong = new XiaoHong();
		XiaoWang xiaoWang = new XiaoWang();

		RoomAgency roomAgency = new RoomAgency(xiaoHong);
		roomAgency.seekRoom();
		roomAgency.watchRoom();
		roomAgency.room();
		roomAgency.finish();
	}
}
