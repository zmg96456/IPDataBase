package com.tledu.aaa.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		// 配置文件
		String resource = "mybatis-config.xml";
		// 读取配置文件
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			// 创建factory
			sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 获取session的方法
	 * 
	 * @return
	 */
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}

	/**
	 * 关闭session的方法
	 * 
	 * @param session
	 */
	public static void closeSession(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}
}
