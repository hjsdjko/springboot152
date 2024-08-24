package com.cl.dao;

import com.cl.entity.XinlipingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinlipingjiaView;


/**
 * 心理评价
 * 
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface XinlipingjiaDao extends BaseMapper<XinlipingjiaEntity> {
	
	List<XinlipingjiaView> selectListView(@Param("ew") Wrapper<XinlipingjiaEntity> wrapper);

	List<XinlipingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<XinlipingjiaEntity> wrapper);
	
	XinlipingjiaView selectView(@Param("ew") Wrapper<XinlipingjiaEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XinlipingjiaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XinlipingjiaEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XinlipingjiaEntity> wrapper);


    List<Map<String, Object>> xinlipingjiaTypeStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XinlipingjiaEntity> wrapper);

}
