package com.cl.dao;

import com.cl.entity.XinliwenzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinliwenzhangView;


/**
 * 心理文章
 * 
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface XinliwenzhangDao extends BaseMapper<XinliwenzhangEntity> {
	
	List<XinliwenzhangView> selectListView(@Param("ew") Wrapper<XinliwenzhangEntity> wrapper);

	List<XinliwenzhangView> selectListView(Pagination page,@Param("ew") Wrapper<XinliwenzhangEntity> wrapper);
	
	XinliwenzhangView selectView(@Param("ew") Wrapper<XinliwenzhangEntity> wrapper);
	

}
