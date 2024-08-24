package com.cl.dao;

import com.cl.entity.ZixunyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZixunyuyueView;


/**
 * 咨询预约
 * 
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface ZixunyuyueDao extends BaseMapper<ZixunyuyueEntity> {
	
	List<ZixunyuyueView> selectListView(@Param("ew") Wrapper<ZixunyuyueEntity> wrapper);

	List<ZixunyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<ZixunyuyueEntity> wrapper);
	
	ZixunyuyueView selectView(@Param("ew") Wrapper<ZixunyuyueEntity> wrapper);
	

}
