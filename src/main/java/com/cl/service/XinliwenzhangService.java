package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XinliwenzhangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XinliwenzhangView;


/**
 * 心理文章
 *
 * @author 
 * @email 
 * @date 2024-03-20 16:25:16
 */
public interface XinliwenzhangService extends IService<XinliwenzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinliwenzhangView> selectListView(Wrapper<XinliwenzhangEntity> wrapper);
   	
   	XinliwenzhangView selectView(@Param("ew") Wrapper<XinliwenzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinliwenzhangEntity> wrapper);
   	

}

