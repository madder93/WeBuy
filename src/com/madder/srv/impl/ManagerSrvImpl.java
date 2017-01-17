package com.madder.srv.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.madder.dao.ManagerDao;
import com.madder.po.ManagerPO;
import com.madder.srv.ManagerSrv;
import com.madder.vo.ManagerVO;

@Service
public class ManagerSrvImpl implements ManagerSrv {
	
	@Resource
	private ManagerDao managerDao;

	@Override
	public ManagerVO getManager(String username) {
		String sql = "from ManagerPO where username = ?";
		ManagerPO manager = this.managerDao.get(sql, username);
		ManagerVO vo = null;
		if(manager != null){
			vo = new ManagerVO();
			BeanUtils.copyProperties(manager, vo);
		}
		return vo;
	}

	@Override
	public String login(String username, String password) {
		String flag = "success";
		ManagerVO vo = this.getManager(username);
		if(vo != null){
			if(!password.equals(vo.getPassword())){
				flag = "passFail";
			}
		}else{
			flag = "nameFail";
		}
		return flag;
	}

}
