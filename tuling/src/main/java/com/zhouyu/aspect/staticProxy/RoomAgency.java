package com.zhouyu.aspect.staticProxy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RoomAgency.java
 * @Description 房屋中介
 * @createTime 2022年11月28日 17:27:00
 */
public class RoomAgency implements Room{

	private Room room; // 持有一个被代理人（小明）的引用

	public RoomAgency(Room room){
		this.room = room;
	}

	@Override
	public void seekRoom() {
		room.seekRoom();
	}

	@Override
	public void watchRoom() {
		room.watchRoom();
	}

	@Override
	public void room() {
		room.room();
	}

	@Override
	public void finish() {
		room.finish();
	}
}
