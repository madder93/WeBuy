package com.madder.srv.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.madder.dao.CategoryDao;
import com.madder.po.CategoryPO;
import com.madder.srv.CategorySrv;
import com.madder.vo.CategoryVO;

@Service
public class CategorySrvImpl implements CategorySrv {
	
	@Resource
	private CategoryDao categoryDao;

	@Override
	public List<CategoryVO> getAllCategory(int type) {
		String sql = "from CategoryPO where type = ? order by sortNum";
		List<CategoryPO> categories = categoryDao.findAll(sql, type);
		List<CategoryVO> voList = new ArrayList<CategoryVO>();
		if(categories != null && categories.size() > 0){
			for(CategoryPO category : categories){
				CategoryVO vo = new CategoryVO();
				BeanUtils.copyProperties(category, vo);
				voList.add(vo);
			}
		}
		return voList;
	}

}
