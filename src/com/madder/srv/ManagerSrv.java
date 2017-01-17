package com.madder.srv;

import com.madder.vo.ManagerVO;

public interface ManagerSrv {

	/**
	 * 查询用户
	 * @param username
	 * @return
	 */
	ManagerVO getManager(String username);
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	String login(String username, String password);
}
