package com.madder.srv;

import java.util.List;

import com.madder.vo.ProductsVO;
import com.madder.vo.QueryParamVO;

public interface ProductsSrv {

	/**
	 * 查询所有有效商品
	 * @param type
	 * @param showDataNum
	 * @return
	 */
	List<ProductsVO> getAllProducts(Integer type, int showDataNum);
	
	/**
	 * 统计商品总数
	 * @param type
	 * @return
	 */
	int countProducts(Integer type);
	
	/**
	 * 查询所有商品
	 * @param queryParamVO
	 * @return
	 */
	List<ProductsVO> getAllProductsByPage(QueryParamVO queryParamVO);
}
