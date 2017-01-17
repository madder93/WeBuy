package com.madder.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.madder.srv.ManagerSrv;

@Controller
public class ManagerCtrl {

	@Resource
	private ManagerSrv managerSrv;
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/manager/login.do")
	public String login(String username, String password, HttpServletRequest request, HttpServletResponse response){
		return this.managerSrv.login(username, password);
	}
}
