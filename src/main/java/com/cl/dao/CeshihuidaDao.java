package com.cl.dao;

import com.cl.entity.CeshihuidaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CeshihuidaView;


/**
 * 测试回答
 * 
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface CeshihuidaDao extends BaseMapper<CeshihuidaEntity> {
	
	List<CeshihuidaView> selectListView(@Param("ew") Wrapper<CeshihuidaEntity> wrapper);

	List<CeshihuidaView> selectListView(Pagination page,@Param("ew") Wrapper<CeshihuidaEntity> wrapper);
	
	CeshihuidaView selectView(@Param("ew") Wrapper<CeshihuidaEntity> wrapper);
	

}
