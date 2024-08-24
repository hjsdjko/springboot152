package com.cl.dao;

import com.cl.entity.DiscussxinliwenzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxinliwenzhangView;


/**
 * 心理文章评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface DiscussxinliwenzhangDao extends BaseMapper<DiscussxinliwenzhangEntity> {
	
	List<DiscussxinliwenzhangView> selectListView(@Param("ew") Wrapper<DiscussxinliwenzhangEntity> wrapper);

	List<DiscussxinliwenzhangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxinliwenzhangEntity> wrapper);
	
	DiscussxinliwenzhangView selectView(@Param("ew") Wrapper<DiscussxinliwenzhangEntity> wrapper);
	

}
