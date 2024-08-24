package com.cl.dao;

import com.cl.entity.XinliceshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinliceshiView;


/**
 * 心理测试
 * 
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface XinliceshiDao extends BaseMapper<XinliceshiEntity> {
	
	List<XinliceshiView> selectListView(@Param("ew") Wrapper<XinliceshiEntity> wrapper);

	List<XinliceshiView> selectListView(Pagination page,@Param("ew") Wrapper<XinliceshiEntity> wrapper);
	
	XinliceshiView selectView(@Param("ew") Wrapper<XinliceshiEntity> wrapper);
	

}
