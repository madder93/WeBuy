package com.madder.srv.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madder.dao.ProductsDao;
import com.madder.po.ProductsPO;
import com.madder.srv.ProductsSrv;
import com.madder.vo.ProductsVO;
import com.madder.vo.QueryParamVO;

@Transactional
@Service("productsSrv")
public class ProductsSrvImpl implements ProductsSrv {
	
	@Resource
	private ProductsDao productsDao;

	@Override
	public List<ProductsVO> getAllProducts(Integer type, int showDataNum) {
		String sql = "from ProductsPO where status <> 0";
		if(type != null && type != 0){
			sql += " and type = " + type;
		}
		sql += " order by addTime desc ";
		List<ProductsPO> list = this.productsDao.findByPage(showDataNum, 6, sql);
		List<ProductsVO> voList = new ArrayList<ProductsVO>();
		if(list != null && list.size() > 0){
			for(ProductsPO product : list){
				ProductsVO vo = new ProductsVO();
				BeanUtils.copyProperties(product, vo);
				vo.setType(product.getCategory().getId());
				vo.setTypeName(product.getCategory().getName());
				voList.add(vo);
			}
		}
		return voList;
	}

	@Override
	public int countProducts(Integer type) {
		String sql = "from ProductsPO ";
		if(type != null && type != 0){
			sql += " where type = " + type;
		}
		int count = this.productsDao.count(sql);
		return count;
	}

	@Override
	public List<ProductsVO> getAllProductsByPage(QueryParamVO queryParamVO) {
		String sql = "from ProductsPO where 1=1 ";
		int pageNum = 0;
		int pageSize = 0;
		if(queryParamVO != null){
			pageSize = queryParamVO.getPageSize()==null?0:queryParamVO.getPageSize();
			pageNum = ((queryParamVO.getPageNumber()==null?1:queryParamVO.getPageNumber()) - 1)*pageSize;
			
			if(queryParamVO.getName() != null){
				sql += " and name like '%" + queryParamVO.getName() + "%'";
			}
			if(queryParamVO.getType() != null){
				sql += " and type = " + queryParamVO.getType();
			}
			if(queryParamVO.getMinPrice() != null){
				sql += " and price >= " + queryParamVO.getMinPrice();
			}
			if(queryParamVO.getMaxPrice() != null){
				sql += " and price <= " + queryParamVO.getMaxPrice();
			}
			if(queryParamVO.getKeyword() != null){
				sql += " and keyword like '%" + queryParamVO.getKeyword() + "%'";
			}
			if(queryParamVO.getStatus() != null){
				sql += " and status = " + queryParamVO.getStatus();
			}
		}
		sql += " order by addTime desc ";
		List<ProductsPO> list = this.productsDao.findByPage(pageNum, pageSize, sql);
		List<ProductsVO> voList = new ArrayList<ProductsVO>();
		if(list != null && list.size() > 0){
			for(ProductsPO product : list){
				ProductsVO vo = new ProductsVO();
				BeanUtils.copyProperties(product, vo);
				vo.setType(product.getCategory().getId());
				vo.setTypeName(product.getCategory().getName());
				voList.add(vo);
			}
		}
		return voList;
	}

}
