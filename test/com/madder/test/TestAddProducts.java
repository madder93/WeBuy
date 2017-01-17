package com.madder.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.madder.dao.CategoryDao;
import com.madder.dao.ProductsDao;
import com.madder.po.CategoryPO;
import com.madder.po.ProductsPO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"../../../config/springmvc.xml","../../../config/spring-common.xml"})
public class TestAddProducts {
	
	@Resource
	private ProductsDao productsDao;
	@Resource
	private CategoryDao categoryDao;

	@Transactional
	@Rollback(false)
	@Test
	public void testAddProducts(){
		Random r = new Random();
		Random r2 = new Random();
		Random r3 = new Random();
		Random r4 = new Random();
		String[] keyword = {"女装","男装","家居","创意","可爱","实用","送礼","经典","蓝色"};
		for(int i = 100; i < 500; i++){
			UUID id = UUID.randomUUID();
			ProductsPO pro = new ProductsPO();
			pro.setId(id.toString());
			pro.setName("测试" + i);
			int type = r.nextInt(5) + 1;
			CategoryPO category = categoryDao.getById(CategoryPO.class.getName(), type);
			pro.setCategory(category);
			double price = 11 + (11 * r2.nextDouble());
			pro.setPrice(BigDecimal.valueOf(price).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			pro.setUrl("http://www.123.com?id=" + i);
			int length = r4.nextInt(4) + 1;
			String key = "";
			for(int j = 0; j < length; j++){
				key += (keyword[r3.nextInt(9)] + ",");
			}
			key = key.substring(0, key.length()-1);
			pro.setKeyword(key);
			pro.setPhonePassword("淘口令" + i);
			pro.setImg("img" + i + ".png");
			Date d = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = formatter.format(d);
			try {
				Date d2 = formatter.parse(dateStr);
				pro.setAddTime(d2);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			productsDao.save(pro);
		}
	}
	
	@Test
	public void testRandom(){
		Random r = new Random();
		for(int i = 0; i < 10; i++){
		double price = 11 + (11 * r.nextDouble());
		BigDecimal test = BigDecimal.valueOf(price).setScale(2);
		System.out.println(test);
		}
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testAddCategory(){
		String[] type = {"女装","男装","数码","家居","创意"};
		for(int i = 0; i < 5; i++){
			CategoryPO category = new CategoryPO();
			category.setId((i+1));
			category.setName(type[i]);
			category.setSortNum(i+1);
			categoryDao.save(category);
		}
	}
}
