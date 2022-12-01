package com.zhouyu.jvm;

import com.zhouyu.service.User;

import java.util.ArrayList;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Math.java
 * @Description TODO
 * @createTime 2022年09月21日 13:39:00
 */
public class Math {

	public static int initData = 666;
	public static User user = new User();

	public int compute() { // 一个方法对应一块栈帧内存区域
		int a = 1;
		int b = 2;
		int c = (a + b) * 10;
		return c;
	}

	public static void main(String[] args) {
//		Math math = new Math();
//		while (true) {
//			math.compute();
//		}

//		ArrayList<String> list = new ArrayList<String>();
//		for (int i = 0; i < 10000000; i++) {
//			String str = String.valueOf(i).intern();
//			list.add(str);
//		}

		String s1 = new String("he") + new String("llo");
		String s2 = s1.intern();
		System.out.println(s1 == s2);

		String s3 = "wo";
		String s4 = new String("wo");
		System.out.println(s3 == s4);

		String s5 = s4.intern();
		System.out.println(s3 == s5);
	}
}
