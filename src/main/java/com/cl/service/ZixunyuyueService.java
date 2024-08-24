package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZixunyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZixunyuyueView;


/**
 * 咨询预约
 *
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface ZixunyuyueService extends IService<ZixunyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZixunyuyueView> selectListView(Wrapper<ZixunyuyueEntity> wrapper);
   	
   	ZixunyuyueView selectView(@Param("ew") Wrapper<ZixunyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZixunyuyueEntity> wrapper);
   	

}

