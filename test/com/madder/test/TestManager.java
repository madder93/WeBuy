package com.madder.test;

import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.madder.dao.ManagerDao;
import com.madder.po.CategoryPO;
import com.madder.po.ManagerPO;
import com.madder.srv.ManagerSrv;
import com.madder.vo.ManagerVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"../../../config/springmvc.xml","../../../config/spring-common.xml"})
public class TestManager {
	
	@Resource
	private ManagerSrv managerSrv;
	@Resource
	private ManagerDao managerSDao;

	@Transactional
	@Test
	public void testGetManager(){
		ManagerVO vo = managerSrv.getManager("madder");
		System.out.println(vo);
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testAddManager(){
		ManagerPO po = new ManagerPO();
		po.setId(UUID.randomUUID().toString());
		po.setUsername("madder");
		po.setPassword("123456");
		this.managerSDao.save(po);
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testAddMenu(){
		CategoryPO po = new CategoryPO();
		po.setName("商品管理");
		po.setSortNum(2);
		po.setType(2);
		//po.setUrl("manageHome.jsp");
		this.managerSDao.save(po);
		CategoryPO po2 = new CategoryPO();
		po2.setName("用户管理");
		po2.setSortNum(3);
		po2.setType(2);
		//po.setUrl("manageHome.jsp");
		this.managerSDao.save(po2);
		CategoryPO po3 = new CategoryPO();
		po3.setName("菜单管理");
		po3.setSortNum(4);
		po3.setType(2);
		//po.setUrl("manageHome.jsp");
		this.managerSDao.save(po3);
	}
}
