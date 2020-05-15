package com.tledu.aaa.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.tledu.aaa.dao.IIPAndLocationPojoDao;
import com.tledu.aaa.util.MyBatisUtil;

public class IPAndLocationPojoDao implements IIPAndLocationPojoDao{

	@Override
	public String load(String ip) {
		SqlSession session =null;
		String location="";
		try {
			session =MyBatisUtil.getSession();
		 location =	session.getMapper(IIPAndLocationPojoDao.class).load(ip);
		 System.out.println(location);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSession(session);
		}
		return location;
	}

}
