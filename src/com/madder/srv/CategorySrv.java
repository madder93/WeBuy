package com.madder.srv;

import java.util.List;

import com.madder.vo.CategoryVO;

public interface CategorySrv {

	/**
	 * 根据类型查询菜单
	 * @param type
	 * @return
	 */
	List<CategoryVO> getAllCategory(int type);
}
