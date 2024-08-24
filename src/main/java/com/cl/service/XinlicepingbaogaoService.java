package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XinlicepingbaogaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinlicepingbaogaoView;


/**
 * 心理测评报告
 *
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface XinlicepingbaogaoService extends IService<XinlicepingbaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinlicepingbaogaoView> selectListView(Wrapper<XinlicepingbaogaoEntity> wrapper);
   	
   	XinlicepingbaogaoView selectView(@Param("ew") Wrapper<XinlicepingbaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinlicepingbaogaoEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<XinlicepingbaogaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<XinlicepingbaogaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<XinlicepingbaogaoEntity> wrapper);



}

