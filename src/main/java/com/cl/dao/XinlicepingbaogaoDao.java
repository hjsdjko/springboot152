package com.cl.dao;

import com.cl.entity.XinlicepingbaogaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinlicepingbaogaoView;


/**
 * 心理测评报告
 * 
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface XinlicepingbaogaoDao extends BaseMapper<XinlicepingbaogaoEntity> {
	
	List<XinlicepingbaogaoView> selectListView(@Param("ew") Wrapper<XinlicepingbaogaoEntity> wrapper);

	List<XinlicepingbaogaoView> selectListView(Pagination page,@Param("ew") Wrapper<XinlicepingbaogaoEntity> wrapper);
	
	XinlicepingbaogaoView selectView(@Param("ew") Wrapper<XinlicepingbaogaoEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XinlicepingbaogaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XinlicepingbaogaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XinlicepingbaogaoEntity> wrapper);



}
