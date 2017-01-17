package com.madder.ctrl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.madder.srv.CategorySrv;
import com.madder.vo.CategoryVO;

@Controller
public class CategoryCtrl {

	@Resource
	private CategorySrv categorySrv;
	
	@RequestMapping("/category/getAllCategory.do")
	@ResponseBody
	public List<CategoryVO> getAllCategory(int type, HttpServletRequest request, HttpServletResponse response){
		return this.categorySrv.getAllCategory(type);
	}
}
