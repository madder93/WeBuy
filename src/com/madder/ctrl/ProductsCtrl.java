package com.madder.ctrl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.madder.srv.ProductsSrv;
import com.madder.vo.ProductsVO;
import com.madder.vo.QueryParamVO;

@Controller
public class ProductsCtrl {

	@Resource
	private ProductsSrv productsSrv;
	
	/**
	 * 查询所有有效商品
	 * @param type
	 * @param showDataNum
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/product/getAllProducts.do")
	@ResponseBody
	public List<ProductsVO> getAllProducts(Integer type, int showDataNum, HttpServletRequest request, HttpServletResponse response){
		return this.productsSrv.getAllProducts(type, showDataNum);
	}
	
	/**
	 * 统计商品总数
	 * @param type
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/product/countProducts.do")
	@ResponseBody
	public int countProducts(Integer type, HttpServletRequest request, HttpServletResponse response){
		return this.productsSrv.countProducts(type);
	}
	
	/**
	 * 查询所有商品
	 * @param type
	 * @param showDataNum
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/product/getAllProductsByPage.do")
	@ResponseBody
	public List<ProductsVO> getAllProductsByPage(QueryParamVO queryParamVO, HttpServletRequest request, HttpServletResponse response){
		return this.productsSrv.getAllProductsByPage(queryParamVO);
	}
}
