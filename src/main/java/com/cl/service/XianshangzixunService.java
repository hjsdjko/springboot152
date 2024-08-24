package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XianshangzixunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XianshangzixunView;


/**
 * 线上咨询
 *
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface XianshangzixunService extends IService<XianshangzixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XianshangzixunView> selectListView(Wrapper<XianshangzixunEntity> wrapper);
   	
   	XianshangzixunView selectView(@Param("ew") Wrapper<XianshangzixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XianshangzixunEntity> wrapper);
   	

}

