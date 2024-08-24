package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XinliceshiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinliceshiView;


/**
 * 心理测试
 *
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface XinliceshiService extends IService<XinliceshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinliceshiView> selectListView(Wrapper<XinliceshiEntity> wrapper);
   	
   	XinliceshiView selectView(@Param("ew") Wrapper<XinliceshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinliceshiEntity> wrapper);
   	

}

