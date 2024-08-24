package com.cl.dao;

import com.cl.entity.XianshangzixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XianshangzixunView;


/**
 * 线上咨询
 * 
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface XianshangzixunDao extends BaseMapper<XianshangzixunEntity> {
	
	List<XianshangzixunView> selectListView(@Param("ew") Wrapper<XianshangzixunEntity> wrapper);

	List<XianshangzixunView> selectListView(Pagination page,@Param("ew") Wrapper<XianshangzixunEntity> wrapper);
	
	XianshangzixunView selectView(@Param("ew") Wrapper<XianshangzixunEntity> wrapper);
	

}
