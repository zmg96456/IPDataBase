package com.tledu.aaa.controller;

import com.tledu.aaa.dao.IIPAndLocationPojoDao;
import com.tledu.aaa.dao.impl.IPAndLocationPojoDao;
import com.tledu.aaa.util.IPUtil;

public class SystemController {
	public static void main(String[] args) {
		IIPAndLocationPojoDao iPojoDao =new IPAndLocationPojoDao();
		String ip= "123.123.123.123";
		String location =iPojoDao.load(ip);
		System.out.println(location);
	}
}
